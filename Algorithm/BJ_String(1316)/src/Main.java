import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int number = 0;	//�Է¹��� �ܾ� ��
		int count = 0; 	//�׷�ܾ��� ��
		int check = 0;	//�׷�ܾ �´��� üũ�ϱ� ���� ���� ������ �迭
		String[] word;	//�Է¹��� �ܾ ������ �迭
		int[] alphabet = new int[26]; //���ĺ��� ������� üũ
		Scanner sc= new Scanner(System.in);
		
		number = sc.nextInt();
		sc.nextLine();
		word = new String[number];
		
		for(int i=0; i<number; i++){
			word[i] = sc.nextLine();
		}
		
		for(int j=0; j<number; j++){			//1�� ���ϰ� �׷�ܾ �ƴϸ� break�� ���������� ���ϱ⸦ ���Ѵ�.
			for(int k=0; k<word[j].length(); k++){
				if((alphabet[word[j].charAt(k)-97]>0) && (word[j].charAt(k)-97!=word[j].charAt(k-1)-97)&& (k!=0)){
					break;
				}
				//System.out.println(word[j]);
				alphabet[word[j].charAt(k)-97] = alphabet[word[j].charAt(k)-97]+ 1;
				check = check +1; 
			}
			
			if(word[j].length() == check){ //���ϱ�1�� ��� �ߴٸ� �׷�ܾ� �̹Ƿ� ������ ���̰� �ִ��� Ȯ���ϱ� ����
				count = count +1;
			}
			check = 0;								//���� �ܾ ���� �ʱ�ȭ
			for( int h=0; h<alphabet.length; h++){  //���� �ܾ ���� �ʱ�ȭ
				alphabet[h] = 0;
			}
		}

		System.out.println(count); 	//��� ��� - �׷�ܾ��� ��
		
		
	}//main
}//Main
