import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UseKeys extends KeyAdapter {
	
	/*
	 * Note:
	 * 		Must use the same handler declared in GameCore.java
	 * 		Do not create a new instance of the handler
	 */
	ObjectHandler objHandler;

	
	public UseKeys(ObjectHandler objHandler) {
		this.objHandler = objHandler;
	}

	public UseKeys(Player player) {
		
	}
	
	public void keyPressed(KeyEvent input) {
		int button = input.getKeyCode();
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			GameObjects tempObject = objHandler.object.get(i);
			
			if(tempObject.getObjID() == ID.Player) {
				if(button == KeyEvent.VK_W) objHandler.setUp(true);
				if(button == KeyEvent.VK_A) objHandler.setLeft(true);
				if(button == KeyEvent.VK_S) objHandler.setDown(true);
				if(button == KeyEvent.VK_D) objHandler.setRight(true);
			}
		}
	}
	
	public void keyReleased(KeyEvent input) {
		int button = input.getKeyCode();
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			GameObjects tempObject = objHandler.object.get(i);
			
			if(tempObject.getObjID() == ID.Player) {
				if(button == KeyEvent.VK_W) objHandler.setUp(false);
				if(button == KeyEvent.VK_A) objHandler.setLeft(false);
				if(button == KeyEvent.VK_S) objHandler.setDown(false);
				if(button == KeyEvent.VK_D) objHandler.setRight(false);
			}
		}
	}
}
