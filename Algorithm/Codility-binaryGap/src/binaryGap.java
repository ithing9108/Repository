/*
 *  2진수로 바꾼 후 가장 먼 1들 사이의 거리 출력
 */
class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String binary = "";
        int max = 0;
        int temp = 0;
        int posBefore;
        
        while(N>=1){
            if(N%2 ==1){
                binary = binary + "1";
            }
            else{
                binary = binary + "0";
            }
            N /= 2;
        }
        
        posBefore = binary.length()-1;
        for(int i=binary.length() - 1; i>=0; i--){
            if(binary.charAt(i) == '1'){
                temp = posBefore - i -1;
                posBefore = i;        
                if(temp>max){
                    max = temp;
                }
            }
        }
        
        return max;
    }
}