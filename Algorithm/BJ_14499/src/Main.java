import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int posX = sc.nextInt();
		int posY = sc.nextInt();
		int orderNum = sc.nextInt();
		int diceX = 1;
		int diceY = 1;
		int[] orderList = new int[orderNum];
		int[][] map = new int[row][col];
		int[][] dice = new int[4][3];
		
		for(int i=0; i<row; i++){
			for (int j=0; j<col; j++){
				map[i][j] = sc.nextInt();	
			}
		}
		for(int k=0; k<orderNum; k++){
			orderList[k] = sc.nextInt();
			move(map, posX, posY, dice, diceX, diceY, orderList[k]);
		}
	}
	
	static void move(int[][] map, int posX, int posY, int[][] dice, int diceX, int diceY, int order){
		int answer = 0;
		int check = 0;
		if(order==1){
			if(posX+1<map[0].length-1){
				check =1;
				posX++;
				if(map[posX][posY]==0){
					map[posX][posY] = dice[diceX][diceY];
				}
				else{
					dice[diceX][diceY] = map[posX][posY];
					map[posX][posY] = 0;
				}
				answer = upper(dice, diceX, diceY);
				if(diceY==2) diceY=0;
				else diceY++;

			}	
		}
		else if (order==2){
			
		}
		else if(order==3){
			
		}
		else if(order==4){
			
		}
		
		if(check ==1)
			System.out.println(answer);
	}
	static int upper(int[][] dice, int diceX, int diceY){
		//System.out.println(diceX);
		if(diceX==1){
			System.out.println("222222222222");
			if(diceY==0) return dice[1][2];
			else if(diceY==2)return dice[1][0];
		}
		else{
			//System.out.println("3333333");
			if(diceY<=1) return dice[diceX][diceY+2];
			else if(diceY==2) return dice[diceX][0];
			else if(diceY==3) return dice[diceX][1];
		}
		return 0;
	}
}