import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int testNum;
		int M, N, x, y;
		int answer;
		
		testNum = sc.nextInt();
		for(int i=0; i<testNum; i++){
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			answer = -1;
			for(int j=0; j<N; j++){
				if((M*j+x-1) % N +1 ==y){			// y==N�϶�  �������� 0 �� �ȳ������� �ϱ����� �տ��� 1�� ���� �ڿ��� 1�� ������ ��
					answer = M*j+x;
					break;
				}
			}
			
			
			System.out.println(answer);			
		}
	}
}
