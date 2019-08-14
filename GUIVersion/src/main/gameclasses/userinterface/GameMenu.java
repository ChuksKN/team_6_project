package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class GameMenu {
	
	public void render (Graphics renderGraphic) {
		
		Font fnt0 = new Font("chiller", Font.BOLD, 55);
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.red);
		renderGraphic.drawString(GameCore.TITLE, GameCore.WIDTH / (7/2) + 50, 180);
		
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Press 'Enter'!", GameCore.WIDTH / (7/2) + 25, 530);
	}

}
