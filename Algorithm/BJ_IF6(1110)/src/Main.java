
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int count = 0;
		int insert = 0;
		int modular = 0; //10���ڸ�
		int process = 0; //1���ڸ� - �߰���꿡 �ʿ�
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		insert = sc.nextInt();
		
		result = insert;
		
		while(true){
		
			modular = result % 10;                  //10���ڸ�
			process =  ((result /10) + modular)%10; //1���ڸ�
			result = modular * 10 + process;
			count++;
			if(insert == result){
				System.out.println(count);
				break;
			}
		}	
	}
}
