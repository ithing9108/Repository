/*시간초과 - ver2.에서 해결*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
												
		int input = 1;
		int check = 0; // 소수인지 체크
		int count = 0; // 결과값 출력
		int checkList = 0; //어레이리스트에 값이 있는지 체크
		ArrayList<Integer> list = new ArrayList<Integer>(); // 소수만 리스트에 저장하면 속도는 더 빠르게 가능할듯!
											// for (Integer number : list) {}
											// !!!
		Scanner sc = new Scanner(System.in);

		while (input != 0) {
			input = sc.nextInt();
			if(input ==0)
				return;
			for (int i = input + 1; i <= input * 2; i++) {
				for (Integer primeNumber : list) {
					if(i%primeNumber ==0){
						checkList = 1;
						break;
					}
					if(i==primeNumber){
						count = count +1;
						checkList = 1;
						break;
					}
				}
				if(checkList==1){
					checkList = 0;
					continue;
				}
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						check = check + 1;
					}
				}
				if (check == 0) {
					count = count + 1;
					list.add(i);
				}
				check = 0;
			}
			System.out.println(count);
			count = 0;
	//		input = sc.nextInt();
		}
	}
}