
/* 시간초과~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int result = 0;
		int length;
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		
		for(int i=1; i<=9; i++){
			result += stairNumber(""+i, length);
		}
		System.out.println(result);
		
	}
	
	static int stairNumber(String input, int length){
		
		int outcome = 0;
		int lastNumber;
		int temp = 0;
		
		if(input.length() == length)
			return 1;
		
		lastNumber = input.charAt(input.length()-1)-'0';
		if(lastNumber>=1){
			temp = lastNumber - 1;
			outcome += stairNumber(input+temp, length);
			System.out.println(input+temp);
		}
		if(lastNumber<9){
			temp = lastNumber + 1;
			outcome += stairNumber(input+temp, length);
			System.out.println(input+temp);
		}		
		
		return outcome;
	}
}
