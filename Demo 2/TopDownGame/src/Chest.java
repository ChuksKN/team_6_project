import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
