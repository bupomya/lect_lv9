package shop;

import java.util.Scanner;

import itempBasketManager.ItemManager;
import itempBasketManager.UserManager;

public class Shop {
	static Scanner sc = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void mainMenu() {
		System.out.println("1.���� 2.Ż�� 3.�α��� 4.�α׾ƿ�");
		int sel = sc.nextInt();
		if (sel == 1) {
			um.join();
		}else if (sel ==2) {
			
		}else if (sel ==3) {
			
		}else if (sel ==4) {
			
		}else {
			System.out.println("�ٽü���");
		}
	}
}
