import java.util.Scanner;

public class main {

	public static void main(String[] args){
	
		int input = 0;
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();
		System.out.println(fibonacci(input));
	}
	
	public static int fibonacci(int number){
		if(number<=1){
			return 1;
		}
		return fibonacci(number -1) + fibonacci(number-2);
	}
}
