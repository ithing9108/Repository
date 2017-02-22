
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int count = 0;
		int insert = 0;
		int modular = 0; //10의자리
		int process = 0; //1의자리 - 중간계산에 필요
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		insert = sc.nextInt();
		
		result = insert;
		
		while(true){
		
			modular = result % 10;                  //10의자리
			process =  ((result /10) + modular)%10; //1의자리
			result = modular * 10 + process;
			count++;
			if(insert == result){
				System.out.println(count);
				break;
			}
		}	
	}
}
