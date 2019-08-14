package main.gameclasses.gameobjects.secitems;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameCore;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

public class Chalkboard extends Objects {
	
	public Chalkboard(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
	}

	@Override
	public void tick() {
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.drawImage(GameCore.chalkboard, x, y, null);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 85, 70);
	}

}