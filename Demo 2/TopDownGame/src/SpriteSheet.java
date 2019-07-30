import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sprites;
	
	public SpriteSheet(BufferedImage sprites) {
		this.sprites = sprites;
	}
	
	public BufferedImage grabSprite(int col, int row, int width, int height) {
		return sprites.getSubimage((col*320)-320, (row*320)-320, width, height);
	}

}
