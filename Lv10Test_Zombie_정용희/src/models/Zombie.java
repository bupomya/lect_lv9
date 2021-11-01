package models;

import java.util.Random;

public class Zombie extends Unit implements Attackable{
	public Zombie(String name, int hp, int defence, int attack , int floor) {
		super(name, hp, defence, attack, floor);
	}//Zombie
	
	@Override
	public void attack(Unit target) {
		Random rn = new Random();
		int damage = this.getAttack() - target.getDefence() *(rn.nextInt(150)+50)/100;
		
		if (damage<=0) {
			damage = 1;
		}
		target.setHp(target.getHp() - damage);
	}
	
}//Zombie
