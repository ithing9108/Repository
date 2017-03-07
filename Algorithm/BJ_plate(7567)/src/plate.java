/*  그릇을 바닥에 놓았을 때 그 높이는 10cm 이다. 그런데 두 개의 그릇을 같은 방향으로 포개면 그 높이는 5cm만 증가된다.
 *  만일 그릇이 서로 반대방향으로 쌓이면 높이는 그릇만큼, 즉 10cm 늘어난다. 그릇을 괄호 기호로 나타내어 설명해보자.
 *  편의상 그릇이 쌓여지는 방향은 왼쪽에서 오른쪽이라고 가정한다. 그림에서 ‘(’은 그릇이 바닥에 바로 놓인 상태를 나타내며, ‘)
 *  ’은 그릇이 거꾸로 놓인 상태를 나타낸다    */

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

