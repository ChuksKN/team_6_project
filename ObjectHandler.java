import java.awt.Graphics;
import java.util.LinkedList;

/*
 * This class loops through the game and updates all game objects
 * as the game runs
 */
public class ObjectHandler {
	
	LinkedList<GameObjects> object = new LinkedList<GameObjects>();
	
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

}
