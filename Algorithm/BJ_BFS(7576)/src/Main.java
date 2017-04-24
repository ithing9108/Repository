import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int[][] now;
	
	public static void main(String[] args){
		Queue<Pair> q = new LinkedList<Pair>();
		int inRow;
		int inCol;

		int[][] next;
		Scanner sc = new Scanner(System.in);
		inCol = sc.nextInt();
		inRow = sc.nextInt();
		now = new int[inRow][inCol];
		next = new int[inRow][inCol];

		for (int i = 0; i < inRow; i++) {
			for (int j = 0; j < inCol; j++) {
				now[i][j] = sc.nextInt();
				if(now[i][j]==1)
					q.add(new Pair(i,j));
			}
		}
		System.out.println(tomato(q, inRow, inCol, -1));
	}

	static int tomato(Queue q, int row, int col, int fail) {

		int check = 0;
		int max = 0;
		int[] nextX = { 1, -1, 0, 0 };
		int[] nextY = { 0, 0, 1, -1 };
		int[][] temp = new int[now.length][now[0].length];
		int[][] score = new int[row][col];
		Pair p;
		int i,j;
		
		while(!q.isEmpty()){
			p = (Pair) q.remove();
			i = p.x;
			j = p.y;
						
			if (i + nextX[0] < now.length)
				if (now[i + nextX[0]][j] != -1 && now[i + nextX[0]][j] ==0){
					q.add(new Pair(i+nextX[0], j));
					now[i+nextX[0]][j] = 1;	
					score[i+nextX[0]][j] = score[i][j]+1; 	
				}
			if (i + nextX[1] >= 0 && now[i + nextX[1]][j] != -1 && now[i + nextX[1]][j] ==0){
				q.add(new Pair(i+nextX[1], j));
				now[i+nextX[1]][j] = 1;
				score[i+nextX[1]][j] = score[i][j] + 1;
			}
			if (j + nextY[2] < now[0].length)
				if (now[i][j + nextY[2]] != -1 && now[i][j + nextY[2]] ==0){
					q.add(new Pair(i, j+nextY[2]));
					now[i][j+nextY[2]] = 1;
					score[i][j+nextY[2]] = score[i][j] + 1;
				}
			if (j + nextY[3] >= 0 && now[i][j + nextY[3]] != -1 && now[i][j + nextY[3]] ==0){
				q.add(new Pair(i, j+nextY[3]));
				now[i][j+nextY[3]] = 1;
				score[i][j+nextY[3]] = score[i][j] + 1;
			}
		}

		for (int h = 0; h < now.length; h++) {
			for (int l = 0; l < now[0].length; l++) {
				if (now[h][l] == 0) {
					check = 1;
					break;
				}
			}

			if (check == 1) {
				break;
			}
		}
		if (check == 1)
			return -1;

		for (int h = 0; h < now.length; h++) {
			for (int l = 0; l < now[0].length; l++) {
				if(max<score[h][l])
					max = score[h][l];
			}
		}
		
		return max;
	}
}

