package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
		renderGraphic.setColor(Color.black);
		renderGraphic.fillRect(x, y, 32, 32);
		
	}

	// Sets the collision bounding for the walls
	public Rectangle getColBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
