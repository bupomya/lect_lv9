package horse;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	
	private final int RUN = 0;
	private final int GOAL = 1;
	private int num;
	private int x,y,w,h;
	
	private String fileName;
	private ImageIcon icon;
	
	private int state; // 1RUN, 2GOAL
	private int rank;
	private String recode;
	
	
	public Horse(int num ,int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images_race/horse%d.png",this.num);
		this.icon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}//Horse()


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
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


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public ImageIcon getIcon() {
		return icon;
	}


	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getRecode() {
		return recode;
	}


	public void setRecode(String recode) {
		this.recode = recode;
	}
	
	
	public int getRUN() {
		return RUN;
	}


	public int getGOAL() {
		return GOAL;
	}
	
	
}//Horse
