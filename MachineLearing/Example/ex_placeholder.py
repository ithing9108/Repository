#value of placeholder is decided when operated
import tensorflow as tf

a = tf.placeholder(tf.int16)
b = tf.placeholder(tf.int16)

add = tf.add(a, b)
mul = tf.mul(a, b)

with tf.Session() as sess:		#a,b is decided by feed_dict
	print(sess.run(add, feed_dict={a:2, b:3}))	
	print(sess.run(mul, feed_dict={a:2, b:3}))
