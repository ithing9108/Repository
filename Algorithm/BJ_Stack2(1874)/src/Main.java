import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
	
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stackBase = new Stack<Integer>();
		int inputNum = 0;
		int[] inputList;
		int listIndex = 1;
		int checkWhile = 0;
		int first = 1;
		String result = "";
		String check = "";

		Scanner sc = new Scanner(System.in);
 		int temp = 0;
 		int temp2 = 0;
 		
		inputNum = sc.nextInt();
		inputList = new int[inputNum];
		for(int i=0; i<inputNum; i++){
			inputList[i] = sc.nextInt();
			stackBase.push(inputNum-i);
		}
	
		for(int j=0; j<inputNum; j++){
			while(true){
				System.out.println(inputList[j]+"    "+temp +"      "+ result);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(inputList[j]>temp || first ==1){
					if(stackBase.isEmpty()){
						break;
					}
					temp = stackBase.pop();			
					stack.push(temp);
					result = result + "+";
					first = 2;
				}
				else if(inputList[j]==temp){
					if(stack.isEmpty()){
						break;
					}
					result = result + "-";
					temp2 = stack.pop();
					if(!stackBase.isEmpty()){
						temp=stackBase.pop();
						stackBase.push(temp);
					}
					//stackBase.push(temp2);
					break;
				}
				else if(inputList[j]<temp){
					if(stackBase.isEmpty()){
						break;
					}
					result = result + "-";
					temp = stack.pop();
					check = check + ""+ temp;
				}
			}
			if(j==inputNum-1){
				while(!stack.isEmpty()){
					result = result + "-";
					check = check + ""+ stack.pop();
				}
			}
		}
		
		for(int k=0; k<result.length(); k++){
			System.out.println(result.charAt(k));
		}
	}
}
