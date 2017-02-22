import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int distance = 0;
		int insert = 0;
		String result = "";

		Scanner sc = new Scanner(System.in);
		insert = sc.nextInt();

		if (insert >= 1 && insert <= 100) {
			for (int i = insert; i > 0; i--) {

				distance = insert - i;
				for (int r = 0; r < distance; r++) {
					result = result.concat(" ");
					// result = result + " ";
				}
				for (int t = 0; t < i; t++) {
					result = result.concat("*");
					// result = result + "*";
				}

				// result = "444444";
				System.out.println(result);
				result = "";
			}
		}

	}

}
