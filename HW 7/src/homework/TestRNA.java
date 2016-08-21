package homework;

import java.util.Scanner;

/**
 * This class provides simple test for the RNA class.  
 * 
 * @author  Jeremy Muhia
 * @version 13 April 2016
 */ 

public class TestRNA {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// prompt the user to input a DNA sequence in uppercase letters
		System.out.print("Please enter a DNA sequence in uppercase letters\n>");
		
		String toDNA = input.next(); 
		
		// create a DNA object using user input and if it's valid, run some tests
		DNA dna1 = new DNA(toDNA);
		
		if (dna1.isValid()) {
			// create an RNA object
			RNA rna1 = new RNA(dna1.toRNA());
			
			// test the toRNA method and the toString method
			if (0 != dna1.toRNA().compareToIgnoreCase(rna1.toString())) {	
				System.out.println("check toString()");
			}
			
			// test the isValid method
			if (!rna1.isValid()) {
				System.out.println("check isValid() method");
			}
			
			// test the toProtein method
			if (rna1.toProtein(0) == null) {
				System.out.println("check toProtein() method");
			}
			
			// print the RNA object
			System.out.println(rna1);
			
			// print the protein
			System.out.println(rna1.toProtein(0));
		}
		// if the DNA object is invalid or if it's in lowercase letters, ask the user to try again
		else {
			System.out.println("Invalid DNA. Try again.");
			System.exit(0);
		}
		
		input.close();

	}

}
