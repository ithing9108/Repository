import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){

		int inputNum;
		int testNum;
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		inputNum = sc.nextInt();
		for(int i=0; i<inputNum; i++){
			set.add(sc.nextInt());
		}
		testNum = sc.nextInt();
		for(int i=0; i<testNum; i++){
			if(set.contains(sc.nextInt())) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
}
