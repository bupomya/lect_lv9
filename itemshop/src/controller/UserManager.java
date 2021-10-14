package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import shop.User;


public class UserManager {
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	

	private int userCnt;
	private int userLog = -1;
	
	ArrayList<User> ids = new ArrayList<>();
	
	
	public int getUserLog() {
		return this.userLog;
	}//getUserLog
	
	
	//method
	public void join() {
		System.out.print("������ id �Է� :");
		String id = sc.next();
		boolean check = false;
		if (this.userCnt != 0) {
			for (int i = 0; i < this.userCnt; i++) {
				if (this.ids.get(i).getUserId().equals(id)) {
					check = true;
				}
			}
		}
		if (!check) {
			
			this.userCnt++;
			System.out.println("���ԿϷ�");
		}else {
			System.out.println("�ߺ��� id");
		}
	}//join
	
	public void login() {
		if (this.userCnt != 0) {			
			System.out.print("id�Է� : ");
			String id = sc.next();
			for (int i = 0; i < this.userCnt; i++) {
				if (this.ids.get(i).getUserId().equals(id)) {
					this.userLog = i;
				}
			}
			if (this.userLog !=  -1) {
				System.out.println("�α��� �Ϸ�");
			}else {
				System.out.println("id �ٽ� Ȯ��");
			}
		}else {
			System.out.println("���� ������ �����ϴ�");
		}
		
	}//login
	public void logOut() {
		this.userLog = -1;
	}//logOut
	
	public void withdrawal() {
		System.out.println("Ż���� id");
		String delId = sc.next();
		int idx = -1;
		for (int i = 0; i < this.userCnt; i++) {
			if (this.ids.get(i).getUserId().equals(delId)) {
				idx = i;
			}
		}
		if (idx!=-1) {
			ids.set(idx, null);
		}else {
			System.out.println("id�ٽ� Ȯ��");
		}
	}//withdrawal
	
}//UserManager
