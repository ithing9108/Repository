/* ver2 ���� // �̰� Ʋ�����~~~~
 * ��������� �������߿��� ���� �� �ִ� ���� �������� �� ���� �������� ���س��� ���� �Է¹��� ����� �߰��ؼ� ��� �ֽ�ȭ�ϴ� ����̾��µ�
 * �� ����� Ʋ�ȴ�...���ʿ��� ���̰� Ȯ���� ���� ���� ������ .. 
*/
import java.util.Scanner;
import java.util.Arrays;

public class Main {
		
		public static void main(String[] args){
			
			int inputNum =0;
			int result = 0;			//���
			int process = 0;		//��� ����
			int min = 0;
			int minIndex =0;
			int subMin =0;
			int subMinIndex = 0;
			int temp = 0;
			int tempIndex = 0;
			int[] input;
			String[] line;
			Scanner sc = new Scanner(System.in);
			
			inputNum = sc.nextInt();
			//sc.nextLine();
			input = new int[3];
			
			input[0] = sc.nextInt();			
			input[1] = sc.nextInt();			
			input[2] = sc.nextInt();			
			min = input[0];
			subMin = input[1];
			subMinIndex = 1;
			for(int j=0; j<2; j++){
				if(input[j]>input[j+1]){
					min = input[j+1]; 
					subMin= input[j];
					subMinIndex = minIndex;
					minIndex = j+1;
				}
				input[j+1] = min;
			}
			if(subMin==input[1] && min == input[0]){
				if(input[1]>input[2]){
					subMin = input[2];
					subMinIndex = 2;
				}
			}
			System.out.println(min + "  "+minIndex +"  "+ subMin+ "  "+subMinIndex);
			
			for(int i=1; i<inputNum; i++){
													//line = sc.nextLine().split(" ");
				input[0] = sc.nextInt();			//Integer.parseInt(line[0]);
				input[1] = sc.nextInt();			//Integer.parseInt(line[1]);
				input[2] = sc.nextInt();			//Integer.parseInt(line[2]);
				if(minIndex==0){
					if(input[1]>input[2]){
						min = min + input[2];
						minIndex = 2;
					}
					else{ 
						min = min + input[1];
						minIndex = 1;
					}
				}
				else if(minIndex==1){
					if(input[0]>input[2]){
						min = min + input[2];
						minIndex = 2;
					}
					else{ 
						min = min + input[0];
						minIndex = 0;
					}
				}
				else if(minIndex==2){
					if(input[0]>input[1]){
						min = min + input[1];
						minIndex = 1;
					}
					else{
						min = min + input[0];
						minIndex = 0;
					}
				}	

				if(subMinIndex==0){
					if(input[1]>input[2]){
						subMin = subMin + input[2];
						subMinIndex = 2;
					}
					else{ 
						subMin = subMin + input[1];
						subMinIndex = 1;
					}
				}
				else if(subMinIndex==1){
					if(input[0]>input[2]){
						subMin = subMin + input[2];
						subMinIndex = 2;
					}
					else{ 
						subMin = subMin + input[0];
						subMinIndex = 0;
					}
				}
				else if(subMinIndex==2){
					if(input[0]>input[1]){
						subMin = subMin + input[1];
						subMinIndex = 1;
					}
					else{
						subMin = subMin + input[0];
						subMinIndex = 0;
					}
				}
				if(subMin<min){
					temp = min;
					tempIndex = minIndex;
					min = subMin;
					minIndex = subMinIndex;
					subMin = temp;
					subMinIndex = tempIndex;
				}
				
			}
			System.out.println(min);
		}
}
