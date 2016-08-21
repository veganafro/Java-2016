package homework;

/*
 * 
 * Author: Jeremy Muhia
 * 
 * Date of creation: 11 Feb 2016
 * 
 * Description: This program simulates the rolling of 2 dice 1000 times, sums each roll, and indicates how many times each possible sum was rolled as a percent of all the rolls
 * 
 * */

public class TwoDice {

	public static void main(String[] args) {
		
		//create variables that track how many times each sum of the two dice is rolled
		int twos = 0;
		int threes = 0;
		int fours = 0;
		int fives = 0;
		int sixes = 0;
		int sevens = 0;
		int eights = 0;
		
		//set the number of rolls equal to an integer
		int rolls = 1000;
		
		//roll the dice the specified amount of times
		for (int iterations = 0; iterations < rolls; iterations++) {
			
			//randomly generate a number between 1 and 4 for each dice during each roll 
			int die_1 = (int) (Math.random() * 4 + 1);
			int die_2 = (int) (Math.random() * 4 + 1);
			
			//compare the sum of the two dice to an integer and if the sum matches the integer, then increment the corresponding integer variable by 1
			//if the sum is 2, increment twos by 1
			if ((die_1 + die_2) == 2) {
				twos += 1;
			}
			//if the sum is 3, increment threes by 1
			else if ((die_1 + die_2) == 3) {	
				threes += 1;
			}
			//if the sum is 4, increment fours by 1
			else if ((die_1 + die_2) == 4) {
				fours += 1;
			}
			//if the sum is 5, increment fives by 1
			else if ((die_1 + die_2) == 5) {	
				fives += 1;
			}
			//if the sum is 6, increment sixes by 1
			else if ((die_1 + die_2) == 6) {	
				sixes += 1;
			}
			//if the sum is 7, increment sevens by 1
			else if ((die_1 + die_2) == 7) {	
				sevens += 1;
			}
			//if the sum is 8, increment eights by 1
			else if ((die_1 + die_2) == 8) {	
				eights += 1;
			}
			
		}
		
		//display a message indicating the percentage to two decimal places of times each sum was rolled
		System.out.printf("The sum totaled 2 %5.2f%% " + "of times\n", (float) (twos) / rolls * 100);
		System.out.printf("The sum totaled 3 %5.2f%% " + "of times\n", (float) (threes) / rolls * 100);
		System.out.printf("The sum totaled 4 %5.2f%% " + "of times\n", (float) (fours) / rolls * 100);
		System.out.printf("The sum totaled 5 %5.2f%% " + "of times\n", (float) (fives) / rolls * 100);
		System.out.printf("The sum totaled 6 %5.2f%% " + "of times\n", (float) (sixes) / rolls * 100);
		System.out.printf("The sum totaled 7 %5.2f%% " + "of times\n", (float) (sevens) / rolls * 100);
		System.out.printf("The sum totaled 8 %5.2f%% " + "of times\n", (float) (eights) / rolls * 100);
		
	}

}
