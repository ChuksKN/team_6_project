import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import java.awt.event.KeyEvent;
//import javax.swing.ImageIcon;


public class Player extends GameObjects{
	
	private int movementSpeed = 5;
	
	ObjectHandler objHandler;
	
	private BufferedImage player_sprite;

	
	public Player(int x, int y, ID objID, ObjectHandler objHandler, SpriteSheet newSprite) {
		super(x, y, objID, newSprite);
		this.objHandler = objHandler;
		
		player_sprite = newSprite.grabSprite(1, 1, 160, 160);
	}
	
	public void tick() {
		
		detCollision();
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
		// Rendering test for the player
		renderGraphic.drawImage(player_sprite, x, y, null);
		
	}
	
	public Rectangle getColBounds() {
		return new Rectangle(x, y, 32, 48);
	}
	
	// Boolean method used to determine if the players path is free (returns true) or not (returns false)
	public boolean pathFree (int x, int y, Rectangle playerRect, Rectangle otherRect) {
		playerRect.x = x;
		playerRect.y = y;
		
		if(playerRect.intersects(otherRect)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// Method to allow the player to detect collision with certain objects
	public void detCollision() {
		for(int i = 0; i < objHandler.object.size(); i++) {
			GameObjects tempObject = objHandler.object.get(i);
			
			// Collision detection for walls
			if (tempObject.getObjID() == ID.Wall) {
				if (!pathFree((int)(x + velX), y, getColBounds(), tempObject.getColBounds())) {
					x = (int) (x - velX);
				}
				else if (!pathFree(x,(int)(y + velY), getColBounds(), tempObject.getColBounds())) {
					velY = 0;
				}
			}
			
			// Collision detection for chests (lunchboxes)
			if (tempObject.getObjID() == ID.Chest) {
				if (!pathFree((int)(x + velX), y, getColBounds(), tempObject.getColBounds())) {
					x = (int) (x - velX);
				}
				else if (!pathFree(x,(int)(y + velY), getColBounds(), tempObject.getColBounds())) {
					velY = 0;
				}
			}
		}
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

