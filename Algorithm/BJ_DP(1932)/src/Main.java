import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		
		int inputNum = 0;
		String[] inputArr;
		int[] processArr;
		int[] resultArr;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		sc.nextLine();
		processArr = new int[inputNum];
		resultArr = new int[inputNum];
		for(int i=0; i<inputNum; i++){
			inputArr = sc.nextLine().split(" ");
			if(i==0){
				resultArr[0] = Integer.parseInt(inputArr[0]);
			}
			if(i==1){
				processArr[0] = resultArr[0];
				resultArr[1] = processArr[0] + Integer.parseInt(inputArr[1]);//
				resultArr[0] = processArr[0] + Integer.parseInt(inputArr[0]);// À­ÁÙÀÌ¶û ¼ø¼­ ¹Ù²î¸é ¾ÈµÈ´Ù [0]°ªÀÌ ¹Ù²¸¼­
				//System.out.println(resultArr[0] + " " + resultArr[1]);
			}
			if(i>=2){
				for(int k=0; k<i; k++){
					processArr[k] = resultArr[k];
				}
				for(int j=0; j<i-1; j++){
					if(processArr[j]>processArr[j+1]){
						resultArr[j+1] = processArr[j] + Integer.parseInt(inputArr[j+1]);
					}
					else{
						resultArr[j+1] = processArr[j+1] + Integer.parseInt(inputArr[j+1]);
					}
				}
				resultArr[0] = processArr[0] + Integer.parseInt(inputArr[0]);
				resultArr[i] = processArr[i-1] + Integer.parseInt(inputArr[i]);
				//System.out.println(resultArr[0] + " " + resultArr[1] +" "+resultArr[2] +" "+resultArr[3] + " " + resultArr[4]);
			}
		}
		Arrays.sort(resultArr);
		System.out.println(resultArr[inputNum-1]);

	}//main
}//Main
