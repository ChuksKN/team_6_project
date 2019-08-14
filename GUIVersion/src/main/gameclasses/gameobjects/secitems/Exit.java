package main.gameclasses.gameobjects.secitems;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.GameCore;
import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

public class Exit extends Objects {

	@SuppressWarnings("unused")
	private ObjectHandler objHandler;

	public Exit(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
	}

	public void tick() {

	}

	public void render(Graphics renderGraphic) {
		renderGraphic.drawImage(GameCore.eSign, x, y, null);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 24, 24);
	}

}
