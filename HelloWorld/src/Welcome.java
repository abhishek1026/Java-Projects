import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) {
		
		boolean keep = true;
		
		Scanner s = new Scanner(System.in);
		
		do{
			
			int randNum = (int)(Math.random()*100)+1;
			
			System.out.print("Type any integer from 1-100: ");
			
			int input = s.nextInt();
			
			int diff = Math.abs(input-randNum);
			
			if(diff != 0){
				
				System.out.println("Your chosen number is " + diff + " away from the randomly generated integer value of " + randNum +"!");
				
			}
			
			else{
					
				System.out.println("Congrats. Your integer matches the randomly generated integer " + randNum + "!!!");
				
				keep = false;
			}
			
		}while(keep);
		
		
		s.close();
	
		
	}

}
