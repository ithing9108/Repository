import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int nodeNum = 0;
		String[] input;
		Scanner sc = new Scanner(System.in);
		int aaaa = 'A';
		System.out.println(aaaa);
		nodeNum = sc.nextInt();
		sc.nextLine();
		input = new String[nodeNum];
		for(int i=0; i<nodeNum; i++){
			input[i] = sc.nextLine();
		}
		
	
	}
	static void preOrder(String[] input){
		
		String[] line;			//splitÀ» À§ÇÑ 
		String parent = "A";
		String left = "";
		String right = "";
		String result = ""; 
		
		for(int i=0; i<input.length;i++){
			line = input[i].split(" ");
			parent = line[0];
			left = line[1];
			right = line[2];
			
		}
		
		
		
	}
}
