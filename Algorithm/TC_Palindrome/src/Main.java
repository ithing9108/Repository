import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String input = "";
		boolean flag;
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		
		for(int i=input.length(); ; i++){
			flag = true;				// ��� ��ġ -> ���  if(flag)
			
			for(int j=0; j<input.length(); j++){
				if( (i-j-1)<input.length() && input.charAt(j)!=input.charAt(i-j-1) ){	//�� ���� ����
					flag = false;		// �������� ��ġ�ص� ���X, 1�߰� 
					break;
				}
			}
			if(flag) {
				System.out.println(i);
				return;
			}
		}	
	}
}