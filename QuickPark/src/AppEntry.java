import java.util.*;

public class AppEntry {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		Garage c = new Garage("Collins", 5);
		
		Garage b = new Garage("Beard", 8);
		
		Garage j = new Garage("Juniper", 6);
		
		System.out.println("Welcome to QuickPark Services!");
		
		boolean keep;
		
			
		do{
			keep = true;
			int choice = mainMenu();
			
			if(choice != 1 && choice != 2){
				continue;
			}
			else if(choice == 1){
				char garage = printSummary(c,b,j);
				
				switch(garage){
				case 'c': int floor = printToString(c);
				
							switch(floor){
							case 1: if(c.takeSpot(floor)){
								congrats(c,floor);
								keep = c.getFeedAdd(c,floor);
							}
							else
								tryAgain();
							break;
								
							case 2: if(c.takeSpot(floor)){
								congrats(c,floor);
								keep = c.getFeedAdd(c,floor);
							}
							else
								tryAgain();
							break;
								
							case 3: if(c.takeSpot(floor)){
								congrats(c,floor);
								keep = c.getFeedAdd(c,floor);
							}
							else
								tryAgain();
							break;
							
							case 4: if(c.takeSpot(floor)){
								congrats(c,floor);
								keep = c.getFeedAdd(c,floor);
							}
							else
								tryAgain();
							break;
							case 5: if(c.takeSpot(floor)){
								congrats(c,floor);
								keep = c.getFeedAdd(c,floor);
							}
							else
								tryAgain();
							break;
							
							}
							
							break;
							
					
				case 'b':   int floorb = printToString(b);
				
							switch(floorb){
							case 1: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
								
							case 2: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
								
							case 3: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
							
							case 4: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
							
							case 5: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
							case 6: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
							case 7: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
							case 8: if(b.takeSpot(floorb)){
								congrats(b,floorb);
								keep = b.getFeedAdd(b,floorb);
							}
							else
								tryAgain();
							break;
							}
							
							break;
							
				
				case 'j': int floorj = printToString(j);
				
							switch(floorj){
							case 1: if(j.takeSpot(floorj)){
								congrats(j,floorj);
								keep = j.getFeedAdd(j,floorj);
							}
							else
								tryAgain();
							break;
								
							case 2: if(j.takeSpot(floorj)){
								congrats(j,floorj);
								keep = j.getFeedAdd(j,floorj);
							}
							else
								tryAgain();
							break;
								
							case 3: if(j.takeSpot(floorj)){
								congrats(j,floorj);
								keep = j.getFeedAdd(j,floorj);
							}
							else
								tryAgain();
							break;
							
							case 4: if(j.takeSpot(floorj)){
								congrats(j,floorj);
								keep = j.getFeedAdd(j,floorj);
							}
							else
								tryAgain();
							break;
							
							case 5: if(j.takeSpot(floorj)){
								congrats(j,floorj);
								keep = j.getFeedAdd(j,floorj);
							}
							else
								tryAgain();
							break;
							
							case 6: if(j.takeSpot(floorj)){
								congrats(j,floorj);
								keep = j.getFeedAdd(j,floorj);
							}
							else
								tryAgain();
							break;
							}	
							
							break;
							
				}
			}
			else{
				
				char garage = printSummary(c,b,j);
				
				switch(garage){
				case 'c': int floor = printToString(c);
				
							switch(floor){
							case 1: if(c.leaveSpot(floor)){
								thanks();
								keep = c.getFeedRemove(c,floor);
							}
							else
								tryAgain();
							break;
								
							case 2: if(c.leaveSpot(floor)){
								thanks();
								keep = c.getFeedRemove(c,floor);
							}
							else
								tryAgain();
							break;
								
							case 3: if(c.leaveSpot(floor)){
								thanks();
								keep = c.getFeedRemove(c,floor);
							}
							else
								tryAgain();
							break;
							
							case 4: if(c.leaveSpot(floor)){
								thanks();
								keep = c.getFeedRemove(c,floor);
							}
							else
								tryAgain();
							break;
							case 5: if(c.leaveSpot(floor)){
								thanks();
								keep = c.getFeedRemove(c,floor);
							}
							else
								tryAgain();
							break;
							}
							break;
							
					
				case 'b':   int floorb = printToString(b);
				
							switch(floorb){
							case 1: if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
								
							case 2:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
								
							case 3:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
							
							case 4:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
							
							case 5:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
							case 6:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
							case 7:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;

							case 8:  if(b.leaveSpot(floorb)){
								thanks();
								keep = b.getFeedRemove(b,floorb);
							}
							else
								tryAgain();
							break;
							}
							break;
							
				
				case 'j': int floorj = printToString(j);
				
							switch(floorj){
							case 1: if(j.leaveSpot(floorj)){
								thanks();
								keep = j.getFeedRemove(j,floorj);
							}
							else
								tryAgain();
							break;
								
							case 2: if(j.leaveSpot(floorj)){
								thanks();
								keep = j.getFeedRemove(j,floorj);
							}
							else
								tryAgain();
							break;
								
							case 3: if(j.leaveSpot(floorj)){
								thanks();
								keep = j.getFeedRemove(j,floorj);
							}
							else
								tryAgain();
							break;
							
							case 4: if(j.leaveSpot(floorj)){
								thanks();
								keep = j.getFeedRemove(j,floorj);
							}
							else
								tryAgain();
							break;
							
							case 5: if(j.leaveSpot(floorj)){
								thanks();
								keep = j.getFeedRemove(j,floorj);
							}
							else
								tryAgain();
							break;
							
							case 6: if(j.leaveSpot(floorj)){
								thanks();
								keep = j.getFeedRemove(j,floorj);
							}
							else
								tryAgain();
							break;
							}
							
							break;					
							
				}
				
			}
			
			
			
		}while(keep);
		
			
	
		
		System.out.println("Thanks for using QuickPark!");	
		

	}
	
	private static int printToString(Garage x) {
		
		System.out.println(x.toString());
		
		System.out.print("Please type in appropriate floor: ");
		
		int input = s.nextInt();
		
		return input;
	}

	private static char printSummary(Garage a, Garage b, Garage c) {
		System.out.println(a.toSummary());
		System.out.println(b.toSummary());
		System.out.println(c.toSummary());
		
		System.out.print("Please type in first character of appropriate garage: ");
		
		char input = s.next().charAt(0);
		
		return input;
	}

	private static int mainMenu(){
		
		System.out.print("Please type (1) for incoming or (2) for leaving: ");
		
		return s.nextInt();
	}
	
	private static void congrats(Garage x, int floor){
		System.out.println("Congrats! You are reserved a spot on " + x.getName() + " on floor # " + floor);
	}
	private static void thanks(){
		System.out.println("Thanks for notifying your departure!");
	}
	private static void tryAgain(){
		System.out.println("Illogical move!!! Please try again.");
	}


}
