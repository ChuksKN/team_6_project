import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * This class serves as the core game engine
 * 
 * Functionality:
 * 		Determines the window dimensions
 * 		Controls the game's start and stop parameters
 * 		Initialises the game loop engine that updates the game as it is ran and played
 */

public class GameCore extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 1000, HEIGHT = WIDTH * 4/7;
	private static String TITLE = "The Entity...";
	
	private boolean isRunning = false;
	private Thread thread;
	private ObjectHandler objHandler;
	
	public GameCore() {
		new WindowUI(WIDTH, HEIGHT, TITLE, this);
		start();
		
		objHandler = new ObjectHandler();
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
		//////////// Section below serves as Canvas //////////
		
		
		
		renderGraphic.setColor(Color.red);
		renderGraphic.fillRect(0, 0, WIDTH, HEIGHT);
		
		/*
		 * Note: Make sure objects are initialised first,
		 * 		 so they render AFTER the background
		 */
		
		objHandler.render(renderGraphic);
		
		
		//////////////////////////////////////////////////////
		
		renderGraphic.dispose();
		bufferOne.show();
		
	}
	
	
	public static void main(String args[]) {
		new GameCore();
	}

}
