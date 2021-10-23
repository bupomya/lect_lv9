package level10;

import java.text.SimpleDateFormat;
import java.util.Scanner;

//접근제어자 : 선언 또는 정의한 요소에 외부에서 접근할 수 있는 범위를 제한
//ㄴ public
//ㄴ protected : 
//ㄴ default
//ㄴ private



//상속 : 부모가 자식에게 자신의 것을 물려주는 것

//모든 클래스는 Object를 기본 상속 받는다;
class A {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

//상속
//extends 키워드를 통한 상속 처리
//class 자식클래스 extends부모클래스{}

//일반상속 < 추상화(abstract) < 인터페이스(interface)
//ㄴ상속의 강제성의 차이(메소드에 대한)

//Java 에서는 다중상속을 허용하지 않는다
//다중상속의 효과를 갖는 인터페이스의 여러개 상속(멤버가 상수만 존재)

class B {
	int b;
	void methodB() {}
}

class C extends B{
	int c;
	void methodC() {}
	
	//부모로부터 물려받은 메소드는 재정의가 가능하다
	@Override
	void methodB() {
		// TODO Auto-generated method stub
		super.methodB();
	}
}
class D{
	int d;
	
	//생성자(기본X)
	public D(int d) {
		this.d = d;
	}
}
class E extends D{
	int e;
	public E(int d) {
		//부모의 생성자를 호출(부모객체가 우선 생성 -> 자식도 생성)
		super(d); // super() 부모클래스의 생성자
		super.d = 20; // super. : 부모의 멤버에 접근
		this.e = 10; // 부모생성 -> 자식생성 -> 자식멤버 사용가능
	}
}


//'추상 클래스'의 정의
// abstract 키워드를 class 정의할때 앞에 붙여줌
// abstract class 클래스명{}

//부모클래스에서 '특정하는 메소드'에 대하여
// ㄴ 메소드 앞에 abstract 키워드가 붙고, 메소드는 body가 없음, 메소드 정의부만 존재
//상속받은 자식클래스에서 반드시 -> 오버라이딩(재정의) 해야함
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
		//부모가 강제한(abstract) 추상메소드를 재정의해야함
		
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

//인터페이스 (메소드의 군집) 정의
// interface 인터페이스명{}

interface H{
	final int h = 1; // 상수에 대한 멤버만 가질수 있다(일반변수 X)
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

		// 숙제
		// 타이머 만들기
		// ㄴ 입력값을 받고 (제한시간)
		// ㄴ 초 단위로 현재시간(남은시간)을 출력
		// ㄴ Thread.sleep()메소드 활용
		// ㄴ 제한시간이 초과되면 -> "타임아웃"출력 후, 프로그램 종료

				Scanner sc = new Scanner(System.in);

		System.out.println("타이머 설정 >>");
		System.out.print("분 : ");
		int min = sc.nextInt();
		System.out.print("초 : ");
		int sec = sc.nextInt();

		int n = min * 60 + sec;
		SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분 ss초");

		while (n > 0) {
			long time = System.currentTimeMillis();
			System.out.println(sdf.format(time));
			System.out.printf("(%d초 남음)\n", n);
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
