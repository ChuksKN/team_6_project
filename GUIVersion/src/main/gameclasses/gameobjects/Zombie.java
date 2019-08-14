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
 * This is the Zombie (Enemy Type)
 * 
 * This enemy moves within a certain range
 *
 */
public class Zombie extends Objects {
	
	private ObjectHandler objHandler;
	Random moveDir = new Random();
	
	int maxSpeed = 1;
	
	public Zombie(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		int nextDir = moveDir.nextInt(20);
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if (tempObject.getObjID() == ObjID.Wall || tempObject.getObjID() == ObjID.innerWall || tempObject.getObjID() == ObjID.leftWall || tempObject.getObjID() == ObjID.rightWall || tempObject.getObjID() == ObjID.Desk || tempObject.getObjID() == ObjID.Chalkboard) {
				if (getColBounds().intersects(tempObject.getColBounds())){
					x += (velX * 5) * -1;
					y += (velY * 5) * -1;
					velX *= -1;
					velY *= -1;
				}
				else if (nextDir == 0) {
					velX = (moveDir.nextInt(2*maxSpeed+1) - maxSpeed);
					velY = (moveDir.nextInt(2*maxSpeed+1) - maxSpeed);
				}
			}
		}
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.drawImage(GameCore.zombie, x, y, null);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 45, 45);
	}
}
