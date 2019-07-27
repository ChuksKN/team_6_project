import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Player extends Entity{
	
	int velX = 0;
	int velY = 0;
	int movementSpeed = 5;

	
	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
	}
	public void update() {
		y += velY;
		x += velX;
	}
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	public Image getPlayerImg() {
		ImageIcon ic = new ImageIcon("C:/JavaImg/Retard.jpg");
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
	public void KeyReleased(KeyEvent input) {
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
	public void keyTyped(KeyEvent input) {}

		
	
	}
	

