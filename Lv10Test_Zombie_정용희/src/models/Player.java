package models;

import java.util.Random;

//recovery
//attack

public class Player extends Unit implements Recoveriable,Attackable{
	int heal = 0;
	public Player(String name, int hp, int defence, int attack, int floor) {
		super(name, hp, defence, attack, floor);
	}
	
	
	@Override
	public void heal(int recovery) {
		if (this.heal<MAX_RECOVERY) {
			super.setHp(getHp()+recovery);
			this.heal++;
			System.out.println("ü���� ȸ����");
		}else {
			System.out.println("ȸ�� Ƚ�� �ʰ�");
		}
		
	}//heal
	
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
				System.out.println("���� �ı�");
				target.setHp(target.getHp()-damage);
			}
		}else {
			target.setHp(target.getHp()-damage);
		}
		
	}//attack
	
}// player
