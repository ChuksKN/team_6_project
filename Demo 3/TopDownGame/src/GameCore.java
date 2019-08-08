import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/*
 * This class serves as the core game engine
 * 
 * Functionality:
 * 		Determines the window dimensions
 * 		Controls the game's start and stop parameters
 * 		Initializes the game loop engine that updates the game as it is ran and played
 */

public class GameCore extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 1000, HEIGHT = WIDTH * 4/7;
	private static String TITLE = "The Entity...";
	
	private boolean isRunning = false;
	private Thread thread;
	private ObjectHandler objHandler;
	private BufferedImage level = null;
	private Camera povCam;
	
	public GameCore() {
		new WindowUI(WIDTH, HEIGHT, TITLE, this);
		start();
		
		objHandler = new ObjectHandler();
		povCam = new Camera(0,0);
		this.addKeyListener(new UseKeys(objHandler));
		
		ImageLoader imgLoader = new ImageLoader();
		level = imgLoader.loadImage("/dem2_testbackdropver2.png");
		
		loadLevel(level);
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
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
		/*
		 * Game Loop Credit
		 * 		Author: Markus Alexej Persson (A.K.A: Notch)
		 * 		Occupation: Videogame Developer; Best known for producing Minecraft and co-founding Mojang
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
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			if (objHandler.object.get(i).getObjID() == ID.Player) {
				povCam.tick(objHandler.object.get(i));
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
		Graphics2D render2D = (Graphics2D) renderGraphic;
		//////////// Section below serves as Canvas //////////
		
		renderGraphic.setColor(Color.white);
		renderGraphic.fillRect(0, 0, WIDTH, HEIGHT);
		
		/*
		 * Note: Make sure objects are initialized first,
		 * 		 so they render AFTER the background
		 */
		
		render2D.translate(-povCam.getX(), -povCam.getY());
		objHandler.render(renderGraphic);
		render2D.translate(povCam.getX(), povCam.getY());
		
		//////////////////////////////////////////////////////
		
		renderGraphic.dispose();
		bufferOne.show();
		
	}
	
	// Level loading method
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
					objHandler.addObject(new Block(xx*32, yy*32, ID.Block));
				
				
				if (blue == 255)
					objHandler.addObject(new Player(xx*32, yy*32, ID.Player, objHandler));
				
			}
		}
	}
	
	public static void main(String args[]) {
		new GameCore();
	}

}
