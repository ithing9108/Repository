import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputNum = 0;
		String[] input;
		String[] line;
		Scanner sc = new Scanner(System.in);
		testQueue queue = new testQueue();
		
		inputNum = sc.nextInt();
		input = new String[inputNum];
		sc.nextLine();
		
		for(int j=0; j<inputNum; j++){
			input[j] = sc.nextLine();
		}
		
		for(int i=0; i<inputNum; i++){
			line = input[i].split(" ");
			switch(line[0]){
			case "push":	queue.push(Integer.parseInt(line[1]));
							 break;
			
			case "pop":		System.out.println(queue.pop());
							 break;
			
			case "size":	System.out.println(queue.size());
							 break;
			
			case "empty":	System.out.println(queue.empty());
							 break;
			
			case "front":	System.out.println(queue.front());
							 break;
				
			case "back":	System.out.println(queue.back());
							break;
			}
		}
		
		
	}//main
}//Main

class testQueue{
	
	private int[] que = new int[10000];
	private int valFront = 0;
	private int valLast = -1;
	
	void push(int value){
		valLast = valLast + 1;
		que[valLast] = value;
	}
	
	int pop(){
		if(size()==0){
			return -1;
		}
		valFront = valFront + 1;
		return que[valFront-1];
	}
	
	int size(){
		return valLast - valFront + 1;
	}
	
	int empty(){
		if(size()==0){
			return 1;
		}
		return 0;
	}
	
	int front(){
		if(size()==0){
			return -1;
		}
		return que[valFront];
	}
	
	int back(){
		if(size()==0){
			return -1;
		}
		return que[valLast];
	}
	
}