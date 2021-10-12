package shop;

public class Item {
	String name;
	int price;
	String category;
	public Item() {}
	
	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}//Item
	
	public void print() {
		System.out.printf("%s / %d / %s", this.category,this.price,this.name);
	}//print
}//Item
