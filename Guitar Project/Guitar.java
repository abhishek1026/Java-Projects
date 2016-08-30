public class Guitar {

	private double[][] songArray; // This 2D array is populated with a series of double values as created by the constructor and generateSong method.

	private int numStr; //This variable stores the number of strings. The first parameter passed into the constructor determines this value.

	private int numChor; //This variable stores the number of chords. The second parameter passed into the constructor determines this value.

	/* The following is the constructor for the Guitar class. 
	 * It takes in two parameters(int,int).
	 * The first parameter gets stored in the private variable numStr.
	 * The second parameter gets stored in the private variable numChor.
	 * A new appropriately-sized double 2D array is created and is assigned to the private variable songArray.
	 * A method called generateSong(within the Guitar class itself) is invoked by this constructor.
	 */
	
	Guitar(int numStr, int numChor){

		this.numStr = numStr;

		this.numChor = numChor;

		songArray = new double[numStr+1][numChor];

		generateSong();

	}
	
	/*This is a public method within the Guitar class that does not return anything(void).
	 * This methods starts out with a print statement that displays the number of strings and chords.
	 * Nested for-loops are used to populate the songArray array.
	 * All rows except the last are filled with random double values ranging from 27.5(inclusive) to 4186(exclusive), which correspond to the frequency(in Hz).
	 * The last row is filled with random double values ranging from 0 to 3(exclusive), which correspond to the number of beats(in s).
	 * The songArray is printed out to the console, underneath its corresponding header.
	 */
	
	public void generateSong(){

		System.out.println("Guitar() : Generated new guitar with " + numStr + " strings. Song length is " + numChor + " chords.");

		for(int i= 0; i < numStr; i++){

			for(int j=0; j<numChor; j++){

				songArray[i][j] = 27.5+4158.5*Math.random();

				System.out.printf(" %7.2f", songArray[i][j]);
			}

			System.out.println();
		}


		for(int k =0; k<numChor; k++){

			songArray[numStr][k] = 3*Math.random();

			System.out.printf(" %7.1f", songArray[numStr][k]);
		}

		System.out.println("\n");

	}
	
	/*This is another public method within the Guitar class that does not return anything(void).
	 *It starts out by printing the header that identifies the method from which the following output is coming from.
	 *Each chord(column) in the songArray array is displayed as a row in the console.
	 *The addDots method is invoked to delay the program for the appropriate number of milliseconds.
	 *The addDots methods also prints out the appropriate number of periods at one-second intervals.
	 */
	
	public void simulateSong() throws InterruptedException{

		System.out.println("Guitar.simulateSong()");

		for(int i= 0; i<numChor; i++){

			for(int k =(numStr-1); k>=0; k--){

				System.out.printf(" %7.2f", songArray[k][i]);

			}

			addDots(songArray[numStr][i]);

			System.out.println();
		}

		System.out.println();

	}

	private void addDots(double waitTime) throws InterruptedException{

		do{
			System.out.print(".");

			for(int i=0; i<waitTime; i++){

				if (i<(int)waitTime){

					Thread.sleep(1000);

					System.out.print(".");
				}

				else if(i == (int)waitTime){

					Thread.sleep((long)(1000*(waitTime-i)));
				}

			}


		} while(false);

	}
	
	/*This is a public method that returns a double 1D array. The parameter is the number of column to use from the songArray array. 
	 * This method is used by the Vocalist class later on.
	 * The resulting array is formatted by displaying the random frequencies associated with a certain chord followed by the associated number of beats(in s).
	 */

	public double[] getChordAsArray(int column){

		if(column>=numChor){

			System.out.println("No such chord!");

			return null;
		}

		double[] oneD = new double[numStr+1];

		for(int i=0; i<=numStr; i++){

			oneD[i] = songArray[i][column];
		}

		return oneD;
	}

	//The following three public methods are getters of the three private variables stored in the Guitar class(songArray,numStr,numChor).
	
	public int getNumOfChords(){

		return numChor;
	}

	public double [][] getSongArray(){

		return songArray;
	}

	public int getNumOfStrings(){

		return numStr;
	}

}

