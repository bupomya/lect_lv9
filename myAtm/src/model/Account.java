package model;

public class Account {
	private int accNum;
	private int money;
	private int userCode;
	
	public Account(int accNum) {
		this.accNum = accNum;
		this.money = 5000;
	}//Account
	
	
	public Account(int accNum, int userCode) {
		this.accNum = accNum;
		this.userCode = userCode;
	}//Account
	
	
	
	public int getAccNum() {
		return this.accNum;
	}//getAccNum
	public int getMoney() {
		return this.money;
	}//getMoney
	public void setMoeny(int money) {
		this.money = money;
	}//setMoney
	
}//Account
