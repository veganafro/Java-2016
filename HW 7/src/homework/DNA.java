package homework;

/**
 * This class defines the objects of the DNA type and provides various methods for manipulating the object 
 * 
 * @author Jeremy Muhia
 * 
 * @version 13 April 2016
 *
 */

public class DNA {

	//DNA sequence of nucleotide basis
    private String sequence; 
    //valid/invalid indicator 
    private boolean valid; 

    /**
    * Initializes newly created DNA strand to the provided
    * sequence. The sequence is validated to contain only
    * legal nucleotides: guanine (G), adenine (A),
    * thymine (T), or cytosine (C). 
    * 
    * @param sequence the sequence of nucleotide basis to be used
    *    in this DNA 
    */
    public DNA (String sequence) {
    	
    	// sets the DNA object's data field sequence to the String parameter sequence
    	this.sequence = sequence;
    	// sets the DNA object's data field valid to the boolean returned by the validate() method
    	this.valid = this.validate();
    	
    }

    /**
    * Operates on the sequence of this DNA object. It returns true/false 
    * indicating validity of the sequence. The sequence is valid if it contains
    * only legal nucleotide basis: guanine (G), adenine (A),
    * thymine (T), or cytosine (C). The valid data field is set accordingly. 
    * 
    * @return true if the sequence in this DNA object is valid, false otherwise
    */
    private boolean validate () {
    	
    	// for each character in the DNA sequence, check that it's an allowed nucleotide
    	for (int index = 0; index < this.sequence.length(); index++) {
    		
    		if ((this.sequence.charAt(index) == 'G') || (this.sequence.charAt(index) == 'A') || (this.sequence.charAt(index) == 'T') || (this.sequence.charAt(index) == 'C')) {
    			continue;
    		}
    		// if one of the characters is not an allowed nucleotide, return false and stop checking the rest of the sequence
    		else {
    			return false;
    		}
    		
    	}
    	
    	// if all of the characters are valid, return true
    	return true;
    	
    }

    /** 
    * Translates this DNA object to its corresponding RNA sequence. The DNA and RNA
    * are closely related. The major difference is that the RNA contains
    * uracil (U) rather than thymine (T). This method replaces every occurrence of T
    * in the sequence by U and returns the corresponding String object. 
    * 
    * @return the RNA sequence 
    */
    public String toRNA () {

    	String RNA = "";
    	
    	// if the DNA object doesn't have nucleotides to convert or it's validity is false, return null
    	if ((this.sequence.length() == 0) || (this.valid == false)) {
    		return null;
    	}
    	// otherwise, iterate over each nucleotide and convert T to U, leaving everything else the same
    	else {
    		for (int index = 0; index < this.sequence.length(); index++) {
    			
    			// accumulate into the string RNA
    			if (this.sequence.charAt(index) == 'T') {
    				RNA += 'U';
    			}
    			else {
    				RNA += this.sequence.charAt(index);
    			}
    			
    		}	
    	}
    	
    	// return the string RNA
    	return RNA;
    	
    }

    /**
    * Computes the complementary DNA strand. The DNA usually exists as a double 
    * helix: given the strand stored in this DNA object, this method computes
    * and returns the second strand from the helix. To compute the complementary 
    * strand all A's need to be swapped with T's (and vice versa) and all C's need 
    * to be swapped with G's (and vice versa), and then the resulting string is 
    * reversed.
    * 
    * @return DNA object containing the reverse complement of the sequence stored
    *    in this DNA object 
    */
    public DNA reverseComplement () {
    	
    	// if it's a valid DNA object, go through and and swap A with T and C with G
    	if (this.valid == true) {
    		String complementString = "";
    		
    		// iterate backwards over the sequence and accumulate the swapped letters into complementString
    		for (int index = this.sequence.length() - 1; index >= 0; index--) {
    		
    			if (this.sequence.charAt(index) == 'A') {
    				complementString += 'T';
    			}
    			if (this.sequence.charAt(index) == 'T') {
    				complementString += 'A';
    			}
    			if (this.sequence.charAt(index) == 'C') {
    				complementString += 'G';
    			}
    			if (this.sequence.charAt(index) == 'G') {
    				complementString += 'C';
    			}
    		
    		}
    		
    		// create a new DNA object with complementString as the argument then return the new object
    		DNA complement = new DNA(complementString);
    		
    		return complement;
    	}
    	// if the DNA object is invalid, return null
    	else {
    		return null;
    	}
    	
    }

    /**
    * Returns true if this DNA object contains a valid strand and false otherwise.
    * 
    * @return true if this DNA object contains a valid strand and false otherwise
    */
    public boolean isValid () {
    	// return the validity of the DNA object
    	return this.valid;
    	
    }

    /**
    * Returns the String representation of this DNA object which is the sequence 
    * itself.
    */
    public String toString () {
    	// return the string representation of the DNA object
    	return this.sequence;
    
    }
	
}
