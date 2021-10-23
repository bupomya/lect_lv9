package level10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//디자인(설계) 패턴
// ㄴ 생성자 패턴
// . Singleton Pattern
// . 유일한 객체를 생성하고 -> 타 클래스에서 안전하게 유일한 객체의 instance를 참조할 수 있게 하는 것

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
	// UserManager의 instance는 유일해야 한다.

	// Singleton
	// 1. 유일한 instance를 클래스 내부에서 생성
	private static UserManager instance = new UserManager();

	// 2. 생성자는 private 처리(타 클래스에서 new키워드를 통해 또다른 생성이 X)
	private UserManager() {
	}

	// 유일한 instance에 대한 getter
	public static UserManager getInstance() {
		return instance;
	}// getInstance

	// 중앙 데이터
	private ArrayList<User> users = new ArrayList<>();

}// UserManager


public class Ex {
	public static void main(String[] args) {
		UserManager um = UserManager.getInstance();

		// 시간에 대한 처리
		// 객체 활용 -> 구현

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);

		// 년 월 일 요일 시 분 초 밀리초
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH)); // 0~ 부터 카운트
		System.out.println(calendar.get(calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(calendar.DAY_OF_WEEK)); // 일1 월2 화3 수4
		System.out.println(calendar.get(calendar.HOUR));
		System.out.println(calendar.get(calendar.MINUTE));
		System.out.println(calendar.get(calendar.SECOND));
		System.out.println(calendar.get(calendar.MILLISECOND));
		System.out.println(calendar.get(calendar.DAY_OF_WEEK));

		// 시스템 시간 가져오기
		// 시간 단위 : 밀리초로 반환 (1970년 1월 1일 00시 00초 이후로 지금까지 초과된 밀리초)
		long time = System.currentTimeMillis();
		System.out.println(time);

		// 누구나 알아볼수 있는 데이트 양식
		// ****년 **월**일**요일**시**분**초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월");// 소괄호 안에 날짜 출력 양식을 정해줘야함
		System.out.println(sdf.format(time));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 hh시 mm분 ss초 SS초");
		System.out.println("현재시간 : " + sdf1.format(time));

		// 숙제
		// 타이머 만들기
		// ㄴ 입력값을 받고 (제한시간)
		// ㄴ 초 단위로 현재시간(남은시간)을 출력
		// ㄴ Thread.sleep()메소드 활용
		// ㄴ 제한시간이 초과되면 -> "타임아웃"출력 후, 프로그램 종료

		int n = 1;
		while (n < 10) {
			System.out.println(n);
			try {
				Thread.sleep(1000);// 딜레이를 줄 시간을 ms(밀리초)단위로 인자를 줌
			} catch (Exception e) {
				// TODO: handle exception
			}
			n++;
		}
	}
}
