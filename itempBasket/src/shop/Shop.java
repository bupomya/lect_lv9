package shop;

import java.util.Scanner;

import itempBasketManager.ItemManager;
import itempBasketManager.UserManager;

public class Shop {
	static Scanner sc = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void mainMenu() {
		System.out.println("1.가입 2.탈퇴 3.로그인 4.로그아웃");
		int sel = sc.nextInt();
		if (sel == 1) {
			um.join();
		}else if (sel ==2) {
			
		}else if (sel ==3) {
			
		}else if (sel ==4) {
			
		}else {
			System.out.println("다시선택");
		}
	}
}
