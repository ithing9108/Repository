import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = new String();			
		int max = 0;		//최대값
		int temp = 0;		//임시 저장
		int count = 0;		//쓰인횟수
		int[] result = new int[26];
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		for(int i=0; i<input.length(); i++){
			if (input.charAt(i)>=97 && input.charAt(i)<=122 ){	//소문자인 경우
				result[input.charAt(i)-97] = result[input.charAt(i)-97] + 1;
			}
			else if (input.charAt(i)>=65 && input.charAt(i)<=90)//대문자인 경우
			{
				result[input.charAt(i)-65] = result[input.charAt(i)-65] + 1;
			}	
		}
		
		for(int j=0; j<result.length; j++){
			if(result[j]>=count){
				temp = count;	//최대값 같은게 2개인지 확인하기 위해
				count = result[j]; 
				max = j;		//최대값이 몇번 쨰 단어인지
			}			
		}
		if (temp==count){		//최대값이 2개인지 체크
			System.out.println("?");		//최대값 2개면 ? 출력
		}
		else{
			System.out.printf("%c", max+65 );//결과 출력
		}
		
	}//main
}//Main
