package homework;

import java.util.*;
import java.io.*;

public class FindHotSpots {

	public static void main(String[] args) {
		
		// create a file containing all the zip codes
		File fileOfZips = new File("NYCZipCodes.csv");
		
		// create an array of ZipCode objects
		ArrayList<ZipCode> zipCodes = new ArrayList<ZipCode>();
		
		// generate ZipCode objects to test with
		generateZipCodes(fileOfZips, zipCodes);
		
		// create a file containing all the hot spots
		File fileOfHotSpots = new File("NYCWi-FiHotspotLocations.csv");
		
		// create an array of HotSpot objects
		ArrayList<HotSpot> hotSpots = new ArrayList<HotSpot>();
		
		// generate HotSpot objects to test with
		generateHotSpots(fileOfHotSpots, hotSpots);
		
		// create a Scanner for the user to input zip codes for which to find nearby hot spots
		Scanner userInput = new Scanner(System.in);
		
		String userZipCode;
		
		String userAction;
		
		// do {
			// prompt the user for input
			System.out.print("Gimme a zip code so I can find wifi hot spots near it\n>");
			
			// count the iterations of do-while loops
			// int iterations = 0;
		
			userZipCode = userInput.next();
			
			System.out.print("Thanks for the zip code. Now, what do you want to do with the nearby hotspots? (D)isplay "
					+ "hot spots near a zip if you've already given one or (T)erminate the program\n>");
			
			userAction = userInput.next();
		
			// create a unique reference for the matching zip code
			ZipCode matchingZipCode = null;
		
			// loop through each item in the ArrayList of zip codes
			for (int item = 0; item < zipCodes.size(); item += 1) {
			
				// if you find a zip code matching the one specified by the user, assign it a unique a reference variable
				if (userZipCode.equals(zipCodes.get(item).getZipCallCode())) {
					matchingZipCode = zipCodes.get(item);
					break;
				}
			
			}
		
			// create an ArrayList of nearby hot spots
			ArrayList<HotSpot> nearbyHotSpots = new ArrayList<HotSpot>();
			
			// if a hot spot in the cumulative list of hot spots is within a certain distance of the zip code, add it
			// to an ArrayList of nearby hot spots
			for (int item = 0; item < hotSpots.size(); item += 1) {
				
				if (haversine(matchingZipCode.getLatitude(), matchingZipCode.getLongitude(), hotSpots.get(item).getLatitude(), hotSpots.get(item).getLongitude()) <= 2) {
					nearbyHotSpots.add(hotSpots.get(item));
				}
				
			}
			
		do {
			// if the user doesn't elect to terminate the program and there have been more than 1 iterations
			// display hot spots within 2 kilometers
			if (userAction.equalsIgnoreCase("d") /*&& iterations > 0*/) {
				System.out.println("Here are the hot spots within 2 kilometers of you: ");
				for (int item = 0; item < nearbyHotSpots.size(); item += 1) {
					System.out.println("Borough: " + nearbyHotSpots.get(item).getBorough()
							+ "\nFreeness: " + nearbyHotSpots.get(item).getFreedom()
							+ "\nLatitude and Longitude: " + nearbyHotSpots.get(item).getLatitude() + " " + nearbyHotSpots.get(item).getLongitude());
					
					System.out.println();
				}
			
				// prompt the user for input
				System.out.print("Gimme a zip code so I can find wifi hot spots near it\n>");
				
				userZipCode = userInput.next();
				
				System.out.print("Thanks for the zip code. Now, what do you want to do with the nearby hotspots? (D)isplay "
				+ "hot spots near a zip if you've already given one or (T)erminate the program\n>");
				
				userAction = userInput.next();
			
			}
			
		} while(!userZipCode.equalsIgnoreCase("t"));
			
		userInput.close();

	}
	
	
	
	
	/**
	 * This method creates an ArrayList of HotSpot objects
	 * 
	 * @param
	 * @param
	 */
	
