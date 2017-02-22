import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
		
		int inputNum = 0;
		int check = 0;
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		String input;
		
		inputNum = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<inputNum; i++){
			input = sc.nextLine();
			for(int j=0; j<input.length();j++){
				if(input.charAt(j)=='('){
					stack.add(input.charAt(j));
				}
				else if(input.charAt(j)==')'){
					if(stack.isEmpty()){
						System.out.println("NO");
						stack.clear();
						check = 1;
						break;
					}
					stack.pop();
				}
			}
			if(check==1){
				check = 0;
				continue;
			}
			if(stack.size()>0){
				System.out.println("NO");
				stack.clear();
				continue;
			}
			System.out.println("YES");
			continue;
		}
	}//main
}//Main
