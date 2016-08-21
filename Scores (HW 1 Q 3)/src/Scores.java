/*
 * Author: Jeremy Muhia
 * 
 * Date of creation: 3 February 2016
 * 
 * Description: The program asks the user for a number of students and their SAT math scores then prints the best student's name and their score
 * 
 * */

import java.util.Scanner;

public class Scores {

	public static void main(String[] args) {
		
		//Create a Scanner connection that allows for keyboard input
		Scanner input = new Scanner (System.in);
		
		//Ask for the number of students
		System.out.print("How many students are there?\n>");
		
		//User inputs the total number of students to be compared
		int student_count = input.nextInt();
		
		//Set the highest score to 0 as no students have been evaluated yet
		int highest_score = 0;
		
		//Set the best student's name to an empty string as no students have been evaluated yet
		String best_student = "";
		
		//Ask about each individual student by asking for details as many times as there are students
		for (int iterations = 0; iterations < student_count; iterations++) {
			
			//Prompt the user to give a particular student's name
			System.out.print("What's the student's name?\n>");
			
			//Create a variable to hold that student's name
			String new_student = input.next();
			
			//Prompt the user to give that student's SAT score
			System.out.print("What's their math SAT score?\n>");
			
			//Create a variable to hold that student's SAT score
			int new_score = input.nextInt();
			
			//Make sure that the score is within the valid range of scores
			if (new_score >= 200 && new_score <= 800) {
				
				//Compare the newly input score and the previous highest
				if (new_score > highest_score) {
					
					//Assuming the newly input score is greater than the previous high, make the newly input student the new best student
					best_student = new_student;
					
					//Assuming the newly input score is greater than the previous high, make the newly input score the new highest score
					highest_score = new_score;
					
				}
				
			}
			
			//If the newly input score is not in the valid score range, print an error message
			else {
				
				//Tell the user that they have given a score in an invalid range
				System.out.println("You gave me an invalid score. Try again!");
				
			}
		
		}
		
		//Print the message indicating the best student and her/his score
		System.out.println(best_student + " received the highest score of " + highest_score);
		
		//Close the Scanner connection
		input.close();
	}

}