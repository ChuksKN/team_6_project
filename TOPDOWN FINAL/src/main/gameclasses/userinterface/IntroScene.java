package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class IntroScene {
	
	public void render (Graphics renderGraphic) {
		
		// Graphics2D g2d = (Graphics2D) renderGraphic;
		
		Font fnt0 = new Font("century gothic", Font.BOLD, 16);
		Font fnt1 = new Font("chiller", Font.BOLD, 25);
		Font fnt2 = new Font("century gothic", Font.BOLD, 20);
		
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.gray);
		renderGraphic.drawString("You're stuck at your school and it's been overrun by monsters, find the keys and make your way out. Stay alert...", GameCore.WIDTH / (7/2) - 275, 280);
		
		renderGraphic.setFont(fnt1);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Start! (Press 'SPACE')", GameCore.WIDTH / (7/2) + 40, 530);
		
		renderGraphic.setFont(fnt2);
		renderGraphic.drawString("Use the W,A,S,D Keys to move", GameCore.WIDTH / (7/2) + 10, 400);
		
	}


}
