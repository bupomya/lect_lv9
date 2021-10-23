package satrcraft;

import javax.rmi.CORBA.Util;

interface Repairable1{}

interface Damageable1{
	public void damage(int attack);
}//Damageable

class Unit1 {
	boolean isDead;
	final int MAX_HP;
	int hp;

	public Unit1(int maxHp) {
		this.MAX_HP = maxHp;
	}
}// Unit

class GroundUnit1 extends Unit {

	public GroundUnit1(int maxHp) {
		super(maxHp);
		System.out.println("ground");
	}

}// GroundUnit

class AirUnit1 extends Unit {
	public AirUnit1(int maxHp) {
		super(maxHp);
		System.out.println("air");
	}
}// AirUnit

class Tank1 extends GroundUnit1 implements Repairable1, Damageable1{
	public Tank1() {
		super(200);
		hp = MAX_HP;
		System.out.println("Tank생성완료(200)");
	}

	@Override
	public void damage(int attack) {
		hp -= attack;
		System.out.printf("tank1 데미지 (%d)입음\n현재 HP : %d\n",attack,hp);
		if (hp<=0) {
			isDead = true;
			System.out.println("tank1 부셔짐");
		}
	}
}// Tank1

class SCV1 extends GroundUnit1 implements Repairable1,Damageable1{
	public SCV1() {
		super(150);
		hp = MAX_HP;
		System.out.println("SCV생성 완료(150)");
	}
	
	public void repair(Repairable1 repair) {
		Unit target = (Unit)repair;
		if (isDead) {
			System.out.println("SCV1이 부서져 수리할수없습니다 ");
			return;
		}else {
			while(target.hp<target.MAX_HP) {
				target.hp+=10;
				System.out.printf("수리중 (%d)\n", target.hp);
			}
			System.out.println("수리완료");
		}
	}
	
	@Override
	public void damage(int attack) {
		hp -= attack;
		System.out.printf("SCV1 데미지(%d)입음\n현재HP : %d\n",attack,hp);
		
		if (hp<=0) {
			isDead = true;
			System.out.println("SCV1 부셔짐");
		}
	}
}// SCV1

class Marin extends GroundUnit1 {
	public Marin() {
		super(120);
		hp = MAX_HP;
		System.out.println("Marin생성완료(120)");
	}
}// Marin

class DropShip1 extends AirUnit1 implements Repairable1,Damageable1{
	public DropShip1() {
		super(90);
		hp = MAX_HP;
		System.out.println("DropShip1생성완료(90)");
	}
	@Override
	public void damage(int attack) {
		hp-=attack;
		System.out.printf("DropShip1 데미지(%d)입음\n현재HP : %d\n",attack,hp);
		
		if (hp<=0) {
			System.out.println("DropShip1 부셔짐");
		}
	}
}// DropShip1

public class Starcraft {
	public static void main(String[] args) {
		Tank1 tank = new Tank1();
		Marin marin = new Marin();
		SCV1 scv = new SCV1();
		DropShip1 dropship = new DropShip1();
		
		scv.repair(tank);
		tank.damage(20);
		scv.repair(tank);
		dropship.damage(50);
		scv.repair(dropship);
		scv.damage(150);
		scv.repair(scv);
	}
}
