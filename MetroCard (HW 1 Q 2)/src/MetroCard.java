/*
 * Author: Jeremy Muhia
 * 
 * Date of creation: 3 February 2016
 * 
 * Description: The program asks the user for an amount to be deposited into her/his metrocard and calculates the number of rides/bonus amount possible
 * 
 * */

import java.util.Scanner;

public class MetroCard {
	
	public static void main (String [] args) {
		
		//Create a Scanner connection that allows for keyboard input
		Scanner in = new Scanner (System.in);
		
		//Prompt the user to enter an amount she/he wants to add to her/his metrocard
		System.out.print("Enter the amount of money you wish to put on your card:\n>");
		
		//User inputs the dollar amount to be added
		float user_input = in.nextFloat();
		
		//Check that the amount is high enough for at least one ride
		if (user_input >= 2.75) {
			
			//Check if the amount is high enough for an 11% bonus
			if (user_input >= 5.50) {
				
				//Calculate an 11% bonus based on the amount to be deposited
				float bonus_dollars = (float) (user_input * 0.11);
				
				//Add the calculated bonus to the original amount
				user_input += bonus_dollars;
			
			}
			
			//Calculate the number of rides possible with the amount and bonus deposited
			int base_fares = (int) (user_input / 2.75);
			
			//Print a message indicating the number of rides possible
			System.out.print("You will have " + base_fares + " base fares");
		
		}
		
		//Assuming that the input is not enough for at least one ride, print an error message
		else {
			
			System.out.print("That's not enough money for any base fares");
		
		}
	
		in.close();
		
	}

}