package homework;

import java.util.Scanner;

/**
 * 
 * This class analyzes an array of integers and publishes the mean, median and mode
 * 
 * @author Jeremy Muhia
 * 
 * @version 29 Feb 2016
 *
 */

public class NumberStats {
	
	public static void main(String[] args) {
		
		//create a scanner object to accept input
		Scanner input = new Scanner (System.in);
		
		//prompt the user for how long the array should be
		System.out.print("How long should the array be?\n>");
		
		//accept the array length input
		int array_length = input.nextInt();
		
		//create an array of specified length
		int[] to_analyze = new int[array_length];
		
		//append a random number between [-100, 100] to the array
		for (int numbers_to_generate = 0; numbers_to_generate < array_length; numbers_to_generate++) {
			
			to_analyze[numbers_to_generate] = (int) (-100 + Math.random() * 201);
			
		}
		
		//use a method to sort the array
		isSorted(to_analyze);
		
		//print the mean
		System.out.print("The mean is " + mean(to_analyze));
		
		//print the median
		System.out.print("The median is " + median(to_analyze));
		
		//print the mode
		System.out.print("The mode is " + mode(to_analyze));
		
		//close the scanner object
		input.close();
		
	}
	
	/**
	 * 
	 * this sorts the list
	 * 
	 * @param list the list to the sorted
	 * @return true once the list is sorted
	 * 
	 */
	
	public static boolean isSorted(int[] list) {
		
		//initialize the sorted state as false
		boolean sortState = false;
		
		//compare each position in the list to those following it
		for (int element = 0; element < list.length; element++) {
		
			//set the current lowest to the element at the index being compared
			int currentMinElement = list[element];
			
			//compare the following elements to the current one
			for (int nextMinIndex = element + 1; nextMinIndex < list.length; nextMinIndex++) {
			
				//create a variable to store the lowest element if it is found later
				int nextMinElement = list[nextMinIndex];
			
				/*if the index element is greater than the comparison element, swap them
				 */
				if (currentMinElement > nextMinElement) {
				
					list[nextMinIndex] = list[element];
				
					list[element] = nextMinElement;
					
					currentMinElement = list[element];
					
				}
			
			}
		
		}
		
		//change the sorted state to true and return that
		sortState = true;
		
		return sortState;
		
	}
	
	/**
	 * this method finds the arithmetic mean
	 * 
	 * @param list the list of ordered numbers of which to compute the mean
	 * @return the value of the average
	 * 
	 */
	
	public static double mean(int[] list) {
		
		//set the sum of numbers to 0
		int total = 0;
		
		//loop over the array adding each value to the sum
		for (int index = 0; index < list.length; index++) {
			
			total += list[index];
			
		}
		
		//divide the sum by the number of elements in the array
		double average = (double) (total / list.length);
		
		//return the average
		return average;
		
	}
	
	/**
	 * this computes the middle element in the array
	 * @param list the array in which to find the middle element
	 * @return the middle element
	 */
	public static int median(int[] list) {
		
		//find the maximum index
		int index = list.length - 1;
		
		//divide the index by 2 to find the halfway point and cast it to an int
		int middle = list[(int) (index / 2.0)];
		
		//return the value at that index
		return middle;
		
	}
	
	/**
	 * this returns the most frequently occurring number
	 * 
	 * @param list the list in which to find reoccurring numbers
	 * @return return the most reoccurring number
	 */
	public static int mode(int[] list) {
		
		//set the mode to a value that cannot be in the array
		int mostCommon = -1000;
		
		//set the frequency to 0
		int mostCommonAppeared = 0;
		
		//compare the first number to all those following and increment the number of times it's been counted
		for (int elementAt = 0; elementAt < list.length; elementAt++) {
			
			//set the frequency following the first equal to 1
			int count = 1;
			
			//if the element is found again, increment count by one
			for (int nextElements = elementAt + 1; nextElements < list.length; nextElements++) {
				
				if (list[nextElements] == list[elementAt]) {
					
					count += 1;
					
				}
				
			}
			
			//compare the previous high with the recent count and set the maximum to the greater
			if (count > mostCommonAppeared) {
				
				mostCommon = list[elementAt];
				
				mostCommonAppeared = count;
				
			}
			
		}
		
		//return the most common element
		return mostCommon;
		
	}

}
