import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		
		int inputNumA;
		int inputNumB;											//입력받을 갯수
		int[] inputArrA;
		int[] inputArrB;				
		//입력받은 인풋을 넣는 배열
		Scanner sc = new Scanner(System.in);
		
		inputNumA = sc.nextInt();
		inputArrA = new int[inputNumA];
		for(int i=0;i<inputNumA;i++){
			inputArrA[i] = sc.nextInt();
		}

		inputNumB = sc.nextInt();
		inputArrB = new int[inputNumB];
		for(int j=0;j<inputNumB;j++){
			inputArrB[j] = sc.nextInt();
		}
		Arrays.sort(inputArrA);									//바이너리 서치하기 위해서 정렬
		
		for(int k=0; k<inputNumB;k++){
			System.out.println(binarySearch(inputArrA, inputArrB[k]));
		}	
	
	}
	
	public static int binarySearch(int[] arr, int goal){

		int start = 0;
		int end = arr.length-1;
		int index;							//바이너리서치에서 사용할 인덱스 == mid
		while(start<=end){
			index = (start + end) / 2;
			if(goal == arr[index]){
				return 1;
			}
			else if(goal>arr[index]){
				start = index+1;
			}
			else{
				end = index-1;
			}
		}
		return 0;
	}
}
