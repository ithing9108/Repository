import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		int testNum;
		int A,B;
		int temp;
		Scanner sc = new Scanner(System.in);	
		testNum = sc.nextInt();
		
		for(int i=0; i<testNum; i++){
			A= sc.nextInt();
			B= sc.nextInt();
			temp= Math.max(A, B);
			B= Math.min(A, B);
			A= temp;
			for(int j=1; j<=B; j++){
				if(A*j%B==0){
					System.out.println(A*j);
					break;
				}
			}
		}
	}
}
