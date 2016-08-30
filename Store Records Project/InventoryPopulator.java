import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Revised 4/13/2016
 * This code was written by a friend of Lucy 
 * Starnight, who owns a bike repair
 * shop. He adapted it to read in Lucy's inventory 
 * of records for sale. The current version does
 * not read in an initial queue of albums to be
 * repaired. It only reads in an inventory stack.
 * @author Bob Starnight 
 *
 */
public class InventoryPopulator {

	/**
	 * This static method is a utility method
	 * Which reads from a file, turns each line into
	 * a Record object, pushes them onto a RecordStack,
	 * and returns a reference to that RecordStack. 
	 * @param filename The full file path where the 
	 *        file of records is located. 
	 *        Must be formatted as follows:
	 *           Author, Title, Year, Type
	 *        Where Author is a String;
	 *        Title is a String;
	 *        Year is an int
	 *        Type is either lp or ep 
	 *        It is comma-delimited with one album per line. 
	 * @return the new RecordStack of inventory. 
	 */
	public static RecordStack 
	getInitialInventory(String filename) {
		//Create a new file object at the specified path
		//for example "/users/lucy/files/inventory.csv"
		//or "C:\\users\lucy\files\inventory.csv"
		File file = new File(filename);
		
		//a new empty RecordStack to build up
		RecordStack rs = new RecordStack();
		
		//Making a scanner on a file could create an
		//exception so we must wrap this part in a try
		//block. 
		try {
			Scanner sc = new Scanner(file);

			//there is another record in the file
			while (sc.hasNextLine()) {
				
				//make a scanner for that record line
				Scanner line = new Scanner(sc.nextLine());
				line.useDelimiter(",");
				
				String artist = line.next().trim();
				String title = line.next().trim();
				int year = Integer.parseInt(line.next().trim());
				String type = line.next().trim();
			
				//Check if it's lp or 45 and make the 
				//appropriate record type
				if (type.equals("45")) 
					rs.push(new FortyFive(artist,title,year));
				else rs.push(new LP(artist,title,year));
				line.close();
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	/**
	 * This static method is a utility method
	 * Which reads from a file, turns each line into
	 * a Record object, adds them to a Queue of Records
	 * and returns a reference to that Queue. 
	 * @param filename The full file path where the 
	 *        file of records is located. 
	 *        Must be formatted as follows:
	 *           Author, Title, Year, Type
	 *        Where Author is a String;
	 *        Title is a String;
	 *        Year is an int
	 *        Type is either lp or ep 
	 *        It is comma-delimited with one album per line. 
	 * @return the new Queue of items to be repaired. 
	 */
	public static Queue<Record> getInitialRepairQueue(String filename) {
		//Create a new file object at the specified path
		//for example "/users/lucy/files/inventory.csv"
		//or "C:\\users\lucy\files\inventory.csv"
		File file = new File(filename);
		
		//a new empty RecordStack to build up
		Queue<Record> rq = new LinkedList<Record>();
		
		//Making a scanner on a file could create an
		//exception so we must wrap this part in a try
		//block. 
		try {
			Scanner sc = new Scanner(file);

			//there is another record in the file
			while (sc.hasNextLine()) {
				
				//make a scanner for that record line
				Scanner line = new Scanner(sc.nextLine());
				line.useDelimiter(",");
				
				String artist = line.next().trim();
				String title = line.next().trim();
				int year = Integer.parseInt(line.next().trim());
				String type = line.next().trim();
			
				//Check if it's lp or 45 and make the 
				//appropriate record type
				if (type.equals("45")) 
					rq.add(new FortyFive(artist,title,year));
				else rq.add(new LP(artist,title,year));
				line.close();
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return rq;
	}
}
