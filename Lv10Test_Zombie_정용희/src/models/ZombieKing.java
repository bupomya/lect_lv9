package models;

import java.util.Random;

public class ZombieKing extends Unit implements Attackable{
	private int shield;
	public ZombieKing(String name, int hp, int defence, int attack, int floor,int shield) {
			super(name, hp, defence, attack, floor);
			this.shield = shield;
		}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	@Override
	public void attack(Unit target) {
		Random rn = new Random();
		int damage = this.getAttack() - target.getDefence() *(rn.nextInt(150)+50)/100;
		if (damage<=0) {
			damage = 1;
		}
		target.setHp(target.getHp() - damage);
	}
}
