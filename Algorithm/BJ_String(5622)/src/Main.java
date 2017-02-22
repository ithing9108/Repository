import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = new String();
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i)<80){			// 여기까진 규칙
				result = result + (input.charAt(i)-59)/3 +1;
			}
			else if(input.charAt(i)<84){	//나머지 3개는 떼려박았다!
				result = result + 8;
			}
			else if(input.charAt(i)<87){
				result = result + 9;
			} 
			else{
				result = result + 10;
			}
		}
		
		System.out.println(result);			//결과 출력
		
	}//main
}//Main
