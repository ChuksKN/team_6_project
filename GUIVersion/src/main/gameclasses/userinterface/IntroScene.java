package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class IntroScene {
	
	public void render (Graphics renderGraphic) {
		
		Font fnt0 = new Font("century gothic", Font.BOLD, 16);
		Font fnt1 = new Font("chiller", Font.BOLD, 30);
		Font fnt2 = new Font("century gothic", Font.BOLD, 18);
		
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.lightGray);
		renderGraphic.drawString("You're stuck at your school and it's been overrun by monsters", GameCore.WIDTH / (7/2) - 75, 320);
		renderGraphic.drawString("Find 3 keys and the exit while avoiding the monsters to escape!", GameCore.WIDTH / (7/2) - 85, 350);
		
		renderGraphic.setFont(fnt1);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Start! (Press 'SPACE')", GameCore.WIDTH / (7/2) + 35, 550);
		
		renderGraphic.setFont(fnt2);
		renderGraphic.drawString("Use the W,A,S,D Keys to move", GameCore.WIDTH / (7/2) + 15, 420);
		renderGraphic.drawString("Press 'P' to Pause the game", GameCore.WIDTH / (7/2) + 25, 470);
		
	}


}
