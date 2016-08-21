package homework;

/**
 * This Potion class creates an object of the potion type and provides various methods for manipulating the object
 * 
 * @author Jeremy Muhia
 * 
 * @version 1 April 2016
 *
 */
public class Potion {

	// the maximum length of the potion
	private int maxIngredientCount;
	
	// the ingredients in the potion
	private String ingredientsList;
	
	/**
	 * This default constructor creates a Potion object with maximum length 10
	 */
	Potion() {
		
		this.maxIngredientCount = 10;
		
		this.ingredientsList = "";
		
	}
	
	/**
	 * This constructor creates a Potion object with specified maximum length
	 * 
	 * @param ingredientCount The specified maximum length of the Potion object
	 */
	Potion(int ingredientCount) {
		
		this.maxIngredientCount = ingredientCount;
		
		this.ingredientsList = "";
		
	}
	
	/**
	 * This method adds an ingredient to the potion if there are spaces in the potion that can accept new ingredients
	 * 
	 * @param ingredient The character to be added to the potion 
	 * @return True if the ingredient is added to the potion or False if there is no more room in the potion 
	 * 				for ingredients or the item is an invalid ingredient
	 */
	public boolean addIngredient(char ingredient) {
		
		// if the item is a valid ingredient and the potion has space for more ingredients, add the item to the potion and return true
		if ((ingredient == 'a')||(ingredient == 'b')||(ingredient == 'c')||(ingredient == 'd')||(ingredient == 'w')) {
		
			if (this.ingredientsList.length() < this.maxIngredientCount) {
			
				this.ingredientsList += ingredient;
			
				return true;
			
			}
			// if there is no room in the potion for more ingredients, return false
			else {
			
				return false;
			
			}
			
		}
		// if the item is an invalid ingredient, return false
		else {
			
			return false;
			
		}
		
	}
	/**
	 * This getter method returns the ingredient contents of the potion
	 * 
	 * @return Returns a string that includes the contents of the potion
	 */
	public String toString() {
		
		return this.ingredientsList;
		
	}
	
	/**
	 * This method heats the potion and removes any water ('w' characters) from the potion
	 * 
	 * @return True if there are water ingredients that have been removed, or false if no water was found in the potion
	 */
	public boolean heatPotion() {
		
		// if there is at least one water ingredient, accumulate all other ingredients in boiled then reset the potion to boiled
		if (this.ingredientsList.indexOf('w') > -1) {
			
			String boiled = "";
			
			// loop through each ingredient and add it to boiled if it's not a water ingredient
			for (int index = 0; index < this.ingredientsList.length(); index++) {
				
				if (this.ingredientsList.charAt(index) != 'w') {
					
					boiled += this.ingredientsList.charAt(index);
					
				}
				
			}
			
			// reset the potion to boiled and return true
			this.ingredientsList = boiled;
			
			return true;
			
		}
		// if no water was found in the potion, return false
		else {
			
			return false;
			
		}
		
	}
	
	/**
	 * This method places the items in the potion object in the Bucket object b
	 * 
	 * @param b The bucket object containing the contents from the potion object on which it's called
	 */
	public void discardPotion(Bucket b) {
		
		for (int index = 0; index < this.ingredientsList.length(); index++) {
			
			b.dumpIngredient(this.ingredientsList.charAt(index));
			
		}
		
		this.ingredientsList = "";
		
	}
	
	/**
	 * This method checks if there is any more space for new ingredients in the potion
	 * 
	 * @return True if there is no more space in the potion, or false if the potion object can accept more ingredients
	 */
	public boolean isFull() {
		
		// if the current length of the potion object has reached its maximum length, then return true
		if (this.ingredientsList.length() == this.maxIngredientCount) {
		
			return true;
			
		}
		// otherwise, return false
		else {
			
			return false;
			
		}
		
	}
	
}
