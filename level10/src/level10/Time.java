package level10;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Time {
	public static void main(String[] args) {
		// 숙제
		// 타이머 만들기
		// ㄴ 입력값을 받고 (제한시간)
		// ㄴ 초 단위로 현재시간(남은시간)을 출력
		// ㄴ Thread.sleep()메소드 활용
		// ㄴ 제한시간이 초과되면 -> "타임아웃"출력 후, 프로그램 종료

		Scanner sc = new Scanner(System.in);

		System.out.print("제한시간 입력 : ");
		int limiteTime = sc.nextInt();
		int n = limiteTime;
		while (n > 0) {
			long time = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분 ss초 SS초");
			System.out.println("현재시간 : " + sdf.format(time));
			System.out.printf("남은시간 : %d초\n", n);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			n--;
		} // while
	}// main
}// Time
