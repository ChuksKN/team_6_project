package main.gameclasses.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.gameclasses.ObjectHandler;
import main.gameclasses.Objects;
import main.gameclasses.Sprites;
import main.gameclasses.utils.ObjID;

public class Key2 extends Objects {
	
	private ObjectHandler objHandler;

	public Key2(int x, int y, ObjID objID, ObjectHandler objHandler, Sprites newSprite) {
		super(x, y, objID, newSprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	public void render(Graphics renderGraphic) {
		renderGraphic.setColor(Color.orange);
		renderGraphic.fillRect(x, y, 24, 24);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 24, 24);
	}

}
