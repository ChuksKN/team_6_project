import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
//import javax.swing.ImageIcon;


public class Player extends GameObjects{
	
	private int movementSpeed = 5;
	
	ObjectHandler objHandler;

	
	public Player(int x, int y, ID objID, ObjectHandler objHandler) {
		super(x, y, objID);
		this.objHandler = objHandler;
		
	}
	
	public void tick() {
		y += velY;
		x += velX;
		
		// this handles movement up
		if (objHandler.isUp()) {
			velY = -movementSpeed;
		} else if (!objHandler.isDown()) {
			velY = 0;
		}
		
		//this handles movement down
		if (objHandler.isDown()) {
			velY = movementSpeed;
		} else if (!objHandler.isUp()) {
			velY = 0;
		}
		
		//this handles movement left
		if (objHandler.isLeft()) {
			velX = -movementSpeed;
		} else if (!objHandler.isRight()) {
			velX = 0;
		}
		
		//this handles movement right
		if (objHandler.isRight()) {
			velX = movementSpeed;
		} else if (!objHandler.isLeft()) {
			velX = 0;
		}
	}
	
	public void render (Graphics renderGraphic) {
		// Rendering test
		renderGraphic.setColor(Color.blue);
		renderGraphic.fillRect(x, y, 30, 40);
		
	}
	
	public Rectangle getColBounds() {
		return new Rectangle();
	}
	
	/*
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	
	
	public Image getPlayerImg() {
		ImageIcon ic = new ImageIcon("-");
		return ic.getImage();

	}

	public void keyPressed(KeyEvent input) {
		int key = input.getKeyCode();	
		
		switch(key) {
			case (KeyEvent.VK_W): 
				//this handles movement up
				velY = -movementSpeed;
			break;
			case (KeyEvent.VK_S):
				//this handles movement down
				velY = movementSpeed;
			break;
			case (KeyEvent.VK_A):
				//this handles movement left
				velX = -movementSpeed;
			break;
			case (KeyEvent.VK_D):
				//this handles movement right
				velX = movementSpeed;
			break;	
			}
		}
	
	public void keyReleased(KeyEvent input) {
	int key = input.getKeyCode();
		
		switch(key) {
			case (KeyEvent.VK_W): 
				//this handles movement up
				velY = 0;
			break;
			case (KeyEvent.VK_S):
				//this handles movement down
				velY = 0;
			break;
			case (KeyEvent.VK_A):
				//this handles movement left
				velX = 0;
			break;
			case (KeyEvent.VK_D):
				//this handles movement right
				velX = 0;
			break;	
			}
		}
	*/
}

