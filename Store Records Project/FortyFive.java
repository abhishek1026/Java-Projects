//This is one subclass of the parent class named Record.
public class FortyFive extends Record{
	

	//This constructor calls the super constructor with the same exact parameters to initialize the inherited member variables artist,title, and year.
	public FortyFive(String author, String title, int year){

		super(author,title,year);
	}
	//This overrides the toString method of the superclass so that it returns a string with 45: appended to the beginning.
	public String toString(){

		return "45: " + super.toString();
	}
}