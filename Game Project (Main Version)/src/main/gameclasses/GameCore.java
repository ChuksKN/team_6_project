package main.gameclasses;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import main.gameclasses.gameobjects.Chalkboard;
import main.gameclasses.gameobjects.Chest;
import main.gameclasses.gameobjects.Demon;
import main.gameclasses.gameobjects.Desk;
import main.gameclasses.gameobjects.Key1;
import main.gameclasses.gameobjects.Key2;
import main.gameclasses.gameobjects.PlayerChar;
import main.gameclasses.gameobjects.Wall;
import main.gameclasses.gameobjects.Wurm;
import main.gameclasses.gameobjects.Zombie;
import main.gameclasses.utils.GameSTATE;
import main.gameclasses.utils.ObjID;

/**
 * Credit for Code referencing - Marcus Dubreuil
 * 								 Web address: https://marcusman.com/
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
	private Sprites newSprite;
	private Sprites tileSprite;
	
	private BufferedImage level = null;
	private BufferedImage menuBackdrop = null;
	private BufferedImage introBackdrop = null;
	private BufferedImage sprite_sheet = null;
	private BufferedImage tile = null;
	
	private BufferedImage firstTile = null;
	
	private Camera povCam;
	private IntroScene Intro;
	private GameMenu Menu;
	private GameHud Hud;
	
	// Determines game state; Menu or Gameplay
	public static GameSTATE curState = GameSTATE.Gameplay;
	
	public GameCore() {
		new WindowUI(WIDTH, HEIGHT, TITLE, this);
		start();
		
		objHandler = new ObjectHandler();
		povCam = new Camera(0,0);
		Menu = new GameMenu();
		Intro = new IntroScene();
		Hud = new GameHud();
		
		this.addKeyListener(new UseKeys(objHandler));
		
		ImageLoader imgLoader = new ImageLoader();
		//level = imgLoader.loadImage("/dem2_testbackdropver2.png");
		level = imgLoader.loadImage("/Map_ver2_1.png");
		
		sprite_sheet = imgLoader.loadImage("/Char_All_tweak.png");
		newSprite = new Sprites(sprite_sheet);
		
		tile = imgLoader.loadImage("/Floor_SS.png");
		tileSprite = new Sprites(tile);
		
		menuBackdrop = imgLoader.loadImage("/Test_backdrop.jpg");
		introBackdrop = imgLoader.loadImage("/intro_backdrop_test.jpg");
		
		firstTile = tileSprite.grabFloorSprite(2, 1, 32, 32);
		
		loadLevel(level);
	}
	
	// Method that starts up the game
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
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
				update();
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
	public void update() {
		
		if (curState == GameSTATE.Gameplay) {
			for (int i = 0; i < objHandler.object.size(); i++) {
				if (objHandler.object.get(i).getObjID() == ObjID.Player) {
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
		
		/*
		 * Note: Make sure objects are initialized first,
		 * 		 so they render AFTER the background
		 */
		if (curState == GameSTATE.Gameplay) {
			
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
			
			Hud.render(renderGraphic);
			
		}
		else if (curState == GameSTATE.Intro) {
			renderGraphic.drawImage(introBackdrop, 0, 0, this);
			Intro.render(renderGraphic);
		}
		else if (curState == GameSTATE.Menu) {
			renderGraphic.drawImage(menuBackdrop, 0, 0, this);
			Menu.render(renderGraphic);
		}
		renderGraphic.dispose();
		bufferOne.show();
		
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
	
				// Initializes the Walls
				if (red == 255 && green == 0 && blue == 0)
					objHandler.addObject(new Wall(xx*32, yy*32, ObjID.Wall, newSprite));
				
				// Initializes the Player
				if (red == 0 && green == 0 && blue == 255)
					objHandler.addObject(new PlayerChar(xx*16, yy*20, ObjID.Player, objHandler, newSprite));
				
				// Initializes the first Key
				if (red == 130 && blue == 255 && green == 130)
					objHandler.addObject(new Key1(xx*32, yy*32, ObjID.Key1, objHandler, null));
				
				// Initializes the second Key
				if (red == 0 && green == 55 && blue == 0)
					objHandler.addObject(new Key2(xx*32, yy*32, ObjID.Key2, objHandler, null));
				
				// Initializes the Zombie enemies
				if (red == 178 && blue == 255)
					objHandler.addObject(new Zombie(xx*32, yy*32, ObjID.Zombie, objHandler, null));
				
				// Initializes the Desks
				if (green == 255 && blue == 255)
					objHandler.addObject(new Desk(xx*32, yy*32, ObjID.Desk, objHandler, null));
				
				// Initializes the Chalkboards
				if (red == 64 && blue == 64 && green  == 64)
					objHandler.addObject(new Chalkboard(xx*32, yy*32, ObjID.Chalkboard, objHandler, null));
				
				// Initializes the Chests
				if (red == 178 && blue == 255)
					objHandler.addObject(new Chest(xx*32, yy*32, ObjID.Chest, objHandler, null));
				
				// Initializes the Wurm enemies
				if (red == 255 && green  == 106)
					objHandler.addObject(new Wurm(xx*32, yy*32, ObjID.Wurm, objHandler, null));
				
				// Initializes the Demon enemies
				if (red == 182 && green  == 255)
					objHandler.addObject(new Demon(xx*32, yy*32, ObjID.Demon, objHandler, null));
					
			}
		}
	}
	
	public static void main(String args[]) {
		new GameCore();
	}

}
