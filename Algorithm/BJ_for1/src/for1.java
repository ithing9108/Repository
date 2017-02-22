import java.util.Scanner;

public class for1 {

	public static void main(String[] args){
		
		int insert = 0;
		int count = 0;
		
		Scanner input = new Scanner(System.in);
		insert = input.nextInt();
		
		for(count=1; count<=insert; count++){
			System.out.println(count);
		}		
	}
}
