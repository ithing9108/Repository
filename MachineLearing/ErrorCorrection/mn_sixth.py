# python + mnist + NN
# mnist 9626 / 10000

import tensorflow as tf
import numpy as np
import sys
import os
import time
import binascii, doctest

from array import array

from struct import *
from matplotlib import pylab
import matplotlib
import matplotlib.pyplot as plt
import matplotlib.cm as cm
from sklearn.metrics import confusion_matrix


#training file
fp_image = open('train-images.cdx999-ubyte','rb')  # 6000
fp_label = open('train-labels.cdx998-ubyte','rb')  # 6000 - 30%
#fp_label = fp_label.strip()
#test file
fp_t_img = open('t10k-images.idx3-ubyte' ,'rb')
fp_t_lbl = open('t10k-labels.idx1-ubyte' ,'rb')

s = fp_image.read(16)	#read first 16byte	
l = fp_label.read(8)	#read first  8byte
#print(s)

st= fp_t_img.read(16)	#read first 16byte
sl= fp_t_lbl.read(8)	#read first  8byte
#print(st)

img = np.zeros(784)	#1d array (784 byte) - input data
lbl = [ [],[],[],[],[],[],[],[],[],[] ] 	#checking label
check_k = [ [],[],[],[],[],[],[],[],[],[] ]      #check label for k_means
count_k = 0
index_k = 0
num_k = 0
bin_k = 0
base_k = 0
 
r = np.zeros(10)
ay = [ ]
x = [ ]
y = [ ]
k_y = [ ]   # for label from kmeans
t_x = []
t_y = []

print("read training data ")
#training data input to x,y
while True:
	img = fp_image.read(784)
	l = fp_label.read(1)
	if count_k <16:
		print(l)	

	if not img:
		break;
	if not l:
		break;

	if 0<= ord(l) <= 9:
		if not check_k[ord(l)]:

			check_k[ord(l)] = count_k	# find one index per label

	#if l != '\t
	if 0<= ord(l) <= 9:			# to delete '\t'
		count_k = count_k + 1


	x.append(unpack(len(img)*'B',img))
	y.append(int(l[0]))	

print(check_k)
print("training read done ")


"""   kmeans finish   """


#test data input -- evaluate neural network
print("read test data ")
while True:
	img = fp_t_img.read(784)
	l   = fp_t_lbl.read(1)

	if not img:
		break;
	if not l:
		break;

	t_x.append(unpack(len(img)*'B',img))
	t_y.append(int(l[0]))

print("test read done ")


def sigmoid(x):
	output = 1/(1+np.exp(-x))
	return output

def sigmoid_output_to_derivative(output):
	return output*(1-output)

#scaling input data (0~255) => (0~1)


x = np.array(x)
#X = tf.constant(x)
X = (x/255.0)


k_X = tf.constant(X)
k=10
centroides= tf.Variable(tf.slice(tf.random_shuffle(k_X),[0,0], [k,-1])) 
#append label per 1
expanded_k_X = tf.expand_dims(k_X, 0)
expanded_centroides = tf.expand_dims(centroides, 1)
diff = tf.sub(expanded_k_X, expanded_centroides)
sqr = tf.square(diff)
distances = tf.reduce_sum(sqr, 2)
assignments = tf.argmin(distances, 0)
#denote labels in here
means = tf.concat(0, [tf.reduce_mean(tf.gather(k_X, tf.reshape(tf.where(tf.equal(assignments, c)), [1, -1])), reduction_indices=[1]) for c in range(k)])

update_centroides = tf.assign(centroides, means)
init_op = tf.initialize_all_variables()

sess = tf.Session()
sess.run(init_op)

for step in range(100):
	_, centroid_values, assignment_values = sess.run([update_centroides, centroides, assignments])

for p in range (6000):
	for z in range(0,10):  #(0,9)
		if assignment_values[p] == assignment_values[check_k[z]]:
			k_y.append(y[z])

print(len(assignment_values)) 
print(len(k_y))
print(len(x))
for t in range(50):
	print(assignment_values[t])

#print (centroid_values)
#print(assignment_values)  
#print (assignments)  
#print centroid_values
#print(X[0])


