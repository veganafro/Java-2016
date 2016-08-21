package homework;

import processing.core.PApplet;

/**
 * This class is a game I've created
 * @author Jeremy Muhia
 * @version 28 April
 */
public class MyGame extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8467760229977708623L;
	//the car
	private Car myCar;
	//the lines on the road
	private DashedLines myLines;
	//the trees
	private Trees myTreesLeft1;
	private Trees myTreesRight1;
	//the obstacles
	private Obstacles myObstaclesLeft1;
	private Obstacles myObstaclesRight1;

	// runs one time
	public void setup() {
		// size the canvas
		size(600, 600);
		
		// create the objects
		this.myCar = new Car(this);
		this.myLines = new DashedLines(this);
		this.myTreesLeft1 = new Trees(this, (float) random(40, 140));
		this.myTreesRight1 = new Trees(this, (float) random(440, 540));
		this.myObstaclesLeft1 = new Obstacles(this, 255);
		this.myObstaclesRight1 = new Obstacles(this, 345);
		
		frameRate(60);

	}
	//create speeds for the objects and locations to start drawing them
	public float lineStartLocation = (float) -height;
	public float lineSpeed = 2;
	
	public float treeStartLocation = 0;
	public float treeSpeed = 2;
	
	public float obstacleStartLocation = -random(30, 40);
	public float obstacleSpeed = 2;
	
	// infinite loop
	public void draw() {
		background(230, 255, 179);
		
		noStroke();
		//draw the rode
		fill(153, 153, 153);
		rect(200, 0, 200, height);
		//draw the car
		fill(0, 0, 0);
		myCar.drawCar(myCar.getX());
		//draw the lines
		fill(255, 255, 0);
		myLines.drawDashedLines(lineStartLocation);
		//draw the trees
		fill(0, 153, 0);
		myTreesLeft1.drawTrees(treeStartLocation);
		myTreesRight1.drawTrees(treeStartLocation);
		//track the seconds and draw the obstacles every 15, 3, or 4 seconds on the left and right otherwise
		int seconds = second();
			
		fill(255, 102, 102);
		
		if ((seconds % 15 == 0)||(seconds % 3 == 0)||(seconds % 4 == 0)) {
			myObstaclesLeft1.drawObstacles(obstacleStartLocation);
		}
		else {
			myObstaclesRight1.drawObstacles(obstacleStartLocation);
		}
		
		//check if the car and the obstacles have collided and end the game if they have
		if ((myCar.getY() - obstacleStartLocation <= 20)&&((myObstaclesLeft1.getX() - myCar.getX() < 40)/*||(myObstaclesRight1.getX() - myCar.getX() < 40)*/)) {
			noLoop();
			text("YOU LOSE!", 300, 300);
		}
		else if ((myCar.getY() - obstacleStartLocation <= 20)&&(myObstaclesRight1.getX() - myCar.getX() < 40)) {
			noLoop();
			text("YOU LOSE!", 300, 300);
		}
		
		//change the location of the objects on the screen to create the illusion of motion
		//reset location if they move off the screen
		lineStartLocation += lineSpeed;
		
		if (lineStartLocation > -height/2) {
			lineStartLocation = -height;
		}
		
		treeStartLocation += treeSpeed;
		
		if (treeStartLocation > height) {
			treeStartLocation = 0;
		}
		
		obstacleStartLocation += obstacleSpeed;
		
		if (obstacleStartLocation > height) {
			obstacleStartLocation = 0;
		}
		
	}
	/**
	 * This method checks if the user presses the up or down button to increase speed or the left or right buttons
	 * to change the position of the car on the road
	 */
	public void keyPressed() {
		
		if (key == CODED) {
			//if the user presses left or right, change the cars location
			if (keyCode == LEFT) {
				fill(0, 0, 0);
				myCar.drawCar(myCar.moveLeft());
			}
			else if (keyCode == RIGHT) {
				fill(0, 0, 0);
				myCar.drawCar(myCar.moveRight());
			}
			//if the user presses up or down, change the speed
			else if (keyCode == UP) {
				if ((lineSpeed < 10)&&(treeSpeed < 10)&&(obstacleSpeed < 10)) {
					lineSpeed += 1;
					treeSpeed += 1;
					obstacleSpeed += 1;
				}
			}
			else if (keyCode == DOWN) {
				if ((lineSpeed > 0)&&(treeSpeed > 0)&&(obstacleSpeed > 0)) {
					lineSpeed -= 1;
					treeSpeed -= 1;
					obstacleSpeed -= 1;
				}
				if ((lineSpeed == 0)&&(treeSpeed == 0)&&(obstacleSpeed == 0)) {
					lineSpeed += 1;
					treeSpeed += 1;
					obstacleSpeed += 1;
				}
			}
		}
		
	}
	/**
	 * This method accounts for when the user lets go of the key
	 */
	public void keyReleased() {
		//when the user lets go of the left or right key, keep the car where it is
		fill(0, 0, 0);
		myCar.drawCar(myCar.getX());
		
	}

}

