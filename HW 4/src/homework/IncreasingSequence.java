package homework;

import java.util.Arrays;

public class IncreasingSequence{
	public static void main(String[] args){
		//create an array of random numbers
		int[] arr = randomArray(100, 10);
		//print array
		System.out.println(Arrays.toString(arr));
		//call the function that will print increasing patterns
		printIncreasing(arr);
	}
	//creates an array of specified length filled with random numbers in a specified range
	public static int[] randomArray(int range, int numberOfNumbers){
		//create array of length how many numbers
		int [] randomNumbers = new int[numberOfNumbers];
		//loop over array to add random values
		for(int i = 0; i < numberOfNumbers; i++)
		{
			randomNumbers[i] = (int)(Math.random() * range);
		}
		return randomNumbers;
	}
	//check whether values increase or decrease and print when there are two or more increasing values
	public static void printIncreasing(int[] arr){
		int first = 0;
		int second = 1;
		String increasing = "";	
		//loop over the array minus the last value
		for(int i = 0; i < arr.length - 1; i++){
			//store values of current and next value
			first = arr[i];
			second = arr[i + 1];
			//compare values and add to string if they are increasing
			if(first < second){
				//avoid double counting
				if(increasing.length() < 1){
					increasing += (first + " " + second + " ");
				}
				else{
					increasing += (second + " ");
				}
			}
			//if they are not increasing
			//print the string if it is not empty
			else{
				if(increasing.length() > 0){
					System.out.println(increasing); 
				}
				increasing = "";
			}
			//if we are at the last value in our for loop we need to print in case the
			//last values are increasing
			if(i == arr.length - 2 && increasing.length() > 0){
				System.out.println(increasing);
			}
		}
		
	}
}
