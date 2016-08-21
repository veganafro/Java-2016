package homework;

/**
 * This program defines the rectangle class with data fields width and height
 * 
 * @author Jeremy Muhia
 * 
 * @version 23 March 2016
 *
 */

public class Rectangle {
	
	//private data field width with default value 0
	private double width = 0;
	
	//private data field height with default value 0
	private double height = 0;
	
	//default constructor
	Rectangle() {
		
	}
	
	/**
	 * This 2 param constructor creates a new rectangle object with specified width and height
	 * 
	 * @param newWidth The new width of the new rectangle object
	 * @param newHeight The new height of the new rectangle object
	 */
	Rectangle (double newWidth, double newHeight) {
		
		width = newWidth;
		
		height = newHeight;
		
	}
	
	/**
	 * This setter method sets the width for an already created rectangle object
	 * 
	 * @param newWidth The new width of the rectangle object
	 * @return A double value for the new width
	 */
	
	double setWidth(double newWidth) {
		
		return width = newWidth;
		
	}
	

	/**
	 * This setter method sets the height for an already created rectangle object
	 * 
	 * @param newWidth The new height of the rectangle object
	 * @return A double value for the new height
	 */
	
	double setHeight(double newHeight) {
		
		return height = newHeight;
		
	}
	
	/**
	 * This getter method returns the width for an already created rectangle object
	 * 
	 * @return A double value with the width of the rectangle object
	 */
	
	double getWidth() {
		
		return width;
		
	}
	

	/**
	 * This getter method returns the height for an already created rectangle object
	 * 
	 * @return A double value with the height of the rectangle object
	 */
	
	double getHeight() {
		
		return height;
		
	}
	

	/**
	 * This getter method returns the area for an already created rectangle object
	 * 
	 * @return A double value with the area of the rectangle object
	 */
	
	double getArea() {
		
		return width * height;
		
	}
	

	/**
	 * This getter method returns the perimeter for an already created rectangle object
	 * 
	 * @return A double value with the perimeter of the rectangle object
	 */
	
	double getPerimeter() {
		
		return 2 * (width * height);
		
	}
	
}
