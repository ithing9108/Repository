/*
 A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element
 of the array can be paired with another element that has the same value, except for one element that is left unpaired.
*/

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0;i<A.length;i++){
	        
	        if(set.contains(A[i])){	
		        set.remove(A[i]);
	        }
	        else{
		        set.add(A[i]);
	        }
        }
 
    	return set.iterator().next();
        
    }
}