import java.util.Scanner;

public class CrazyBot {

	static boolean[][] map = new boolean[100][100];		// ��(�湮���� üũ)
	static double[] probability = new double[4];		// �������� ���⺰ Ȯ��
	static int[] moveEW = {1, -1, 0, 0};				// �������� �̵�
	static int[] moveSN = {0, 0, -1, 1};				// ���Ϲ��� �̵�
	
	public static void main(String[] args){
		
		int[] input = new int[5];						// 0=�̵�Ƚ��, 1=��, 2=��, 3=��, 4=��
		String[] line;											
		Scanner sc =new Scanner(System.in);
		
		line = sc.nextLine().split(" ");
		for(int i=0; i<5; i++){							// ��ǲ ���� �Ҵ�
			input[i] = Integer.parseInt(line[i]);
		}
		for(int j=0; j<4; j++){							// �������� ���⺰ Ȯ��
			probability[j] = input[j+1] / 100.0;
		}	
		System.out.println(dfs(input[0], 50, 50));		//�������� (50,50)���� ����
	}
	
	static double dfs(int move, int x, int y ){
		double result = 0;
		if(map[x][y]==true) {return 0;}					// �̹� �湮�� ��- dfs��
		if(move==0) {return 1;}							// ���̻� �̵��� ���� �����Ƿ� �� Ȯ�� �״�� ���Ѵ�.
			map[x][y] = true;							// x,y�� �湮 �Ϸ�
		
		for(int k=0; k<4; k++){
			result += dfs(move-1, x+moveEW[k], y+moveSN[k]) * probability[k];
		}
		map[x][y] = false;								//�߿�!! �������� dfs���� ���� ������ ���� �ʱ� ���� !! - �ð� ����..
		return result;
	}
}