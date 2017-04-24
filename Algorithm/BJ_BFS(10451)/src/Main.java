/* BFS 사용
     테스트 케이스 맞는데 답이 틀리다.
     뭐가 문제일까?              */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args){
		
		int inputNum;
		int size;
		int[] inputArr;
		int[] sorted;
		int[] answer;
		Queue<Pair> q = new LinkedList<Pair>();

		Scanner sc = new Scanner(System.in);
		inputNum = sc.nextInt();
		answer = new int[inputNum];
		for (int i = 0; i < inputNum; i++) {
			size = sc.nextInt();
			inputArr = new int[size];
			sorted = new int[size];
			for (int j = 0; j < size; j++) {
				inputArr[j] = sc.nextInt();
				
				q.add(new Pair(j+1, inputArr[j]));		
			}
			
			answer[i] = cycle(q);		
		}
		for(int t=0; t<inputNum; t++)
			System.out.println(answer[t]);
	}
	static int cycle(Queue<Pair> q){
		int result = 0;
		int first = 0;
		Pair p;
		if(q.isEmpty()){
			return 0;
		}
		
		p= q.remove();
		first = p.x;
			if(q.size()==0){
			if(p.x!=p.y)
				return 0;
		}
		while(!q.isEmpty()){
			if(first==p.y){
				result += 1;
				if(!q.isEmpty()){			
					p = q.remove();
					first = p.x;
					continue;
				}
				System.out.println(p.x + "    "+p.y);		//break, continue
			}
			else if (p.x == p.y) result += 1;
			
			p = q.remove();	
		}
	
		return result+1;
	}
}
