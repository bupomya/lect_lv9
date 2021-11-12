package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


class Rect{
	private int x,y,w,h;
	private Color c;
	
	public Rect(int x, int y, int w , int h, Color c) {
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
	
	
}//Nemo

class MovingRect extends JPanel implements MouseListener,MouseMotionListener{
	
	private int yx[] = new int [2];
	private boolean isMoving;
	private int gapW,gapH;
	private Rect rect = null;
	
	public MovingRect() {
		setLayout(null);
		setBounds(0, 0, 700, 500);
		
		setRect();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void setRect() {
		Random rn = new Random();
		int rX = rn.nextInt(500-50);
		int rY = rn.nextInt(500-50);
		
		this.rect = new Rect(rX, rY, 50, 50, Color.red);
	}//setRect

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (isMoving) {
			this.rect.setX(x-gapW);
			this.rect.setY(y-gapH);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		g.setColor(this.rect.getC());
		g.fillRect(this.rect.getX(), this.rect.getY(), this.rect.getW(), this.rect.getH());
		
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (x >= this.rect.getX() && x < this.rect.getX()+this.rect.getW()
		 && y >= this.rect.getY() && y<this.rect.getY()+this.rect.getH()) {
			this.isMoving = true;
			this.gapW = x-this.rect.getX();
			this.gapH = x-this.rect.getY();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMoving = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


public class RectMove extends JFrame {
	
	public RectMove() {
		super("RectMove");
		setBounds(100,100,700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MovingRect());
		
		setVisible(true);
		revalidate();
		
	}
	
	public static void main(String[] args) {
		RectMove rm = new RectMove();
	}
}
