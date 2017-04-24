
import java.util.Scanner;

public class ver2 {

	public static void main(String[] args){
		
		int result = 0;
		int length;
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		
		for(int i=1; i<=9; i++){
			result += stairNumber(i, length, 1);
		}
		System.out.println(result);
		
	}
	
	static int stairNumber(int input, int length, int outcome){
		
		int lastNumber;
		int temp = 0;
		
		if(length==1)
			return 0;
		length -=1;
		if(input==0 || input==9)
			{}
		else
			outcome *= 2;
		
		outcome += stairNumber(input, length, outcome);
		
		return outcome;
	}
}
