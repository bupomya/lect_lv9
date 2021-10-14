package shop;

public class Cart {
	String userId;
	String itemName;
	
	public void printCart() {
		System.out.printf("%s / %s",this.userId,this.itemName);
	}//printCart
}//Cart
