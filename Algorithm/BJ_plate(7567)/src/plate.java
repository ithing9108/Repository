/*  �׸��� �ٴڿ� ������ �� �� ���̴� 10cm �̴�. �׷��� �� ���� �׸��� ���� �������� ������ �� ���̴� 5cm�� �����ȴ�.
 *  ���� �׸��� ���� �ݴ�������� ���̸� ���̴� �׸���ŭ, �� 10cm �þ��. �׸��� ��ȣ ��ȣ�� ��Ÿ���� �����غ���.
 *  ���ǻ� �׸��� �׿����� ������ ���ʿ��� �������̶�� �����Ѵ�. �׸����� ��(���� �׸��� �ٴڿ� �ٷ� ���� ���¸� ��Ÿ����, ��)
 *  ���� �׸��� �Ųٷ� ���� ���¸� ��Ÿ����    */

import java.util.Scanner;

public class plate {

	public static void main(String[] args){
		
		int result = 10;
		String input = "";
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		for(int i=1; i<input.length(); i++){
			if(input.charAt(i)==input.charAt(i-1)){
				result += 5;
			}
			else{
				result +=10;
			}
		}
		System.out.println(result);
	}
}