	public static void generateHotSpots(File fileOfHotSpots, ArrayList<HotSpot> hotSpots) {
		// read the file containing the hot spots using a Scanner and if the file isn't found, throw an error
		try {
			
			Scanner allHotSpotsFile = new Scanner(fileOfHotSpots);
					
			// keep track of line count so that you can skip headers
			int lineCount = 0;
					
			// continue looping while the file has 
			while (allHotSpotsFile.hasNextLine()) {
						
				// read each line in the file containing hot spots and create a new HotSpot object for each line
				if (lineCount > 0) {
					ArrayList<String> nextHotSpotSplit = split(allHotSpotsFile.nextLine());
							
					hotSpots.add(new HotSpot(nextHotSpotSplit.get(1), nextHotSpotSplit.get(2), nextHotSpotSplit.get(6), nextHotSpotSplit.get(7)));
				}
				// go to the next line after the header
				else {
					allHotSpotsFile.nextLine();
				}
						
				lineCount += 1;
						
			}
					
			allHotSpotsFile.close();
					
		}
		catch (FileNotFoundException ex) {			
			// send a message showing what error occurred
			System.out.println("File wasn't found");
		}
		
	}
	
	
	
	
	/**
	 * This method creates an ArrayList of ZipCode objects
	 * 
	 * @param fileOfZips This File type contains details of zip codes
	 * @param zipCodes An ArrayList of valid ZipCode objects
	 */
	
	public static void generateZipCodes(File fileOfZips, ArrayList<ZipCode> zipCodes) {
		
		// create a scanner object to read the file and if the file isn't found, throw an error
		try {
					
			Scanner allZipCodesFile = new Scanner(fileOfZips);
					
			// keep track of the line in the file so that you can skip the header
			int lineCount = 0;
					
			// continues to loop while there is another line to be read from the file
			while (allZipCodesFile.hasNextLine()) {
						
				// read each line in the file containing zip codes and create a new ZipCode that is appended to the ArrayList
				if (lineCount > 0) {				
					ArrayList<String> nextZipCodeSplit = split(allZipCodesFile.nextLine());
						
					zipCodes.add(new ZipCode(nextZipCodeSplit.get(0), nextZipCodeSplit.get(1), nextZipCodeSplit.get(2)));
				}
				// go to the next line after the header
				else {
					allZipCodesFile.nextLine();
				}
						
				lineCount += 1;
						
			}
					
			allZipCodesFile.close();
					
		}
		catch (FileNotFoundException ex) {
			// send a message showing what error occured
			System.out.println("File wasn't found");
		}
		
	}
	
	
	
	
	
	
	/**
	 * This method overrides the existing split method and accounts for commas within specific cells
	 * 
	 * @param textLine This is the line represented as a String to be split with commas as a delimiter
	 * @return This is an ArrayList with each comma separated value in the line as its own element
	 */
	
	public static ArrayList<String> split (String textLine) {
		
		// this is the ArrayList of comma separated values in each line
		ArrayList<String> entries = new ArrayList<String>();
		// this is the length of the line including delimiters
		int lineLength = textLine.length();
		// this is the value to be added to the ArrayList of comma separated values
		StringBuffer nextWord = new StringBuffer();
		// this is the value of the character being checked for its status as a delimiter
		char nextChar;
		// this checks if the character is in a string surrounded by quotations
		boolean insideQuotes = false;
		
		// loop through each character and keep it or use it as a delimiter
		for(int i = 0; i < lineLength; i++ ) {
			
			nextChar = textLine.charAt(i);
			
			// add character to the current entry
			if ((nextChar != ',')&&(nextChar != '"')) {
				nextWord.append(nextChar);
			}
	
			// double quote found, decide if it is opening or closing one
			else if (nextChar == '"' ) {
				if (insideQuotes) {
					insideQuotes = false;
				}
				else {
					insideQuotes = true;
				}
			}
			
			// found comma inside double quotes, just add it to the string
			else if ((nextChar == ',')&&(insideQuotes)) {
				nextWord.append(nextChar);
			}
	
			// end of the current entry reached, add it to the list of entries
			// and reset the nextWord to empty string
			else if ((nextChar == ',')&&(!insideQuotes)) {
				//trim the white space before adding to the list
				entries.add(nextWord.toString().trim());
				nextWord = new StringBuffer();
			}
	
			else {
				System.err.println("This should never be printed.\n");
			}
			
		}
		
		// add the last word
		// trim the white space before adding to the list
		entries.add(nextWord.toString().trim());
		return entries;
		
	}
	
	
	
	
	
	/**
	 * This method calculates the distance between two coordinates given in longitude and latitude
	 * 
	 * @param lat1 The latitude of the first point
	 * @param lon1 The longitude of the first point
	 * @param lat2 The latitude of the second point
	 * @param lon2 The longitude of the second point
	 * @return A double representing the distance in kilometers between the two coordinates
	 */
	public static double haversine(double lat1, double lon1, double lat2, double lon2) {
		
		final double R = 6372.8; // in kilometers
		
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		
		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		
		return R * c;
		
	}

}
