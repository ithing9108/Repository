import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		int inputNum;
		String answer= "*";
		
		Scanner sc = new Scanner(System.in);
		inputNum = sc.nextInt();
		for(int i=0; i<inputNum; i++){
			System.out.println(answer);
			answer+= "*";
		}
	}
}
