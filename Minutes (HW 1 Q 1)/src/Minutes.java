/* 
 * Author: Jeremy Muhia
 *
 * Date of creation: 3 February 2016
 * 
 * Description: The program asks the user for a number of minutes and prints the number of years and days in those minutes
 * 
 * */

import java.util.Scanner;

public class Minutes {

	public static void main (String [] args) {
		
		//Create a Scanner connection that allows for keyboard input
		Scanner in = new Scanner (System.in);
		
		//Prompt the user to input a number of minutes
		System.out.print("Tell me the number of minutes\n>");
		
		//Create an integer called user_input and let it be equal to the recorded value from the last line 
		int user_input = in.nextInt();
		
		//Only do calculations if the input is a positive integer
		if (user_input >= 0) {
		
			//Create an integer called years and equate it to the integer division of the minutes specified by the user and the number of minutes in a 365 day year
			int years = user_input / 525600;
		
			//Create an integer called days and equate it to the remaining minutes not in a 365 day year then integer divide those minutes by the number of minutes in a 24 hour day
			int days = (user_input % 525600) / 1440;
		
			//Print the resulting years and days in the console
			System.out.println(user_input + " is " + years + " years and " + days + " days");
		}
		
		//When the input isn't a positive integer
		else {
			
			//Print an error message with instructions
			System.out.println("That's not a valid number. Try a positive integer next time!");
		
		}
		
		//Close the Scanner connection
		in.close();
		
	}

}