package shop;

public class User {
	private String id;
	private int money;
	
	User(String id, int money){
		this.id = id;
		this.money = money;
	}//User
	
	void print() {
		System.out.printf("%s : %d",this.id,this.money);
	}
	
}//User
