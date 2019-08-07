package main.gameclasses;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * This class manages the loading of images onto the window
 */
public class ImageLoader {
	
	private BufferedImage image;
	
	// Method used to get the image from its file path;
	// try-catch statement is to address a possible IOException error
	
	public BufferedImage loadImage (String path) {
		
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException imgError) {
			imgError.printStackTrace();
		}
		
		return image;
	}
	

}
