/* ���� - 2292
 	���� �׸��� ���� ���������� �̷���� ������ �ִ�. �׸����� ���� �ٿ� ���� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��鼭 1�� �����ϴ� 
 	��ȣ�� �ּҷ� �ű� �� �ִ�. ���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������
 	(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ���, 13������ 3��, 58������ 5���� ������.
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
	
		int input = 0;	//�Է°�
		int rule = 0;	//��� ������ ���ѱ�Ģ
		int result = 0;	//����� ���
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();

		if (input == 1) {
			System.out.println("1");
		} else {

			while (input > 1) {
				input = input - rule;
				rule = rule + 6;
				result = result + 1;
			}
			System.out.println(result);
		}//if
	}//main
}//Main
