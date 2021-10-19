package controller;

import model.Bank;

public class BankManager {

	public static BankManager instance = new BankManager();
	UserManager um = new UserManager();
	AccountManager am = new AccountManager();
	FileManager fm = new FileManager();

	public void printMenu() {
		while(true) {
		if (Bank.log == -1) {
			System.out.println("1.ȸ������\n2.�α���\n3.�ҷ�����\n0.�����ڸ��");
			int sel = Bank.sc.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.login();
			} else if (sel == 3) {
				fm.load();
			}
			
			
			
			else if (sel == 0) {

			} else {
				System.out.println("�߸��� �޴�");
			}
		} else {
			System.out.println("1.��ŷ\n2.���°���\n3.�α׾ƿ�\n4.���»���\n5.ȸ��Ż��\n6.����\n7.�ҷ�����");
			int sel = Bank.sc.nextInt();
			if (sel == 1) {

			} else if (sel == 2) {
				am.createAcc();
			} else if (sel == 3) {
				um.logout();
			} else if (sel == 4) {
				am.deleteAcc();
			}else if (sel == 5) {
				um.secession();
			}else if (sel == 6) {
				fm.save();
			}else if (sel == 7) {
				
			} else {
				System.out.println("�߸��� �޴�");
			}
		}
		}//while

	}// printMenu

	public void selectMenu() {

	}// selectMenu
}
