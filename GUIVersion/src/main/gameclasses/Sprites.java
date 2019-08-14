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
		int posCol = (col*40)-40;
		int posRow = (row*40)-40;
		
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
	
	public BufferedImage grabDeskSprite (int col, int row, int width, int height) {
		int posCol = (col*63)-63;
		int posRow = (row*62)-62;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabZombSprite (int col, int row, int width, int height) {
		int posCol = (col*96)-96;
		int posRow = (row*96)-96;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabDemSprite (int col, int row, int width, int height) {
		int posCol = (col*96)-96;
		int posRow = (row*96)-96;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabWurmSprite (int col, int row, int width, int height) {
		int posCol = (col*14)-14;
		int posRow = (row*20)-20;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabWurmPSprite (int col, int row, int width, int height) {
		int posCol = (col*34)-34;
		int posRow = (row*34)-34;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabCBoardSprite (int col, int row, int width, int height) {
		int posCol = (col*100)-100;
		int posRow = (row*100)-100;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabAllWallSprite(int col, int row, int width, int height) {
		int posCol = (col*32)-32;
		int posRow = (row*32)-32;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabKeySprite(int col, int row, int width, int height) {
		int posCol = (col*32)-32;
		int posRow = (row*32)-32;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}
	
	public BufferedImage grabSignSprite(int col, int row, int width, int height) {
		int posCol = (col*90)-90;
		int posRow = (row*90)-90;
		
		return spriteImg.getSubimage(posCol, posRow, width, height);
	}

}
