import tensorflow as tf

hello = tf.constant('Hello, Tensorflow!')  #constant is operation
					   #hello is variable, node
sess = tf.Session()

print (sess.run(hello)) 		   #node is operated by run!
