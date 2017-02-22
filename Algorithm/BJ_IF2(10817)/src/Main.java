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
		
		if(var1<=var2){				//1과 2를 비교
			result = result + "A";
		}
		else{
			result = result + "B";
		}
		
		if(var1<=var3){				//1과 3을 비교
			result = result + "A";
		}
		else{
			result = result + "B";
		}
		
		if(result.equals("AB") || result.equals("BA")){
			System.out.println(var1);       //var1이 중간인 경우
		}
		else if (result.equals("AA")){     //둘다 var1보다 큰 경우
			if(var2<=var3){
				System.out.println(var2);
			}
			else{
				System.out.println(var3);
			}
					
		}
		else{								//둘다 var1보다 작은 경우
			if(var2<=var3){
				System.out.println(var3);
			}
			else{
				System.out.println(var2);
			}
			
		}
		
	}
	
}
