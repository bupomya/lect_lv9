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

		
	}// addOpen

	public void deposit() {// �Ա�
		System.out.println("�Ա��� ����");
		String acc = Bank.sc.next();

		for (int i = 0; i < this.users.size(); i++) {

		}

	}// deposit

}
