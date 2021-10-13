package shop;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void menu() {
		if (um.getUserLog() == -1) {
			mainMenu();
		}else {
			logMenu();
		}
	}
	
	public void mainMenu() {
		System.out.println("1.가입 2.로그인 3.로그아웃 4.탈퇴");
		int sel = sc.nextInt();
		
		if (sel == 1) {
			um.join();
		}else if (sel ==2) {
			um.login();
		}else if (sel ==3) {
			um.logOut();
		}else if (sel == 4) {
			
		}else {
			System.out.println("잘못된 메뉴");
		}
	}//mainMenu
	
	public void logMenu() {
		System.out.println("1.쇼핑 2.장바구니 0.뒤로가기");
		int sel = sc.nextInt();
		if (sel == 1) {
			
		}else if (sel == 2) {
			
		}else if (sel == 0) {
			
		} else {
			System.out.println("잘못된 메뉴");
		}
	}//logMenu
}//shop
