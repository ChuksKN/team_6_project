import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UseKeys extends KeyAdapter {

	Player p;

	public UseKeys(Player player) {
		p = player;
	}
	public void KeyPressed(KeyEvent input) {
		p.keyPressed(input);
	}
	public void KeyReleased(KeyEvent input) {
		p.KeyReleased(input);
	}
}
