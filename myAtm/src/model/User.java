package model;

public class User {
	private String id;
	private String pw;
	private String name;
	private int userCode;
	private int accCnt;
	
	public User(String id, String pw, String name, int userCode) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.userCode = userCode;
	}//User
	
	public String getId() {
		return this.id;
	}//getId
	public String getPw() {
		return this.pw;
	}//getPw
	public String getName() {
		return this.name;
	}//getName
	public int getUserCode() {
		return this.userCode;
	}//getUserCode
	public int getAccCnt() {
		return this.accCnt;
	}//getAccCnt
	
	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}//setAccCnt
	
	
}//User
