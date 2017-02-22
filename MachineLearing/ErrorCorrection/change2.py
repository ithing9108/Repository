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
fp_out = open('train-labels.cdx555-ubyte', 'wb')
fp_label = open('train-labels.idx1-ubyte', 'rb')

#variable
d=0
l=0
index =0

l = fp_label.read(8)

fp_out.write(l)

while True:
	l = fp_label.read(1)  #reading 1byte 

	if not l:
		break;
	if 0<=ord(l) <=9:
		if random.randint(1,20)==1:
			d= '0'+ str(random.randint(0,9))
			l=binascii.a2b_hex(d)
			
	fp_out.write(l)
	print(l[0])
print("done")

