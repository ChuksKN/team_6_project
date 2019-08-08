import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObjects {
	
	public Block(int x, int y, ID objId) {
		super(x, y, objId);
	}

	public void tick() {
		
	}

	public void render(Graphics renderGraphic) {
		renderGraphic.setColor(Color.black);
		renderGraphic.fillRect(x, y, 32, 32);
		
	}

	public Rectangle getColBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
