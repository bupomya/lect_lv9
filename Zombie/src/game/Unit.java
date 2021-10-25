package game;

import java.util.Random;

public class Unit {
	private String name;//�̸�
	private int hp;//ü��
	private int attack;// ����
	private int defense;//����
	private int floor;//����
	
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
		System.out.printf("%s�� ����\n",name);
		System.out.printf("%d�� �����\n",damage);
		target.setHp(target.getHp() - damage);
		System.out.printf("%s�� ���� ü�� : %d\n",target.name,target.hp);
	}//attack
	
	public void print() {
		System.out.printf("�̸� : %s/tü�� : %d\n",name,hp);
		System.out.printf("���ݷ� : %d\t���� : %d\t���� : %d",attack,defense,floor);
	}//print
}//Unit
