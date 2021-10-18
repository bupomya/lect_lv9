package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Bank;
import model.User;

public class UserManager {
	Random rn = new Random();
	
	public static UserManager instance =  new UserManager();
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
			this.users.add(newUser);
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
	
	public void logout() {
		Bank.log = -1;
	}//logout
	
	public void secession() {
		System.out.print("delete id : ");
		String delId = Bank.sc.next();
		int idx = -1;
		for (int i = 0; i < this.getUsersSize(); i++) {
			if (this.users.get(i).getId() == delId) {
				idx = i;
			}
		}
		if (idx!=-1) {
			this.users.set(idx, null);
			System.out.println("Ż��Ϸ�");
		}else {
			System.out.println("id�ٽ�Ȯ��");
		}
	}//secession
	
	
	
	
	//<<<<<<<<<<<<<<<
	
	public User getUser(int log) {
		return this.users.get(log);
	}//getUser
	public int getUsersSize() {
		return this.users.size();
	}//getUsersSize
	public void addUser(User user) {
		this.users.add(user);
	}//addUser
	
}// UserManager
