import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inNum = 0;		//�Է� ����
		String[] inStr;		//�Է� OX
		Scanner sc = new Scanner(System.in);		
		String[] result;			//����� X�� �ڸ� �迭 'OOO' 			
		int numResult = 0;
		int temp = 0;				//OOO ������ �ӽ÷� �Է�
		
		inNum = sc.nextInt();
		inStr = new String[inNum];	//�Է� ���ڷ� �迭 ����
		sc.nextLine();    			//���๮�� ����  or sc.next()�� ����ص� ��
		
		for(int i=0; i<inNum; i++){
			inStr[i] = sc.nextLine();	//OX �� �ޱ�
		}
		
		for(int t=0; t<inNum; t++){
			result = inStr[t].split("X");
			
			for(int k=0; k<result.length; k++){
				temp = result[k].length();
				for(; temp>0; temp-- ){
					numResult = numResult + temp;
				}
			}
			System.out.println(numResult);
			numResult = 0;
		}	
	}//main
}//Main
