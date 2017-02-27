import tensorflow as tf
import numpy as np

x1_data = [1,0,3,0,5]
x2_data = [0,2,0,4,0]
y_data = [1,2,3,4,5]	#training Data

W1 = tf.Variable(tf.random_uniform([1], -1.0, 1.0))	#for x1_data
W2 = tf.Variable(tf.random_uniform([1], -1.0, 1.0))	#for x2_data
b = tf.Variable(tf.random_uniform([1], -1.0, 1.0))	#for y_data

hypothesis = W1*x1_data + W2*x2_data + b		#model

cost = tf.reduce_mean(tf.square(hypothesis - y_data))	#cost function

learningRate = tf.Variable(0.1)
optimizer = tf.train.GradientDescentOptimizer(learningRate)
train = optimizer.minimize(cost)	#minimize cost

init = tf.initialize_all_variables()

sess = tf.Session()
sess.run(init)

for step in range(2000):
	sess.run(train)
	if step%20 == 0:
		print(step, sess.run(cost), sess.run(W1), sess.run(W2), sess.run(b))




