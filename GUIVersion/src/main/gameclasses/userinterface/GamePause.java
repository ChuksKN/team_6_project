package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class GamePause {


	public void render (Graphics renderGraphic) {
		
		Font fnt0 = new Font("century gothic", Font.BOLD, 25);
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("PAUSED (Press 'P' to resume)", GameCore.WIDTH / (7/2), 380);
	}

}
