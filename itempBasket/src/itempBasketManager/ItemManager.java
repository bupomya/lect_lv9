package itempBasketManager;

import java.util.ArrayList;

import shop.Basket;
import shop.Item;

public class ItemManager {
	public static Item instance = new Item();
	public static Basket instance1 = new Basket();
	ArrayList<String> category = new ArrayList<>();
	ArrayList<Item> item = new ArrayList<>();
	ArrayList<Basket> cart = new ArrayList<>();
	
	
}
