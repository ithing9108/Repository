/*
 	암호화를 위한 숫자 리스트를 받는다. 리스트중에 1개의 값을 1증가 시킨다. 이 때 내부의 모든 숫자 곱이 가장 커져야 합니다.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
			
		Scanner sc = new Scanner(System.in);
		String[] input;
		int[] arr; 
		int result = 1;
		
		input = sc.nextLine().split(" ");
		arr = new int[input.length];

		for(int i=0; i<input.length;i++){	
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);						
		arr[0] += 1;							// 가작 작은값에 +1
		
		for(int j=0; j<arr.length;j++){			// 결과 계산
			result *= arr[j];
		}
		
		System.out.println(result);
	}
}
