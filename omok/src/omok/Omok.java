package omok;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class OmokGame extends JPanel implements ActionListener{
	private final int SIZE = 10;
	private JButton om[][] = new JButton[SIZE][SIZE];
	private int checkOm[][] = new int[SIZE][SIZE];
	private int x = 50;
	private int y = 50;
	private int turn = 1;
	private int win = 0;
	
	public OmokGame() {
		setLayout(null);
		setBounds(250, 250, 500, 500);
		setMap();
		checkWin();
		if (this.win!= 0) {
			System.out.println("qwer");
		}
	}//OmokGame
	
	private void setMap() {
		for (int i = 0; i < this.SIZE; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				this.om[i][j] = new JButton();
				this.om[i][j].setBounds(x,y,50,50);
				this.om[i][j].setBackground(new Color(243, 240, 215));
				this.om[i][j].addActionListener(this);
				
				add(this.om[i][j]);
				
				x+=50;
			}
			x = 50;
			y+=50;
		}
	}//setMap
	
	
	private void checkWin() {
		checkWidth();
		checkVert();
		checkDia();
		checkRevers();

	}//checkWin
	private void checkWidth() {		// -		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE-4; j++) {
				if (this.checkOm[i][j] == this.turn && this.checkOm[i][j+1] == this.turn && 
						this.checkOm[i][j+2] == this.turn && this.checkOm[i][j+3] == this.turn &&
						this.checkOm[i][j+4] == this.turn) {
					this.win = this.turn;
				}
			}
		}
	}//checkWidth
	
	private void checkVert() {		// |
		for (int i = 0; i < this.SIZE-4; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				if (this.checkOm[i][j]== this.turn && this.checkOm[i+1][j] == this.turn &&
						this.checkOm[i+2][j] == this.turn && this.checkOm[i+3][j] == this.turn &&
						this.checkOm[i+4][j] == this.turn) {
					this.win = this.turn;
				}
			}
		}
	}//checkHight
	
	/*
	 * 00	01	02	03	04	05	06
	 * 10	11	12	13	14	15	16
	 * 20	21	22	23	24	25	26
	 * 30	31	32	33	34	35	36
	 * 40	41	42	43	44	45	46
	 * 50	51	52	53	54	55	56
	 * 60	61	62	63	64	65	66
	 */
	
	private void checkDia() {		// \
		for (int i = 0; i < this.SIZE-4; i++) {
			for (int j = 0; j < this.SIZE-4; j++) {
				if (this.checkOm[i][j] == this.turn && this.checkOm[i+1][j+1] == this.turn &&
						this.checkOm[i+2][j+2] == this.turn && this.checkOm[i+3][j+3] == this.turn &&
						this.checkOm[i+4][j+4] == this.turn) {
					this.win = this.turn;
				}
			}
		}
	}//checkDia

	private void checkRevers() {	// /
		for (int i = 0; i < this.SIZE-4; i++) {
			for (int j = 4; j < this.SIZE; j++) {
				if (this.checkOm[i][j] == this.turn && this.checkOm[i+1][j-1] == this.turn &&
						this.checkOm[i+2][j=2] == this.turn && this.checkOm[i+3][j-3] == this.turn &&
						this.checkOm[i+4][j-4] == this.turn) {
					this.win = this.turn;
				}
			}
		}
		
		
	}//checkRevers



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < this.SIZE; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				if (target == this.om[i][j]) {
					if (this.turn == 1 && this.checkOm[i][j] == 0) {
						target.setBackground(new Color(000,000,000));
						this.checkOm[i][j] = 1;
						this.turn = 2;
					}else if (this.turn ==2&& this.checkOm[i][j] == 0) {
						target.setBackground(new Color(238,238,238));
						this.checkOm[i][j] = 2;
						this.turn = 1;
					}
				}
			}
		}
		
	}//actionperformed
	
	
}//OmokGame

class OmokFrame extends JFrame{
	OmokGame game = new OmokGame();
	public OmokFrame() {
		super("¿À¸ñ");
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(game);
		
		setVisible(true);
		revalidate();
	}//OmokFrame
}//OmokFrame

public class Omok {
	public static void main(String[] args) {
		OmokFrame frame = new OmokFrame();
	}
}
