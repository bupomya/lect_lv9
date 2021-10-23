package level10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//������(����) ����
// �� ������ ����
// . Singleton Pattern
// . ������ ��ü�� �����ϰ� -> Ÿ Ŭ�������� �����ϰ� ������ ��ü�� instance�� ������ �� �ְ� �ϴ� ��

class User {
	private String id;
	private String pw;
	private String name;

	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}// User
}// User

class UserManager {
	// UserManager�� instance�� �����ؾ� �Ѵ�.

	// Singleton
	// 1. ������ instance�� Ŭ���� ���ο��� ����
	private static UserManager instance = new UserManager();

	// 2. �����ڴ� private ó��(Ÿ Ŭ�������� newŰ���带 ���� �Ǵٸ� ������ X)
	private UserManager() {
	}

	// ������ instance�� ���� getter
	public static UserManager getInstance() {
		return instance;
	}// getInstance

	// �߾� ������
	private ArrayList<User> users = new ArrayList<>();

}// UserManager


public class Ex {
	public static void main(String[] args) {
		UserManager um = UserManager.getInstance();

		// �ð��� ���� ó��
		// ��ü Ȱ�� -> ����

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);

		// �� �� �� ���� �� �� �� �и���
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH)); // 0~ ���� ī��Ʈ
		System.out.println(calendar.get(calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(calendar.DAY_OF_WEEK)); // ��1 ��2 ȭ3 ��4
		System.out.println(calendar.get(calendar.HOUR));
		System.out.println(calendar.get(calendar.MINUTE));
		System.out.println(calendar.get(calendar.SECOND));
		System.out.println(calendar.get(calendar.MILLISECOND));
		System.out.println(calendar.get(calendar.DAY_OF_WEEK));

		// �ý��� �ð� ��������
		// �ð� ���� : �и��ʷ� ��ȯ (1970�� 1�� 1�� 00�� 00�� ���ķ� ���ݱ��� �ʰ��� �и���)
		long time = System.currentTimeMillis();
		System.out.println(time);

		// ������ �˾ƺ��� �ִ� ����Ʈ ���
		// ****�� **��**��**����**��**��**��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��");// �Ұ�ȣ �ȿ� ��¥ ��� ����� ���������
		System.out.println(sdf.format(time));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� MM�� dd�� EE���� hh�� mm�� ss�� SS��");
		System.out.println("����ð� : " + sdf1.format(time));

		// ����
		// Ÿ�̸� �����
		// �� �Է°��� �ް� (���ѽð�)
		// �� �� ������ ����ð�(�����ð�)�� ���
		// �� Thread.sleep()�޼ҵ� Ȱ��
		// �� ���ѽð��� �ʰ��Ǹ� -> "Ÿ�Ӿƿ�"��� ��, ���α׷� ����

		int n = 1;
		while (n < 10) {
			System.out.println(n);
			try {
				Thread.sleep(1000);// �����̸� �� �ð��� ms(�и���)������ ���ڸ� ��
			} catch (Exception e) {
				// TODO: handle exception
			}
			n++;
		}
	}
}
