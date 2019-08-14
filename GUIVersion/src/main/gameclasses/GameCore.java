package main.gameclasses;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import main.gameclasses.gameobjects.Demon;
import main.gameclasses.gameobjects.PlayerChar;
import main.gameclasses.gameobjects.Wurm;
import main.gameclasses.gameobjects.WurmProj;
import main.gameclasses.gameobjects.Zombie;
import main.gameclasses.gameobjects.secitems.Chalkboard;
import main.gameclasses.gameobjects.secitems.Desk;
import main.gameclasses.gameobjects.secitems.Exit;
import main.gameclasses.gameobjects.secitems.Key1;
import main.gameclasses.gameobjects.secitems.Key2;
import main.gameclasses.gameobjects.secitems.Key3;
import main.gameclasses.gameobjects.secitems.Wall;
import main.gameclasses.gameobjects.secitems.innerWall;
import main.gameclasses.gameobjects.secitems.leftWall;
import main.gameclasses.gameobjects.secitems.rightWall;
import main.gameclasses.userinterface.GameHud;
import main.gameclasses.userinterface.GameMenu;
import main.gameclasses.userinterface.GameOver;
import main.gameclasses.userinterface.GamePause;
import main.gameclasses.userinterface.GameWin;
import main.gameclasses.userinterface.IntroScene;
import main.gameclasses.userinterface.WindowUI;
import main.gameclasses.utils.GameSTATE;
import main.gameclasses.utils.ObjID;

