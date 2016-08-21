package homework;

public class RNA {
	// RNA sequence of nucleotides
	private String sequence;
	// validity indicator
	private boolean validity;
	
	// constructor that accepts a string type sequence of nucleotides and creates an RNA object
	public RNA (String sequence) {
		
		// sets the RNA object's data field sequence to the String parameter sequence
		this.sequence = sequence;
		// sets the RNA object's data field validity to the boolean returned by the validate method
		this.validity = this.validate();
		
	}
	
	/**
	 * This method iterates over each letter in the RNA sequence and checks to assure that it is a valid letter
	 * 
	 * @return true if the elements of the RNA object are valid and false otherwise
	 */
	private boolean validate () {
    	
		// iterate over each character and compare it to the allowable values
    	for (int index = 0; index < this.sequence.length(); index++) {
    		// if the character is valid, move to the next one, otherwise, return false
    		if ((this.sequence.charAt(index) == 'U') || (this.sequence.charAt(index) == 'G') || (this.sequence.charAt(index) == 'A') || (this.sequence.charAt(index) == 'C')) {
    			continue;
    		}
    		else {
    			return false;
    		}
    		
    	}
    	// if all of the characters are valid, then return true
    	return true;
		
	}
	
	/**
	 * This getter method returns the validity value of the RNA object
	 * 
	 * @return true if the RNA object is valid and false otherwise
	 */
	public boolean isValid() {
		// return the validity of the RNA object
		return this.validity;
		
	}
	
	/**
	 * This method iterates over an RNA object and converts each codon to a protein
	 * 
	 * @param position The positions in the RNA string from where to start converting to a protein
	 * @return A string representing the protein
	 */
	public String toProtein (int position) {
		
		String rnaToProtein = "";
		
		// if the position is a positive integer that's at least 3 less than the final index, begin converting
		if ((position >= 0) && (position < this.sequence.length()) && (this.sequence.length() - position >= 3)) {
			String codon = "";
			
			// beginning from the position, accumulate each codon and convert it to a protein 
			for (int index = position; index < this.sequence.length(); index += 1) {
				
				codon += this.sequence.charAt(index);
				
				// when the codon has reached length 3, begin converting it to a protein
				if ((codon.length() == 3)) {
					String toAppend = codonToProtein(codon);
					
					// if the codon is invalid, return null
					if (toAppend == null) {
						return null;
					}
					// if the codon is valid but not stop, add it to the protein and reset the codon
					else if (!toAppend.equals("stop")) {
						rnaToProtein += toAppend;
						codon = "";
					}
					// if the codon is valid and stop, return the protein
					else if (toAppend.equals("stop")) {
						return rnaToProtein;
					}
				}
				
			} 
		}
		else {
			return null;	
		}
		
		// return the protein string
		return rnaToProtein;
		
	}
	
	/**
	 * This method accepts a codon and converts it to a protein
	 * 
	 * @param codon A valid RNA string of length 3
	 * @return A string representing the protein
	 */
	private String codonToProtein (String codon) {
		
		String [][] codons = {
				{ "AUU", "AUC", "AUA" },
				{ "CUU", "CUC", "CUA", "CUG", "UUA", "UUG" },
				{ "GUU", "GUC", "GUA", "GUG" },
				{ "UUU", "UUC" },
				{ "AUG" },
				{ "UGU", "UGC" },
				{ "GCU", "GCC", "GCA", "GCG" },
				{ "GGU", "GGC", "GGA", "GGG" },
				{ "CCU", "CCC", "CCA", "CCG" },
				{ "ACU", "ACC", "ACA", "ACG" },
				{ "UCU", "UCC", "UCA", "UCG", "AGU", "AGC" }, 
				{ "UAU", "UAC" },
				{ "UGG" },
				{ "CAA", "CAG" },
				{ "AAU", "AAC" },
				{ "CAU", "CAC" },
				{ "GAA", "GAG" },
				{ "GAU", "GAC" },
				{ "AAA", "AAG" },
				{ "CGU", "CGC", "CGA", "CGG", "AGA", "AGG" },
				{ "UAA", "UAG", "UGA" }
		};
		
		String [] proteins = { "I", "L", "V", "F", "M", "C", "A",
				"G", "P", "T", "S", "Y", "W", "Q",
				"N", "H", "E", "D", "K", "R", "stop" };
		
		// iterate over each row of the matrix containing valid codons and compare each value to the codon passed in
		for (int row = 0; row < codons.length; row += 1) {
			
			for (int column = 0; column < codons[row].length; column += 1) {
				
				// if the codon is found in the matrix, return the protein at the corresponding row
				if (codons[row][column].equals(codon)) {
					return proteins[row];
				}
				else {
					continue;
				}
				
			}
			
		}
		
		// if a matching codon is not found in the matrix, return null
		return null;
		
	}
	
	/**
	 * This method returns the string representation of the RNA object
	 */
	public String toString() {
		
		// if the RNA object is valid and exists, return the sequence data field, otherwise, return null
		if ((this.validity) && (this.sequence.length() > 0)) {
			return this.sequence;
		}
		else {
			return null;
		}
		
	}
	
}
