import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args){
		
		String[] firstInput;
		String[] input;
		Scanner sc = new Scanner(System.in);
		firstInput = sc.nextLine().split(" ");
		input = new String[Integer.parseInt(firstInput[1])];
		
		for(int i=0; i<Integer.parseInt(firstInput[1]); i++) {
			input[i] = sc.nextLine();
		}
		
		DFS(firstInput, input);
		BFS(firstInput, input);
	}//main
	
	static void DFS(String[] firstInput, String[] input){
		Queue<String> dfsQueue = new LinkedList<String>();
	
	}//DFS
	
	static void BFS(String[] firstInput, String[] input){
		Queue bfsQueue = new LinkedList<String>(); 
		ArrayList forSort = new ArrayList();
		int start = Integer.parseInt(firstInput[2]);
		int nextStart = 0;
		int pointNumber = Integer.parseInt(firstInput[0]);
		int edgeNumber = Integer.parseInt(firstInput[1]);
		int j=0;
		String[] line;
		for (int i=0; i<Integer.parseInt(firstInput[1]); i++){
			line = input[i].split(" ");
			if(start ==Integer.parseInt(line[0])){
				forSort.add(line[0]);
			}
			Collections.sort(forSort);
			while(!forSort.isEmpty()){
				bfsQueue.add(forSort.get(j));
				forSort.remove(j);
				j= j+1;
			}
			j=0;
		}
		
	}//BFS
}//Main
