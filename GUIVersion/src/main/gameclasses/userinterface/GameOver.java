package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class GameOver {

	public GameOver() {
	}

	public void render(Graphics renderGraphic) {
		
		Font fnt0 = new Font("chiller", Font.BOLD, 50);
		Font fnt1 = new Font("century gothic", Font.BOLD, 30);
		
		renderGraphic.setFont(fnt0);
		renderGraphic.setColor(Color.red);
		renderGraphic.drawString("You DIED...", GameCore.WIDTH / (7/2) + 60, 330);
		
		renderGraphic.setFont(fnt1);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("Press 'R' to Restart or 'Esc' to Exit", GameCore.WIDTH / (7/2) - 60, 530);
	}

}
