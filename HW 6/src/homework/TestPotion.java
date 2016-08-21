package homework;

/**
 * This class is created to test the Potion and Bucket classes that it references within its body
 * 
 * @author Jeremy Muhia
 * 
 * @version 1 April 2016
 *
 */
public class TestPotion {

	public static void main(String[] args)
	{
		// create a Potion object
		Potion potionOne = new Potion(5);
		
		// create a Bucket object
		Bucket bucketOne = new Bucket();
		
		// items to mix
		String itemsToMix = "brcaxpaxdqaqdrrdtpaxxdbapprbbpqaqaqqpacbxcaaprrardawpaccrxpabqqqqwcpqpxdawrpbadddddqppcaccbxdpbbpxwqqrcrbarraqqxpabrrbcrqpbbcxbbprqacbxbwaccpbrqadxpqdwrqawwdrcpwcqpqawpabrcqqxdabpbbbcppwpbxbdbbrbbcwaxrqxqcqdqpapwdcdadawxaxprrdxaqpbcpqcpdqbpwwwcxdwcardcxcbcxxwwaqrcdxpwpdpaqrabwqddqqdqqpbarqqdqqcaddwwabdabraxxpabqxrabrxdqqcaxaaxxaxqqbrcrracxwdqxxxwxbwdcwcpxrrrddcdxxdbwrwxppcpxcrxdxqrcqpawppcdqppbxbqbqawqwqcpcqapcwwawbrpqbpqcqxrrcarpbqqqacxadbararrxaawpqqacqprccrdqpraawcaabrqqrqqwbwdwqqdaqcqdqparbb";
		
		// iterate over all items
		for (int element = 0; element < itemsToMix.length(); element++) {
			
			// if the item is a valid ingredient add it to the potion, then check if the potion is full
			if ((itemsToMix.charAt(element) == 'a')||(itemsToMix.charAt(element) == 'b')||(itemsToMix.charAt(element) == 'c')||(itemsToMix.charAt(element) == 'd')||(itemsToMix.charAt(element) == 'w')) {
				
				potionOne.addIngredient(itemsToMix.charAt(element));
				
				// if the potion is full after adding the ingredient, heat the potion
				if (potionOne.isFull()) {
				
					// if the heating works, the potion is complete and the program is done
					// otherwise, discard the potion in the bucket
					if (potionOne.heatPotion()) {
						
						break;
						
					}
					else {
						
						potionOne.discardPotion(bucketOne);
						
					}
				
				}
				
			}
			// if the item isn't a valid ingredient, add the item to the bucket
			else {
				
				bucketOne.dumpIngredient(itemsToMix.charAt(element));
				
			}
			
		}
		
		// output
		System.out.println("Potion #1: " + potionOne.toString() );
		System.out.println("Bucket #1: " + bucketOne.toString() );
	}
	
}
