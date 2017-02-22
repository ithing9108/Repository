import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = "";
		int[] checkInput = new int[10];	//입력값을 검사하기 위한 배열
		int checkValue = 0;				//입력값을 체크하기 위한 변수
		int result =0; 
		
		Scanner sc= new Scanner(System.in);
		
		input = sc.nextLine();
		for(int i=0; i<input.length(); i++){
			checkInput[(int)input.charAt(i)-48] = checkInput[(int)input.charAt(i)-48] +1;
		}
		checkInput[6] = (checkInput[6] + checkInput[9] + 1)/2;
		
		for(int j=0; j<9; j++){
			if(checkInput[j]>result){
				result = checkInput[j];
			}
		}
		System.out.println(result);
		
	}//main
}//Main
