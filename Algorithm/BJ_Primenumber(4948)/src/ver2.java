import java.util.ArrayList;
import java.util.Scanner;

public class ver2 {

	public static void main(String[] args) {

		int input = 1;
		int check = 0; // �Ҽ����� üũ
		int count = 0; // ����� ���
		int checkList = 0; //��̸���Ʈ�� ���� �ִ��� üũ
		ArrayList<Integer> list = new ArrayList<Integer>(); // �Ҽ��� ����Ʈ�� �����ϸ� �ӵ��� �� ������ �����ҵ�!
											// for (Integer number : list) {}
		list.add(2);									// !!!
		Scanner sc = new Scanner(System.in);

			for (int i = 2 ; i <=246912 ; i++) {
				for (Integer j : list) {
					if (i % j == 0) {
						check = check + 1;
						break;
					}
				}
				if (check == 0) {
					list.add(i);
				}
				check = 0;
			}
	
		while (true) {
			input = sc.nextInt();
			if (input == 0)
				return;

			for (int k = input+1; k <= input * 2; k++) {
				for (Integer primeNumber : list) {
					if(Math.sqrt(k)<primeNumber){	//�ð� ������ �ٽ�... 
						count = count + 1;
						checkList=1;
						break;		
					}
					//System.out.println(k +" " + primeNumber);
					if (k % primeNumber == 0 && k!=primeNumber) {
						checkList = 1;
						break;
					}
					if (k == primeNumber) {
						count = count + 1;
						checkList = 1;
						break;
					}
				}
				if(checkList==1){
					checkList = 0;
					continue;
				}
			}
			System.out.println(count);
			count=0;	
		
		}
	}	
}


/*
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
*/