/**
 * Credit for some Code referencing - Marcus Dubreuil
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
	
	// Width and Title variables are public to allow access by the GameMenu class
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1000;

	private static final int HEIGHT = WIDTH * 3/4;
	public static String TITLE = "The Entity...";
	
	private boolean isRunning = false;
	private Thread thread;
	private ObjectHandler objHandler;
	
	private Sprites newSprite;
	
	private Sprites tileSprite;
	private Sprites deskSprite;
	
	private BufferedImage level = null;
	private BufferedImage menuBackdrop = null;
	private BufferedImage introBackdrop = null;
	private BufferedImage winBackdrop = null;
	private BufferedImage loseBackdrop = null;
	private BufferedImage sprite_sheet = null;
	private BufferedImage tile = null;
	private BufferedImage desk1 = null;
	
	private BufferedImage firstTile = null;
	
	private Camera povCam;
	private IntroScene Intro;
	private GameMenu Menu;
	private GamePause Pause;
	private GameOver Lose;
	private GameWin Win;
	private GameHud Hud;

	private BufferedImage zomb;
	private Sprites zombSprite;
	
	private BufferedImage dem;
	private Sprites demonSprite;
	
	private BufferedImage wurm1;
	private Sprites wurmSprite;
	
	private BufferedImage wurmP;
	private Sprites wurmPSprite;
	
	private BufferedImage chalkB;
	private Sprites chalkBSprite;

	private BufferedImage wall_cases;
	private Sprites aWallSprite;

	private BufferedImage key;
	private Sprites keySprite;

	private BufferedImage exitS;
	private Sprites signSprite;
	
	// Variables are public to allow access by each game object
	public static BufferedImage keyS;
	
	public static BufferedImage rWall;
	public static BufferedImage lWall;
	public static BufferedImage inWall;

	public static BufferedImage eSign;
	public static BufferedImage wallOne = null;
	public static BufferedImage deskOne = null;
	public static BufferedImage chalkboard = null;
	public static BufferedImage wurmProj = null;
	public static BufferedImage wurm = null;
	public static BufferedImage demon = null;
	public static BufferedImage zombie = null;
	
	public static int KEYSCOL = 0;
	
	// Determines game state; Menu or Gameplay
	
	public static GameSTATE curState = GameSTATE.Menu;
	
	public GameCore() {
		new WindowUI(WIDTH, HEIGHT, TITLE, this);
		start();
		
		objHandler = new ObjectHandler();
		povCam = new Camera(0,0);
		Menu = new GameMenu();
		Intro = new IntroScene();
		Hud = new GameHud();
		Pause = new GamePause();
		Lose = new GameOver();
		Win = new GameWin();
		
		this.addKeyListener(new UseKeys(objHandler));
		
		ImageLoader imgLoader = new ImageLoader();
		
		//// Section for handling and loading Sprites ////
		level = imgLoader.loadImage("/Map_ver2_1_3.png");
		
		sprite_sheet = imgLoader.loadImage("/char_d_shadow.png");
		newSprite = new Sprites(sprite_sheet);
		
		tile = imgLoader.loadImage("/tileand_wall.png");
		tileSprite = new Sprites(tile);
		
		wall_cases = imgLoader.loadImage("/all_wall_edges_tweak2.png");
		aWallSprite = new Sprites(wall_cases);
		
		desk1 = imgLoader.loadImage("/sprite_desk0.png");
		deskSprite = new Sprites(desk1);
		
		zomb = imgLoader.loadImage("/zombie1d_3.png");
		zombSprite = new Sprites(zomb);
		
		dem = imgLoader.loadImage("/demon1d_3.png");
		demonSprite = new Sprites(dem);
		
		wurm1 = imgLoader.loadImage("/wurm_faced.png");
		wurmSprite = new Sprites(wurm1);
		
		wurmP = imgLoader.loadImage("/BAll.png");
		wurmPSprite = new Sprites(wurmP);
		
		chalkB = imgLoader.loadImage("/board1.png");
		chalkBSprite = new Sprites(chalkB);
		
		key = imgLoader.loadImage("/key_1.png");
		keySprite = new Sprites(key);
		
		exitS = imgLoader.loadImage("/exitsign.png");
		signSprite = new Sprites(exitS);
		
		menuBackdrop = imgLoader.loadImage("/Test_backdrop.jpg");
		introBackdrop = imgLoader.loadImage("/intro_backdrop_ver2.jpg");
		winBackdrop = imgLoader.loadImage("/win_backdrop.jpg");
		loseBackdrop = imgLoader.loadImage("/death_backdrop.jpg");
		
		firstTile = tileSprite.grabFloorSprite(2, 1, 32, 32);
		
		wallOne = tileSprite.grabFloorSprite(11, 1, 32, 32);
		inWall = aWallSprite.grabAllWallSprite(1, 1, 32, 32);
		rWall = aWallSprite.grabAllWallSprite(1, 2, 32, 32);
		lWall = aWallSprite.grabAllWallSprite(1, 3, 32, 32);
		
		eSign = signSprite.grabSignSprite(1, 1, 32, 32);
		keyS = keySprite.grabKeySprite(1, 1, 32, 32);
		deskOne = deskSprite.grabDeskSprite(1, 1, 63, 62);
		zombie = zombSprite.grabZombSprite(1, 1, 50, 50);
		demon = demonSprite.grabDemSprite(1, 1, 50, 50);
		wurm = wurmSprite.grabWurmSprite(1, 1, 34, 34);
		wurmProj = wurmPSprite.grabWurmPSprite(1, 1, 10, 10);
		chalkboard = chalkBSprite.grabCBoardSprite(1, 1, 100, 100);
		
		///////////////////////////////////
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
		@SuppressWarnings("unused")
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
			objHandler.tick();
		}
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
		else if (curState == GameSTATE.Pause) {
			renderGraphic.drawImage(introBackdrop, 0, 0, this);
			Pause.render(renderGraphic);
		}
		else if (curState == GameSTATE.GameOver) {
			renderGraphic.drawImage(loseBackdrop, 0, 0, this);
			Lose.render(renderGraphic);
		}
		else if (curState == GameSTATE.GameWin) {
			renderGraphic.drawImage(winBackdrop, 0, 0, this);
			Win.render(renderGraphic);
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
	
				// Initializes the Main wall, inner wall section, left wall and right wall, respectively
				if (red == 255 && green == 0 && blue == 0)
					objHandler.addObject(new Wall(xx*32, yy*32, ObjID.Wall, newSprite));
				
				if(red == 47 && green == 47 && blue == 100 )
					objHandler.addObject(new innerWall(xx*32, yy*32, ObjID.innerWall, newSprite));
				
				if(red == 39 && green == 156 && blue == 73 )
					objHandler.addObject(new leftWall(xx*32, yy*32, ObjID.leftWall, newSprite));

				if(red == 0 && green == 41 && blue == 12 )
					objHandler.addObject(new rightWall(xx*32, yy*32, ObjID.rightWall, newSprite));
				
				// Initializes the Player
				if (red == 0 && green == 0 && blue == 255)
					objHandler.addObject(new PlayerChar(xx*16, yy*20, ObjID.Player, objHandler, newSprite));
				
				// Initializes the first Key
				if (red == 130 && green == 255 && blue == 130)
					objHandler.addObject(new Key1(xx*32, yy*32, ObjID.Key1, objHandler, null));
				
				// Initializes the second Key
				if (red == 255 && green == 255 && blue == 0)
					objHandler.addObject(new Key2(xx*32, yy*32, ObjID.Key2, objHandler, null));
				
				// Initializes the third Key
				if (red == 178 && green == 0 && blue == 255)
					objHandler.addObject(new Key3(xx*32, yy*32, ObjID.Key3, objHandler, null));
				
				// Initializes the Zombie enemies
				if (red == 255 && blue == 220)
					objHandler.addObject(new Zombie(xx*32, yy*32, ObjID.Zombie, objHandler, null));
				
				// Initializes the Desks
				if (green == 255 && blue == 255)
					objHandler.addObject(new Desk(xx*32, yy*32, ObjID.Desk, objHandler, null));
				
				// Initializes the Chalkboards
				if (red == 64 && blue == 64 && green  == 64)
					objHandler.addObject(new Chalkboard(xx*32, yy*32, ObjID.Chalkboard, objHandler, null));
								
				// Initializes the Wurm enemies
				if (red == 255 && green  == 106)
					objHandler.addObject(new Wurm(xx*32, yy*32, ObjID.Wurm, objHandler, null));
				
				// Initializes the Wurm projectile
				if (red == 125 && green  == 50)
					objHandler.addObject(new WurmProj(xx*32, yy*32, ObjID.WurmProj, objHandler, null));
				
				// Initializes the Demon enemies
				if (red == 182 && green  == 255)
					objHandler.addObject(new Demon(xx*32, yy*32, ObjID.Demon, objHandler, null));
				
				// Initializes the Exit section for game win
				if (red == 255 && green == 155 && blue  == 155)
					objHandler.addObject(new Exit(xx*32, yy*32, ObjID.Exit, objHandler, null));
				
			}
		}
	}
	
	public static void main(String args[]) {
		new GameCore();
	}

}
