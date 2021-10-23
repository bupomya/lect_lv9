package level10;

import java.text.SimpleDateFormat;
import java.util.Scanner;

//���������� : ���� �Ǵ� ������ ��ҿ� �ܺο��� ������ �� �ִ� ������ ����
//�� public
//�� protected : 
//�� default
//�� private



//��� : �θ� �ڽĿ��� �ڽ��� ���� �����ִ� ��

//��� Ŭ������ Object�� �⺻ ��� �޴´�;
class A {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

//���
//extends Ű���带 ���� ��� ó��
//class �ڽ�Ŭ���� extends�θ�Ŭ����{}

//�Ϲݻ�� < �߻�ȭ(abstract) < �������̽�(interface)
//������� �������� ����(�޼ҵ忡 ����)

//Java ������ ���߻���� ������� �ʴ´�
//���߻���� ȿ���� ���� �������̽��� ������ ���(����� ����� ����)

class B {
	int b;
	void methodB() {}
}

class C extends B{
	int c;
	void methodC() {}
	
	//�θ�κ��� �������� �޼ҵ�� �����ǰ� �����ϴ�
	@Override
	void methodB() {
		// TODO Auto-generated method stub
		super.methodB();
	}
}
class D{
	int d;
	
	//������(�⺻X)
	public D(int d) {
		this.d = d;
	}
}
class E extends D{
	int e;
	public E(int d) {
		//�θ��� �����ڸ� ȣ��(�θ�ü�� �켱 ���� -> �ڽĵ� ����)
		super(d); // super() �θ�Ŭ������ ������
		super.d = 20; // super. : �θ��� ����� ����
		this.e = 10; // �θ���� -> �ڽĻ��� -> �ڽĸ�� ��밡��
	}
}


//'�߻� Ŭ����'�� ����
// abstract Ű���带 class �����Ҷ� �տ� �ٿ���
// abstract class Ŭ������{}

//�θ�Ŭ�������� 'Ư���ϴ� �޼ҵ�'�� ���Ͽ�
// �� �޼ҵ� �տ� abstract Ű���尡 �ٰ�, �޼ҵ�� body�� ����, �޼ҵ� ���Ǻθ� ����
//��ӹ��� �ڽ�Ŭ�������� �ݵ�� -> �������̵�(������) �ؾ���
abstract class F{
	int f;
	void methodF() {}
	abstract void methodFF();
}

class G extends F implements H{
	int g;
	void methodG() {}
	@Override
	void methodFF() {
		//�θ� ������(abstract) �߻�޼ҵ带 �������ؾ���
		
	}
	
	@Override
	void methodF() {
		// TODO Auto-generated method stub
		super.methodF();
	}
	@Override
	public void methodH() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void methodHH() {
		// TODO Auto-generated method stub
		
	}
}

//�������̽� (�޼ҵ��� ����) ����
// interface �������̽���{}

interface H{
	final int h = 1; // ����� ���� ����� ������ �ִ�(�Ϲݺ��� X)
	void methodH();
	void methodHH();
}

class I implements H{

	@Override
	public void methodH() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodHH() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Time_1 {
	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		C c = new C();
		c.b = 1;
		c.c = 2;
		c.methodB();

		// ����
		// Ÿ�̸� �����
		// �� �Է°��� �ް� (���ѽð�)
		// �� �� ������ ����ð�(�����ð�)�� ���
		// �� Thread.sleep()�޼ҵ� Ȱ��
		// �� ���ѽð��� �ʰ��Ǹ� -> "Ÿ�Ӿƿ�"��� ��, ���α׷� ����

				Scanner sc = new Scanner(System.in);

		System.out.println("Ÿ�̸� ���� >>");
		System.out.print("�� : ");
		int min = sc.nextInt();
		System.out.print("�� : ");
		int sec = sc.nextInt();

		int n = min * 60 + sec;
		SimpleDateFormat sdf = new SimpleDateFormat("hh�� mm�� ss��");

		while (n > 0) {
			long time = System.currentTimeMillis();
			System.out.println(sdf.format(time));
			System.out.printf("(%d�� ����)\n", n);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			n--;
		}
		System.out.println("Timeout");

	}
}
