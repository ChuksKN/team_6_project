package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.Rectangle;

import main.gameclasses.GameCore;

public class GameMenu {
	
	// public Rectangle play = new Rectangle(GameCore.WIDTH / (8/2) + 120, 420, 150, 50);
	
	public void render (Graphics renderGraphic) {
		
		// Graphics2D g2d = (Graphics2D) renderGraphic;
		
		Font fnt0 = new Font("chiller", Font.BOLD, 55);
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.red);
		renderGraphic.drawString(GameCore.TITLE, GameCore.WIDTH / (7/2) + 50, 180);
		
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Press 'Enter'!", GameCore.WIDTH / (7/2) + 25, 530);
	}

}
