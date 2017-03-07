import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		
		int inputNumA;
		int inputNumB;											//�Է¹��� ����
		int[] inputArrA;
		int[] inputArrB;				
		//�Է¹��� ��ǲ�� �ִ� �迭
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
		Arrays.sort(inputArrA);									//���̳ʸ� ��ġ�ϱ� ���ؼ� ����
		
		for(int k=0; k<inputNumB;k++){
			System.out.println(binarySearch(inputArrA, inputArrB[k]));
		}	
	
	}
	
	public static int binarySearch(int[] arr, int goal){

		int start = 0;
		int end = arr.length-1;
		int index;							//���̳ʸ���ġ���� ����� �ε��� == mid
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
