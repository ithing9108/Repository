import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String[] line;					//1줄 	
		String[] word;					//1줄을 split으로 쪼갠 word
		String result = new String();	// 결과 
		int total = 0; //전체 인풋의 수
		int count = 0; //각 알파벳의 반복 횟수
		
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();		//총 입력 횟수
		line = new String[total];
		sc.nextLine();
		for(int k=0; k<total; k++){
			line[k] = sc.nextLine();
		}
		
		for(int t=0; t<total; t++){
			if (line[t].length() != 1) {
				word = line[t].split(" ");
				count = Integer.parseInt(word[0]);		//반복 횟수

				for (int i = 0; i < word[1].length(); i++) {
					for (int j = 0; j < count; j++) {
						result = result + word[1].charAt(i);	//새롭게 바꾼 결과
					}
				}
				System.out.println(result);			//결과 출력
				result = "";	//초기화
			}
		}
		sc.close();
	}//main
}//Main