"""
alpha = 0.8

print ("Alpha:", (alpha)) 
np.random.seed(1)

# (784 - 256 - 64 - 10 )
synapse_0 = ( 2*np.random.random((784,256)) - 1 )
synapse_1 = ( 2*np.random.random((256,64)) - 1 )
synapse_2 = ( 2*np.random.random((64,10)) - 1 )



layer_0 = np.zeros((1,784))
layer_1 = np.zeros((1,256))
layer_2 = np.zeros((1,64))
layer_3 = np.zeros((1,10))


times = 10
print("do neural")
start = time.time()

for j in range(times):

	for i in range( len(X) ):

	#	print(len(X))
		#print("iter:",j)
		layer_0 = X[i]
		layer_1 = sigmoid(np.dot(layer_0,synapse_0))
		layer_2 = sigmoid(np.dot(layer_1,synapse_1))
		layer_3 = sigmoid(np.dot(layer_2,synapse_2))

		r=np.zeros(10)  #r=np.zeros(10)		
		r[k_y[i]] = 1.0
	#	print(k_y[i])
	#	print (r)		

		#print("back prop")
		#print("out:",layer_3)
		#print("ans:",y[i])
		
		layer_3_error = layer_3 - r
		#layer_3_error = r - layer_3
		
		#print("err:",layer_3_error)

		layer_3_delta = layer_3_error*sigmoid_output_to_derivative(layer_3)			
			
		#print ( "Error after "+str(j)+" iterations:" + str(np.mean(np.abs(layer_3_error))) )
		#break;

		layer_2_error = layer_3_delta.dot(synapse_2.T)
		layer_2_delta = layer_2_error * sigmoid_output_to_derivative(layer_2)	

		layer_1_error = layer_2_delta.dot(synapse_1.T)
		layer_1_delta = layer_1_error * sigmoid_output_to_derivative(layer_1)
		
		#layer_3_error = layer_3 - y
		synapse_2 -= alpha * np.reshape(layer_2,(-1,1))*layer_3_delta
		synapse_1 -= alpha * np.reshape(layer_1,(-1,1))*layer_2_delta
		synapse_0 -= alpha * np.reshape(layer_0,(-1,1))*layer_1_delta
		

		

	print ((j)," iterations:"  )
	print ("Error last input :" ,str(np.mean(np.abs(layer_3_error))) )
	#print("out:",layer_3)
	#print("ans:",r)

end = time.time()


#evaluate 

x = np.array(t_x)
X = (x/255.0)

correct = 0
incorrect =0

map = np.zeros((10,10))	#map[ans][out], map[answer ][print] += 1 
map = map.astype(np.int32)

for i in range(len(X)):
	#break;
	layer_0 = X[i]
	layer_1 = sigmoid(np.dot(layer_0,synapse_0))
	layer_2 = sigmoid(np.dot(layer_1,synapse_1))
	layer_3 = sigmoid(np.dot(layer_2,synapse_2))

	r = np.zeros(10)
	r[t_y[i]] = 1.0

	#print("out:",X[i],":", layer_3)
	#print("out:",layer_3)
	
	#print("out:",layer_3.argmax(axis=0) )
	#print("answer:",t_y[i])
	
	if(layer_3.argmax(axis=0) == t_y[i]):
		correct+=1
	else:
		incorrect +=1

	map[ t_y[i] ][ layer_3.argmax(axis=0) ] += 1


print(times," times ")
print("correct ratio = ", correct,"/",len(X) )
print("learning time: ",(end-start) )
print(map)


#make confusion matrix
map = map.astype(np.float64)
for i in range(10):
	map[i] = map[i] / np.sum(map[i])

# show result

plt.figure()
plt.imshow(map, interpolation='nearest', cmap=plt.cm.Blues)
plt.title("MNIST  ratio : "+str(correct)+str("/")+str(len(X)) )
plt.colorbar()
tick_marks = np.arange(10)
plt.xticks( range(10))
plt.yticks( range(10))
plt.tight_layout()
plt.ylabel('answer')
plt.xlabel('output')

plt.show()
"""
