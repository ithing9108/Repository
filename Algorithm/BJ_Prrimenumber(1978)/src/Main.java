
/*�̹����� Ʋ�� ���ε� !! // ���� �˰����� ������ؿ��� �������� üũ�ȴ�.
 *  �Ҽ� * �Ҽ� // �Ҽ��� ����
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		int inputNum =0;
		String[] input;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		sc.nextLine();
		input = sc.nextLine().split(" ");
	
		countPrimeNumber(input);
			
	}//main
	
	static void countPrimeNumber(String[] arr){
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(checkPrimeNumber(Integer.parseInt(arr[i]))){
				count = count+1;
			}
		}
		System.out.println(count);
	}
	
	static boolean checkPrimeNumber(int number){
	
		if(number%2>0 &&number%3>0 && number%5 >0 && number>1 || number==5 || number==2 || number==3){
			return true;	//for������ �Է°����� ��� ������ �� �������°� 1���� ��츦 �Ҽ��� Ǯ���� �ִ�.
		}
		return false;
	}//main
}//Main

/* (�����佺�׳׽��� ü)
 * �־��� �ڿ��� N�� �Ҽ��̱� ���� �ʿ� ��������� N�� N�� �����ٺ��� ũ�� ���� � �Ҽ��ε� �������� �ʴ´�. 
 */