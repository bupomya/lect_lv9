package game;

import java.util.Random;

public class Unit {
	private String name;
	private int hp;
	private int attack;
	private int defense;
	private int floor;
	
	
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
	}//attack
}
