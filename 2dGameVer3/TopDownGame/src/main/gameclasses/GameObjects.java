package main.gameclasses;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.utils.ID;

/**
 * This (abstract) class describes the parameters of all the Game objects,
 * as well as the methods that are associated with them
 * 
 * @author Bobby B.
 * @version 1.0
 * @since 2019-08-07
 */
public abstract class GameObjects {
	
	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID objID;
	private SpriteSheet newSprite;
	
	/**
	 * This method is used to create sprites using the following parameters and methods
	 * 
	 * @param x
	 * @param y
	 * @param objID
	 * @param newSprite
	 */
	public GameObjects(int x, int y, ID objID, SpriteSheet newSprite) {
		this.x = x;
		this.y = y;
		this.objID = objID;
		this.newSprite = newSprite;
	}
	
	public abstract void tick();
	public abstract void render(Graphics renderGraphic);
	public abstract Rectangle getColBounds();

	public int getX() {
		return x;
	}

	public ID getObjID() {
		return objID;
	}

	public void setObjID(ID objID) {
		this.objID = objID;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	
}
