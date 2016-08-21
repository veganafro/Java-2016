package homework;

/**
 * This class represents an individual zip code
 * 
 * @author Jeremy Muhia
 * @version 8 May 2016
 *
 */
public class ZipCode {

	// important details of the zip code including it's string representation and longitude and latitude
	private String callCode;
	private double latitude;
	private double longitude;
	
	/**
	 * This ZipCode constructor creates an object whose datafields are equal to the corresponding constructor arguments
	 * 
	 * @param callCode This is the 5 digit representation of the zip code
	 * @param latitude This is the longitude coordinate of the zip code
	 * @param longitude This is the latitude coordinate of the zip code
	 */
	public ZipCode(String callCode, String latitude, String longitude) {
		this.callCode = callCode;
		this.latitude = Double.parseDouble(latitude);
		this.longitude = Double.parseDouble(longitude);
	}
	
	/**
	 * This method returns the string representation of a zip code
	 * @return A string that is the 5 digit call code for a zip code
	 */
	public String getZipCallCode() {
		return this.callCode;
	}
	
	/**
	 * This method returns the longitudinal location of a zip code
	 * @return A double that is the longitude of a zip code
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * This method returns the latitudinal location of a zip code
	 * @return A double that is the latitude of a zip code
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
}
