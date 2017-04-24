import java.util.Scanner;

public class Main {
	public static void main(String[] args){

		int A, B, temp;
		int answer1;  // 최대공약수
		int answer2;  // 최소공배수
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		answer2 = A*B;
		
		temp = Math.max(A, B);
		B = Math.min(A, B);
		A = temp;
		
		if(A==B){
			System.out.println(A);
			System.out.println(A);
			return;
		}
		
		while(true){
			temp = B;
			B = A%B;
			A=temp;
			if(B==0) break;
		}
		answer1 = A;
		answer2 /=A;
		System.out.println(answer1);
		System.out.println(answer2);
	}	
}
