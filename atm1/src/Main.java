
import controller.BankManager;
import models.Bank;

public class Main {
	public static void main(String[] args) {
		/*
		 * atm
		 * 
		 * 1. ȸ������/Ż��
		 * 2.�α���
		 * 3.���°���/öȸ(ȸ���� 3�� ���� ����)
		 * 4.��ŷ���(�Ա�/���/��ü/��ȸ)
		 * 5.����ó��(����/�ε�)
		 * 6.�����ڸ��(admin/0000 -> ��ü���� ��ȸ/��ü������ȸ
		 * 
		 */
		
		/*
		 * models package �ȿ� ��üȭ�� Ŭ�������� ����
		 * User
		 * Account
		 * Bank
		 */
		
		/*
		 * controller package �ȿ� ��ü ó���� �� ���(�޼ҵ�) ����
		 *  �� UserManager(User type ArrayList)
		 *  �� AccountManager(Account type ArryaList)
		 *  �� BankManager
		 *  �� FileManager
		 */
		
		Bank.setName("GREEN");
		BankManager.instance.run();
	}
}
