package shop;

import controller.ItemManager;

public class Item {
	
	String name;
	int price;
	String category;
	
	public Item(String name, int price, String category){
		this.name = name;
		this.price = price;
		this.category = category;
	}//Item
	
	public void printItem() {
		System.out.printf("%s / %d / %s", this.price,this.name,this.category);
	}//printItem
	
}//Item
