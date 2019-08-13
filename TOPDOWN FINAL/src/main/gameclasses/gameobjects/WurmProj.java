package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

public class WurmProj extends Objects {

	private ObjectHandler objHandler;
	
	int bulVelY = 4;
	
	public WurmProj(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;

	}


	public void tick() {
		y += bulVelY;
		
		// Work on collision with wall
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if (tempObject.getObjID() == ObjID.Wall) {
				if (getColBounds().intersects(tempObject.getColBounds())){
					bulVelY = -4;
				}
			}
			else if (tempObject.getObjID() == ObjID.Wurm) {
				if (getColBounds().intersects(tempObject.getColBounds())){
					bulVelY = 4;
				}
			}
		}
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.setColor(Color.cyan);
		renderGraphic.fillRect(x+5, y+5, 14, 14);
	}

	public Rectangle getColBounds() {
		return new Rectangle(x+5, y+5, 14, 14);
	}


}
