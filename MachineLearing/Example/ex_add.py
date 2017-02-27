#everything is operation
import tensorflow as tf

sess = tf.Session()

a = tf.constant(2)	#a is operation
b = tf.constant(3)	#b is operation

c = a+b			#c is operation,   it doesn't have 5 

print (sess.run(c))

