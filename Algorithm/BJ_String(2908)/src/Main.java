import java.util.Scanner;
public class Main {
	
	public static void main(String[] args){
		
		String input = new String();	//입력
		String[] numb;	//숫자 값을 받아서 넣을 배열
		String result1 = "";	//숫자를 뒤집은 결과1
		String result2 = ""; //숫자를 뒤집은 결과2
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		numb = input.split(" ");
		
		for(int i=numb[1].length()-1; i>=0; i--){
			result1 = result1 + numb[1].charAt(i);
		}

		for(int j=numb[0].length()-1; j>=0; j--){
			result2 = result2 + numb[0].charAt(j);
		}
		
		if(Integer.parseInt(result1)>Integer.parseInt(result2)){
			System.out.println(result1);
		}
		else{
			System.out.println(result2);
		}
		
	}//main
}//Main
