package main.gameclasses;

import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * This class initialises the game window and sets its parameters
 * 
 * Functionality:
 * 		Initializes new window to contain game
 * 		Sets window constraints, such as:
 * 			> Maximum and Minimum size
 * 			> Ability to be resized
 * 			> Visibility
 * 			> Location
 */

public class WindowUI {
	
	public WindowUI(int width, int height, String title, GameCore game) {
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
