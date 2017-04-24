import java.util.Scanner;

public class Main {
	public static void main(String[] args){

		
		int inRow;
		int inCol;
		int[][] map;
		Scanner sc = new Scanner(System.in);
		
		inRow = sc.nextInt();
		inCol = sc.nextInt();
		map = new int[inRow][inCol];
		for(int i=0; i<inRow; i++){
			for(int j=0; j<inCol; j++){
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(DP_Candy(map));
	}
	static int DP_Candy(int[][] arr){
		
		int[][] score = new int [arr.length][arr[0].length];
		score[0][0] = arr[0][0];
		
		for(int i=1; i<arr[0].length; i++)
			score[0][i] = score[0][i-1] + arr[0][i];
		for(int j=1; j<arr.length; j++)
			score[j][0] = score[j-1][0] +arr[j][0];

		for(int j=1; j<arr[0].length; j++){
			for(int i=1; i<arr.length; i++){
				score[i][j] = Math.max(Math.max(score[i-1][j], score[i][j-1]),score[i-1][j-1]) + arr[i][j];
			}
		}
		
		return score[arr.length-1][arr[0].length-1];
	}
}
