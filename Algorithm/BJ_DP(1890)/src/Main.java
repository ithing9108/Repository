import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		int[][] map;
		long[][] score;
		int inputSize;
		Scanner sc = new Scanner(System.in);
		inputSize = sc.nextInt();
		
		map = new int[inputSize][inputSize];
		score = new long[inputSize][inputSize];
		
		for(int i=0; i<inputSize; i++){
			for(int j=0; j<inputSize; j++){
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(jump(map, score));
	}	
	static long jump(int[][] map, long[][] score){
		
		score[0][0] = 1;
	
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[0].length; j++){
				if(i==map.length-1 && j==map[0].length-1) break;
				if (score[i][j] != 0) {                       			// if (score[i][j] == 0) continue;  
					if (j + map[i][j] < map[0].length) {
						score[i][j + map[i][j]] += score[i][j];
					}
					if (i + map[i][j] < map.length) {
						score[i + map[i][j]][j] += score[i][j];        //score[i][j] + 1;
					}
				}
			}
		}
		
		return score[score.length-1][score.length-1];
	}
}
