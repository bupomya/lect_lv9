package oneToFifty;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//타이머
//5*5
//랜덤판
//누르면 색바뀜
//두번째 누르면 버튼 사라짐

class OTF extends JPanel{
	
	private JButton map[][] = new JButton[5][5];
	
	public OTF(){
		
	}//OTF	
	
	private void setMap() {
		Random rn = new Random();
		int a = 1;
		
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				map[i][j] = new JButton();
				
			}
		}
	}//setMap
	
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
		
		setVisible(true);
		revalidate();
	}//OTFFrame
	
	
	
}//OTFFrame

public class OneToFifty {
	public static void main(String[] args) {
		OTFFrame frame = new OTFFrame();
	}
}
