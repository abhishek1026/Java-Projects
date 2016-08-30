public abstract class Record{
	
	//The following private member variables belong to all instances of the Record class(either 45 or LP-both of which inherit from this superclass).
	private String artist;

	private String title;

	private int year; 

	//This public Record constructor(which takes in 3 parameters) assigns values to the three declared member variables.
	public Record(String author, String title, int year){

		artist = author;

		this.title = title;

		this.year = year;
	}
	//The following three methods are getters for the three private member variables.
	public String getArtist(){

		return artist;
	}

	public String getTitle(){

		return title;
	}

	public int getYear(){

		return year;
	}
	//This is the over-ridden method(of the Object class) called toString that displays the details pertaining to each Record object.
	public String toString(){

		return title + " by " + artist +", " + year;
	}
}