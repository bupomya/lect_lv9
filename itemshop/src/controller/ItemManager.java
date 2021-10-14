package controller;

import java.util.ArrayList;
import java.util.Scanner;

import shop.Cart;
import shop.Item;

public class ItemManager {
	Scanner sc = new Scanner(System.in);

	ArrayList<String> category = new ArrayList<>();
	ArrayList<Item> itemList = new ArrayList<>();
	ArrayList<Cart> jangList = new ArrayList<>();
	
	public void init() {
		this.category.add("과자");
		Item temp = new Item("빅파이", 1000 , this.category.get(0));
		this.itemList.add(temp);
	}//init
	
	public void printJang() {
		for (int i = 0; i < this.jangList.size(); i++) {
			this.jangList.get(i).printCart();
		}
	}//printShop
	
	public void printCategory() {
		for (int i = 0; i < this.category.size(); i++) {
			System.out.printf("%d. %s",i+1,this.category.get(i));
		}
	}//printCategory
	
	public void printItem() {
		for (int i = 0; i < this.itemList.size(); i++) {
			this.itemList.get(i).printItem();
		}
	}//printItem
	
	public void addItem() {
		System.out.println("추가할 아이템");
		String item = sc.next();
		
	}//addItem
	
}//ItemManager
