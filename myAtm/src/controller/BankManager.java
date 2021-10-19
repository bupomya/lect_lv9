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
			System.out.println("1.회원가입\n2.로그인\n3.불러오기\n0.관리자모드");
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
				System.out.println("잘못된 메뉴");
			}
		} else {
			System.out.println("1.뱅킹\n2.계좌개설\n3.로그아웃\n4.계좌삭제\n5.회원탈퇴\n6.저장\n7.불러오기");
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
				System.out.println("잘못된 메뉴");
			}
		}
		}//while

	}// printMenu

	public void selectMenu() {

	}// selectMenu
}
