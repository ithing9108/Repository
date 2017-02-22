import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String insert;
		char result;
		Scanner sc = new Scanner(System.in);
		
		insert = sc.next();
		result = insert.charAt(0);
		System.out.println((int)result);
	}
}
