/*
		ī��1 = 1,2,3,4,5,6,7,8   / ī��2 = 1,2,3,4,9,10,11,12  / ī��3 = 1,2,5,6,9,10,13,14  / ī��4 = 1,3,5,7,9,11,13,15
		ī�� 4���� �̿��� 4���� �������� ������ ������ ���ڸ� �����
 */
import java.util.Scanner;

public class numberMagic {

	public static void main(String[] args){

		int result = 1;
		int square = 8;						//��信 ���� ���ϴ� ��
		String input ="";
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();				//�Է¹�� = YYYY ~ NNNN
		
		for(int i=0;i<4; i++){
			if(input.charAt(i)=='Y'){
				
			}
			else if (input.charAt(i)=='N'){
				result += square;
			}
			square /= 2;
		}
		System.out.println(result);
	}
}
	
/* �ٸ� ���
	YYYYYYYYNNNNNNNN
	YYYYNNNNYYYYNNNN
	YYNNYYNNYYNNYYNN
	YNYNYNYNYNYNYNYN		//�Է°� ���ڿ��� ���ؼ� �״�� ���
*/