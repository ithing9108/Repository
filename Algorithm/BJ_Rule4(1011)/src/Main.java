/* 백준-규칙찾기(1011)
 * 이전 작동시기에 k광년을 이동하였을 때는 k-1 , k 혹은 k+1 광년만을 다시 이동할 수 있다. 예를 들어, 이 장치를 처음 작동시킬 경우
 *  -1 , 0 , 1 광년을 이론상 이동할 수 있으나 사실상 음수 혹은 0 거리만큼의 이동은 의미가 없으므로 1 광년을 이동할 수 있으며, 
 *  그 다음에는 0 , 1 , 2 광년을 이동할 수 있는 것, 최소 작동 횟수 구하라
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputCount = 0;  //입력 횟수
		String[] line; //입력 1줄1줄
		String[] input;		//입력 내용을 자를 때 사용
		int aaa =6;
		
		Scanner sc = new Scanner(System.in);
		inputCount = sc.nextInt();
		line = new String[inputCount];
		sc.nextLine();
		for(int i=0; i<inputCount; i++){
			line[i] = sc.nextLine();
		}
		for(int i=0; i<inputCount; i++){
			input = line[i].split(" ");
			ruleForFly(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
	}//main
	
	static void ruleForFly(int source, int dest){
		
		int distance = 0; //거리
		int countCalcul = 0; //계산을 위한 카운트
		int calcul = 1;	//계산 결과
		
		distance = dest - source;
		countCalcul = (int) Math.sqrt(distance); 
		
		if(distance ==1){
			System.out.println("1");
		}
		else if(distance == countCalcul*countCalcul ){
			System.out.println(2*countCalcul -1);
		}
		else if(countCalcul*countCalcul<distance && distance <=countCalcul*(countCalcul+1)){
			System.out.println(2*countCalcul);
		}
		else{		//n(n+1)<distance <(n+1)(n+1)
			System.out.println(2*countCalcul +1);
		}
		
	}//ruleForFly
}//Main

