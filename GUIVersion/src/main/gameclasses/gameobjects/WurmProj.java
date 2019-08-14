package main.gameclasses.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameCore;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

/**
 * This is the "projectile" that is fired by the Wurm enemy type
 * 
 *
 */
public class WurmProj extends Objects {

	private ObjectHandler objHandler;
	
	int bulVelY = 4;
	
	public WurmProj(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;

	}


	public void tick() {
		y += bulVelY;
		
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
		renderGraphic.drawImage(GameCore.wurmProj, x+10, y+10, null);
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 8, 8);
	}


}
