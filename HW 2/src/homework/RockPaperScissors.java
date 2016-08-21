package homework;

/*
 * 
 * Author: Jeremy Muhia
 * 
 * Date of creation: 11 Feb 2016
 * 
 * Description: This program simulates a game of rock paper scissors between a user and the computer
 * 
 * */

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		//draw the ribbon of equals using my drawRibbon method
		drawRibbon();
		
		//Welcome the player
		System.out.println("\n Welcome to the Rock-Paper-Scissors game!");
		
		//draw another ribbon of equals using the drawRibbon method
		drawRibbon();
		
		//create a scanner object
		Scanner input = new Scanner (System.in);
		
		//ask the player which hand they want to play
		System.out.print("\n\nWhich had do you want to throw?\nR/r - rock\nP/p - paper\nS/s - scissors\n> ");
		
		//accept the player's input and store it as a lower case letter in a string called user_hand
		String user_hand = input.next().toLowerCase();
		
		//display the user's hand to confirm that input was accepted properly or an error message if the input was invalid
		if (user_hand.equals("r")) {
			System.out.println("\nYou chose rock");
		}
		else if (user_hand.equals("p")) {
			System.out.println("\nYou chose paper");
		}
		else if (user_hand.equals("s")) {
			System.out.println("\nYou chose sciccors");
		}
		else {
			System.out.println("\nThat's not a valid hand");
		}
		
		//create a string to hold the computer's hand
		String cpu_hand = "";
		
		//randomly select an integer from 0 to 2 which will determine the computer's hand
		int character_index = (int) (Math.random() * 3);
		
		//if the randomly generated integer is 0, set the computer's hand to rock
		if (character_index == 0) {
			cpu_hand = "r";
			System.out.println("Computer chose rock");
		}
		//if the randomly generated integer is 1, set the computer's hand to paper
		else if (character_index == 1) {
			cpu_hand = "p";
			System.out.println("Computer chose paper");
		}
		//if the randomly generated integer is 2, set the computer's hand to scissors
		else if (character_index == 2) {
			cpu_hand = "s";
			System.out.println("Computer chose scissors");
		}
		
		//compare the player's and computer's hand and generate the appropriate outcome
		if ( (cpu_hand.equals("p"))&&(user_hand.equals("s")) ) {
			System.out.println("You won! (scissors beats paper)");
		}
		else if ( (cpu_hand.equals("p"))&&(user_hand.equals("r")) ) {
			System.out.println("Computer won! (paper beats rock)");
		}
		else if ( (cpu_hand.equals("r"))&&(user_hand.equals("p")) ) {
			System.out.println("You won! (paper beats rock)");
		}
		else if ( (cpu_hand.equals("r"))&&(user_hand.equals("s")) ) {
			System.out.println("Computer won! (rock beats scissors)");
		}
		else if ( (cpu_hand.equals("s"))&&(user_hand.equals("r")) ) {
			System.out.println("You won! (rock beats scissors)");
		}
		else if ( (cpu_hand.equals("s"))&&(user_hand.equals("p")) ) {
			System.out.println("Computer won! (scissors beats paper)");
		}
		else if ( (cpu_hand.equals(user_hand)) ) {
			System.out.println("It's a tie.");
		}
		
		//close the scanner connection
		input.close();

	}
	
	//create a method for drawing a ribbon of 42 equals signs
	public static void drawRibbon() {
		
		//print an equals sign on the same line 42 times
		for (int banner_ribbon = 0; banner_ribbon < 42; banner_ribbon++) {
			System.out.print("=");
		}
		
	}

}
