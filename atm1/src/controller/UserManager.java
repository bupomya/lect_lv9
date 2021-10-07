package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Bank;
import models.User;

public class UserManager {
	public static UserManager instance = new UserManager();

	private UserManager() {
	}

	// users : �߾� (��) ������
	ArrayList<User> users = new ArrayList<>();

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

	private int randomCode() {// �ߺ�ó��
		Random rn = new Random();
		int code = 0;
		boolean check = false;
		for (int i = 0; i < this.users.size(); i++) {
			int rNum = rn.nextInt(8999) + 1000;
			for (int j = 0; j < this.users.size(); j++) {
				if (this.users.get(i).getUserCode() == code) {
					check = true;
				}
			}
			if (!check) {
				code = rNum;
			}
		}
		return code;
	}//randomCode
	
	public void printAcc() {
		for (int i = 0; i < this.users.get(Bank.log).accCnt(); i++) {
			System.out.print(this.users.get(Bank.log).getAcc(i)+" / ");
		}
	}

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

	public void accOpen() {
		if (this.users.get(Bank.log).accCnt()<3) {
			this.users.get(Bank.log).setAcc(Bank.log, randomCode());
		}else {
			System.out.println("��������� �����ϴ�");
		}
	}// addOpen

	public void deposit() {// �Ա�
		printAcc();
		System.out.println("�Ա��� ����");
		int acc = Bank.sc.nextInt();
		
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < this.users.size(); i++) {
			for (int j = 0; j < this.users.get(i).accCnt(); j++) {
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
	
	public void withdraw() {
		printAcc();
		System.out.println("����� ���� �Է�");
		int acc = Bank.sc.nextInt();
		int idx1 = -1;
		int idx2 = -1;
		
		//
		for (int i = 0; i < this.users.size(); i++) {
			for (int j = 0; j < this.users.get(i).accCnt(); j++) {
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

	
	
}
