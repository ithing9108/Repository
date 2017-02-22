import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputNum = 0;
		String[] wordList;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		sc.nextLine();
		wordList = new String[inputNum];
		for(int i=0; i<inputNum; i++){
			wordList[i] = sc.next();
		}
	
	
	}//main
}//Main
