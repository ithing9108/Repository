import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = "";
		int[] checkInput = new int[10];	//�Է°��� �˻��ϱ� ���� �迭
		int checkValue = 0;				//�Է°��� üũ�ϱ� ���� ����
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
