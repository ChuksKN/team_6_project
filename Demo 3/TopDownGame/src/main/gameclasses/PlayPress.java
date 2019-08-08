/*
package main.gameclasses;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.gameclasses.utils.GameState;

public class PlayPress extends KeyAdapter{
	
	public PlayPress() {
		
	}
	
	public void playPressed(KeyEvent input) {
		int play = input.getKeyCode();
		
		if (GameCore.curState == GameState.Menu) {
			if (play == KeyEvent.VK_P) {
				GameCore.curState = GameState.Gameplay;
			}
		}
	}

}
*/