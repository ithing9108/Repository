
/*
 A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P - 1] and A[P], A[P + 1], ..., A[N - 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P - 1]) - (A[P] + A[P + 1] + ... + A[N - 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 */

//66%

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int sumLeft = 0;
        int sumRight = 0;
        int diff = 0;
        int min = 0;
 
        if(A.length==0)
            return 0;
        for(int i=0; i<A.length; i++)
            sumLeft += A[i];    
 
        for(int j=0; j<A.length; j++){
            sumRight += A[j];
            sumLeft -= A[j];
            diff = Math.abs(sumRight-sumLeft);
            
            if(min==0)
                min = diff;
            min = Math.min(min, diff);
        }
        return min;
    }
}