import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		String insert = new String();	//�Է¹޴� �迭
		String[] single;				//���� 1����
		int check = 0;					//1==asc, 2=dsc, 3=mxd
		int now = 0;					//�迭 [i]
		int next = 0;					//�迭 [i+1]
		Scanner sc = new Scanner(System.in);
		
		insert = sc.nextLine();
		single = insert.split(" ");
		
		for(int i=0; i<(single.length - 1); i++){
			
			now = Integer.parseInt(single[i]);
			next = Integer.parseInt(single[i+1]);
			if(now >= next && check!=2){
				check =1;
			}
			else if(now<=next && check!=1){
				check =2;
			}
			else{
				check =3;
				break;
			}
		}
		
		if(check==1){
			System.out.print("descending");
		}
		else if (check==2){
			System.out.println("ascending");
		}
		else{
			System.out.println("mixed");
		}
		
	}//main
}//Main
