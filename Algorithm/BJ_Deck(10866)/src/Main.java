import java.util.Scanner;

public class Main {
	
	public	static void main(String[] args){
		
		Deck deck = new Deck();
		int inputNum = 0;		//입력 횟수
		String[] input;			//각 입력
		String[] line; 			//입력을 스플릿하는데 사용
		Scanner sc = new Scanner(System.in);
		inputNum = sc.nextInt();
		sc.nextLine();
		input = new String[inputNum];
		
		for(int i=0; i<inputNum; i++){
			input[i] = sc.nextLine();
			line = input[i].split(" ");
			switch (line[0]){
			case "push_front" : deck.push_front(Integer.parseInt(line[1]));
								break;
			case "push_back"  : deck.push_back(Integer.parseInt(line[1]));
								break;
			case "pop_front"  : System.out.println(deck.pop_front());
								break;
			case "pop_back"   : System.out.println(deck.pop_back());
								break;
			case "size"		  : System.out.println(deck.size());
								break;
			case "empty"	  : System.out.println(deck.empty());
								break;
			case "front"	  : System.out.println(deck.front());
								break;
			case "back"		  : System.out.println(deck.back());
								break;
			}
		}		
	}
}

class Deck{
	
	//private ArrayList<Integer> deck = new ArrayList<Integer>();
	private static int[] deck = new int[10000];
	private static int frontIndex = 9999;
	private static int backIndex = 0;
	private static int size =0;
	
	static void push_front(int input){
		if (frontIndex==9999){
			frontIndex = 0;
			deck[0] =input;
		}
		else{
			frontIndex++;
			deck[frontIndex] = input;
		}
		size++;
	}
	
	static void push_back(int input){
		if(backIndex==0){
			backIndex=9999;
		}
		else{
			backIndex--;
		}
		deck[backIndex] = input;
		size++;
	}
	
	static int size(){
		return size;
	}
	
	static int pop_front(){
		if(size()<=0 ){
			return -1;
		}
		if(frontIndex==0){
			frontIndex = 9999;	// int frontIndex=-1 이랑 이 if문 떄문에 컴파일에러 8번..
			size--;
			return deck[0];
		}
		frontIndex--;
		size--;
		return deck[frontIndex+1];
	}
	
	static int pop_back(){
		if(size()<=0){
			return -1;
		}
		if(backIndex==9999){
			backIndex = 0;
			size--;
			return deck[9999];
		}
		backIndex++;
		size--;
		return deck[backIndex-1];
	}
	
	static int empty(){
		if(size()==0){
			return 1;
		}
		return 0;       	
	}
	
	static int front(){
		if(size()<=0){
			return -1;
		}
		return deck[frontIndex];
	}
	
	static int back(){
		if(size()<=0){
			return -1;
		}
		return deck[backIndex];
	}
}
