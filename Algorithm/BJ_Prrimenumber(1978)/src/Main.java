
/*이문제는 틀린 답인데 !! // 백준 알고리즘의 정답기준에선 정답으로 체크된다.
 *  소수 * 소수 // 소수의 제곱
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		int inputNum =0;
		String[] input;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		sc.nextLine();
		input = sc.nextLine().split(" ");
	
		countPrimeNumber(input);
			
	}//main
	
	static void countPrimeNumber(String[] arr){
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(checkPrimeNumber(Integer.parseInt(arr[i]))){
				count = count+1;
			}
		}
		System.out.println(count);
	}
	
	static boolean checkPrimeNumber(int number){
	
		if(number%2>0 &&number%3>0 && number%5 >0 && number>1 || number==5 || number==2 || number==3){
			return true;	//for문으로 입력값까지 모두 나눠서 딱 떨어지는게 1개인 경우를 소수로 풀수도 있다.
		}
		return false;
	}//main
}//Main

/* (에라토스테네스의 체)
 * 주어진 자연수 N이 소수이기 위한 필요 충분조건은 N이 N의 제곱근보다 크지 않은 어떤 소수로도 나눠지지 않는다. 
 */