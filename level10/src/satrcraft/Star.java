package satrcraft;

//상속을 활용한 스타크래프트 만들기

//MarkInterface : 내용X
// ㄴ 마크인터페이스로 정의된 클래스는 해당 인터페이스의 하위 자료형으로 묶임

interface Repairable {

}// Repairable

interface Damageable {
	public void damage(int att);
}// damageable

//interface Damageable{} 인터페이스를 정의하고,
// damage() 메소드를 만들어서
// Tank, SCV, DropShip에게 상속(손상가능)
// 손상시킨 각 유닛에 대하여 ->scv.repair()를 하고
// 수리전 hp가 0이면 -> Unit의 사망 출력
// hp 1 이상인 상태에서 -> repair() -> "수리중>>"출력

//Unit
//ㄴ GroundUnit : Tank(120)(repair O), marine(100), SCV(우주건설차량)(200)(repair O)
//ㄴ AirUnit : DropShip(90)

//모든 유닛의 최고 조상 클래스
class Unit {
	boolean isDead;
	final int MAX_HP;
	int hp;

	public Unit(int hp) {
		this.MAX_HP = hp;
	}
}// Unit

class GroundUnit extends Unit {

	public GroundUnit(int hp) {
		super(hp);
		System.out.println("I can Walk");
	}
}

class AirUnit extends Unit {

	public AirUnit(int hp) {
		super(hp);
		System.out.println("I can fly");
	}
}

// Unit 만들기

class Tank extends GroundUnit implements Repairable, Damageable {

	public Tank() {
		super(120); // Unit의 MAX_HP가 초기화(상수)
		hp = MAX_HP; // super.hp = super.MAX_HP;
		System.out.printf("탱크 출격[hp : %d]\n", hp);
	}

	@Override
	public void damage(int att) {
		hp -= att;
		System.out.printf("tank 데미지(%d)입음\n현재 hp : %d\n", att, hp);
		if (hp < 0) {
			isDead = true;
			System.out.println("Tank 사망");
		}
	}// damage
}// Tank

class Marine extends GroundUnit {
	public Marine() {
		super(100);
		hp = MAX_HP;
		System.out.printf("마린 출격[hp : %d]\n", hp);
	}

} // Marine

// SCV 우주건설차량 은 다른 유닛을 치료할수 있는 '기능'
// ㄴ 단, 치료할 수 있는 Unit에 대해서만 처리 가능
// ㄴ 즉, 치료할 수 없는 Unit 과 구분이 되어야함

// => MarkInterface 를 활용한 '치료 가능한'Unit의 식별
class SCV extends GroundUnit implements Repairable, Damageable {
	public SCV() {
		super(200);
		hp = MAX_HP;
		System.out.printf("SCV 출격[hp : %d]\n", hp);
	}

	// repair()메소드
	// 고장난 유닛의 hp를 고유한 MAX_HP까지 회복시킴
	public void repair(Repairable repairable) {// <- 파라미터로 수리할 유닛을 받아옴
		Unit target = (Unit) repairable; // 형변환 Typecast
		if (isDead) {
			System.out.println("SCV가 이미 폭파되었습니다");
			return;
		}
		if (!target.isDead) {
			while (target.hp < target.MAX_HP) {
				target.hp += 10;
				System.out.println("수리중>>");
			} // while
			System.out.println("[수리완료]");
		} else {
			System.out.println("이미 사망한 Unit");
		}
	}// repair

	@Override
	public void damage(int att) {
		hp -= att;
		System.out.printf("SCV 데미지(%d)입음\n현재 hp : %d\n", att, hp);
		if (hp < 0) {
			isDead = true;
			System.out.println("SCV 사망");
		}
	}// damage
}// SCV

class DropShip extends AirUnit implements Damageable {
	public DropShip() {
		super(90);
		hp = MAX_HP;
		System.out.printf("DropShip 출격[hp : %d]\n", hp);
	}

	@Override
	public void damage(int att) {
		hp -= att;
		System.out.printf("DropShip 데미지(%d)입음\n현재 hp : %d\n", att, hp);
		if (hp < 0) {
			isDead = true;
			System.out.println("DropShip 사망");
		}
	}
}

public class Star {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropship = new DropShip();

		// MarkInterface 는 특정 기능의 식별용도로 활용 할 수 있다

		scv.repair(scv);
		scv.repair(tank);
		tank.damage(300);
		scv.repair(tank);
		dropship.damage(50);
		scv.damage(300);
		scv.repair(tank);
//		scv.repair(marine);
//		scv.repair(dropship);
	}
}
