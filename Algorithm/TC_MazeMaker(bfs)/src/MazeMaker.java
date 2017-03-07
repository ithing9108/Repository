/*
 	3*3�� �̷ΰ� �ִ�. �̷� ���� �����  �� �� �̵��� �Է°�(x,y)��ŭ �̵� �����ϴ�.
 										�ش� �Է°����� Ż���ϱ� ���� ���� �������� ã��, �� ���� Ż���ϱ� ���� �̵� Ƚ���� ����϶�.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeMaker {
	
	public static void main(String[] args){
		
		int jumpNum; 							//���� ������ ��
		int[] inputJump;
		int startX = 1;							//������ġ (1,0)���� ������
		int startY = 0;
		int result_max = -1;					//����� ����� ��
		int [][] map = new int[3][3];			//���� 3*3���� ����
		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();

		Scanner sc = new Scanner(System.in);
		
		jumpNum = sc.nextInt();
		inputJump = new int[jumpNum*2];

		for (int i=0; i<jumpNum*2; i++){
			inputJump[i]= sc.nextInt();
		}
		
		map[startX][startY] =0;
		queueX.add(startX);
		queueY.add(startY);
		
		while( !queueX.isEmpty()){
			int x = queueX.poll();
			int y = queueY.poll();
			for(int j=0; j<jumpNum;j++){
				int nextX = x + inputJump[2*j];
				int nextY = y + inputJump[2*j+1];
				if(0<=nextX && nextX<3  
								&& 0<=nextY && nextY<3 
												&& map[nextY][nextX]<1){
					map[nextY][nextX] = map[y][x] + 1;
					queueX.add(nextX);
					queueY.add(nextY);
				}
			
			}
		}
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				result_max = Math.max(result_max, map[i][j]);
			}
		}
		System.out.println(result_max);
	}
}