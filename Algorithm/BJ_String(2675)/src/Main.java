import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String[] line;					//1�� 	
		String[] word;					//1���� split���� �ɰ� word
		String result = new String();	// ��� 
		int total = 0; //��ü ��ǲ�� ��
		int count = 0; //�� ���ĺ��� �ݺ� Ƚ��
		
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();		//�� �Է� Ƚ��
		line = new String[total];
		sc.nextLine();
		for(int k=0; k<total; k++){
			line[k] = sc.nextLine();
		}
		
		for(int t=0; t<total; t++){
			if (line[t].length() != 1) {
				word = line[t].split(" ");
				count = Integer.parseInt(word[0]);		//�ݺ� Ƚ��

				for (int i = 0; i < word[1].length(); i++) {
					for (int j = 0; j < count; j++) {
						result = result + word[1].charAt(i);	//���Ӱ� �ٲ� ���
					}
				}
				System.out.println(result);			//��� ���
				result = "";	//�ʱ�ȭ
			}
		}
		sc.close();
	}//main
}//Main
