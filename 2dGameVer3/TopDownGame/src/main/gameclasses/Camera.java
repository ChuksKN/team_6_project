package main.gameclasses;
/**
 * This class functions as the camera; it locks on the player and tracks their movement
 * 
 * @author Chuks N.
 * @version 1.0
 * @since 2019-08-07
 */
public class Camera {
	 /**
	  * This class is to make use of the camera, as the window is limited to what can be displayed
	  * 
	  * @param float x This is the x coordinate
	  * @param float y This is the y coordinate
	  */
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Using the tick method the camera is updated as the game progresses
	 * This focuses the camera on the player and updates it as it moves
	 * 
	 * @param camObject
	 * @return Nothing
	 */
	public void tick(GameObjects camObject) {
		
		x += ((camObject.getX() - x) - 1000/2) * 0.05f;
		y += ((camObject.getY() - y) - (1000 * 3/4)/2) * 0.05f;
		
		// Bounds for how far the camera goes in relation to map border; camera stops when map border is reached
		if (x <= 0) x = 0;
		if (x >= 1050) x = 1050;
		if (y <= 0) y = 0;
		if (y >= 500) y = 500;
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
