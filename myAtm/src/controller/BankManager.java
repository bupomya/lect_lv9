package controller;

import model.Bank;

public class BankManager {

	public static BankManager instance = new BankManager();
	UserManager um = new UserManager();
	AccountManager am = new AccountManager();

	public void printMenu() {

		if (Bank.log == -1) {
			System.out.println("1.ȸ������\n2.�α���\n3.�����ڸ��");
			int sel = Bank.sc.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.login();
			} else if (sel == 3) {

			} else {
				System.out.println("�߸��� �޴�");
			}
		} else {
			System.out.println("1.���� ����\n2.��ŷ\n3.�α׾ƿ�\n4.���»���\n5.ȸ��Ż��");
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
			} else {
				System.out.println("�߸��� �޴�");
			}
		}

	}// printMenu

	public void selectMenu() {

	}// selectMenu
}
