import java.util.Scanner;

public class CrazyBot {

	static boolean[][] map = new boolean[100][100];		// 맵(방문여부 체크)
	static double[] probability = new double[4];		// 동서남북 방향별 확률
	static int[] moveEW = {1, -1, 0, 0};				// 동서방향 이동
	static int[] moveSN = {0, 0, -1, 1};				// 남북방향 이동
	
	public static void main(String[] args){
		
		int[] input = new int[5];						// 0=이동횟수, 1=동, 2=서, 3=남, 4=북
		String[] line;											
		Scanner sc =new Scanner(System.in);
		
		line = sc.nextLine().split(" ");
		for(int i=0; i<5; i++){							// 인풋 값을 할당
			input[i] = Integer.parseInt(line[i]);
		}
		for(int j=0; j<4; j++){							// 동서남북 방향별 확률
			probability[j] = input[j+1] / 100.0;
		}	
		System.out.println(dfs(input[0], 50, 50));		//시작점은 (50,50)으로 고정
	}
	
	static double dfs(int move, int x, int y ){
		double result = 0;
		if(map[x][y]==true) {return 0;}					// 이미 방문한 곳- dfs끝
		if(move==0) {return 1;}							// 더이상 이동할 곳이 없으므로 이 확률 그대로 더한다.
			map[x][y] = true;							// x,y는 방문 완료
		
		for(int k=0; k<4; k++){
			result += dfs(move-1, x+moveEW[k], y+moveSN[k]) * probability[k];
		}
		map[x][y] = false;								//중요!! 독립적인 dfs들이 서로 영향을 주지 않기 위해 !! - 시간 투자..
		return result;
	}
}
