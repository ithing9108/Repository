import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inNum = 0;		//입력 숫자
		String[] inStr;		//입력 OX
		Scanner sc = new Scanner(System.in);		
		String[] result;			//결과를 X로 자른 배열 'OOO' 			
		int numResult = 0;
		int temp = 0;				//OOO 갯수를 임시로 입력
		
		inNum = sc.nextInt();
		inStr = new String[inNum];	//입력 숫자로 배열 선언
		sc.nextLine();    			//개행문자 제거  or sc.next()를 사용해도 됨
		
		for(int i=0; i<inNum; i++){
			inStr[i] = sc.nextLine();	//OX 값 받기
		}
		
		for(int t=0; t<inNum; t++){
			result = inStr[t].split("X");
			
			for(int k=0; k<result.length; k++){
				temp = result[k].length();
				for(; temp>0; temp-- ){
					numResult = numResult + temp;
				}
			}
			System.out.println(numResult);
			numResult = 0;
		}	
	}//main
}//Main
