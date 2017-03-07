import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int nodeNum = 0;
		String[] input;
		Scanner sc = new Scanner(System.in);
		nodeNum = sc.nextInt();
		sc.nextLine();
		input = new String[nodeNum];
		for(int i=0; i<nodeNum; i++){
			input[i] = sc.nextLine();
		}
		
	
	}
}
