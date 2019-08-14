package main.gameclasses.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameCore;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

/**
 * This is the Wurm (Enemy Type)
 * 
 * This enemy tracks simulates firing a projectile (WurmProj)
 *
 */
public class Wurm extends Objects {
	
	@SuppressWarnings("unused")
	private ObjectHandler objHandler;

	public Wurm(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
	}

	public void tick() {
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.drawImage(GameCore.wurm, x, y, null);
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 24, 24);
	}

}
