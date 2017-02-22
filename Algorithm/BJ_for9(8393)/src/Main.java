import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		int insert = 0;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		insert = sc.nextInt();
		
		if(insert>=1 && insert<=10000){
			for(int i=1; i<=insert; i++){
				result = result + i;
			}
			System.out.println(result);
		}
		
	}

}
