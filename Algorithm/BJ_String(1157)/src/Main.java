import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = new String();			
		int max = 0;		//�ִ밪
		int temp = 0;		//�ӽ� ����
		int count = 0;		//����Ƚ��
		int[] result = new int[26];
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		for(int i=0; i<input.length(); i++){
			if (input.charAt(i)>=97 && input.charAt(i)<=122 ){	//�ҹ����� ���
				result[input.charAt(i)-97] = result[input.charAt(i)-97] + 1;
			}
			else if (input.charAt(i)>=65 && input.charAt(i)<=90)//�빮���� ���
			{
				result[input.charAt(i)-65] = result[input.charAt(i)-65] + 1;
			}	
		}
		
		for(int j=0; j<result.length; j++){
			if(result[j]>=count){
				temp = count;	//�ִ밪 ������ 2������ Ȯ���ϱ� ����
				count = result[j]; 
				max = j;		//�ִ밪�� ��� �� �ܾ�����
			}			
		}
		if (temp==count){		//�ִ밪�� 2������ üũ
			System.out.println("?");		//�ִ밪 2���� ? ���
		}
		else{
			System.out.printf("%c", max+65 );//��� ���
		}
		
	}//main
}//Main
