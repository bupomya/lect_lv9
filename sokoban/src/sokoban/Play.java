package sokoban;

import javax.swing.JFrame;

public class Play extends JFrame{
	public Play() {
		super("sokoban");
		setBounds(100, 100, 1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		revalidate();
	}

}
