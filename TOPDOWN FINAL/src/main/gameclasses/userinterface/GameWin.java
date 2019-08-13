package main.gameclasses.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.gameclasses.GameCore;

public class GameWin {

	public GameWin() {
	}

	public void render(Graphics renderGraphic) {
		
		Font fnt1 = new Font("chiller", Font.BOLD, 45);
		
		renderGraphic.setFont(fnt1);
		renderGraphic.setColor(Color.white);
		renderGraphic.drawString("You managed to escape...", GameCore.WIDTH / (7/2) + 25, 330);
		
	}

}
