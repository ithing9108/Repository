/*
 	입력값으로부터 회문을 만들 수 있는 최소 글자 수
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = "";
		boolean flag;
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		
		for(int i=input.length(); ; i++){
			flag = true;				// 모두 일치 -> 출력  if(flag)
			
			for(int j=0; j<input.length(); j++){
				if( (i-j-1)<input.length() && input.charAt(j)!=input.charAt(i-j-1) ){	//비교 범위 설정 (j값이 커지게 && 실제 비교)
					flag = false;		// 나머지가 일치해도 출력X, 1추가 
					break;
				}
			}
			if(flag) {
				System.out.println(i);
				return;
			}
		}	
	}
}
