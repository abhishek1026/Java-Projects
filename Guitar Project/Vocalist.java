public class Vocalist {

	private double midRangeFreq; //This variable stores the mid-range frequency(as a double) as determined by the user input.

	private double [][] melody; //This double 2D array is populated by the constructor, with the help of the findClosest method.

	private double [][] guitarArray; //This array is retrieved by the getSongArray method of the guitar class. The last index of this array is used to retrieve the time(s) for each column in melody array.

	/*This is the constructor of the Vocalist class. This takes in a double named frequency(local variable) and an object of the Guitar type as parameters.
	 *This constructor initializes the member variables midRangeFreq, melody, and guitarArray.
	 * Using 2 for-loops, the constructor populates the melody array with the frequency to be played along with the number of beats(time in s).
	 * This constructor also prints out the vocalist header(song length in chords and Mid-Range Frequency) in the console that is supposed to appear directly above the melody array. 
	 */

	Vocalist(double frequency, Guitar object){

		midRangeFreq = frequency;

		melody = new double[2][object.getNumOfChords()];

		guitarArray = object.getSongArray();

		for(int i=0; i<object.getNumOfChords(); i++){

			melody[0][i] = findClosest(object.getChordAsArray(i));
		}

		for(int i=0; i<object.getNumOfChords(); i++){

			melody[1][i] = guitarArray[guitarArray.length-1][i];
		}

		System.out.println("Vocalist(): midRangeFreq: " + midRangeFreq);

		System.out.println("Vocalist(): songLength: " + object.getNumOfChords());

	}

	/*This is a private method that returns a double from a double array parameter named check.
	 *This method's purpose is to extract the frequency from a single chord that is closest in absolute value to the Mid-Range Frequency. 
	 *This method returns this closest value from the array parameter as a double. 
	 */
	
	private double findClosest(double[] check){

		double closestValue = check[0];

		for(int i=1; i<(check.length-1); i++){

			if(Math.abs(check[i]-midRangeFreq) < Math.abs(closestValue-midRangeFreq)){

				closestValue = check[i];
			}
		}

		return closestValue;
	}

	/*This public method returns a formatted string that displays the 2D array (melody). 
	 *The main method invokes this method by placing the name of the Vocalist object(b) within a print statement.
	 */
	
	public String toString(){

		String viewMelody = "";

		for(int i=0; i<melody[0].length; i++){

			viewMelody += String.format(" %7.2f", melody[0][i]);

		}

		viewMelody +="\n";

		for(int i=0; i<melody[0].length; i++){

			viewMelody += String.format(" %7.1f", melody[1][i]);

		}

		return viewMelody;


	}
	
	/*The sing method plays(from the speakers of the computer) the frequencies taken from the melody array
	 *for the assigned time(in s) as soon as the melody array is printed to the console.
	 *This method invokes the playTone method found in the StdAudio class.
	 */
	
	public void sing(){

		for(int i=0; i<melody[0].length; i++){

			StdAudio.playTone(melody[0][i], melody[1][i]);

		}


	}
	
	/*The following three methods are getters for the three private member variables
	 *stored in the Vocalist class(midRangeFreq,getMelody,getGuitarArray).
	 */

	public double getMidRangeFreq(){

		return midRangeFreq;
	}

	public double[][] getMelody(){

		return melody;
	}

	public double[][] getGuitarArray(){

		return guitarArray;
	}

}
