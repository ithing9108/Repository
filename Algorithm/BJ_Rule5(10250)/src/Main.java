import java.util.Scanner;
public class Main {
	
	public static void main(String[] args){
	
		int inNumber = 0; 		//ÀÎÇ² °¹¼ö
		String[] inTotal;		//ÀüÃ¼ ÀÎÇ²
		String[] hotInfo;
		int hotWidth = 0;
		int hotHeight = 0;
		int hotNumber = 0;
		
		Scanner sc = new Scanner(System.in);
		inNumber = sc.nextInt();
		sc.nextLine();
		inTotal = new String[inNumber];
		for(int i=0; i<inNumber; i++){
			inTotal[i] = sc.nextLine();
		}
		for (int j=0; j<inNumber; j++){
			hotInfo = inTotal[j].split(" ");
			hotWidth = Integer.parseInt(hotInfo[1]);
			hotHeight = Integer.parseInt(hotInfo[0]);
			hotNumber = Integer.parseInt(hotInfo[2]);
			if (hotWidth <= 99 && hotHeight <= 99 && hotWidth >= 1 && hotHeight >= 1 && hotNumber >= 1 && hotNumber <= hotWidth * hotHeight) {
				findRoomNumber(hotWidth, hotHeight, hotNumber);
			}
		}
	}//main
	
	static void findRoomNumber(int width, int height, int number){
		
		int result = 0; 		//°á°ú °ª
		int resultWidth = 1;
		int resultHeight = 1;
		
		for(;height<number;){
			number = number - height;
			resultWidth = resultWidth + 1;
		}
		resultHeight = number*100;
		result = resultHeight + resultWidth; 
		System.out.println(result);
	}//findRoomNumber
}//Main
