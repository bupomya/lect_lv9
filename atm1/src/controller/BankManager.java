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
			System.out.println("1.�α���\n2.ȸ������\n3.����");
		}else {
			System.out.println("1.���� ����\n2.�Ա�\n3.���\n4.��ü\n5.��ȸ");
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
					//ȸ������ �޼ҵ带 ȣ��
					um.joinUser();
					//UserManager.instance.joinUser();
				}
			}else {
				
				if (sel == 1) {//���°���
					um.accOpen();
				}else if (sel == 2) {//�Ա�
					um.deposit();
				}else if (sel == 3) {//���
					
				}else if (sel ==4) {//��ü
					
				}else if (sel == 5) {//��ȸ
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�Է°� Ȯ��");
		}
		
	}//selectMenu
}
