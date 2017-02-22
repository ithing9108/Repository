import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String insert = "";
		String[] result;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		insert = sc.nextLine();
		
		result = insert.trim().split(" ");
		count = result.length;
		if(result[0].equals(""))
			count--;
		
		System.out.print(count);
		
	}
	
}
