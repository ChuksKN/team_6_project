import javax.swing.JFrame;

//for testing only
public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("The Entity");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GameFrame());
		frame.setResizable(false);
		frame.setVisible(true);
		
	//	frame.setFocusable(true);

	//	frame.addKeyListener(null);
	//	GameFrame window;
	//	window = new GameFrame();
	//	frame.add(window);
	//	frame.addKeyListener(new UseKeys(window.getPlayer()));
	}

}
