import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){
		
		stack stack = new stack();
		int inputNum = 0;
		String[] input;
		String[] line;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		sc.nextLine();
		input = new String[inputNum];
		for(int i=0; i<inputNum; i++){
			input[i] = sc.nextLine();
			line = input[i].split(" ");
			switch(line[0]){
			case "pop"	 : System.out.println(stack.pop());
							break;
			case "top"   : System.out.println(stack.top());
							break;
			case "size"  : System.out.println(stack.size());
							break;
			case "empty" : System.out.println(stack.empty());
							break;
			case "push"  : stack.push(Integer.parseInt(line[1]));
							break;
			}	
		}
	}//main
}//Main

class stack{

	private static ArrayList<Integer> stack = new ArrayList<Integer>();
	private static int stackRecent =-1;		//stack의 마지막 index;
	
	static void push(int in){
		stack.add(in);
		stackRecent = stackRecent + 1;
	}	
	
	static int pop(){
		int result = 0;
		if(stackRecent>=0){
			result = stack.get(stackRecent);
			stack.remove(stackRecent);
			stackRecent = stackRecent - 1;
			return result;
		}
		return -1;
	}
	
	static int size(){
		return stackRecent+1;
	}
	
	static int empty(){
		if(stackRecent==-1){
			return 1;
		}
		else return 0;
	}
	
	static int top(){
		int result = 0;
		if(stackRecent==-1){
			return -1;
		}
		else{
			result = stack.get(stackRecent); 
			return result;
		}
	}	
}//stack
