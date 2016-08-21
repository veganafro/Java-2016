package homework;

/*
 * 
 * Author: Jeremy Muhia
 * 
 * Date of creation: 11 Feb 2016
 * 
 * Description: This program accepts non negative integer input from the user and displays the unicode 16 and hexadecimal representations of that integer along with an interesting fact about the unicode representation
 * 
 * */

import java.util.Scanner;

public class CharacterCheck {

	public static void main(String[] args) {
		
		//create a scanner object
		Scanner input = new Scanner (System.in);
		
		//prompt the user for a numeric input
		System.out.print("Gimme a non-negative integer to convert to hexadecimal\n> ");
		
		//store the user's input in an integer called user_integer
		int user_integer = input.nextInt();
		
		//display an error message if the input is negative
		if (user_integer < 0) {
			System.out.println("I said non-negative integer.");
			System.exit(0);
		}
		
		//convert the user's input into a Unicode-16 character and store it in a character type called converted_char 
		char converted_char = (char) user_integer;
		
		//use print formatting to print the user's integer, its hexadecimal representation and its Unicode-16 representation
		System.out.printf(user_integer + " (0x%02X) is Unicode-16 for for character '" + converted_char + "'.\n", user_integer);
		
		//determine if the character is a letter, a digit or neither and display a message indicating which it is
		if (Character.isLetter(converted_char)) {
			System.out.println("It's a letter.");
		}
		else if (Character.isDigit(converted_char)) {
			System.out.println("It's a digit.");
		}
		else {
			System.out.println("It's not a letter or a digit.");
		}
		
		//close the scanner connection
		input.close();
	}
	
}
