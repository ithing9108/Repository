import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int input = 0;
		int[] checkInput = new int[10];	//�Է°��� �˻��ϱ� ���� �迭
		int checkValue = 0;				//�Է°��� üũ�ϱ� ���� ����
		int result =0; 
		
		Scanner sc= new Scanner(System.in);
		
		input = sc.nextInt();
		for(; input>0;){
			checkValue = input % 10;
			input = input/10;
			checkInput[checkValue] = checkInput[checkValue] +1;
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
