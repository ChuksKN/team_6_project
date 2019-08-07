package main.gameclasses;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import main.gameclasses.gameobjects.Chest;
import main.gameclasses.gameobjects.Player;
import main.gameclasses.gameobjects.Wall;
import main.gameclasses.utils.GameState;
import main.gameclasses.utils.ID;

/**
 * Credit for Code referencing - Author: Zack Berenger
 * 								 Web address: https://www.codingmadesimple.com/about/
 * 		
 * This class serves as the core game engine
 * 
 * Functionality:
 * 		Determines the window dimensions
 * 		Controls the game's start and stop parameters
 * 		Initializes the game loop engine that updates the game as it is ran and played
 * 
 * @author Chuks N.
 * @version 1.0
 * @since 2019-08-07
 */

public class GameCore extends Canvas implements Runnable {
	
	// Width and Title variables are not private to allow access by the GameMenu class
	
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 1000;

	private static final int HEIGHT = WIDTH * 3/4;
	static String TITLE = "The Entity...";
	
	private boolean isRunning = false;
	private Thread thread;
	private ObjectHandler objHandler;
	private SpriteSheet newSprite;
	private SpriteSheet tileSprite;
	
	private BufferedImage level = null;
	private BufferedImage menuBackdrop = null;
	private BufferedImage sprite_sheet = null;
	private BufferedImage tile = null;
	
	private BufferedImage firstTile = null;
	
	private Camera povCam;
	private GameMenu Menu;
	
	// Determines game state; Menu or Gameplay
	public static GameState curState = GameState.Gameplay;
	
	public GameCore() {
		new WindowUI(WIDTH, HEIGHT, TITLE, this);
		start();
		
		objHandler = new ObjectHandler();
		povCam = new Camera(0,0);
		Menu = new GameMenu();
		this.addKeyListener(new UseKeys(objHandler));
		
		ImageLoader imgLoader = new ImageLoader();
		level = imgLoader.loadImage("/dem2_testbackdropver2.png");
		
		sprite_sheet = imgLoader.loadImage("/Char_All_tweak.png");
		newSprite = new SpriteSheet(sprite_sheet);
		
		tile = imgLoader.loadImage("/Floor_SS.png");
		tileSprite = new SpriteSheet(tile);
		
		menuBackdrop = imgLoader.loadImage("/Test_backdrop.jpg");
		
		firstTile = tileSprite.grabFloorSprite(2, 1, 32, 32);
		
		loadLevel(level);
	}
	
	// Method that starts up the game
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	// Method that tells the game to stop running
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		}
		catch (InterruptedException ErrorOne){
			ErrorOne.printStackTrace();
		}
	}
	
	public void run() {
		/**
		 * Game Loop (Code Credit)
		 * 
		 * @author Markus Alexej Persson (A.K.A: Notch)
		 */
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	// Visually updates all game items (Updated ~60 times/sec)
	public void tick() {
		
		if (curState == GameState.Gameplay) {
			for (int i = 0; i < objHandler.object.size(); i++) {
				if (objHandler.object.get(i).getObjID() == ID.Player) {
					povCam.tick(objHandler.object.get(i));
				}
			}
		}
		objHandler.tick();
	}
	
	// Visually renders all game items (Updated ~1000 times/sec)
	public void render() {
		BufferStrategy bufferOne = this.getBufferStrategy();
		if(bufferOne == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics renderGraphic = bufferOne.getDrawGraphics();
		
		renderGraphic.drawImage(menuBackdrop, 0, 0, this);
		
		/// Section below serves as Canvas, where all game objects are rendered ///
		
		/*
		 * Note: Make sure objects are initialized first,
		 * 		 so they render AFTER the background
		 */
		
		if (curState == GameState.Gameplay) {
			
			Graphics2D render2D = (Graphics2D) renderGraphic;
			
			render2D.translate(-povCam.getX(), -povCam.getY());
			
			// Background Sprite rendering loop
			for (int xx = 0; xx < 30*72; xx+=30) {
				for (int yy = 0; yy < 30*72; yy+=30) {
					renderGraphic.drawImage(firstTile, xx, yy, null);
				}
			}
			
			objHandler.render(renderGraphic);
			render2D.translate(povCam.getX(), povCam.getY());	
		}
		
		else if (curState == GameState.Menu) {
			Menu.render(renderGraphic);
		}
		
		///////////////////////////////////////////////////////////////////////////
		
		renderGraphic.dispose();
		bufferOne.show();
		
	}
	
	/*
	 * Level loading method
	 * 
	 * Loads and sets all game level items based on their designated colors
	 * in the game map
	 */
	private void loadLevel(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int xx = 0; xx < width; xx++) {
			for(int yy = 0; yy < height; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 255)
					objHandler.addObject(new Wall(xx*32, yy*32, ID.Wall, newSprite));
				
				if (blue == 255)
					objHandler.addObject(new Player(xx*16, yy*20, ID.Player, objHandler, newSprite));
				
				if (green == 255)
					objHandler.addObject(new Chest(xx*32, yy*32, ID.Chest, objHandler, newSprite));
			}
		}
	}
	
	public static void main(String args[]) {
		new GameCore();
	}

}
