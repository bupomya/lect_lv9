package controller;

import models.Bank;

public class BankManager {

private UserManager um = UserManager.instance;
	
	public static BankManager instance = new BankManager();
	private BankManager() {}
	
	public void run() {
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.getName()+"ATM");
			printMenu();
			selectMenu();
		}
	}//run
	
	private void printMenu() {
		if (Bank.log == -1) {			
			System.out.println("1.로그인\n2.회원가입\n3.종료");
		}else {
			System.out.println("1.계좌 개설\n2.입금\n3.출금\n4.이체\n5.조회");
		}
	}//printMenu
	
	private void selectMenu() {
		String input = Bank.sc.next();
		try {
			int sel = Integer.parseInt(input);
			if (Bank.log == -1) {
				if (sel == 1) {
					Bank.log = um.login();
				}else if (sel ==2) {
					//회원가입 메소드를 호출
					um.joinUser();
					//UserManager.instance.joinUser();
				}
			}else {
				
				if (sel == 1) {//계좌개설
					um.accOpen();
				}else if (sel == 2) {//입금
					um.deposit();
				}else if (sel == 3) {//출금
					
				}else if (sel ==4) {//이체
					
				}else if (sel == 5) {//조회
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("입력값 확인");
		}
		
	}//selectMenu
}
