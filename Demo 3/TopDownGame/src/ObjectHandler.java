import java.awt.Graphics;
import java.util.LinkedList;

/*
 * This class loops through the game and updates all game objects
 * as the game runs
 */
public class ObjectHandler {

	LinkedList<GameObjects> object = new LinkedList<GameObjects>();
	
	private boolean up = false, down = false, right = false, left = false;
	
	public void tick() {
		for (int objectIterate = 0; objectIterate < object.size(); objectIterate++) {
			GameObjects tempObject = object.get(objectIterate);
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics renderGraphic) {
		for (int objectIterate = 0; objectIterate < object.size(); objectIterate++) {
			GameObjects tempObject = object.get(objectIterate);
			
			tempObject.render(renderGraphic);
		}
		
	}
	
	public void addObject(GameObjects tempObject) {
		object.add(tempObject);
	}
	
	public void removeObject(GameObjects tempObject) {
		object.remove(tempObject);
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

}
