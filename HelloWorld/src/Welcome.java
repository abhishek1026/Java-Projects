import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Type any integer: ");
		
		int input = s.nextInt();
		
		System.out.println("Your favorite number appears to be " + input);
		
		s.close();
		
	}

}
