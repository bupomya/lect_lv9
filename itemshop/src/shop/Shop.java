package shop;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void mainMenu() {
		System.out.println("1.���� 2.�α��� 3.�α׾ƿ� 4.Ż��");
		int sel = sc.nextInt();
		
		if (sel == 1) {
			um.join();
		}else if (sel ==2) {
			um.login();
		}else if (sel ==3) {
			um.logOut();
		}else if (sel == 4) {
			
		}else {
			System.out.println("�߸��� �޴�");
		}
	}//mainMenu
}//shop
