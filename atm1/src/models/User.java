package models;

public class User {
	private int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	private Integer acc[] = new Integer[3];
	private Integer money[] = new Integer[3];
	//보유계좌의 객체 주소 배열
	
	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
				
	}
	
	public String getId() {
		return this.id;
	}//getId
	public String getPw() {
		return this.pw;
	}//getPw
	public int getUserCode() {
		return this.userCode;
	}//getUserCode
	public int accCnt() {
		return this.accCnt;
	}//accCnt
	public int getAcc(int idx) {
		return this.acc[idx];
	}//getAcc
	public int getMoney(int idx) {
		return this.money[idx];
	}
	
	public void setAcc(int idx, int data) {
		this.acc[idx] = data;
	}
	public void setMoney(int idx, int data) {
		this.money[idx] = data;
	}
}
