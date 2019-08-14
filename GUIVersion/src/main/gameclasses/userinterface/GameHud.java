package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;
import main.gameclasses.gameobjects.PlayerChar;


public class GameHud {
	
	public static boolean hOne;

	
	public void render (Graphics renderGraphic) {
		
		int hpX = 5;
		int hpY = 5;
		int hpL = 200;
		int hpPos = 32;
		
		renderGraphic.setColor(Color.red);
		renderGraphic.fillRect(hpX, hpY, hpL, hpPos);
		
		renderGraphic.setColor(Color.green);
		renderGraphic.fillRect(hpX, hpY, PlayerChar.healthStatus * 2, hpPos);
		
		renderGraphic.setColor(Color.white);
		renderGraphic.drawRect(hpX, hpY, hpL, hpPos);

		
		Font fnt0 = new Font("century gothic", Font.BOLD, 17);
		
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Keys found: " + GameCore.KEYSCOL + "/3", 5, 60);
		
	}
	
	public void tick() {
		
	}

}
