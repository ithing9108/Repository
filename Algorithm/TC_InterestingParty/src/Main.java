/*
 	������ ģ���� 2���� �������� ������ ������.  ��ΰ� ������ ����ִ� ������ �־�� ��Ƽ�� ��̴�.  ��ſ� ��Ƽ�� �Ƿ��� �ʴ��� �� �ִ� �ִ��� ģ�� ����?
 */
import java.util.Scanner;
import java.util.*;

public class Main {

	public static void main(String[] args){
		
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		int inputNum = 0;
		String[] first;			//��ǲ1
		String[] second;		//��ǲ2
		Scanner sc = new Scanner(System.in);
		int result = 0;			//�����
		
		first = sc.nextLine().split(" ");
		second = sc.nextLine().split(" ");
		inputNum = first.length;
				
		for(int i=0; i<inputNum; i++){
			dic.put(first[i], 0);		//�ʿ� Ű�� �ʱⰪ 0 �Է�
			dic.put(second[i], 0);		
		}
		
		for(int j=0; j<inputNum; j++){
			dic.put(first[j], dic.get(first[j])+1);		//����ī���� ��������
			dic.put(second[j], dic.get(second[j])+1);
		}
		
		for( String key : dic.keySet()){
			result = Math.max(result, dic.get(key));	//value�� ���� ū ���� ��� ��
		}
		
		System.out.println(result);
		
	}
}