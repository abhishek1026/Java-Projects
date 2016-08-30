import java.util.Scanner;

public class WatneyRescue {
		public static void main(String[] args) {

		//Creates a new instance object. Don't worry about this for now.
		WatneyRescue wr = new WatneyRescue();

		//A new scanner to read input from the user
		Scanner s = new Scanner(System.in);

		//The user's menu selection; 'd', 'r', 'q' or something else 
		char inputChoice;

		do  {
			System.out.println("Do you want 'd' distance mode, 'r' rover mode, or 'q' quit?");
			inputChoice = s.nextLine().charAt(0);

			switch(inputChoice) {

			//Enter distance mode; make the table then compute walking time based on the table
			case 'd': 
				System.out.println("How many meters to Watney?");
				String line = s.nextLine(); 
				double metersToWatney = Double.parseDouble(line.trim());
				String table = wr.generateContingency(metersToWatney);
				System.out.println(table);
				System.out.println("Which row?");
				line = s.nextLine();
				int row = Integer.parseInt(line.trim());
				System.out.println(wr.computeWalkingTime(metersToWatney,table,row));	
				break;

			//Enter rover mode; receive and translate a series of angles for the rover
			case 'r':
				System.out.println("What series of angles?");
				String angles = s.nextLine();
				System.out.println("Mission control on earth sends the following message:\n");
				System.out.println(wr.interpretHexadecimal(angles) + "\n");
				break;

			//Quit
			case'q': 
				continue;

			//Ignore anything that isn't 'd', 'r', or 'q'
			default: 
				continue;
			}
			
		} while (inputChoice != 'q'); //keep going until we get 'q'

		System.out.println("Goodbye. May the hexadecimals be with you.");
		
		//Close the scanner to keep eclipse from driving me crazy with its warnings
		s.close();
	}

	/**
	 * Generates a contingency table of distances that Watney
	 * will have to travel to the ship
	 * @param distLewisWatney The distance in meters from Lewis to Watney, 
	 * as read from Lewis' suit sensors
	 * @return
	 */
	public String generateContingency(double distLewisWatney) {
		String result = "";
		result += "Contingencies given distance " + distLewisWatney + " from Lewis to Watney:\n";
        int countRow = 1;
        int distWatneyHab = 0;
		for(int angle = 15; angle<=75; angle+=5) {


			for(int dist= 15; dist<=30; dist+=3){

			double angleToUse = 1.57 - angle * 3.14 /180;

			 distWatneyHab = (int)Math.round(Math.sqrt(Math.pow(distLewisWatney,2)+ Math.pow(dist,2) - 2*distLewisWatney*dist*Math.cos(angleToUse)));

			result += countRow + ") " + angle + " | " + dist + " | " + distWatneyHab + "\n";

			countRow++;

			}
		}
		return result;
		}
	

	/**
	 * This method computes how long it will take Watney and Lewis to walk to the hab
	 * given their distances from it. The necessary distances must be looked up within
	 * the table provided as a parameter. 
	 * @param distLewisWatney The distance Lewis is from Watney, as measured by her suit
	 * @param table The table of angle and distance values generated from another method
	 * @param row The row of the table that should be used in the calculation
	 * @return
	 */
	public String computeWalkingTime (double distLewisWatney, String table, int row) {
		 

		//TODO: Traverse the table to get the correct row's string. (Hint: look at the 
		//starter code for the interpretHexadecimal method to see a cool trick for stepping
		//through a String and breaking it apart using a certain character.) 
		Scanner s = new Scanner(table); //78 rows

		for (int i=0; i <= row; i++) {
			table = s.nextLine();
		}		

		//TODO: Extract from that row the needed distance. 
		Scanner s2 = new Scanner(table);

		s2.useDelimiter("\\s*\\|\\s*");

		s2.next(); //just ignore angle

		int distLewis = s2.nextInt();
		int distWatney = s2.nextInt();


		//TODO: Compute the walking time for Watney and Lewis to the ship. 
		//Watney is injured so his walking pace is 0.9 meters per second. 
		//Lewis' walking pace is 1.7 meters per second.

		table = String.format("Watney walking time to ship: %s seconds\n", Math.round(distWatney/0.9));
		table += String.format("Lewis walking time to ship: %s seconds", Math.round(distLewis/1.7));

	    return table;
	}

	/**
	 * This method interprets a series of angles around a circle to find the hexadecimal
	 * digit they "point to" on the circle. Then, it maps those hexadecimal pairs to characters from the
	 * English alphabet. The 360 degrees of the circle are broken into 16 equal pieces of 22.5 degrees each. 
	 * @param angles The comma-delimited list of angles
	 * @return a String with the message in English
	 */
	public String interpretHexadecimal(String angles) {
		//An easy way to break apart a list of things is to make a Scanner on it
		//This Scanner is unrelated to any other variables with the same name because this
		//one is only meaningful inside this method. Also, this scanner does not read from the
		//console! It only operates over the one String you created it on, namely angles. 
		Scanner s = new Scanner(angles);
		//You can tell each Scanner what you want it to use to break up the String. 
		//Making it a comma, when you call next() you get whatever is between the commas.
		//Pretty convenient. 
		s.useDelimiter(",");

		double firstAngle = -1;
		double secondAngle = -1;
		angles = "";

		while (s.hasNext()) {
			if (firstAngle > 0) {
				secondAngle = s.nextDouble();

				int first = (int)(firstAngle / 22.5);
				int second = (int)(secondAngle / 22.5);

				String firstHex = Integer.toHexString(first);
				String secondHex = Integer.toHexString(second);

				int asciiValue = Integer.parseInt(firstHex+secondHex, 16);

				angles += (char)asciiValue;

				//reset for next pair
				firstAngle = -1;
				secondAngle = -1;
			}
			else {
				firstAngle = s.nextDouble();
			}
		}
		
		return angles;
	}
}





