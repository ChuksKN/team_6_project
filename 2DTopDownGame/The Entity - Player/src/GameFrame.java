import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

//for testing only, this draws a window with an object
public class GameFrame extends JPanel implements ActionListener {
	
	Timer mainTimer;
	Player player;
	

	public GameFrame() {
		setFocusable(true);
		requestFocus();
		addKeyListener(new UseKeys(player));
		

		player = new Player(0,0);
		mainTimer = new Timer(5, this);
		mainTimer.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		player.draw(g2d);

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		player.update();
		repaint();
	}
//	public Player getPlayer() {
//		return this.player;
//	}
//	public void keyPressed(KeyEvent arg0) {
//		// TODO Auto-generated method stub
		
//	}
//	public void keyReleased(KeyEvent arg0) {
//		// TODO Auto-generated method stub
		
//	}

}
