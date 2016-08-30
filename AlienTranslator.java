import java.util.Scanner;

/**
 * This class translates messages from aliens on planets
 * Beaumonde and Regina into Earth English. 
 * @author Kristy Boyer
 *
 */
public class AlienTranslator {

	/**
	 * This main method creates an AlienTranslator and then calls the
	 * translateInput method. Students should not modify this method.
	 * @param args
	 */
	public static void main(String[] args) {
		AlienTranslator a = new AlienTranslator();
		Scanner s = new Scanner(System.in);
		a.translateInput(s);
	}

	/**
	 * This method gets the necessary input from the user regarding planet 
	 * and the message to be translated. 
	 * Students should fill in the missing code in this method.
	 * @param in A Scanner created on the appropriate stream of input. 
	 */
	public String translateInput(Scanner in) {

		//TODO: Get from user which planet the inter-galactic message is from.
		//1=Beaumonde and 2=Regina
		//Store value in an int variable named planet. If it is not valid, print
		//an error to the user and exit the program. Otherwise (a valid planet)
		//Get the inter-galactic message that needs to be translated.
		//Store it in a String variable named message

		//---- > Fill in Student Code Here < ------
		System.out.println("What planet?");

		int planet = in.nextInt();

		if (planet != 1 && planet != 2)
		{
			System.out.println("Not a valid planet.");
			System.exit(0);
		}
		else 
			System.out.println("What message?");

			in.nextLine();

		String message = in.nextLine();
		//---- > End Student Code < -----


		//Teaching staff code - STUDENTS DO NOT MODIFY - extracts characters
		//one at a time from the String message and stores each character in
		//the char variable named charToTranslate

		//The result variable is used to build and store the translated message
		// which will be sent back when this method is finished.
		String result = "";

		for (int i=0; i < message.length(); i++) {

			char charToTranslate = message.charAt(i);

			//End teaching staff code

			//TODO: translate the character stored in variable charToTranslate
			//and append the translated character to the result variable

			//----- >  Fill in Student Code Here < -----
			if (planet == 1)
			{
				if ((67<=charToTranslate && charToTranslate<=90) || (99<=charToTranslate && charToTranslate<=122))
				{
					
					result += ((char)(charToTranslate-2));
				}
				else if (charToTranslate == 65)
				{
					result += "Y";
				}
				else if (charToTranslate == 66)
				{
					result += "Z";
				}
				else if (charToTranslate == 97)
				{
					result += "y";
				}
				else if (charToTranslate == 98)
				{
					result += "z";
				}
				else
				{
					result += (charToTranslate);
				}
			}
			else
			{
				if ((65<=charToTranslate && charToTranslate<=88) || (97<=charToTranslate && charToTranslate<=120))
				{
					result += ((char) (charToTranslate+2));
				}
				else if (charToTranslate == 89)
				{
					result += "A";
				}
				else if (charToTranslate == 90)
				{
					result += "B";
				}
				else if (charToTranslate == 121)
				{
					result += "a";
				}
				else if (charToTranslate == 122)
				{
					result += "b";
				}
				else
				{
					result += (charToTranslate);
				}
			}
			//----- >  End Student Code < -----



		} 
		//ends the for loop


//TODO: perform the necessary output as specified in the requirements
// **** This TODO was added to this starter code on Mon 1/25 2:55pm ****
//------> Fill in Student Code < -------
		if (planet == 1)
		{
			System.out.println("Original message in Beaumondian: " + message); 
            System.out.println("Translation in Earth English: " + result);
		}
		else
		{
			System.out.println("Original message in Reginian: " + message); 
            System.out.println("Translation in Earth English: " + result);	
		}
//------> End Student Code < -------

		//Sends back the value of the result variable 
		return result;
	} //ends the translateInput method

} //ends the AlienTranslator class

