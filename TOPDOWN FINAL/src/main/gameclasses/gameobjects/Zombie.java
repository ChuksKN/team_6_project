package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

public class Zombie extends Objects {
	
	private ObjectHandler objHandler;
	Random moveDir = new Random();
	private float enemySight, dX, dY;
	
	int maxSpeed = 1;
	
	public Zombie(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		int nextDir = moveDir.nextInt(20);
		
		// Work on zombie collision with wall
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if (tempObject.getObjID() == ObjID.Wall) {
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
		renderGraphic.setColor(Color.green);
		renderGraphic.fillRect(x, y, 20, 20);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 40, 40);
	}
}
