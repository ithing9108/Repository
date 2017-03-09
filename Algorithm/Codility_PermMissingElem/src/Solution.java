/*
  A zero-indexed array A consisting of N different integers is given. The array contains integers
  in the range [1..(N + 1)], which means that exactly one element is missing.
  Your goal is to find that missing element.
 */

class Solution {
    public int solution(int[] A) {
        int result = A.length + 1;
        for ( int i = 0; i < A.length; i++) {
            result = result - A[i] + i + 1;
        }
        return result;
    }
}