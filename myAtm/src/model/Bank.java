package model;

import java.util.Scanner;

public class Bank {
	public static Scanner sc = new Scanner(System.in);
	public static int log = -1;
	public static String name; // 은행이름
	
	private Bank() {}
	
	public static String getName() {
		return Bank.name;
	}//getName
	
	public static void setName(String name) {
		Bank.name = name;
	}//setName
	
}//Bank