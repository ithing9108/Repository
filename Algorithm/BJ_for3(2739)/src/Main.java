import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int insert = 0;  // 사용자 입력 값
		int nine = 0;    // 1~9
		int result = 0;  // 계산 결과
		Scanner sc = new Scanner(System.in);
		
		insert = sc.nextInt();  
		
		for(nine=1; nine<10; nine++){
			result = insert * nine;
			System.out.println(insert +" * " +nine + " = " +result);
		}
		
	}
}
