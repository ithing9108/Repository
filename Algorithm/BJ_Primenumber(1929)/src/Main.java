import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String[] line;
		int sqrt = 0;			//
		int check = 0; 			//소수가 아닌지 체크 
		Scanner sc = new Scanner(System.in);
		
		line = sc.nextLine().split(" ");

		for(int i= Integer.parseInt(line[0]); i<=Integer.parseInt(line[1]); i++){
			sqrt = (int) Math.sqrt(i);
			for(int j=2; j<=sqrt;j++){
				if(i%j==0){
					check = check +1;
				}
			}
			if(check==0 && i>1){
				System.out.println(i);
			}
			check = 0;
		}
		
	}//main
}//Main
