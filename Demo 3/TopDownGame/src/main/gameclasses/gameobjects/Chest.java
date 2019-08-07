package main.gameclasses.gameobjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameObjects;
import main.gameclasses.ObjectHandler;
import main.gameclasses.SpriteSheet;
import main.gameclasses.utils.ID;

/*
 * This is the Chest item class; Chests are iteractable objects
 */
public class Chest extends GameObjects{
	
	private ObjectHandler objHandler;

	public Chest(int x, int y, ID objID, ObjectHandler objHandler, SpriteSheet newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;
	}

	public void tick() {
		
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.setColor(Color.orange);
		renderGraphic.fillRect(x, y, 24, 24);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 24, 24);
	}

}
