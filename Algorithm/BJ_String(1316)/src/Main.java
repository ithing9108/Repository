import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int number = 0;	//입력받을 단어 수
		int count = 0; 	//그룹단어의 수
		int check = 0;	//그룹단어가 맞는지 체크하기 위해 합을 저장한 배열
		String[] word;	//입력받은 단어를 저장한 배열
		int[] alphabet = new int[26]; //알파벳이 사용됬는지 체크
		Scanner sc= new Scanner(System.in);
		
		number = sc.nextInt();
		sc.nextLine();
		word = new String[number];
		
		for(int i=0; i<number; i++){
			word[i] = sc.nextLine();
		}
		
		for(int j=0; j<number; j++){			//1씩 더하고 그룹단어가 아니면 break로 빠져나가서 더하기를 못한다.
			for(int k=0; k<word[j].length(); k++){
				if((alphabet[word[j].charAt(k)-97]>0) && (word[j].charAt(k)-97!=word[j].charAt(k-1)-97)&& (k!=0)){
					break;
				}
				//System.out.println(word[j]);
				alphabet[word[j].charAt(k)-97] = alphabet[word[j].charAt(k)-97]+ 1;
				check = check +1; 
			}
			
			if(word[j].length() == check){ //더하기1씩 모두 했다면 그룹단어 이므로 갯수에 차이가 있는지 확인하기 위해
				count = count +1;
			}
			check = 0;								//다음 단어를 위해 초기화
			for( int h=0; h<alphabet.length; h++){  //다음 단어를 위해 초기화
				alphabet[h] = 0;
			}
		}

		System.out.println(count); 	//결과 출력 - 그룹단어의 수
		
		
	}//main
}//Main
