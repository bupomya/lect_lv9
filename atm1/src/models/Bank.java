package models;

import java.util.Scanner;

public class Bank {
	public static Scanner sc = new Scanner(System.in);
	public static int log = -1; // �α�����
	
	private static String name;
	
	private Bank() {} // new �� ���� Bank ������ �ȵǰ� ����
	
	public static String getName() {
		return Bank.name;
	}
	
	public static void setName(String name) {
		Bank.name = name;
	}
}
