import java.util.Scanner;

public class Main {

	private static int[][] totalDrink;
	private static int[] wine;

	public static void main(String[] args) {

		int inputNum;
		Scanner sc = new Scanner(System.in);
		inputNum = sc.nextInt();
		wine = new int[inputNum];
		totalDrink = new int[3][inputNum];
		for (int i = 0; i < inputNum; i++)	wine[i] = sc.nextInt();

		System.out.println(drink(inputNum));
	}

	private static int drink(int amount) {

		if(amount==2) return wine[0]+wine[1];
		if(amount==1) return wine[0];
		
		totalDrink[2][2] = wine[1]+wine[2];
		totalDrink[1][2] = wine[0]+wine[2];
		totalDrink[0][2] = wine[0]+wine[1];
		
		for (int i = 3; i < amount; i++) {
			totalDrink[2][i] = totalDrink[1][i - 1] + wine[i];
			totalDrink[1][i] = totalDrink[0][i - 1] + wine[i];
			totalDrink[0][i] = Math.max(Math.max(totalDrink[1][i - 1], totalDrink[2][i - 1]), totalDrink[0][i - 1]);
		}
		return Math.max(Math.max(totalDrink[1][amount-1], totalDrink[2][amount-1]), totalDrink[0][amount-1]);
	}

}
