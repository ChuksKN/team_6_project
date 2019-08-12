package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.Objects;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

/**
 * This is the Chest item class; Chests are iteractable objects
 */
public class Chest extends Objects{
	
	private ObjectHandler objHandler;

	public Chest(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;
	}

	public void tick() {
		
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.setColor(Color.pink);
		renderGraphic.fillRect(x, y, 24, 24);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 24, 24);
	}

}
