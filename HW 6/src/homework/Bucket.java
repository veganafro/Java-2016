package homework;

/**
 * This Bucket class creates an object of the bucket type and provides various methods for manipulating the object
 * 
 * @author Jeremy Muhia
 * 
 * @version 1 April 2016
 *
 */
public class Bucket {

	// the ingredients that have been placed in the bucket
	private String extraIngredients;
	
	/**
	 * This default constructor creates a bucket object of infinite length
	 */
	Bucket() {
		
		this.extraIngredients = "";
		
	}
	
	/**
	 * This method adds a specified ingredient to the current bucket object
	 * 
	 * @param ingredient The char that is to be added to the bucket
	 */
	public void dumpIngredient(char ingredient) {
		
		this.extraIngredients += ingredient;
		
	}
	
	/**
	 * This getter method returns the ingredient contents in the bucket
	 * 
	 * @return Returns a string that includes the contents of the bucket
	 */
	public String toString() {
		
		return this.extraIngredients;
		
	}
	
	/**
	 * This getter method returns the current length of the bucket object
	 * 
	 * @return Returns an int represents how many character ingredients are in the bucket
	 */
	public int getSize() {
		
		return this.extraIngredients.length();
		
	}
	
}
