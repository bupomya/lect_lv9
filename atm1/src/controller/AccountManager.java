package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Account;
import models.Bank;
import models.User;

public class AccountManager {
	
	private UserManager um = UserManager.instance;
	public static AccountManager intstance = new AccountManager();
	
	private ArrayList<Account> accs = new ArrayList<>();
	
	public void createAcc() {
		//���� �α��� ���� ȸ����
		//������ ������ ���� Ȯ���� �ǰ�
		//������ ���� Account.MAX ���� ��������
		//ó���� �ΰ����� ������ 
		
		int userCode = um.users.get(Bank.log).getUserCode();
		
//		int cnt = 0;
//		for (Account acc : accs) {
//			if (userCode == acc.getUserCode()) {
//				cnt++;
//			}
//		}
		int cnt = um.users.get(Bank.log).getAccCnt();
		if (cnt<3) {
			this.accs.add(new Account(randomCode(), userCode));
			um.users.get(Bank.log).setAccCnt(++cnt);
			System.out.print("���»��� �Ϸ�");
		}else {
			System.out.println("�����Ұ�");
		}
	}
	
	public void deleteAcc() {
		printAccs();
		System.out.print("������ ���� ���� : ");
		String input = Bank.sc.next();
		int delIdx = findIndex(input);
		if (delIdx != -1) {
			this.accs.remove(delIdx);
			um.users.get(Bank.log).setAccCnt(--cnt);
			System.out.println("���� öȸ �Ϸ�");
		}
//		try {
//			int userCode = um.users.get(Bank.log).getUserCode();
//			int cnt = um.users.get(Bank.log).getAccCnt();
//			
//			int num = Integer.parseInt(input)-1;
//			
//			if (num>=0 && num<cnt) {
//				int delIdx = -1;
//				int tempCnt = 0;
//				for (int i = 0; i < this.accs.size(); i++) {
//					if (userCode == this.accs.get(i).getUserCode()) {
//						delIdx = i;
//						tempCnt++;
//						if (tempCnt == num) {
//							break;
//						}
//					}
//				}
//				this.accs.remove(delIdx);
//				um.users.get(Bank.log).setAccCnt(--cnt);
//				System.out.println("���� öȸ �Ϸ�");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	
	private int randomCode() {
		Random rn = new Random();
		while(true) {
			int ranCode = rn.nextInt(8999)+1000;
			boolean check = false;
					for(int i = 0; i<this.accs.size();i++) {
						if (ranCode == accs.get(i).getAccNum()) {
						System.out.print(i+1+") ");
						System.out.println(accs.get(i));
					check = true;
				}
			}
			if (!check) {
				return ranCode;
			}
		}
	}
	private int findIndex(String input) {
		int index = -1;
		try {
			int userCode = um.users.get(Bank.log).getUserCode();
			int cnt = um.users.get(Bank.log).getAccCnt();
			
			int num = Integer.parseInt(input)-1;
			
			if (num>=0 && num<cnt) {
				int delIdx = -1;
				int tempCnt = 0;
				for (int i = 0; i < this.accs.size(); i++) {
					if (userCode == this.accs.get(i).getUserCode()) {
						index = i;
						tempCnt++;
						if (tempCnt == num) {
							break;
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return index;
	}
	
	public void inputMoany() {}
	public void outMoney() {}
	public void withdraw() {}
	
}
