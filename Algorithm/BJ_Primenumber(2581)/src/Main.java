import java.util.Scanner;

public class Main {

	public static void main(String[] args){
	
		boolean[] primeList;
		int min = 0;
		int sum = 0;
		int input1, input2;
		Scanner sc = new Scanner(System.in);
		input1 = sc.nextInt();
		input2 = sc.nextInt();
		
		primeList = new boolean[input2+1];
		for(int i=2; i<=Math.sqrt(input2); i++){
			for(int j=input1; j<=input2; j++){
				if(primeList[j]==false){
					if(j%i==0 && j/i>1){
						primeList[j]=true;
					}
				}
			}
		}
		for(int i=input1; i<=input2; i++){
		//	System.out.println(primeList[i]);
			if(primeList[i]==false && i!=1){
				sum += i;
				if(min==0) min = i;
			}
		}
		if (min > 0) {
			System.out.println(sum);
			System.out.println(min);
		}
		else{
			System.out.println("-1");
		}
	}
}
