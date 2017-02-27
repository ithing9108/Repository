import tensorflow as tf


x_data = [1,2,3]					# training data
y_data = [1,2,3]
"""use placeholder for recycling"""
X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)
""

W = tf.Variable(tf.random_uniform([1], -1.0, 1.0))	#initial weight (random: -1 to +1)
b = tf.Variable(tf.random_uniform([1], -1,0, 1.0))	

#hypothesis = W * x_data +b				#model 
hypothesis = W * X + b

cost = tf.reduce_mean(tf.square(hypothesis - y_data))	#cost function 

a = tf.Variable(0.1)					#learning rate
optimizer = tf.train.GradientDescentOptimizer(a)
train = optimizer.minimize(cost)			#minimize cost-function

init = tf.initialize_all_variables()			#initialize the variables

sess = tf.Session()
sess.run(init)

for step in range(1800):
	sess.run(train, feed_dict={X:x_data, Y:y_data})      	#input training data
	if step % 20 ==0:
		print (step, sess.run(cost, feed_dict={X:x_data, Y:y_data}), sess.run(W), sess.run(b))

