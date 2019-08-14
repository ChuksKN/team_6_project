package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class GameWin {

	public GameWin() {
	}

	public void render(Graphics renderGraphic) {
		
		Font fnt0 = new Font("chiller", Font.BOLD, 45);
		Font fnt1 = new Font("century gothic", Font.BOLD, 30);
		
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("You escaped...", GameCore.WIDTH / (7/2) + 25, 330);
		
		renderGraphic.setFont(fnt1);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Press 'R' to Replay or 'Esc' to Exit", GameCore.WIDTH / (7/2) - 60, 430);
		
	}

}
