import numpy as np
import sys
import os
from array import array

from struct import *
import matplotlib
import matplotlib.pyplot as plt
import matplotlib.cm as cm

#파일 읽기 
fp_out = open('train-labels.cdx1-ubyte','wb')
fp_label = open('train-labels.idx1-ubyte','rb')

#사용할 변수 초기화
lbl = [ [],[],[],[],[],[],[],[],[],[] ] #숫자별로 저장 (0 ~ 9)
d = 0
l = 0
index=0 

l = fp_label.read(8)     #read first  8byte

fp_out.write(l)


#숫자 데이터를 읽어서 해당하는 데이터를 지정하고 출력 
k=0 #테스트용 index
#read mnist and show number
while True:    
    l = fp_label.read(1) #1바이트씩 읽음

    if not l:
        break;

    fp_out.write(l)	
    print(l)
    # index = int(l[0]) 
    
 
print("done")
