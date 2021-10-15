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
			User newUser = new User(id,pw,name,randomCode());
			System.out.println("가입 완료");
		}else {
			System.out.println("중복 id");
		}
	}//join
	
	private int randomCode() {
		int userCode = -1;
		boolean check = false;
		for (int i = 0; i < this.users.size(); i++) {
			int rNum = rn.nextInt(8999)+1000;
			for (User user : this.users) {
				if (user.getUserCode() == rNum) {
					check = true;
				}
			}
			if (check) {
				i = 0;
			}else {
				userCode = rNum;
			}
		}
		return userCode;
	}//randomCode
}//UserManager
