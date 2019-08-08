package main.gameclasses;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.gameclasses.gameobjects.PlayerChar;
import main.gameclasses.utils.ObjID;

public class UseKeys extends KeyAdapter {
	
	/**
	 * Class that handles user key input
	 * 
	 * Note:
	 * 		Must use the same handler declared in GameCore.java
	 * 		Do not create a new instance of the handler
	 * 
	 * @author Bobby B.
	 * @version 1.0
	 * @since 2019-08-07
	 * 
	 */
	ObjectHandler objHandler;

	
	public UseKeys(ObjectHandler objHandler) {
		this.objHandler = objHandler;
	}

	public UseKeys(PlayerChar player) {
		
	}
	
	/**
	 * Method that checks if the corresponding key has been pressed
	 * Keys checked are: W, A, S and D
	 * 
	 * @return Nothing
	 */
	public void keyPressed(KeyEvent input) {
		int butPress = input.getKeyCode();
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if(tempObject.getObjID() == ObjID.Player) {
				if(butPress == KeyEvent.VK_W) objHandler.setUp(true);
				if(butPress == KeyEvent.VK_A) objHandler.setLeft(true);
				if(butPress == KeyEvent.VK_S) objHandler.setDown(true);
				if(butPress == KeyEvent.VK_D) objHandler.setRight(true);
			}
		}
	}
	
	/**
	 * Method that checks if the corresponding key has been released, after which the action mapped to the key is carried out
	 * Keys checked are: W, A, S and D
	 * 
	 * @return Nothing
	 *
	 */
	public void keyReleased(KeyEvent input) {
		int butPress = input.getKeyCode();
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if(tempObject.getObjID() == ObjID.Player) {
				if(butPress == KeyEvent.VK_W) objHandler.setUp(false);
				if(butPress == KeyEvent.VK_A) objHandler.setLeft(false);
				if(butPress == KeyEvent.VK_S) objHandler.setDown(false);
				if(butPress == KeyEvent.VK_D) objHandler.setRight(false);
			}
		}
	}
}
