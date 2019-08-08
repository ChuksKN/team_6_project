import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * This class describes the parameters of all the Game objects
 */
public abstract class GameObjects {
	
	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID objID;
	
	public GameObjects(int x, int y, ID objID) {
		this.x = x;
		this.y = y;
		this.objID = objID;
	}
	
	public abstract void tick();
	public abstract void render(Graphics renderGraphic);
	public abstract Rectangle getColBounds();

	public int getX() {
		return x;
	}

	public ID getObjID() {
		return objID;
	}

	public void setObjID(ID objID) {
		this.objID = objID;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	
}
