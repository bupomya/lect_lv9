package controller;

import models.Bank;

public class BankManager {

private UserManager um = UserManager.instance;
private AccountManager am = AccountManager.intstance;
	
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
			System.out.println("1.로그인\n2.회원가입/회원탈퇴\n3.종료");
		}else {
			System.out.println("1.계좌 개설\n2.입금\n3.출금\n4.이체\n5.조회");
		}
		
		if (Bank.log == 0) {
			System.out.println("8.관리자");
		}
	}//printMenu
	
	private boolean selectMenu() {
		String input = Bank.sc.next();
		try {
			int sel = Integer.parseInt(input);
			if (Bank.log == -1) {
				if (sel == 1) {
					Bank.log = um.login();
				}else if (sel ==2) {
					//회원가입 메소드를 호출
					System.out.println("1.회원가입\n2.회원탈퇴");
					sel = Bank.sc.nextInt();
					if (sel == 1) {						
						um.joinUser();
					}else if (sel == 2) {
						
					}else if (sel == 3) {
						//종료
						return false;
					}else {
						System.out.println("잘못된 메뉴");
					}
					//UserManager.instance.joinUser();
					return true;
				}
			}else {
				
				if (sel == 1) {//계좌개설
					um.accOpen();
				}else if (sel == 2) {//입금
					um.deposit();
				}else if (sel == 3) {//출금
					um.withdraw();
				}else if (sel ==4) {//이체
					um.transfer();
				}else if (sel == 5) {//조회
					
				}else if (sel == 6) {//관리자 모드
					
				}
			}
			if (sel == 8 && Bank.log == 0) {
				System.out.println("1.전체유저조회\n2.전체계좌조회");
				selectAdmin();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("입력값 확인");
		}
		
		private void selectAdmin() {
			String input = Bank.sc.next();
			
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					um.printAllData();
				}else if (sel == 2) {
					um.printAllData();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}//selectMenu
}
