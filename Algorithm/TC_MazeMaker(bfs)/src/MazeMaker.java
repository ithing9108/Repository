/*
 	3*3의 미로가 있다. 미로 안의 사람은  한 번 이동시 입력값(x,y)만큼 이동 가능하다.
 										해당 입력값으로 탈출하기 가장 힘든 시작점을 찾고, 이 때의 탈출하기 위한 이동 횟수를 출력하라.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeMaker {
	
	public static void main(String[] args){
		
		int jumpNum; 							//점프 종류의 수
		int[] inputJump;
		int startX = 1;							//시작위치 (1,0)으로 고정ㅇ
		int startY = 0;
		int result_max = -1;					//결과로 출력할 값
		int [][] map = new int[3][3];			//맵은 3*3으로 고정
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
