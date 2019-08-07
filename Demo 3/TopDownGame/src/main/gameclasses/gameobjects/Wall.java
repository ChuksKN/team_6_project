package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameObjects;
import main.gameclasses.SpriteSheet;
import main.gameclasses.utils.ID;

/*
 * This is the Wall (boundary) class
 */
public class Wall extends GameObjects {
	
	public Wall(int x, int y, ID objId, SpriteSheet newSprite) {
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
