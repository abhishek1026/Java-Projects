//This is the class that contains the main method. 
//This class instantiates two separate objects from two other side classes (Guitar and Vocalist).
//It also invokes methods on these objects and prints out the Vocalist object using the toString method of that class. 
public class Songwriter {

	public static void main(String[] args) throws InterruptedException /*throws is in place to handle Thread.sleep*/ {
		
		Guitar a = new Guitar(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		
		//A new object(a) of the type Guitar is instantiated.
		//The constructor of the Guitar class takes in two command line parameters(Number of Strings, Number of Chords).
		
		a.simulateSong();
		
		//A public method within the Guitar class called simulateSong is invoked on the Guitar object named a. 
		//This is the method that prints each chord of the song along with periods to indicate its associated number of beats.
		
		Vocalist b = new Vocalist(Double.parseDouble(args[2]), a);
		
		//A new object(b) of the type Vocalist is instantiated. 
		//The constructor of the Vocalist class also takes in two parameters.
		//Mid-Range Frequency(from last command line parameter) and the Guitar object a are the two parameters of this constructor.
		
		System.out.println(b);
		
		//This placement of object b within the print statement automatically invokes the toString method defined within the Vocalist class.
		//Since the toString method returns a custom-formatted string, the print statement simply prints out the string that was returned. 
		
		b.sing();
		
		//A public method within the Vocalist class called sing is invoked on the Vocalist object named b.
		//This is the method that actually leads to the production of sound frequencies that are emitted.
	}

	

}
