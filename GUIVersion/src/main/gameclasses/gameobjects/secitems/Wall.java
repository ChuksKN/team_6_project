package main.gameclasses.gameobjects.secitems;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameCore;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

/**
 * This is the Wall (boundary) class
 */
public class Wall extends Objects {
	
	
	public Wall(int x, int y, ObjID objId, Sprites newSprite) {
		super(x, y, objId, newSprite);
	}

	public void tick() {
		
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.drawImage(GameCore.wallOne, x, y, null);
		
	}

	// Sets the collision bounding for the walls
	public Rectangle getColBounds() {
		return new Rectangle(x, y, 30, 20);
	}

}
