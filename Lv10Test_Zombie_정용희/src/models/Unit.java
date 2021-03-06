package models;

import java.util.Random;

public class Unit implements Attackable{
	private String name;
	private int hp;
	private int defence;
	private int attack;
	private int floor;
	
	public Unit(String name , int hp, int defence, int attack, int floor) {
		this.name = name;
		this.hp = hp;
		this.defence = defence;
		this.attack = attack;
		this.floor = floor;
	}//Unit
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
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
	
	@Override
	public void attack(Unit target) {
		Random rn = new Random();
		int damage = this.getAttack() - target.getDefence() *(rn.nextInt(150)+50)/100;
		if (damage <=0) {
			damage = 1;
		}
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).getShield()>0) {
				((ZombieKing)target).setShield(((ZombieKing)target).getShield() - damage);
			}else {
				System.out.println("???? ?ı?");
				target.setHp(target.getHp()-damage);
			}
		}else {
			target.setHp(target.getHp()-damage);
		}
		
	}//attack
	
	
	public void printUnit() {
		System.out.printf("name : %s\thp : %d\n",this.name,this.hp);
		System.out.printf("attack : %d\tdefence : %d\t ?? ?? : %d\n",this.attack,this.defence,this.floor);
	}//printUnit
	
}//Unit

