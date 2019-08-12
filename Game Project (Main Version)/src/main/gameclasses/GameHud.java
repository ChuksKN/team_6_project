package main.gameclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameHud {
	
	private BufferedImage heartSprite = null;
	
	public void render (Graphics renderGraphic) {
		
		ImageLoader hudLoader = new ImageLoader();
		
		int imgX = 32;
		int imgY = 27;
		
		heartSprite = hudLoader.loadImage("/pix_hearttweak.png");
		
		renderGraphic.drawImage(heartSprite, 5, 5, imgX, imgY, null);
		renderGraphic.drawImage(heartSprite, 69, 5, imgX, imgY, null);
		renderGraphic.drawImage(heartSprite, 133, 5, imgX, imgY, null);
		
	}

}
