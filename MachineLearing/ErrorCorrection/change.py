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
fp_out = open('train-labels.cdx41-ubyte', 'wb')
fp_label = open('train-labels.idx1-ubyte', 'rb')

#variable
d=0
l=0
index =0
count =0

l = fp_label.read(8)

fp_out.write(l)

while True:
	l = fp_label.read(1)  #reading 1byte 
	rdi = random.randint(1,2)
	
	if not l:
		break;
	if l==binascii.a2b_hex('01'):
		count=count+1
		if count>4045:
			l=binascii.a2b_hex('05')
			

	fp_out.write(l)
	#print(l[0])
	print(rdi)
print("done")

