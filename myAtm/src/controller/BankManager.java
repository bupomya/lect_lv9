package controller;

import model.Bank;

public class BankManager {
	
	BankManager instance = new BankManager();
	UserManager um = new UserManager();
	AccountManager am = new AccountManager();
	
	public void printMenu() {
		
		if (Bank.log!=-1) {			
			System.out.println("1.ȸ������\n2.�α���\n3.�����ڸ��");
			int sel = Bank.sc.nextInt();
			if (sel == 1) {
				um.join();
			}else if (sel == 2) {
				
			}else if (sel == 3) {
				
			}else {
				System.out.println("�߸��� �޴�");
			}
		}else {
			System.out.println("1.���� ����\n2.��ŷ\n3.ȸ��Ż��\n4.���»���");
			int sel = Bank.sc.nextInt();
			if (sel == 1) {
				
			}else if (sel == 2) {
				
			}else if (sel == 3) {
				
			}else if (sel ==4) {
				
			}else {
				System.out.println("�߸��� �޴�");
			}
		}
		
	}//printMenu
	
	public void selectMenu() {
		
	}//selectMenu
}
