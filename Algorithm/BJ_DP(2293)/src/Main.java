import java.util.Scanner;
import java.util.Arrays;

public class Main {

	private static int[] result;

	public static void main(String[] args) {

		int inputNum;
		int goal;
		int[] inputMoney;
		Scanner sc = new Scanner(System.in);

		inputNum = sc.nextInt();
		goal = sc.nextInt();
		inputMoney = new int[inputNum];
		result = new int[goal + 1];

		for (int i = 0; i < inputNum; i++)
			inputMoney[i] = sc.nextInt();

		System.out.println(money(inputMoney, goal));

	}

	private static int money(int[] inputMoney, int goal) {

		Arrays.sort(inputMoney);
		result[0] = 1;

		for (int j = 0; j<inputMoney.length; j++) {		//포문 2개를 거꾸로해서 오답 나와서 고생....
			for (int i = 0; i < goal + 1; i++) {

				if (i + inputMoney[j] < goal + 1) {
					result[i + inputMoney[j]] += result[i];
				}
			}
		}
		return result[goal];
	}
}
