package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	Scanner sc = new Scanner(System.in);
	String name;
	int price;
	String category;
	
	ArrayList<String> categorys = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();
	ArrayList<Integer> prices = new ArrayList<>();
	
	public void init() {
		this.categorys.add("����");
		this.names.add("�����");
		this.prices.add(1500);
	}//init
	
	public void printShop() {

	}//printShop
	
	
}//ItemManager
