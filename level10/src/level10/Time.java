package level10;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Time {
	public static void main(String[] args) {
		// ����
		// Ÿ�̸� �����
		// �� �Է°��� �ް� (���ѽð�)
		// �� �� ������ ����ð�(�����ð�)�� ���
		// �� Thread.sleep()�޼ҵ� Ȱ��
		// �� ���ѽð��� �ʰ��Ǹ� -> "Ÿ�Ӿƿ�"��� ��, ���α׷� ����

		Scanner sc = new Scanner(System.in);

		System.out.print("���ѽð� �Է� : ");
		int limiteTime = sc.nextInt();
		int n = limiteTime;
		while (n > 0) {
			long time = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� hh�� mm�� ss�� SS��");
			System.out.println("����ð� : " + sdf.format(time));
			System.out.printf("�����ð� : %d��\n", n);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			n--;
		} // while
	}// main
}// Time
