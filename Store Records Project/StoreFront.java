import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * This is a skeleton code provided for students' convenience. 
 * The public methods specified here are required. The private methods are optional.
 * Do not change names of member variables for this class. Do not change public method signatures.
 * All of those items will be tested by the teaching staff's JUnit testing. 
 * The private methods here (or ones that you create as part of your own design) will not be
 * JUnit tested. 
 * @author Dr. Boyer
 *
 */
public class StoreFront {
	
	//The following member variables belong to the StoreFront class. repairQueue is an instantiation of the Queue class(by using new LinkedList<Record>.
	//inventory45s and inventoryLPs are instantiations of RecordStack class, one of which will store 45 records while the other stores LP records.
	//The Queue and RecordStack will be initially filled by using methods built in the InventoryPopulator class.
	private Queue<Record> repairQueue = new LinkedList<Record>();
	private RecordStack inventory45s = new RecordStack();
	private RecordStack inventoryLPs = new RecordStack();

	/**
	 * This main method takes two command-line arguments. 
	 * First it takes a string of the full path to a file from which Lucy's
	 * repair queue should be initialized.
	 * Second it takes a string of the full path to a file from which Lucy's
	 * inventory stacks are to be initialized. That file has LPs and 45s interleaved.
	 * The main method deals with that to create the two inventory stacks.
	 * @param args The full path to a file for the repair queue and a file for inventory
	 */
	public static void main(String[] args) {
		
		//You can name this whatever you want, but this line of code is left here
		//to help you see that you'll instantiate a StoreFront object inside this main method
		StoreFront lucysStore = new StoreFront();
		
		//Here's a helpful hint of how to initialize the repair queue. 
		//You call the methods for this class from the instantiated StoreFront object
		//whether you call it lucysStore or something else is up to you. 
		lucysStore.repairQueue = InventoryPopulator.getInitialRepairQueue(args[0]);
		
		//This initializes the selling stack. However, a for loop must be used to separate the LPs and 45s from the RecordStack that is returned from the method.
		//The 45 Records are pushed to the 45 stack, and the LP Records are pushed to the LP stack.
		RecordStack initialGlob = InventoryPopulator.getInitialInventory(args[1]);
		

		for(int i=0;i<initialGlob.size();i++){
			
			Record r = initialGlob.getData()[i];

			if(r instanceof FortyFive)

				lucysStore.inventory45s.push(r);

			else if(r instanceof LP)

				lucysStore.inventoryLPs.push(r);
		}
		
		//Greeting message when the program is initially run.
		System.out.println("Welcome to Lucy's Album Sales and Service!\n");
		

		//The int variable is going to be used for the switch statement that is executed after the desired integer is returned from the displayMenu method.
		int choice;
		
		//This do-while loop is used to display the Main Menu and perform actions until the program aborts or the user decides to quit(option #8).
		do{
			choice = lucysStore.displayMenu();

			switch(choice){

				case 1: lucysStore.addAlbumToRepair(lucysStore.getRecordInfoFromLucy());
						
						break;

				case 2: lucysStore.repairAlbum();
				
						break;

				case 3: if(lucysStore.printRepairQueue() != "") 
					{System.out.println(lucysStore.printRepairQueue());
					
					}
				
						break;

				case 4: lucysStore.addAlbumToSell(lucysStore.getRecordInfoFromLucy());
				
						break;

				case 5: lucysStore.sellLP();
				
						break;

				case 6: lucysStore.sell45();
				
						break;

				case 7: System.out.println(lucysStore.displayInventory());
				
						break;

				case 8: System.out.println("Bon Voyage!");

				default: 
			}
		}while(choice !=8);
		
	} 

	/**
	 * StoreFront constructor. Initializes the repairQueue, inventory45s, and inventoryLPs
	 * to empty structures.
	 */
	public StoreFront() {
		
	}

	/**
	 * Adds the specified album to the end of the repair queue.
	 * Since there is no limit to the size of the repair queue this method just adds the record.
	 * @param r The record to add to the repair queue
	 */
	
	//If the album to add is null, an error message is printed to notify the user. Also, the null record is not added to the queue.
	public void addAlbumToRepair(Record r) {

		if(r != null){
			repairQueue.add(r);
	
			System.out.println("Album has been sent to repair queue!");
		}
		
		else
			System.out.println("Sorry. Cannot add album that is not of type LP or 45!");

	}

	/**
	 * Removes the album at the head of the repair queue.
	 * If the repair queue was already empty, this does nothing. 
	 */
	
	//Actually, if the repair queue is already empty, a message is printed to the console.
	//Also, the repaired album is printed to the console if it is successfully removed from the queue.
	public void repairAlbum() {

		if(!repairQueue.isEmpty()){

			Record reveal = repairQueue.remove();

			System.out.println("Album" + "(" + reveal + ")" + " at head of queue has been repaired!");
		}

		else
			System.out.println("Nothing is left in the repair queue!");
	}

	/**
	 * Displays the repair queue, as a list of single albums per line. 
	 * Each album is displayed precisely as mandated for the Record.toString method. 
	 * There is no new line at the end of the returned String but there is a newline between
	 * each displayed album.
	 * @return
	 */
	
