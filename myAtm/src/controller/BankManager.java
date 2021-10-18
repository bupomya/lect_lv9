package controller;

import model.Bank;

public class BankManager {

	public static BankManager instance = new BankManager();
	UserManager um = new UserManager();
	AccountManager am = new AccountManager();

	public void printMenu() {

		if (Bank.log == -1) {
			System.out.println("1.회원가입\n2.로그인\n3.관리자모드");
			int sel = Bank.sc.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.login();
			} else if (sel == 3) {

			} else {
				System.out.println("잘못된 메뉴");
			}
		} else {
			System.out.println("1.계좌 개설\n2.뱅킹\n3.로그아웃\n4.계좌삭제\n5.회원탈퇴");
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
				System.out.println("잘못된 메뉴");
			}
		}

	}// printMenu

	public void selectMenu() {

	}// selectMenu
}
