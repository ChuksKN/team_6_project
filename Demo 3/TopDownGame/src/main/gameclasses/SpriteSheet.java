package main.gameclasses;
import java.awt.image.BufferedImage;

/*
 * This class manages the process of grabbing specific Sprites from their sprite sheets
 */
public class SpriteSheet {
	
	private BufferedImage spriteImg;
	
	public SpriteSheet(BufferedImage sprites) {
		this.spriteImg = sprites;
	}
	
	// Method that grabs the character sprite images
	public BufferedImage grabCharSprite(int col, int row, int width, int height) {
		int posCol = (col*19)-19;
		int posRow = (row*15)-15;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	// Method that grabs the floor/tile sprites images
	public BufferedImage grabFloorSprite(int col, int row, int width, int height) {
		int posCol = (col*32)-32;
		int posRow = (row*32)-32;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}

}
