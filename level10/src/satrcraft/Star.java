package satrcraft;

//����� Ȱ���� ��Ÿũ����Ʈ �����

//MarkInterface : ����X
// �� ��ũ�������̽��� ���ǵ� Ŭ������ �ش� �������̽��� ���� �ڷ������� ����

interface Repairable {

}// Repairable

interface Damageable {
	public void damage(int att);
}// damageable

//interface Damageable{} �������̽��� �����ϰ�,
// damage() �޼ҵ带 ����
// Tank, SCV, DropShip���� ���(�ջ󰡴�)
// �ջ��Ų �� ���ֿ� ���Ͽ� ->scv.repair()�� �ϰ�
// ������ hp�� 0�̸� -> Unit�� ��� ���
// hp 1 �̻��� ���¿��� -> repair() -> "������>>"���

//Unit
//�� GroundUnit : Tank(120)(repair O), marine(100), SCV(���ְǼ�����)(200)(repair O)
//�� AirUnit : DropShip(90)

//��� ������ �ְ� ���� Ŭ����
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

// Unit �����

class Tank extends GroundUnit implements Repairable, Damageable {

	public Tank() {
		super(120); // Unit�� MAX_HP�� �ʱ�ȭ(���)
		hp = MAX_HP; // super.hp = super.MAX_HP;
		System.out.printf("��ũ ���[hp : %d]\n", hp);
	}

	@Override
	public void damage(int att) {
		hp -= att;
		System.out.printf("tank ������(%d)����\n���� hp : %d\n", att, hp);
		if (hp < 0) {
			isDead = true;
			System.out.println("Tank ���");
		}
	}// damage
}// Tank

class Marine extends GroundUnit {
	public Marine() {
		super(100);
		hp = MAX_HP;
		System.out.printf("���� ���[hp : %d]\n", hp);
	}

} // Marine

// SCV ���ְǼ����� �� �ٸ� ������ ġ���Ҽ� �ִ� '���'
// �� ��, ġ���� �� �ִ� Unit�� ���ؼ��� ó�� ����
// �� ��, ġ���� �� ���� Unit �� ������ �Ǿ����

// => MarkInterface �� Ȱ���� 'ġ�� ������'Unit�� �ĺ�
class SCV extends GroundUnit implements Repairable, Damageable {
	public SCV() {
		super(200);
		hp = MAX_HP;
		System.out.printf("SCV ���[hp : %d]\n", hp);
	}

	// repair()�޼ҵ�
	// ���峭 ������ hp�� ������ MAX_HP���� ȸ����Ŵ
	public void repair(Repairable repairable) {// <- �Ķ���ͷ� ������ ������ �޾ƿ�
		Unit target = (Unit) repairable; // ����ȯ Typecast
		if (isDead) {
			System.out.println("SCV�� �̹� ���ĵǾ����ϴ�");
			return;
		}
		if (!target.isDead) {
			while (target.hp < target.MAX_HP) {
				target.hp += 10;
				System.out.println("������>>");
			} // while
			System.out.println("[�����Ϸ�]");
		} else {
			System.out.println("�̹� ����� Unit");
		}
	}// repair

	@Override
	public void damage(int att) {
		hp -= att;
		System.out.printf("SCV ������(%d)����\n���� hp : %d\n", att, hp);
		if (hp < 0) {
			isDead = true;
			System.out.println("SCV ���");
		}
	}// damage
}// SCV

class DropShip extends AirUnit implements Damageable {
	public DropShip() {
		super(90);
		hp = MAX_HP;
		System.out.printf("DropShip ���[hp : %d]\n", hp);
	}

	@Override
	public void damage(int att) {
		hp -= att;
		System.out.printf("DropShip ������(%d)����\n���� hp : %d\n", att, hp);
		if (hp < 0) {
			isDead = true;
			System.out.println("DropShip ���");
		}
	}
}

public class Star {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropship = new DropShip();

		// MarkInterface �� Ư�� ����� �ĺ��뵵�� Ȱ�� �� �� �ִ�

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
