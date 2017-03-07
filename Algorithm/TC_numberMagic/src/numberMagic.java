/*
		카드1 = 1,2,3,4,5,6,7,8   / 카드2 = 1,2,3,4,9,10,11,12  / 카드3 = 1,2,5,6,9,10,13,14  / 카드4 = 1,3,5,7,9,11,13,15
		카드 4장을 이용한 4번의 질문으로 상대방이 생각한 숫자를 맞춰라
 */
import java.util.Scanner;

public class numberMagic {

	public static void main(String[] args){

		int result = 1;
		int square = 8;						//대답에 따라 더하는 값
		String input ="";
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();				//입력방식 = YYYY ~ NNNN
		
		for(int i=0;i<4; i++){
			if(input.charAt(i)=='Y'){
				
			}
			else if (input.charAt(i)=='N'){
				result += square;
			}
			square /= 2;
		}
		System.out.println(result);
	}
}
	
/* 다른 방법
	YYYYYYYYNNNNNNNN
	YYYYNNNNYYYYNNNN
	YYNNYYNNYYNNYYNN
	YNYNYNYNYNYNYNYN		//입력값 문자열과 비교해서 그대로 출력
*/