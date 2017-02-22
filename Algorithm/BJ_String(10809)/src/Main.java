import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		String input = new String();
		Scanner sc = new Scanner(System.in);
		int[] count = new int[26];
		int aschi = 0;	//아스키코드 값으로 잠시 담을 변수
		
		input = sc.next();
		for(int i=0; i<26; i++){
			count[i] = -1;
		}
		
		for(int j=0; j<input.length(); j++){
			aschi = (int)input.charAt(j) - 97;	//a=97, b=98
			if(count[aschi] == -1){
				count[aschi] = j;
			}
		}
		for(int k=0; k<count.length; k++){
			System.out.print(count[k] + " ");
		}
		
	}//main
}//Main
