package oneToFifty;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//타이머
//5*5
//랜덤판
//누르면 색바뀜
//두번째 누르면 버튼 사라짐

class OTF extends JPanel implements ActionListener{
	
	private JButton map[][] = new JButton[5][5];
	private int mapNum[][] = new int [5][5];
	
	public OTF(){
		setLayout(null);
		setBounds(0, 0, OTFFrame.SIZE, OTFFrame.SIZE);
		setMap();
//		shuffle();
	}//OTF	
	
	private void setMap() {
		int a = 1;
		int x = 200;
		int y = 200;
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				this.map[i][j] = new JButton();
				this.map[i][j].setBounds(x,y,100,100);
				this.map[i][j].setBackground(new Color(243, 240, 215));//rgb(52, 190, 130)
				this.map[i][j].addActionListener(this);
				this.map[i][j].setText(a+"");
				add(this.map[i][j]);
				a++;
				x+=100;
			}
			x = 200;
			y+=100;
		}
		for (int i = 0; i < this.mapNum.length; i++) {
			for (int j = 0; j < this.mapNum.length; j++) {
				this.mapNum[i][j] = a;
				a++;
			}
		}
		
		
		
		
	}//setMap
	
	private void shuffle() {
		Random rn = new Random();
		for (int i = 0; i < 1000; i++) {
			int rX = rn.nextInt(this.map.length);
			int rY = rn.nextInt(this.map.length);
			String temp = this.map[0][0].getText();
			this.map[0][0].setText(this.map[rY][rX].getText());
			this.map[rY][rX].setText(temp);
		}
		for (int i = 0; i < 1000; i++) {
			int rX = rn.nextInt(this.mapNum.length);
			int rY = rn.nextInt(this.mapNum.length);
			int temp = mapNum[0][0];
			mapNum[0][0] = mapNum[rY][rX];
			mapNum[rY][rX] = temp;
		}
		
	}//shuffle

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				if (target == this.map[i][j]) {
					this.map[i][j].setText(this.mapNum[i][j]+"");
				}else if (target.getText().equals(String.valueOf(mapNum[i][j]))) {
					//버튼 지우기
					
				}
				
			}
		}
		
		
	}//actionPerformed
	
}//OTF


class OTFFrame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int width = dm.width;
	public static int height = dm.height;
	
	public final static int SIZE = 900;
	
	public OTFFrame() {
		setLayout(null);
//		super("One to fifty");
		setTitle("One to fifty");
		setBounds(width/2-SIZE/2,height/2-SIZE/2,SIZE,SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new OTF());
		
		setVisible(true);
		revalidate();
	}//OTFFrame
	
	
	
}//OTFFrame

public class OneToFifty {
	public static void main(String[] args) {
		OTFFrame frame = new OTFFrame();
	}
}
