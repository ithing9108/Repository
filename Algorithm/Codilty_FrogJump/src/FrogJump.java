

class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int distance = Y-X;
        int result = 0;
        if(distance%D==0){
            result = distance/D;
        }
        else{
            result = distance/D + 1;
        }
        return result;
    }
}