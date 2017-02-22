import binascii, doctest
import random
import numpy as np
import sys
import os
from array import array

from struct import *
import matplotlib
import matplotlib.pyplot as plt
import matplotlib.cm as cm

#file reading
fp_test = open('train-labels.cdx05-ubyte', 'rb')

#variable
counter = np.zeros(10)

l = fp_test.read(8)

while True:
	l = fp_test.read(1)  #reading 1byte 

	if not l:
		print(counter)
		break;
	if 0<=ord(l) <=9:
		counter[ord(l)] = counter[ord(l)] + 1
	#d= '0'+ str(random.randint(0,9))
	#l=binascii.a2b_hex(d)
			
	#fp_out.write(l)
	#print(l[0])
print("done")

