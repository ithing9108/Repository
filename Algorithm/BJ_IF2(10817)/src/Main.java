import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		int var1 = 0;
		int var2 = 0;
		int var3 = 0;
		String result = "";
	
		Scanner sc = new Scanner(System.in);
	
		var1 = sc.nextInt();
		var2 = sc.nextInt();
		var3 = sc.nextInt();
		
		if(var1<=var2){				//1�� 2�� ��
			result = result + "A";
		}
		else{
			result = result + "B";
		}
		
		if(var1<=var3){				//1�� 3�� ��
			result = result + "A";
		}
		else{
			result = result + "B";
		}
		
		if(result.equals("AB") || result.equals("BA")){
			System.out.println(var1);       //var1�� �߰��� ���
		}
		else if (result.equals("AA")){     //�Ѵ� var1���� ū ���
			if(var2<=var3){
				System.out.println(var2);
			}
			else{
				System.out.println(var3);
			}
					
		}
		else{								//�Ѵ� var1���� ���� ���
			if(var2<=var3){
				System.out.println(var3);
			}
			else{
				System.out.println(var2);
			}
			
		}
		
	}
	
}
