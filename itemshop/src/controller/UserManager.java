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
		System.out.print("가입할 id 입력 :");
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
			System.out.println("가입완료");
		}else {
			System.out.println("중복된 id");
		}
	}//join
	
	public void login() {
		if (this.userCnt != 0) {			
			System.out.print("id입력 : ");
			String id = sc.next();
			for (int i = 0; i < this.userCnt; i++) {
				if (this.ids.get(i).getUserId().equals(id)) {
					this.userLog = i;
				}
			}
			if (this.userLog !=  -1) {
				System.out.println("로그인 완료");
			}else {
				System.out.println("id 다시 확인");
			}
		}else {
			System.out.println("가입 정보가 없습니다");
		}
		
	}//login
	public void logOut() {
		this.userLog = -1;
	}//logOut
	
	public void withdrawal() {
		System.out.println("탈퇴할 id");
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
			System.out.println("id다시 확인");
		}
	}//withdrawal
	
}//UserManager
