import  java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		String input;
		int answer = 0;
		String[] result;
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
        input = input.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=","1");
        answer = input.length();
        System.out.println(answer);

//		result = input.split("=|-|j");

/*		for(int i=0; i<input.length(); i++)
			if(input.charAt(i)=='a' || input.charAt(i)=='e' || input.charAt(i)=='o' || input.charAt(i)=='i' || input.charAt(i)=='u')
				answer +=1; */
	}
}