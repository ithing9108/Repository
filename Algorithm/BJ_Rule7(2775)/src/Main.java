import java.util.Scanner;

public class Main {

	public static void main(String[] args){
	
		int inTestNum = 0;		//�׽�Ʈ Ƚ��
		int inRoomStair = 0;	//�Է� ��
		int inRoomNumber = 0;	//�Է� ȣ��
		int[][] data = new int[15][14];
		Scanner sc = new Scanner(System.in);
	
		for(int i=0; i<14; i++){	//1���� �ʱⰪ
			data[0][i] = i+1;
		}
		for(int t=0; t<15; t++){	//1���� �ʱⰪ
			data[t][0] = 1;
		}
		
		for(int j=1;j<15;j++){		//��Ģ�� ���� ������ �迭 ����
			for(int k=1; k<14; k++){
				data[j][k] = data[j][k-1] + data[j-1][k];
			}
		}
		
		inTestNum = sc.nextInt();
		for(int h=0; h<inTestNum; h++){
			inRoomStair = sc.nextInt();								//���� �Է�
			inRoomNumber = sc.nextInt();
			System.out.println(data[inRoomStair][inRoomNumber-1]);	//��� ���
		}
		
		
	}//main
}//Main
