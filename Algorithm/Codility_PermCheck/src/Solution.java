/* (70%)
A non-empty zero-indexed array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
 */

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
     long result = 0;
     long comp = (A.length) * (A.length +1) / 2;
     HashSet<Integer> set = new HashSet<Integer>();
     
     for(int i=0; i<A.length; i++){
        if(set.contains(A[i]))
            return 0;
            
        if(A[i]>A.length || A[i]<1)
            return 0;
        result += A[i];
        set.add(A[i]);
     }
     if(result!= comp)
        return 0;
    return 1;    
      
    }
}