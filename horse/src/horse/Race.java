package horse;

import javax.swing.JFrame;

public class Race extends JFrame{
	public Race() {
		super("Horse Race");
		setBounds(100, 100, 1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Content());
		
		setVisible(true);
		revalidate();
	}
}
