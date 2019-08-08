package main.gameclasses;
import java.awt.image.BufferedImage;

/*
 * This class manages the process of grabbing specific Sprites from their sprite sheets
 */
public class Sprites {
	
	private BufferedImage spriteImg;
	/**
	 * 
	 * @param sprites (from the Sprite sheet)
	 */
	public Sprites(BufferedImage sprites) {
		this.spriteImg = sprites;
	}
	
	/**
	 * Method that grabs the character sprite images
	 * 
	 * @param col - This is the column the sprite's located at
	 * @param row - This is the row the sprite's located at
	 * @param width - This is the width
	 * @param height - This is the height
	 * @return spriteImag.getSubimage(posCol, posRow, width, height);
	 */
	
	public BufferedImage grabCharSprite(int col, int row, int width, int height) {
		int posCol = (col*19)-19;
		int posRow = (row*15)-15;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	
	/**
	 * Method that grabs the floor/tile sprites images
	 * 
	 * @param col - This is the column the sprite's located at
	 * @param row - This is the row the sprite's located at
	 * @param width - This is the width
	 * @param height - This is the height
	 * @return spriteImg.getSubimage(posCol, posRow, width, height);
	 */
	public BufferedImage grabFloorSprite(int col, int row, int width, int height) {
		int posCol = (col*32)-32;
		int posRow = (row*32)-32;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}

}
