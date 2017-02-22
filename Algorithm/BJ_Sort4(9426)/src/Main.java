import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		
		int inputAmount = 0;
		int inputRange = 0;
		int[] sortArr;
		int[] inputArr;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		inputAmount = sc.nextInt();
		inputArr = new int[inputAmount];
		inputRange = sc.nextInt();
		sortArr = new int[inputRange];
		
		for(int i=0; i<inputAmount; i++){
			inputArr[i] = sc.nextInt();
		}
		
		for(int j=0; j<inputAmount-inputRange+1; j++){
			for(int k=j, t=0; k<j+inputRange; k++, t++){
				sortArr[t]= inputArr[k];	
			}
			Arrays.sort(sortArr);
			result += sortArr[(inputRange+1) /2 -1];
		}
		
		System.out.println(result);		
	}//main
}//Main
