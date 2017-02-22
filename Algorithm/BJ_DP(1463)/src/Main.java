import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputNum = 0;
		int result = 0;
		int process = 1;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();

		while(true){
			System.out.println(process);
			if(inputNum-process == 0){ break;}
			process *= 3;
			if(inputNum%process != 0){
				process /= 3;
				process *= 2;
			}
			if (inputNum % process !=0){		//여기에 else if 쓰면 난리난다.
				process /= 2;
				inputNum -= 1;
			}
			
			
			result += 1;
		}
		System.out.println(result);
	}
}
