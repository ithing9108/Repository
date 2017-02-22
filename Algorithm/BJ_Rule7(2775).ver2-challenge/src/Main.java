import java.util.Scanner;

public class Main {

	static int preStair =0;
	static int preRoomNumber = 0;
	
	public static void main(String[] args){
	
		int inTestNum = 0;		//테스트 횟수
		int inRoomStair = 0;	//입력 층
		int inRoomNumber = 0;	//입력 호수
		int[][] data = new int[15][14];
		Scanner sc = new Scanner(System.in);
		
		inTestNum = sc.nextInt();
		for(int h=0; h<inTestNum; h++){
			inRoomStair = sc.nextInt();								//유저 입력
			inRoomNumber = sc.nextInt();
			System.out.println(countRoomPeople(inRoomStair, inRoomNumber));	//결과 출력
		}
	}//main
	
	static int countRoomPeople(int stair, int roomNumber){
		
		if (stair ==0){
			System.out.println("room number : "+roomNumber);
			return roomNumber;
		}
		else if(roomNumber ==1){
			return 1;
		}
		else if (stair > 0 && roomNumber > 1) {
			preStair = countRoomPeople(stair - 1, roomNumber);
			preRoomNumber = countRoomPeople(stair, roomNumber - 1);
			System.out.println(preStair +" "+ preRoomNumber);
		}
		return preStair + preRoomNumber;
	}
	
}//Main
