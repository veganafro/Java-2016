package homework;

import processing.core.PApplet;

public class ProcessingTest extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1336925182255935898L;

	public void setup() {
		size(500,500);
	}
	
	public void draw() {
		ellipse(random(0,500), random(0,500), 10, 10);
	}
}
