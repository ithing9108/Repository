import java.util.Scanner;

public class Main {

	public static void main(String[] args){
	
		int inTestNum = 0;		//테스트 횟수
		int inRoomStair = 0;	//입력 층
		int inRoomNumber = 0;	//입력 호수
		int[][] data = new int[15][14];
		Scanner sc = new Scanner(System.in);
	
		for(int i=0; i<14; i++){	//1행의 초기값
			data[0][i] = i+1;
		}
		for(int t=0; t<15; t++){	//1열의 초기값
			data[t][0] = 1;
		}
		
		for(int j=1;j<15;j++){		//규칙을 통한 데이터 배열 새성
			for(int k=1; k<14; k++){
				data[j][k] = data[j][k-1] + data[j-1][k];
			}
		}
		
		inTestNum = sc.nextInt();
		for(int h=0; h<inTestNum; h++){
			inRoomStair = sc.nextInt();								//유저 입력
			inRoomNumber = sc.nextInt();
			System.out.println(data[inRoomStair][inRoomNumber-1]);	//결과 출력
		}
		
		
	}//main
}//Main
