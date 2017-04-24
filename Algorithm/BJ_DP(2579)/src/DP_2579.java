import java.util.Scanner;

public class DP_2579 {
	
	private static int[] scoreResult;

	public static void main(String[] args){
		
		int inputNum;
		int[] stairScore;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		stairScore = new int[inputNum];
		scoreResult = new int[inputNum];
		for (int i=0; i<inputNum;i++){
			stairScore[i] = sc.nextInt();			
		}
		System.out.println(climb(stairScore, inputNum));
	}
	
	private static int climb(int[] stairScore, int level){
		int result = 0;
		
		if(level==1) return stairScore[0];
		if(level==2) return stairScore[0] + stairScore[1];
		if(level==3) return Math.max(stairScore[0]+stairScore[2], stairScore[1]+stairScore[2]);
		if(scoreResult[level-1]>0) return scoreResult[level-1];
		
		result = Math.max(climb(stairScore,level-2)+stairScore[level-1], 
				           climb(stairScore,level-3)+stairScore[level-1]+stairScore[level-2]);
		
		scoreResult[level-1] = result;
		
		return result;
	}
}
