import java.util.Scanner;
import java.util.Arrays;

public class ver2 {

	public static void main(String[] args){
		
		
		int red = 0;
		int green = 0;
		int blue = 0;
		int inputNum = 0;
		int tempRed, procRed1, procRed2 = 0;
		int tempGreen, procGreen1, procGreen2 = 0;
		int tempBlue, procBlue1, procBlue2 = 0;
		int[] sortArray = new int[3];
		Scanner sc = new Scanner(System.in);
	
		inputNum = sc.nextInt();

		red = sc.nextInt();
		green = sc.nextInt();
		blue = sc.nextInt();
		
		for(int i=1; i<inputNum; i++){
		
			tempRed = sc.nextInt();
			tempGreen = sc.nextInt();
			tempBlue = sc.nextInt();
			
			procRed1 = tempRed + green;
			procRed2 = tempRed + blue;
			procBlue1 = tempBlue + red;
			procBlue2 = tempBlue + green;
			procGreen1 = tempGreen + red;
			procGreen2 = tempGreen + blue;
	
			if(procRed1>procRed2){red = procRed2;}
			else{red = procRed1;}
			if(procBlue1>procBlue2){blue = procBlue2;}
			else{blue = procBlue1;}
			if(procGreen1>procGreen2){green = procGreen2;}
			else{green = procGreen1;}
	
		}
		
		sortArray[0]= red;
		sortArray[1]= green;
		sortArray[2]= blue;
		Arrays.sort(sortArray);
		System.out.println(sortArray[0]);
	}
}
