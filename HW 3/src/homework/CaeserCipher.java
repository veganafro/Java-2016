package homework;

//import java.util.Arrays;
import java.util.Scanner;

public class CaeserCipher {

	public static void main(String[] args) {
	
	//call the drawRibbon method to draw a banner
	drawRibbon();
	
	//welcome the user to the program
	System.out.print(" \nEncrypt/Decrypt Tool\n");
	
	//all the drawRibbon method to draw a banner
	drawRibbon();
	
	//prompt the user for what action they would like to take
	System.out.print("\nWould you like to (E)ncrypt or (D)ecrypt?\n>");
	
	//create a new scanner object called input
	Scanner input = new Scanner (System.in);
	
	//accept input from user to determine which action to take
	String action = input.nextLine();
	
	//if the input is E or e, work through the process for encryption
	if (action.equalsIgnoreCase("E")) {
		
		//ask the user for the text they would like to encrypt
		System.out.print("What do you want to ecrypt?\n>");
		
		//accept the message to be encrypted using the scanner object called input
		String unsecured = input.nextLine();
		
		//ask the user for an encryption key
		System.out.print("What key do you want to use?\n>");
		
		//accept the encryption key using the scanner object called input
		int encryption_key = input.nextInt();
		
		//if the key is not valid, throw an error and end the program
		if ((encryption_key < -26)||(encryption_key > 26)) {
			System.out.print("That's not a valid key");
			System.exit(0);
		}
		//otherwise, print a message that indicates what the newly encrypted message is
		else {
			System.out.print("The encrypted message is " + encrypt(unsecured, encryption_key));
		}
		
	}
	//if the input is D or d, work through the process for decrypting
	else if (action.equalsIgnoreCase("D")) {
		//prompt the user for a phrase to decrypt
		System.out.print("What do you want to decrypt?\n>");
		
		//accept the phrase to be decrypted using the scanner object called input
		String secured = input.nextLine();
		
		//prompt the user for a decryption key
		System.out.print("What key do you want to use?\n>");
		
		//accept the decryption key using the scanner object called input
		int decryption_key = input.nextInt();
		
		//if the decryption key is invalid, throw an error and end the program
		if ((decryption_key < -26)||(decryption_key > 26)) {
			System.out.print("That's not a valid key");
			System.exit(0);
		}
		//otherwise, print a message with the decrypted phrase included
		else {
			System.out.print("The decrypted message is " + decrypt(secured, decryption_key));
		}
		
	}
	//if the direction that the user inputs is invalid then throw an error and end the program
	else {
		System.out.print("ERROR: invalid choice");
		System.exit(0);
	}
	
	//close the scanner onject called input
	input.close();
	
	}
	
	//this is the encryption method that accepts a string called message and an int called key
	public static String encrypt(String message, int key) {
		
		//create a string to hold the decrypted message and initialize it to an empty string
		String encrypted = "";
		
		//if the key is negative, add 26 to it to make it positive
		if (key < 0) {
			
			key = 26 + key;
		
		}
		
		//loop through the unencrypted message and shift each letter by the key value
		for (int letter_index = 0; letter_index < message.length(); letter_index++) {
			
			//create a char to hold the current letter
			char original = (char) (message.charAt(letter_index));
			//create a char to hold the newly shifted letter
			char to_append = (char) (original + key);
			
			//if the original character is an uppercase letter, check if the shifted letter is beyond Z
			if (Character.isUpperCase(original)) {
				
				/*if the shifted letter is beyond Z, then correct the shift by subtracting the difference
				 * between 26 and the key then append the new letter*/
				if (to_append > 'Z') {
					encrypted += (char) (message.charAt(letter_index) - (26 - key));
				}
				//otherwise, append the shifted letter without correction
				else {
					encrypted += to_append;
				}
				
			}
			//if the original character is a lowercase letter, check if the shifted letter is beyond z
			else if (Character.isLowerCase(original)) {
				
				/*if the shifted letter is beyond z, then correct the shift by subtracting the difference
				 * between 26 and the key then append the new letter*/
				if (to_append > 'z') {
					encrypted += (char) (message.charAt(letter_index) - (26 - key));
				}
				//otherwise, append the shifted letter without correciton
				else {
					encrypted += to_append;
				}
				
			}
			//if the original character is not a letter, add it to the encrypted message as is
			else {
				
				encrypted += original;
			
			}
			
		}
		
		//return the encrypted message
		return encrypted;
		
	}
	
	//this is the decryption method that accepts a string called message and an int called key
	public static String decrypt(String message, int key) {
		
		//create a string to hold the encrypted message and initialize it to an empty string
		String decrypted = "";
		
		//if the key is negative, add 26 to it to make it positive
		if (key < 0) {
			
			key = 26 + key;
		
		}
		
		//loop through the encrypted message and shift each letter by the key value
		for (int letter_index = 0; letter_index < message.length(); letter_index++) {
			
			//create a char to hold the current letter
			char original = (char) (message.charAt(letter_index));
			//create a char to hold the newly shifted letter
			char to_append = (char) (original + key);
			
			//if the original character is an uppercase letter, check if the shifted letter is beyond Z
			if (Character.isUpperCase(original)) {
				
				/*if the shifted letter is beyond Z, then correct the shift by subtracting the difference
				 * between 26 and the key then append the new letter*/
				if (to_append > 'Z') {
					decrypted += (char) (message.charAt(letter_index) - (26 - key));
				}
				//otherwise, append the shifted letter without correciton
				else {
					decrypted += to_append;
				}
				
			}
			//if the original character is a lowercase letter, check if the shifted letter is beyond z
			else if (Character.isLowerCase(original)) {
				
				/*if the shifted letter is beyond z, then correct the shift by subtracting the difference
				 * between 26 and the key then append the new letter*/
				if (to_append > 'z') {
					decrypted += (char) (message.charAt(letter_index) - (26 - key));
				}
				//otherwise, append the shifted letter without correciton
				else {
					decrypted += to_append;
				}
				
			}
			//if the original character is not a letter, add it to the decrypted message as is
			else {
				
				decrypted += original;
			
			}
			
		}
		
		//return the decrypted message
		return decrypted;
		
	}
	
	//create a method for drawing a ribbon of 20 equals signs
	public static void drawRibbon() {
			
		//print an equals sign on the same line 20 times
		for (int banner_ribbon = 0; banner_ribbon < 20; banner_ribbon++) {
			
			System.out.print("=");
		
		}
	
	}
		
}
	
