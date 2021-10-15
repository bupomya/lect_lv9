package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Bank;
import model.User;

public class UserManager {
	Random rn = new Random();

	ArrayList<User> users = new ArrayList<>();

	public void join() {
		System.out.print("join id : ");
		String id = Bank.sc.next();
		System.out.print("join pw : ");
		String pw = Bank.sc.next();
		System.out.print("join name : ");
		String name = Bank.sc.next();

		boolean check = false;
		for (User user : this.users) {
			if (user.getId().equals(id)) {
				check = true;
			}
		}

		if (!check) {
			User newUser = new User(id, pw, name, randomCode());
			System.out.println("���� �Ϸ�");
		} else {
			System.out.println("�ߺ� id");
		}
	}// join

	private int randomCode() {
		int userCode = -1;
		boolean check = false;
		for (int i = 0; i < this.users.size(); i++) {
			int rNum = rn.nextInt(8999) + 1000;
			for (User user : this.users) {
				if (user.getUserCode() == rNum) {
					check = true;
				}
			}
			if (check) {
				i = 0;
			} else {
				userCode = rNum;
			}
		}
		return userCode;
	}// randomCode

	public void login() {
		System.out.print("login ID : ");
		String id = Bank.sc.next();
		System.out.print("login PW : ");
		String pw = Bank.sc.next();

		int idx = -1;
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getId().equals(id) && this.users.get(i).getPw().equals(pw)) {
				idx = i;
			}
		}

		if (idx != -1) {
			System.out.println("login�Ϸ�");
			Bank.log = idx;
		} else {
			System.out.println("id�Ǵ� pwȮ��");
		}
	}// login

}// UserManager
