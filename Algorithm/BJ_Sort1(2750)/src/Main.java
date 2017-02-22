import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		int inputNum = 0;
		int[] inputData;
		int smallest = 0; 	//sort를 위한 임시 저장
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		inputData = new int[inputNum];
		
		for(int i=0; i<inputNum; i++){
			inputData[i] = sc.nextInt();
		}
		
		for(int j=0; j<inputNum-1; j++){
			for(int k=j; k<inputNum-1; k++){
				smallest = inputData[j];
				if(smallest>inputData[k+1]){
					smallest = inputData[k+1];
					inputData[k+1] = inputData[j];
					inputData[j] = smallest;
				}
			}
		}
		
		for(int t=0; t<inputNum; t++){
				System.out.println(inputData[t]);
		}
		
		
	}// main
}// Main
