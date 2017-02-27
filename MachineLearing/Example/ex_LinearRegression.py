import tensorflow as tf


x_data = [1,2,3]					# training data
y_data = [1,2,3]

W = tf.Variable(tf.random_uniform([1], -1.0, 1.0))	#initial weight (random: -1 to +1)
b = tf.Variable(tf.random_uniform([1], -1,0, 1.0))	

hypothesis = W * x_data +b				#model 

cost = tf.reduce_mean(tf.square(hypothesis - y_data))	#cost function 

a = tf.Variable(0.1)					#learning rate
optimizer = tf.train.GradientDescentOptimizer(a)
train = optimizer.minimize(cost)			#minimize cost-function

init = tf.initialize_all_variables()			#initialize the variables

sess = tf.Session()
sess.run(init)

for step in range(1800):
	sess.run(train)
	if step % 20 ==0:
		print (step, sess.run(cost), sess.run(W), sess.run(b))

