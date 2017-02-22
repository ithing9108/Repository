import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int inputNum =0 ;
		String inputMethod = "";
		String inputArray = "";
		int arrayCount = 0;
		char charMethod;
		Deck deck;
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<inputNum; i++){		//�ٷ� �ٷ� ��µǰ�
			inputMethod = sc.nextLine();
			arrayCount = sc.nextInt();
			sc.nextLine();
			inputArray = sc.nextLine();
			deck = new Deck(inputArray ,arrayCount);
			
			for(int j=0; j<inputMethod.length(); j++){
				charMethod = inputMethod.charAt(j);
				switch(charMethod){
				case 'R' : deck.changeIndex();
							break;
				case 'D' : deck.pop();
							break;				
				}	
			}
			deck.printDeck();
		}
	}
}

class Deck{
	
	int[] deck = new int[100000];
	int indexFirst = 0;
	int indexLast = deck.length;
	int[] input;
	int index = 0;				// index = indexFirst �� �ʱ�ȭ��
	int size = 0;
	

	Deck(String line, int arrayCount){
		input = new int[arrayCount];
		for(int i=0; i<arrayCount;i++){
			input[i] = line.charAt(2*i+1)-48;
		}
		size = arrayCount;
		indexLast = arrayCount;	
	}
	void pop(){
		if(index==indexFirst){		
			if(indexFirst==99999){		//�� �������� ��� ��� ����
				indexFirst = 0;
				index = 0;
			}
			else{ 
				indexFirst +=1;
				index +=1;
			}
		}
		else if(index==indexLast){		
			if(indexLast==0){			//�� �������� ��� ��� ����
				indexLast = 99999;
				index = 99999;
			}
			else{ 
				indexLast -=1;
				index -= 1;
			}
		}
		size -= 1;
	}

	void changeIndex(){
		if(index == indexFirst){
			index = indexLast;
		}
		else if (index==indexLast){
			index = indexFirst;
		}
	}
	
	void printDeck(){
		if(size<=-1){			//push ��ɵ� �־��ٸ� pop �Ǵ¼����� �ٷ� print ��� ����
			System.out.println("error");
		}
		else if (size==0){
			System.out.println("[]");
		}		else if(index == indexFirst){		
			System.out.print("[" + input[indexFirst]);
			for(int i=indexFirst+1; i<indexLast; i++){
				System.out.print("," +input[i]);
			}
			System.out.println("]");
		}
		else if(index == indexLast){
			System.out.print("[" + input[indexLast-1]);
			for(int i=indexLast-2; i>=indexFirst; i--){
				System.out.print("," +input[i]);
			}
			System.out.println("]");			
		}
	}
}