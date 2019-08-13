package main.gameclasses;
import java.awt.Graphics;
import java.util.ArrayList;

import main.gameclasses.gameobjects.WurmProj;


/**
 * This class loops through the game and updates all game objects
 * as the game runs using the tick method
 * 
 * @author Chuks N.
 * @version 1.0
 * @since 2019-08-07
 */
public class ObjectHandler {

	public ArrayList<Objects> object = new ArrayList<Objects>();
	
	private boolean up = false, down = false, right = false, left = false;
	
	/**
	 * Method to update game frame by frame as it progresses
	 * @return Nothing
	 */
	public void tick() {
		for (int objectIterate = 0; objectIterate < object.size(); objectIterate++) {
			Objects tempObject = object.get(objectIterate);
			
			tempObject.tick();
		}
		
	}
	
	/**
	 * Method that renders game objects onto the game window
	 * @param renderGraphic
	 * @return Nothing
	 */
	public void render(Graphics renderGraphic) {
		for (int objectIterate = 0; objectIterate < object.size(); objectIterate++) {
			Objects tempObject = object.get(objectIterate);
			
			tempObject.render(renderGraphic);
		}
		
	}
	

	/**
	 * addObject and removeObject, respectively, add the game objects onto the window scene
	 * and removes them when necessary
	 * 
	 * @param tempObject
	 * @return Nothing
	 */
	public void addObject(Objects tempObject) {
		object.add(tempObject);
	}
	
	/**
	 * See above
	 * 
	 * @param tempObject
	 * @return Nothing
	 */
	public void removeObject(Objects tempObject) {
		object.remove(tempObject);
	}
	
	/**
	 * Boolean statements to check player movement
	 * as well as their respective getters and setters
	 * 
	 * @return boolean
	 */
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

}
