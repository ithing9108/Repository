import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int insert = 0;
		int distance = 0;
		int var = 0;
		
		Scanner sc = new Scanner(System.in);
		insert = sc.nextInt();
		if(1<=insert && insert<=100){
			for(var=1; var<=insert; var++){
				distance = insert - var;
				for (int i=0; i<distance; i++){
				System.out.print(" ");
				}
				for (int j=0; j<var; j++){
				System.out.print("*");
				}
				System.out.println("");
			}
		}
		
		
	}
}
