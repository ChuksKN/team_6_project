package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

public class Demon extends Objects {
	
	private ObjectHandler objHandler;

	Random moveDir = new Random();
	private float enemySight, dX, dY;
	
	int demW = 12;
	int demH = 20;
	
	public Demon(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;

	}


	public void tick() {
		x += velX;
		y += velY;
		
		int nextDir = moveDir.nextInt(10);
		
		// Work on collision with wall
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if (tempObject.getObjID() == ObjID.Wall || tempObject.getObjID() == ObjID.Desk) {
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
		renderGraphic.setColor(Color.red);
		renderGraphic.fillRect(x, y, 20, 20);
	}

	public Rectangle getColBounds() {
		return new Rectangle(x-10, y-10, 40, 40);
	}
	

}
