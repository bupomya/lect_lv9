package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Bank;
import models.User;

public class UserManager {
	public static UserManager instance = new UserManager();

	private UserManager() {
		User admin = new User(9999,"admin","0000","관리자");
		this.users.add(admin);
	}

	// users : 중앙 (총) 데이터
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

//	private int randomCode() {// 중복처리
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

	public int login() {// 로그인
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

	public void accOpen() {//계좌 개설
		int accCnt = this.users.get(Bank.log).getAccCnt();
		if (accCnt<3) {
			this.users.get(Bank.log).setAcc(accCnt, randomCode());
			accCnt++;
			this.users.get(Bank.log).setAccCnt(accCnt);
			System.out.println("개설 완료");
		}else {
			System.out.println("저장공간이 없습니다");
		}
	}// addOpen

	public void deposit() {// 입금
		printAcc();
		System.out.println("입금할 계좌");
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
			System.out.print("입금할 금액 입력 : ");
			int money = Bank.sc.nextInt();
			this.users.get(idx1).setAcc(idx2, money);
			System.out.println("입금완료");
		}else {
			System.out.println("잘못된 계좌번호");
		}

	}// deposit
	
	public void withdraw() {//출금
		printAcc();
		System.out.println("출금할 계좌 입력");
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
			System.out.print("출금할 금액 입력 : ");
			int money = Bank.sc.nextInt();
			if (this.users.get(idx1).getMoney(idx2)>=money) {
				int chaMoney = this.users.get(idx1).getMoney(idx2) - money;
				this.users.get(idx1).setMoney(idx2, chaMoney);
				System.out.println("출금 완료");
				System.out.println("잔액 : "+ chaMoney);
			}else {
				System.out.println("잔액 부족");
			}
		}
		
	}//withdraw

	public void transfer() {
		System.out.print("이체할 계좌 입력 : ");
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
			System.out.print("이체 금액 입력 : ");
			int money = Bank.sc.nextInt();
		}else {
			System.out.println("잘못된 계좌번호");
		}
		
		
	}//transfer
	
}//UserManager
