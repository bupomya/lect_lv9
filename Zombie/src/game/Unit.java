package game;

import java.util.Random;

public class Unit {
	private String name;//이름
	private int hp;//체력
	private int attack;// 공격
	private int defense;//방어력
	private int floor;//층수
	
	public Unit(String name, int hp, int attack, int defense, int floor) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.floor = floor;
	}//Unit
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getName() {
		return name;
	}
	public int getDefense() {
		return defense;
	}

	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public void attack(Unit target) {
		Random rn = new Random();
		int damage = (this.attack - target.defense)*(rn.nextInt(150)+50)/100;
		if (damage <= 0) {
			damage = 1;
		}
		System.out.printf("%s의 공격\n",name);
		System.out.printf("%d의 대미지\n",damage);
		target.setHp(target.getHp() - damage);
		System.out.printf("%s의 남은 체력 : %d\n",target.name,target.hp);
	}//attack
	
	public void print() {
		System.out.printf("이름 : %s/t체력 : %d\n",name,hp);
		System.out.printf("공격력 : %d\t방어력 : %d\t층수 : %d",attack,defense,floor);
	}//print
}//Unit
