package main.gameclasses;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.gameclasses.gameobjects.Player;
import main.gameclasses.utils.ID;

public class UseKeys extends KeyAdapter {
	
	/*
	 * Class that handles user key input
	 * 
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
	
	// Method that checks if the corresponding key has been pressed
	// Keys checked are: W, A, S and D
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
	
	// Method that checks if the corresponding key has been released, after which the action mapped to the key is carried out
	// Keys checked are: W, A, S and D
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
