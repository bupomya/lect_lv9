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
			System.out.println("1.�α���\n2.ȸ������/ȸ��Ż��\n3.����");
		}else {
			System.out.println("1.���� ����\n2.�Ա�\n3.���\n4.��ü\n5.��ȸ");
		}
		
		if (Bank.log == 0) {
			System.out.println("8.������");
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
					//ȸ������ �޼ҵ带 ȣ��
					System.out.println("1.ȸ������\n2.ȸ��Ż��");
					sel = Bank.sc.nextInt();
					if (sel == 1) {						
						um.joinUser();
					}else if (sel == 2) {
						
					}else if (sel == 3) {
						//����
						return false;
					}else {
						System.out.println("�߸��� �޴�");
					}
					//UserManager.instance.joinUser();
					return true;
				}
			}else {
				
				if (sel == 1) {//���°���
					um.accOpen();
				}else if (sel == 2) {//�Ա�
					um.deposit();
				}else if (sel == 3) {//���
					um.withdraw();
				}else if (sel ==4) {//��ü
					um.transfer();
				}else if (sel == 5) {//��ȸ
					
				}else if (sel == 6) {//������ ���
					
				}
			}
			if (sel == 8 && Bank.log == 0) {
				System.out.println("1.��ü������ȸ\n2.��ü������ȸ");
				selectAdmin();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�Է°� Ȯ��");
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
