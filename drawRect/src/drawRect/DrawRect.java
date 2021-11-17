package drawRect;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Nemo {
	private int x, y, w, h;
	private Color c;

	public Nemo(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

}// nemo

class DrawNemo extends MyUtil {

	private Nemo nemo = null;
	private int sX, sY;
	private boolean shift;

	public DrawNemo() {
		setLayout(null);
		setBounds(0, 0, 900, 900);


		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		addKeyListener(this);
	}// DrawNemo()

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (this.nemo != null) {
			g.setColor(this.nemo.getC());
			g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getW(), this.nemo.getH());
		}
		requestFocusInWindow();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			this.shift = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			this.shift = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.sX = e.getX();
		this.sY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.nemo.setC(Color.blue);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		int w = Math.abs(x - this.sX);
		int h = Math.abs(y - this.sY);

		if (shift) {
			w = h;
		}
		
		int rX = this.sX;
		int rY = this.sY;
		if (x < this.sX) {
			rX = this.sX - w;
		}
		if (y < sY) {
			rY = this.sY - h;
		}

		this.nemo = new Nemo(rX, rY, w, h, Color.red);
	}

}

public class DrawRect extends JFrame {

	public DrawRect() {
		super("Draw Rect");
		setBounds(100, 100, 900, 900);

		add(new DrawNemo());

		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		DrawRect dr = new DrawRect();
	}
}
