import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args){
		
		int count = 0;
		int total = 0;
		int max = 0;
		int par = 0;
		float average = 0;
		ArrayList list = new ArrayList();
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		count = count - 1;
		for(int i =0; i<=count; i++){
			list.add(sc.nextInt());
		}
		Collections.sort(list);
	
		max = (int) list.get(count);
		
		for(int i=0; i<=count; i++){
			total = total + (int)list.get(i);
		}
		average = total / (float)(count+1);
		average =  average / (float)max *100;
		System.out.printf("%.2f", average);
		
		
		
		/*	for(int i =0; i<count; i++){
			System.out.println(list.get(i));
		}*/
	}
	
}