	//If the queue is empty, a message is simply printed and the method returns an empty string.
	public String printRepairQueue() {


		String repcue = "";

		
		if (repairQueue.isEmpty()){

			System.out.println("Queue is empty right now!");

			return repcue;
		}
		
		Queue<Record> healrq = new LinkedList<Record>();

		while(!repairQueue.isEmpty()){

			healrq.add(repairQueue.peek());

			if(repairQueue.size()>1)
				repcue += repairQueue.remove().toString() + "\n";
			
			else
				repcue += repairQueue.remove().toString();

		}

		repairQueue = healrq;

		return repcue;
	}

	/**
	 * Adds a new album to the top of the appropriate inventory stack.
	 * @param r The LP or 45 to add to the inventory. 
	 */
	//If the record is null, it is not pushed to any stack and a message is printed to the console.
	public void addAlbumToSell(Record r) {
		
		if(r != null){


			if(r instanceof LP)

			inventoryLPs.push(r);
			

		else if(r instanceof FortyFive)

			inventory45s.push(r);

		System.out.println("Desired album has been added to stack!");

		}
		
		else
			System.out.println("Sorry. Cannot add album that is not of type LP or 45!");
		
	}

	/**
	 * Removes the topmost item from the inventory of LPs.
	 * If the inventory is empty, calling this method will cause a runtime exception.
	 * Your code must check for empty before calling this method. 
	 */
	
	//if-else statement is used to handle the situation that arises when the stack is already empty.
	public void sellLP() {

		if(inventoryLPs.size()>0)
		{
			System.out.println("The following item has been sold: " + inventoryLPs.pop());
		}

		else{

			System.out.println("PLANETARY IMPLOSION! NO MORE LP RECORDS! ABORTING SHORTLY!");

			System.exit(0);
		}
		
	}

	/**
	 * Sells a 45. Removes the topmost 45 from the inventory stack.
	 */
	
	//if-else statement is used to handle the situation that arises when the stack is already empty.
	public void sell45() {

				if(inventory45s.size()>0)
		{
			System.out.println("The following item has been sold: " + inventory45s.pop());
		}

		else{
			
			System.out.println("PLANETARY IMPLOSION! NO MORE 45 RECORDS! ABORTING SHORTLY!");

			System.exit(0);
		}
		
	}

	/**
	 * This method displays the inventory. It is PROVIDED to students to avoid annoying
	 * test case failure due to small formatting problems. :) 
	 * It is JUnit testable for precise, correct output. 
	 * @return a String representation of the inventory. First LPs then 45s. 
	 * 		   Does not include a new line at the end of this string representation. 
	 */
	public String displayInventory() {
		String LPs = (this.inventoryLPs.size() == 1) ? " LP " : " LPs ";
		String FortyFives = (this.inventory45s.size() == 1) ? " 45." : " 45s.";
		return "You have " + this.inventoryLPs.size() + LPs + "and " + 
		this.inventory45s.size() + FortyFives;	
	}

	/*
	 * This method displays the storefront menu. Dr. Boyer thinks it is convenient to 
	 * display the menu to Lucy, get her choice, and then return that choice from this method.
	 * If your menu items are not ints then you would change the return type. 
	 * You can also just delete this method if it doesn't fit your design.  
	 * @return the selection that Lucy made, as an integer
	 */
	private int displayMenu() {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Pick one of the following 8 options:");

		System.out.println("1.Add Record to Repair Queue\n2.Repair Record in Queue\n3.View Repair Queue\n4.Add Record to Sell\n5.Sell LP Record\n6.Sell 45 Record\n7.View Selling Inventory\n8.Abandon All Hope");
		
		
		String input = s.next();

	
		if(this.containsOnlyNumbers(input)){
			
			return Integer.parseInt(input);
		}
		//If the user input only consists of numbers, then the integer form of the string is returned. Otherwise, 0 is returned to propagate the do-while loop in order to reprint the Main Menu.
		else
			return 0;
		
	}

	/*
	 * This is a service method within this class, provided only for your convenience. 
	 * You do not have to use it (you can delete this method  and structure your code
	 * however you like, including the ways in which you get the info for the new Record
	 * that Lucy wants to either add to inventory or add to the repair queue). 
	 * It is  up to your discretion how to ask Lucy for each new record's information
	 * This method will NOT be JUnit tested. 
	 * @return a new Record which will either be added to a queue or a stack, depending on context
	 */
	private Record getRecordInfoFromLucy() {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Ok! What is the title of the album?");
		String title = s.nextLine();
		
		System.out.println("What is the artist name?");
		String artist = s.nextLine();
		
		//The program keeps asking for the year until a valid input(non-negative integer) is entered.
		String yearStr = "";
		do {
			System.out.println("What is the album's year?");
			yearStr = s.nextLine().trim();
		} while (!(containsOnlyNumbers(yearStr)) || Integer.parseInt(yearStr)<0);

		int year = Integer.parseInt(yearStr);
		
		System.out.println("Is it an LP or a 45? Type 'LP' or '45'.");
		String type = s.nextLine();

		
		if (type.equals("LP")) return new LP(artist, title,year);
		else if (type.equals("45")) return new FortyFive(artist,title,year);
		else return null;
	}
	
	//I've created this private method to check whether a certain string contains only digits(numbers). If it does, then true is returned. Else, false is returned.
	 private boolean containsOnlyNumbers(String str) {
		    for (int i = 0; i < str.length(); i++) {
		      if (!Character.isDigit(str.charAt(i)))
		        return false;
		    }
		    return true;
		  }

}//class

