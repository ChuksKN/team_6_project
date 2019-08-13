package main.gameclasses;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.gameclasses.gameobjects.PlayerChar;
import main.gameclasses.utils.GameSTATE;
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
	 * Keys checked are: W, A, S, D, SPACE, ENTER, P and R
	 * 
	 * @return Nothing
	 */
	public void keyPressed(KeyEvent input) {
		int butPress = input.getKeyCode();
		
		for (int i = 0; i < objHandler.object.size(); i++) {
			Objects tempObject = objHandler.object.get(i);
			
			if(tempObject.getObjID() == ObjID.Player) {
				if (GameCore.curState == GameSTATE.Gameplay) {
					if(butPress == KeyEvent.VK_W) objHandler.setUp(true);
					if(butPress == KeyEvent.VK_A) objHandler.setLeft(true);
					if(butPress == KeyEvent.VK_S) objHandler.setDown(true);
					if(butPress == KeyEvent.VK_D) objHandler.setRight(true);
				}
			}
		}
		
		if (butPress == KeyEvent.VK_ENTER && GameCore.curState == GameSTATE.Menu) {
			GameCore.curState = GameSTATE.Intro;
		}

		if (butPress == KeyEvent.VK_SPACE && GameCore.curState == GameSTATE.Intro){
			GameCore.curState = GameSTATE.Gameplay;
		}
		
		if (butPress == KeyEvent.VK_P && GameCore.curState == GameSTATE.Gameplay){
			GameCore.curState = GameSTATE.Pause;
		}
		else if (butPress == KeyEvent.VK_P && GameCore.curState == GameSTATE.Pause) {
			GameCore.curState = GameSTATE.Gameplay;
		}
		
		/*
		 * Working on Restart feature
		 *
		if (butPress == KeyEvent.VK_R && GameCore.curState == GameSTATE.GameOver || GameCore.curState == GameSTATE.GameWin) {
			new GameCore();
			GameCore.curState = GameSTATE.Gameplay;
			PlayerChar.healthStatus = 100;
		}
		*/
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
