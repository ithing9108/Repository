/*
 	��ȣȭ�� ���� ���� ����Ʈ�� �޴´�. ����Ʈ�߿� 1���� ���� 1���� ��Ų��. �� �� ������ ��� ���� ���� ���� Ŀ���� �մϴ�.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
			
		Scanner sc = new Scanner(System.in);
		String[] input;
		int[] arr; 
		int result = 1;
		
		input = sc.nextLine().split(" ");
		arr = new int[input.length];

		for(int i=0; i<input.length;i++){	
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);						
		arr[0] += 1;							// ���� �������� +1
		
		for(int j=0; j<arr.length;j++){			// ��� ���
			result *= arr[j];
		}
		
		System.out.println(result);
	}
}
