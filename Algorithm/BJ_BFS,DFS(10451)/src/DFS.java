/* 
     BFS로 푸니까 답이 틀려서 DFS로 다시
 */
import java.util.Scanner;
public class DFS {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int inputNum;
		int size;
		int answer = 0;
		int[] inputArr;
		boolean[] map;
		
		inputNum = sc.nextInt();
		for(int i=0; i<inputNum; i++){
			size = sc.nextInt();
			inputArr = new int[size+1];
			map = new boolean[size+1];
			for(int j=1; j<size+1; j++){
				inputArr[j] = sc.nextInt();
			}
			for(int k=1; k<size+1; k++){
				if(map[k]==false)
					answer += DFS_Cycle(inputArr, map, k);
			}
			System.out.println(answer);
			answer = 0;
		}
	}
	static int DFS_Cycle(int[] arr, boolean[] map, int index){
		
		int answer = 0;
		map[index] = true;
		if(map.length==2)
			if(arr[1]!=1)
				return 0;
		if(map[arr[index]]==true) 
			return 1;
							
		return answer + DFS_Cycle(arr, map, arr[index]);
	}
}
