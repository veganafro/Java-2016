package homework;

import java.util.Scanner;

/**
 * This program asks the user to create a matrix with dimensions between 1 and 5 then does some computation on that matrix
 * 
 * @author Jeremy Muhia
 * 
 * @version 23 March 2016
 *
 */

public class Matrix {

	public static void main(String[] args) {
		
		//create a scanner object and use it to accept integer inputs for the dimensions of the matrix
		Scanner input = new Scanner (System.in);
		
		System.out.print("How many rows should the matrix have?\n>");
		
		int rows = input.nextInt();
		
		System.out.print("How many columns should the matrix have?\n>");
		
		int columns = input.nextInt();
		
		//create a new matrix with the specified dimensions
		int[][] matrix = new int[rows][columns];
		
		//check to make sure the dimensions are between 1 and 5 for both rows and columns
		if ((columns <= 5&&columns >= 1)&&(rows <= 5&&rows >= 1)) {
			
			/*assuming acceptable dimension inputs from the user, append a new random element between 
			 * -10 and 10 to each row*/
			for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			
				for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
				
					matrix[rowIndex][columnIndex] = (int) (-10 + Math.random() * 21); 
				
				}
			
			}
			
		}
		//if the input dimensions aren't valid, throw an error message and exit the program
		else {
			
			System.out.print("The dimensions you entered were not between 1 and 5. Try again");
			
			System.exit(0);
			
		}
		
		//use the print matrix method to print the original matrix
		printMatrix(matrix);
		
		System.out.print("\n");
		
		//create a string object to denote and hold the action chosen by the user
		String action;
		
		//present the user a menu of options and execute the appropriate command then quit the program
		do {
			//print a menu of action options for the user
			System.out.print("What computation would you like to do?\n"
					+ "H: Horizontal Flip - each row is reversed\n"
					+ "V: Vertical Flip - each column is reversed\n"
					+ "T: Transpose - rows become columns and vice versa\n"
					+ "R: rowMax - find the largest value in each row\n"
					+ "C: columnSum - find the sum of the values in each column\n"
					+ "Q: Quit - you know what this means\n\n>");
			
			//accept the user's action input and store it in the string object action
			action = input.next();
			
			System.out.print("\n");
			
			//if the user input H, reverse the order of elements in each row and print the new matrix
			if (action.equalsIgnoreCase("H")) {
		
				printMatrix(horizontalFlip(matrix));
		
				System.out.print("\n");
			
				System.exit(0);
		
			}
			//if the user input is V, reverse the order of elements in each column and print the new matrix
			else if (action.equalsIgnoreCase("V")) {
		
				printMatrix(verticalFlip(matrix));
		
				System.out.print("\n");
			
				System.exit(0);
			
			}
			//if the user input is T, the original rows become columns and the original columns become rows
			//then print this new matrix
			else if (action.equalsIgnoreCase("T")) {
			
				printMatrix(transpose(matrix));
		
				System.out.print("\n");
			
				System.exit(0);
			
			}
			//if the user input is R, store the largest value in each row in a new matrix and print the new matrix
			else if (action.equalsIgnoreCase("R")) {
			
				printMatrix(rowMax(matrix));
		
				System.out.print("\n");
			
				System.exit(0);
			
			}
			//if the user input is C, store the sum of the values in each column in a new matrix and print the new matrix
			else if (action.equalsIgnoreCase("C")) {
		
				printMatrix(columnSum(matrix));
			
				System.out.print("\n");
			
				System.exit(0);
			
			}
			//if the user input is Q, quit the program
			else if (action.equalsIgnoreCase("Q")) {
			
				System.exit(0);
			
			}
			//if the user inputs an invalid value, throw an error message and present the menu options again
			else {
			
				System.out.println("Invalid command.\n");
			
			}
			//ask the user which of the commands they would like to execute if the previous command is invalid
		} while (action.equalsIgnoreCase("Q") == false);
		
		//close the scanner object
		input.close();

	}
	
	/**
	 * This method accepts a 2 dimensional array and prints the elements row by row
	 * 
	 * @param toPrint The 2 dimensional array to be printed 
	 */
	
	public static void printMatrix(int[][] toPrint) {
		
		//iterate over each row in the 2 dimensional array
		for (int row = 0; row < toPrint.length; row++) {
			
			//at each row, print each element in the row then print a new line
			for (int column = 0; column < toPrint[row].length; column++) {
				
				System.out.printf("%3d", toPrint[row][column]);
				
			}
			
			System.out.print("\n");
			
		}
		
	}
	
	/**
	 * This overloaded method accepts a 1 dimensional array and prints the elements in the array
	 * 
	 * @param toPrint The 1 dimensional array to be printed
	 */
	
	public static void printMatrix(int[] toPrint) {
		
		//iterate over each element in the array and print it
		for (int element = 0; element < toPrint.length; element++) {
			
			System.out.printf("%3d", toPrint[element]);
			
		}
		
	}
	
	/**
	 * This method reverses the order of each row in the matrix
	 * 
	 * @param toFlip The matrix to be row reversed
	 * @return A new matrix with rows in the reverse order of the original
	 */
	
	public static int[][] horizontalFlip(int[][] toFlip) {
		
		//calculate the number of rows in the original matrix
		int toFlipRowCount = toFlip.length;
		
		//calculate the number of columns in the original matrix
		int toFlipColumnCount = toFlip[toFlipRowCount - 1].length;
		
		//create a new matrix with the same dimensions as the original
		int[][] flippedMatrix = new int[toFlipRowCount][toFlipColumnCount];
		
		//iterate over each row of the original matrix
		for (int toFlipRow = 0; toFlipRow < toFlipRowCount; toFlipRow++) {
			
			//track the index of the newest element to be added in each row of the new matrix
			int flippedColumnIndex = 0;
			
			/*iterate over each element of the row in the old matrix in reverse order and append that element to the
			 * new matrix in sequentially increasing order*/
			for (int toFlipColumn = toFlipColumnCount -1; toFlipColumn >= 0; toFlipColumn--) {
				
				flippedMatrix[toFlipRow][flippedColumnIndex] = toFlip[toFlipRow][toFlipColumn];
				
				flippedColumnIndex += 1;
				
			}
			
		}
		
		//return the new matrix
		return flippedMatrix;
		
	}
	
	/**
	 * This method reverses the order of each column in the matrix
	 * 
	 * @param toFlip The matrix to be column reversed
	 * @return A new matrix with columns in the reverse order of the original
	 */
	
	public static int[][] verticalFlip(int[][] toFlip) {
		
		//calculate the number of rows in the original matrix
		int toFlipRowCount = toFlip.length;
		
		//calculate the number of columns in the original matrix
		int toFlipColumnCount = toFlip[toFlipRowCount - 1].length;
		
		//create a new matrix with the same dimensions as the original
		int[][] flippedMatrix = new int[toFlipRowCount][toFlipColumnCount];
		
		//iterate over each row of the original matrix
		for (int toFlipColumn = 0; toFlipColumn < toFlipColumnCount; toFlipColumn++) {
			
			//track the index of the newest element to be added in each column of the new matrix
			int flippedRowIndex = 0;
			
			/*iterate over each element of the column in the old matrix in reverse order and append that element to the
			 * new matrix in sequentially increasing order*/
			for (int toFlipRow = toFlipRowCount - 1; toFlipRow >= 0; toFlipRow--) {
				
				flippedMatrix[flippedRowIndex][toFlipColumn] = toFlip[toFlipRow][toFlipColumn];
				
				flippedRowIndex += 1;
				
			}
			
		}
		
		//return the new matrix
		return flippedMatrix;
		
	}
	
	/**
	 * This method changes rows to columns and columns to rows
	 * 
	 * @param toFlip The matrix to be transposed
	 * @return A new matrix with columns and rows swapped
	 */
	
	public static int[][] transpose(int[][] toTranspose) {
		
		//calculate the number of rows in the original matrix
		int toTransposeRowCount = toTranspose.length;
		
		//calculate the number of columns in the original matrix
		int toTransposeColumnCount = toTranspose[toTransposeRowCount - 1].length;
		
		//create a new matrix with swapped column and row dimensions
		int[][] transposed = new int[toTransposeColumnCount][toTransposeRowCount];
		
		//iterate over each row of the original matrix
		for (int toTransposeRow = 0; toTransposeRow < toTransposeRowCount; toTransposeRow++) {
			
			//iterate over each element in each row of the original matrix
			for (int toTransposeColumn = 0; toTransposeColumn < toTransposeColumnCount; toTransposeColumn++) {
				
				//append the elements of the original matrix to the new matrix with reversed index
				transposed[toTransposeColumn][toTransposeRow] = toTranspose[toTransposeRow][toTransposeColumn];
				
			}
			
		}
		
		//return the transposed matrix
		return transposed;
		
	}
	
	/**
	 * This method finds the largest element in each row
	 * 
	 * @param toFlip The matrix to be analyze
	 * @return A new matrix with the largest element from each row
	 */
	
	public static int[] rowMax(int[][] findMax) {
		
		//iterate over each row and compare the largest element so far with the following elements track the greater
		int[] largestAtRow = new int[findMax.length];
		
		for (int row = 0; row < findMax.length; row++) {
			
			int currentLargestNumber = 0;
			
			for (int column = 0; column < findMax[row].length; column++) {
				
				if (findMax[row][column] > currentLargestNumber) {
					
					currentLargestNumber = findMax[row][column];
					
				}
				
			}
			
			//append the largest element from the most recent row
			largestAtRow[row] = currentLargestNumber;
			
		}
		
		//return the collection of largest elements
		return largestAtRow;
		
	}
	
	/**
	 * This method calculates the sum of each column
	 * 
	 * @param toFlip The matrix to be analyze
	 * @return A new matrix the sum of elements from each column
	 */
	
	public static int[] columnSum(int[][] findSum) {
		//iterate over each column and add the elements sequentially
		int[] sumAtColumn = new int[findSum[0].length];
		
		for (int column = 0; column < findSum[0].length; column++) {
			
			int currentSum = 0;
			
			for (int row = 0; row < findSum.length; row++) {
				
				currentSum += findSum[row][column];
				
			}
			
			//append the sum to the array
			sumAtColumn[column] = currentSum;
			
		}
		
		//return the array of sums
		return sumAtColumn;
		
	}

}
