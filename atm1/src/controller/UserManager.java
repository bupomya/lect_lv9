package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Bank;
import models.User;

public class UserManager {
	public static UserManager instance = new UserManager();

	private UserManager() {
		User admin = new User(9999,"admin","0000","������");
		this.users.add(admin);
	}

	// users : �߾� (��) ������
	public ArrayList<User> users = new ArrayList<>();

	//
	public void joinUser() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		System.out.print("name : ");
		String name = Bank.sc.next();

		User newUser = new User(randomCode(), id, pw, name);
		this.users.add(newUser);
	}//joinUser

//	private int randomCode() {// �ߺ�ó��
//		Random rn = new Random();
//		int code = 0;
//		boolean check = false;
//		for (int i = 0; i < this.users.size(); i++) {
//			int rNum = rn.nextInt(8999) + 1000;
//			for (int j = 0; j < this.users.size(); j++) {
//				if (this.users.get(i).getUserCode() == code) {
//					check = true;
//				}
//			}
//			if (!check) {
//				code = rNum;
//			}
//		}
//		return code;
//	}//randomCode
	
	private int randomCode() {
		Random rn = new Random();
		while(true) {
			int ranCode = rn.nextInt(8999)+1000;
			boolean check = false;
			for(User user : this.users) {
				if (ranCode == user.getUserCode()) {
					check = true;
				}
			}
			if (!check) {
				return ranCode;
			}
		}
	}
	
	
	public void printAcc() {
		for (int i = 0; i < this.users.get(Bank.log).getAccCnt(); i++) {
			System.out.print(this.users.get(Bank.log).getAcc(i)+" / ");
		}
	}//printAcc

	public int login() {// �α���
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}// login

	public void accOpen() {//���� ����
		int accCnt = this.users.get(Bank.log).getAccCnt();
		if (accCnt<3) {
			this.users.get(Bank.log).setAcc(accCnt, randomCode());
			accCnt++;
			this.users.get(Bank.log).setAccCnt(accCnt);
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("��������� �����ϴ�");
		}
	}// addOpen

	public void deposit() {// �Ա�
		printAcc();
		System.out.println("�Ա��� ����");
		int acc = Bank.sc.nextInt();
		
		//
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < this.users.size(); i++) {
			for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
				if (this.users.get(i).getAcc(j)==acc) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		if (idx1 != -1 && idx2 != -2) {
			System.out.print("�Ա��� �ݾ� �Է� : ");
			int money = Bank.sc.nextInt();
			this.users.get(idx1).setAcc(idx2, money);
			System.out.println("�ԱݿϷ�");
		}else {
			System.out.println("�߸��� ���¹�ȣ");
		}

	}// deposit
	
	public void withdraw() {//���
		printAcc();
		System.out.println("����� ���� �Է�");
		int acc = Bank.sc.nextInt();
		
		//
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < this.users.size(); i++) {
			for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
				if (this.users.get(i).getAcc(j)==acc) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		if (idx1 != -1 && idx2 != -1) {
			System.out.print("����� �ݾ� �Է� : ");
			int money = Bank.sc.nextInt();
			if (this.users.get(idx1).getMoney(idx2)>=money) {
				int chaMoney = this.users.get(idx1).getMoney(idx2) - money;
				this.users.get(idx1).setMoney(idx2, chaMoney);
				System.out.println("��� �Ϸ�");
				System.out.println("�ܾ� : "+ chaMoney);
			}else {
				System.out.println("�ܾ� ����");
			}
		}
		
	}//withdraw

	public void transfer() {
		System.out.print("��ü�� ���� �Է� : ");
		int acc = Bank.sc.nextInt();

		//
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < this.users.size(); i++) {
			for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
				if (this.users.get(i).getAcc(j)==acc) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		
		if (idx1 != -1 && idx2 != -1) {
			System.out.print("��ü �ݾ� �Է� : ");
			int money = Bank.sc.nextInt();
		}else {
			System.out.println("�߸��� ���¹�ȣ");
		}
		
		
	}//transfer
	
}//UserManager
