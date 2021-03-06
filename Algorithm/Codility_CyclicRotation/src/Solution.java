

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] temp;
        
        if(A.length>0)					// ..
            K = K % A.length;
        temp = new int[K];
        
        if(K==0 || A.length==0)
            return A;
        
        for(int i=0; i<K; i++)    
            temp[i] = A[A.length-1-i];
            
        for(int j=A.length-1-K; j>=0; j--)
            A[j+K] = A[j];
            
        for(int h=0; h<K; h++)
            A[h] = temp[K-h-1];
            
        return A;    
    }
}