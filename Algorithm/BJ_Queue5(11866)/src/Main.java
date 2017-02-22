import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
		
		
		int inputA = 0;
		int inputB = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		inputA = sc.nextInt();
		inputB = sc.nextInt();
		
		for(int i=1; i<inputA+1; i++){
			queue.add(i);
		}
		
		System.out.print("<");
		while(queue.size()>1){
			for(int i=0; i<inputB-1; i++){
				queue.add(queue.poll());
			}
			System.out.print(queue.poll()+", ");
		}
		System.out.print(queue.poll() + ">");
	}
}
