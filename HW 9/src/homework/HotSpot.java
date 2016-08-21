package homework;

/**
 * This class represents an individual hot spot
 * 
 * @author Jeremy Muhia
 * @version 8 May 2016
 *
 */
public class HotSpot {
	
	// important details of the hot spot including which borough it's in, the longitude and latitude, if it's free,
	// and the distance from a specific zip code
	private String boro;
	private String free;
	private double latitude;
	private double longitude;
	private double distanceFromZip;
	
	/**
	 * This HotSpot constructor creates an object whose datafields are equal to the corresponding constructor arguments
	 * 
	 * @param boro This is the abbreviated representation of the borough where the HotSpot is located
	 * @param latitude This is the latitude coordinate of the HotSpot
	 * @param longitude This is the longitude coordinate of the HotSpot
	 * @param free This shows whether or not the HotSpot is freely available
	 */
	public HotSpot(String boro, String free, String latitude, String longitude) {
		this.boro = boro;
		this.free = free;
		this.latitude = Double.parseDouble(latitude);
		this.longitude = Double.parseDouble(longitude);
	}
	
	/**
	 * This method gets the borough location of the HotSpot
	 * @return The String representation of the HotSpot's borough location
	 */
	public String getBorough() {
		return this.boro;
	}
	
	/**
	 * This method gets the cost of use for the HotSpot
	 * @return The String representation of the HotSpot's cost to use
	 */
	public String getFreedom() {
		return this.free;
	}
	
	/**
	 * This method returns the longitudinal location of a HotSpot
	 * @return A double that is the longitude of a HotSpot
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * This method returns the latitudinal location of a HotSpot
	 * @return A double that is the longitude of a HotSpot
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * This method returns the distance from a ZipCode of a HotSpot
	 * @return A double that is the distance from a ZipCode of a HotSpot
	 */
	public double getDistanceFromHotSpot() {
		return this.distanceFromZip;
	}

	/**
	 * This method sets the distance from a ZipCode of a HotSpot
	 * @return A double that is the distance from a ZipCode of a HotSpot
	 */
	public void setDistanceFromHotSpot(String distanceFromZip) {
		this.distanceFromZip = Double.parseDouble(distanceFromZip);
	}
	
}
