package horse;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Content extends Util implements Runnable{

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
		this.reset.setText("START");
		this.reset.setBounds(80, 50, 80, 30);
		this.reset.addActionListener(this);
		add(this.reset);
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
				g.drawString(h.getRank()+"등", this.endX-100, h.getY()+h.getH()/2);
				g.setFont(new Font("",Font.PLAIN, 10));
				g.drawString(h.getRecode(), this.endX-50, h.getY()+h.getH()/2);
			}
		}
		if (this.isRun) {
			try {
				Thread.sleep(50);
				update();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		repaint();
	}// paintComponent
	
	private void update() {
		//5마리의 말들이 랜덤하게 점프
		// setX()
		
		//1번 update 할때에, 1마리만 골인할 수 있다
		boolean goal = false;
		
		for (int i = 0; i < SIZE; i++) {
			Horse h = this.horses[i];
			int jump = rn.nextInt(10)*3;
			
			int xx = h.getX()+jump;
			
			if (h.getState() == h.getRUN()) {
				if (xx>= this.endX && !goal) {
					xx = endX;
					h.setState(h.getGOAL());
					h.setRecode(String.format("%d.%03d", this.ms/1000, this.ms%1000));
					h.setRank(this.rank);
					this.rank++;
					goal = !goal;
				}else if (xx>= this.endX && goal) {
					i--;
					continue;
				}
				h.setX(xx);
			}
		}
	}//update
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.reset) {
			this.isRun = !this.isRun;
			this.reset.setText(this.isRun ? "reset" : "start");

			if (!this.isRun) {
				resetGame();
			}
		}
		
	}

	private void resetGame() {
		setHorse();
		this.ms = 0;
		this.timer.setText("REDAY");
		this.rank = 1;
	}

	@Override
	public void run() {
		while(true) {
			if (this.isRun) {
				this.ms++;
				this.timer.setText(String.format("%3d.%03d", this.ms/1000,this.ms%1000));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//while
		
	}
}// Content
