package main.gameclasses.gameobjects;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.gameclasses.Objects;
import main.gameclasses.GameCore;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Sprites;
import main.gameclasses.utils.GameSTATE;
import main.gameclasses.utils.ObjID;

/**
 * This is the player class; all player characteristics are handled within this class
 * 
 * Such as:
 * 		Player movement
 * 		Collision detection
 * 		Rendering
 * 
 */
public class PlayerChar extends Objects{
	
	private int movementSpeed = 6;
	public static int healthStatus = 100;
	
	ObjectHandler objHandler;
	
	private BufferedImage player_sprite;

	
	public PlayerChar(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;
		
		player_sprite = newSprite.grabCharSprite(3, 1, 15, 19);
	}
	
	public void tick() {
		
		detCollision();
		y += velY;
		x += velX;
		
		// this handles movement up
		if (objHandler.isUp()) {
			velY = -movementSpeed;
		} else if (!objHandler.isDown()) {
			velY = 0;
		}
		
		//this handles movement down
		if (objHandler.isDown()) {
			velY = movementSpeed;
		} else if (!objHandler.isUp()) {
			velY = 0;
		}
		
		//this handles movement left
		if (objHandler.isLeft()) {
			velX = -movementSpeed;
		} else if (!objHandler.isRight()) {
			velX = 0;
		}
		
		//this handles movement right
		if (objHandler.isRight()) {
			velX = movementSpeed;
		} else if (!objHandler.isLeft()) {
			velX = 0;
		}
	}
	
	public void render (Graphics renderGraphic) {
		// Rendering test for the player
		renderGraphic.drawImage(player_sprite, x, y, null);
		
	}
	
	public Rectangle getColBounds() {
		return new Rectangle(x, y, 16, 20);
	}
	
	// Boolean method used to determine if the players path is free (returns true) or not (returns false)
	public boolean pathFree (int x, int y, Rectangle playerRect, Rectangle otherRect) {
		playerRect.x = x;
		playerRect.y = y;
		
		if(playerRect.intersects(otherRect)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// Method to allow the player to detect collision with certain objects
	public void detCollision() {
		for(int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			// Collision detection for walls
			if (tempObject.getObjID() == ObjID.Wall) {
				if (!pathFree((int)(x + velX), y, getColBounds(), tempObject.getColBounds())) {
					x = (int) (x - velX);
				}
				else if (!pathFree(x,(int)(y + velY), getColBounds(), tempObject.getColBounds())) {
					velY = 0;
				}
			}
			
			// Collision detection for chests
			if (tempObject.getObjID() == ObjID.Desk || tempObject.getObjID() == ObjID.Chalkboard || tempObject.getObjID() == ObjID.Wurm) {
				if (!pathFree((int)(x + velX), y, getColBounds(), tempObject.getColBounds())) {
					x = (int) (x - velX);
				}
				else if (!pathFree(x,(int)(y + velY), getColBounds(), tempObject.getColBounds())) {
					velY = 0;
				}
			}
			
			// Picking up the Key items
			if (tempObject.getObjID() == ObjID.Key1 || tempObject.getObjID() == ObjID.Key2 || tempObject.getObjID() == ObjID.Key3) {
				if (!pathFree((int)(x + velX), y, getColBounds(), tempObject.getColBounds())) {
					GameCore.KEYSCOL ++;
					objHandler.removeObject(tempObject);
				}
			}
			
			// Player collision with Zombie, Demon and enemy types
			if (tempObject.getObjID() == ObjID.Zombie || tempObject.getObjID() == ObjID.Demon) {
				if (getColBounds().intersects(tempObject.getColBounds())) {
					if (healthStatus > 0) {
						healthStatus --;
					}
					if (healthStatus == 0) {
						GameCore.curState = GameSTATE.GameOver;
					}
				}
			}
			
			// Player collsion with Wurm projectile
			if (tempObject.getObjID() == ObjID.WurmProj) {
				if (getColBounds().intersects(tempObject.getColBounds())) {
					healthStatus --;
				}
			}
			
			// Win condition
			if (tempObject.getObjID() == ObjID.Exit) {
				if (getColBounds().intersects(tempObject.getColBounds())) {
					if (GameCore.KEYSCOL == 3) {
						GameCore.curState = GameSTATE.GameWin;
					}
				}
			}
			
		}
	}
}

