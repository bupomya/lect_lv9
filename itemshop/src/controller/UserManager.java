package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class UserManager {
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	
	private String userId;
	private int userCode;
	private int userCnt;
	private int userLog = -1;
	
	ArrayList<String> ids = new ArrayList<String>();
	
	
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
				if (this.ids.get(i) == id) {
					check = true;
				}
			}
		}
		if (!check) {
			ids.add(id);
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
				if (ids.get(i) == id) {
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
		
	}//withdrawal
	
}//UserManager
