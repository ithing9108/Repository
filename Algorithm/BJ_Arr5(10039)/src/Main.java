import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int[] insert = new int[5];
		int total = 0;
		int average = 0;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++){
			insert[i] = sc.nextInt();
			if(insert[i]<40){
				total = total + 40;
			}
			else{
				total = total + insert[i];
			}
		}
		average = total / insert.length;
		System.out.println(average);	
	}
}
