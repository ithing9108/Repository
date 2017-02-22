import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputNum = 0;
		int width = 0;
		String result = "";
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		width = findWidth(inputNum);
		result = findRule(width, inputNum);
		System.out.println(result);
	
	}//main
	
	static int findWidth(int inputNum){
		
		int calcul = 0;
		int result = 1;
		
		for(result=1;calcul<inputNum ; ++result){
			calcul = calcul + result;
		}
		return result-1;
	
	}//findWidth
	
	static String findRule(int width, int inputNum){
		
		int leftNumber = width;
		int rightNumber = 1;
		int check = 0;

		for(int i=1; i<width; i++){
			check = check + i;
		}
		for(int j=check; j<inputNum-1; j++){
			leftNumber -= 1;
			rightNumber += 1;
		}
		if(width%2==1){						//출력 부분 정확하게 읽자...
		return leftNumber +"/"+rightNumber;
		}
		else
			return rightNumber +"/" + leftNumber;
	}
}//Main