/**
 * This class animates the car
 * @author Jeremy Muhia
 *
 */
class Car {
	//the x and y locations of the car
	private int x = 215;
	private int y = 300;
	
	PApplet canvas;
	// the default constructor
	public Car(PApplet canvas) {
		this.canvas = canvas;
	}
	/**
	 * this method draws the car on the correct side of the road
	 * @param x the x coordinate of the car
	 */
	public void drawCar(int x) {
		//draw the car on the correct side of the road
		canvas.rect(x, this.y, 80, 50);
	}
	
	/**
	 * This method draws the car on the right
	 * @return an int representing the x coordinate of the car
	 */
	public int moveRight() {
		// only change the location if it's not already on the right
		if (this.x == 215) {
			this.x = 305;
			return 305;
		}
		else {
			return this.x;
		}
		
	}
	
	/**
	 * this method draws the car on the left
	 * @return an int representing the y coordinate of the car
	 */
	public int moveLeft() {
		//only change the location if it's not already on the left
		if (this.x == 305) {
			this.x = 215;
			return 215;
		}
		else {
			return this.x;
		}
		
	}
	/**
	 * this is a getter method for the car's x coordinate
	 * @return an int that shows where the car is
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * this is a getter method for the car's y coordinate
	 * @return an int that shows where the car is
	 */
	public int getY() {
		return this.y;
	}
	
}

/**
 * this class defines the dashed lines on the road
 * @author Jeremy Muhia
 *
 */
class DashedLines {
	
	PApplet canvas;
	
	public DashedLines(PApplet canvas) {
		this.canvas = canvas;
	}
	
	public void drawDashedLines(float y) {
		for (int lineCoordinate = 0; lineCoordinate <= canvas.height * 3; lineCoordinate++) {
			
			if (lineCoordinate % 20 == 0) {
				canvas.rect((float) 297.5, (float) lineCoordinate + y, (float) 5, (float) 15);
			}
			
		}
	}
	
}
/**
 * this class defines the trees on the side
 * @author JeremyM80
 *
 */
class Trees {
	
	private float x1;
	
	PApplet canvas;
	
	public Trees(PApplet canvas, float x) {
		this.canvas = canvas;
		this.x1 = x;
	}
	
	public void drawTrees(float y) {
		canvas.ellipse(this.x1,  y, 80, 80);
	}
	
}
/**
 * this class defines the obstacles on the road
 * @author JeremyM80
 *
 */
class Obstacles {

	private float x1;
	
	PApplet canvas;
	
	public Obstacles(PApplet canvas, float x) {
		this.canvas = canvas;
		this.x1 = x;
	}
	
	public void drawObstacles(float y) {
		canvas.ellipse(x1, y, 40, 40);
	}
	
	public float getX() {
		return this.x1;
	}
	
}