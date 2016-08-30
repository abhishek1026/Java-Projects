//This is another subclass of the parent class named Record.
public class LP extends Record{
	
	//This constructor calls the super constructor with the same exact parameters to initialize the inherited member variables artist,title, and year.
	public LP(String author, String title, int year){

		super(author,title,year);
	}
	
	//This overrides the toString method of the superclass so that it returns a string with 45: appended to the beginning.
	public String toString(){

		return "LP: " + super.toString();
	}
}