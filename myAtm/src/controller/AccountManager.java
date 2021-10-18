package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Account;
import model.Bank;
import model.User;

public class AccountManager {

	public static AccountManager instance = new AccountManager();
	
	ArrayList<Account> ac = new ArrayList<>();
	private UserManager um = UserManager.instance;
	
	public void createAcc() {
		int userCode = um.getUser(Bank.log).getUserCode();
		int cnt =um.users.get(Bank.log).getAccCnt(); 
		if (cnt<3) {
			this.ac.add(new Account(createAccNum(),userCode));
			ac.get(Bank.log).setUserCode(createAccNum());
			um.getUser(Bank.log).setAccCnt(++cnt);
		}else {
			System.out.println("최대개설 계좌 초과");
		}
	}//createAcc
	
	public int createAccNum() {
		Random rn = new Random();
		while(true) {
			int accNum = rn.nextInt(899999)+100000;
			boolean check = false;
			for(Account acc : this.ac) {
				if (accNum == acc.getAccNum()) {
					check = true;
				}
			}
			if (!check) {
				return accNum;
			}
			
		}//while
	}//createAccNum
	
	public void deleteAcc() {
		System.out.print("delete Acc : ");
		int acc = Bank.sc.nextInt();
		int idx = -1;
		for(int i = 0; i<ac.size();i++) {
			if (ac.get(i).getUserCode() == acc) {
				idx = i;
			}
		}
		if (idx != -1) {
			ac.set(idx, null);
			System.out.println("삭제 완료");
		}
	}//deleteAcc
	
	
	
}//AccountManager
	