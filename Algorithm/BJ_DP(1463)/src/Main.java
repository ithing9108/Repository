import java.util.Scanner;

public class Main {

	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args){
		
		int inputNum;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();

		makeOne( inputNum, 0);
		System.out.println(result);
	}
	
	static void makeOne(int input, int process){		//입력값과 현재 result값
		
		if(process>=result)
			return;
		if(input==1){
			if(process<result)
				result = process;			 // D[n] = min( D[n-1], D[n/2], D[n/3] ) + 1;
		}									//  이게 더 좋은 방법
		if(input<1)
			return;
		
		if(input%3==0)
			makeOne(input/3, process+1);
		if(input%2==0)
			makeOne(input/2, process+1);
		makeOne(input-1, process+1);
		
		return;
	}
	
}
