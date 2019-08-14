package main.gameclasses.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.gameclasses.GameCore;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

/**
 * This is the Demon (Enemy Type)
 * 
 * This enemy tracks the player when within a certain range
 *
 */
public class Demon extends Objects {
	
	private ObjectHandler objHandler;

	Random moveDir = new Random();
	private float enemySight, dX, dY;
	
	int demW = 20;
	int demH = 20;
	
	public Demon(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;

	}


	public void tick() {
		x += velX;
		y += velY;
		
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if (tempObject.getObjID() == ObjID.Wall || tempObject.getObjID() == ObjID.innerWall || tempObject.getObjID() == ObjID.leftWall || tempObject.getObjID() == ObjID.rightWall || tempObject.getObjID() == ObjID.Desk || tempObject.getObjID() == ObjID.Chalkboard) {
				if (getColBounds().intersects(tempObject.getColBounds())){
					x += (velX * 5) * -1;
					y += (velY * 5) * -1;
					velX *= -1;
					velY *= -1;
				}
			}
			else if (tempObject.getObjID() == ObjID.Player) {
				dX = x - tempObject.getX() - demW;
				dY = y - tempObject.getY() - demH;
				enemySight = (float) Math.sqrt((x - tempObject.getX()) * (x - tempObject.getX()) + (y - tempObject.getY()) * (y - tempObject.getY()));
				
				if (enemySight < 220) {
					velX = ((-2 / enemySight) * dX);
					velY = ((-2 / enemySight) * dY);
				}
				else {
					velX = 0;
					velY = 0;
				}
			}
		}
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.drawImage(GameCore.demon, x, y, null);
	}

	public Rectangle getColBounds() {
		return new Rectangle(x-10, y-10, 38, 38);
	}
	

}
