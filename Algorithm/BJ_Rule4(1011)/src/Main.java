/* ����-��Ģã��(1011)
 * ���� �۵��ñ⿡ k������ �̵��Ͽ��� ���� k-1 , k Ȥ�� k+1 ���⸸�� �ٽ� �̵��� �� �ִ�. ���� ���, �� ��ġ�� ó�� �۵���ų ���
 *  -1 , 0 , 1 ������ �̷л� �̵��� �� ������ ��ǻ� ���� Ȥ�� 0 �Ÿ���ŭ�� �̵��� �ǹ̰� �����Ƿ� 1 ������ �̵��� �� ������, 
 *  �� �������� 0 , 1 , 2 ������ �̵��� �� �ִ� ��, �ּ� �۵� Ƚ�� ���϶�
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputCount = 0;  //�Է� Ƚ��
		String[] line; //�Է� 1��1��
		String[] input;		//�Է� ������ �ڸ� �� ���
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
		
		int distance = 0; //�Ÿ�
		int countCalcul = 0; //����� ���� ī��Ʈ
		int calcul = 1;	//��� ���
		
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

