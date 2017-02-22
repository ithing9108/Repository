import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inA = 0;	//입력값A
		int inB = 0;	//입력값B
		int inC = 0;	//입력값C
		int multi = 0;	//A,B,C의 곱
		int count = 1;  //자릿수를 찾아가기 위한 변수, 이중포문 사용않기 위해
		int temp = 0;	//배열에 집어넣기 전에 임시로 사용하는 변수
		int[] result = new int[10];	//결과를 입력할 배열 생성, 0으로 초기화
		
		Scanner sc = new Scanner(System.in);
		inA = sc.nextInt();
		inB = sc.nextInt();
		inC = sc.nextInt();
		
		multi = inA * inB * inC;
		
		for(;count<multi;){
			count = count * 10; // 10을 곱하면서 같은자릿수를 찾는다.
		}
		count = count/10;		// 더 커졌으므로 10을 나눈다.
		
		for(;count>=1;){
			temp = multi / count;		//자릿수 값
			multi = multi -(temp*count);//위에서 계산한값을 빼준다.
			count = count/10;			//count값도 10으로 나눈다
			result[temp] = result[temp] + 1;			//결과 배열에 1을 더해줘서 결과를 반영
		}	
		
		for(int i=0; i<10; i++){		//결과 출력
			System.out.println(result[i]);
		}
	}
}
