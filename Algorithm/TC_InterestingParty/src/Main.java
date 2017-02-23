/*
 	각각의 친구는 2가지 주제에만 관심을 가진다.  모두가 공통의 흥미있는 주제가 있어야 파티가 즐겁다.  즐거운 파티가 되려면 초대할 수 있는 최대의 친구 수는?
 */
import java.util.Scanner;
import java.util.*;

public class Main {

	public static void main(String[] args){
		
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		int inputNum = 0;
		String[] first;			//인풋1
		String[] second;		//인풋2
		Scanner sc = new Scanner(System.in);
		int result = 0;			//결과값
		
		first = sc.nextLine().split(" ");
		second = sc.nextLine().split(" ");
		inputNum = first.length;
				
		for(int i=0; i<inputNum; i++){
			dic.put(first[i], 0);		//맵에 키와 초기값 0 입력
			dic.put(second[i], 0);		
		}
		
		for(int j=0; j<inputNum; j++){
			dic.put(first[j], dic.get(first[j])+1);		//워드카운터 느낌으로
			dic.put(second[j], dic.get(second[j])+1);
		}
		
		for( String key : dic.keySet()){
			result = Math.max(result, dic.get(key));	//value값 가장 큰 값이 결과 값
		}
		
		System.out.println(result);
		
	}
}
