import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inA = 0;	//�Է°�A
		int inB = 0;	//�Է°�B
		int inC = 0;	//�Է°�C
		int multi = 0;	//A,B,C�� ��
		int count = 1;  //�ڸ����� ã�ư��� ���� ����, �������� ���ʱ� ����
		int temp = 0;	//�迭�� ����ֱ� ���� �ӽ÷� ����ϴ� ����
		int[] result = new int[10];	//����� �Է��� �迭 ����, 0���� �ʱ�ȭ
		
		Scanner sc = new Scanner(System.in);
		inA = sc.nextInt();
		inB = sc.nextInt();
		inC = sc.nextInt();
		
		multi = inA * inB * inC;
		
		for(;count<multi;){
			count = count * 10; // 10�� ���ϸ鼭 �����ڸ����� ã�´�.
		}
		count = count/10;		// �� Ŀ�����Ƿ� 10�� ������.
		
		for(;count>=1;){
			temp = multi / count;		//�ڸ��� ��
			multi = multi -(temp*count);//������ ����Ѱ��� ���ش�.
			count = count/10;			//count���� 10���� ������
			result[temp] = result[temp] + 1;			//��� �迭�� 1�� �����༭ ����� �ݿ�
		}	
		
		for(int i=0; i<10; i++){		//��� ���
			System.out.println(result[i]);
		}
	}
}
