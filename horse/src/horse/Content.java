package horse;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Content extends Util {

	Random rn = new Random();
	private final int SIZE = 5;
	private Horse[] horses = new Horse[SIZE];

	private boolean isRun;
	private int ms;
	private JLabel timer = new JLabel();

	private int startX = 30;
	private int startY = 80;
	private int endX = 1000 - 120 - 30;
	private int rank;

	private JButton reset = new JButton();

	public Content() {
		setLayout(null);
		setBounds(0, 0, 1000, 600);

		setTimer();
		setHorse();
		setButton();

	}// Content();

	private void setButton() {

	}

	private void setTimer() {
		this.timer.setBounds(30, 50, 50, 30);
		this.timer.setText("ready");
		add(this.timer);
	}// setTimer

	private void setHorse() {
		this.rank = 1;
		int x = this.startX;
		int y = this.startY;
		for (int i = 0; i < SIZE; i++) {
			this.horses[i] = new Horse(i + 1, x, y, 120, 80);
			y += 90;
		}
	}// setHorse

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//horse
		for (int i = 0; i < SIZE; i++) {
			Horse h = this.horses[i];
			g.drawImage(h.getIcon().getImage(), h.getX(), h.getY(), null);
			g.drawLine(this.startX, h.getY()+h.getH(), 1000-30, h.getY()+h.getH());
			
			if (h.getState() == h.getGOAL()) {
				g.setFont(new Font("", Font.BOLD, 20));
				g.drawString("µî", this.endX-100, h.getY()+h.getH()/2);
				g.setFont(new Font("",Font.PLAIN, 10));
				g.drawString(h.getRecode(), this.endX-50, h.getY()+h.getH()/2);
			}
		}

		if (isRun) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		repaint();
	}// paintComponent
}// Content
