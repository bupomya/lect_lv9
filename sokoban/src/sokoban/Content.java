package sokoban;

import java.awt.Graphics;
import java.util.Iterator;

public class Content extends Util {
	private final int SIZE = 10;

	private Sokoban map[][] = new Sokoban[SIZE][SIZE];
	private Sokoban box[][] = new Sokoban[SIZE][SIZE];

	private Sokoban player = null;

	public Content() {
		setLayout(null);
		setBounds(0, 0, 1000, 1000);

		setMap();

		// keyListener

	}// Content()

	private void setMap() {
		int x = 50;
		int y = 50;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.map[i][j] = new Sokoban(x, y, 50, 50);
				x += 50;
			}
			x = 50;
			y += 50;
		}
	}// setMap
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//map
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				Sokoban s = this.map[i][j];
				g.drawRect(s.getX(), s.getY(), s.getW(), s.getH());
			}
		}
		
		repaint();
	}

}// Content
