package unit;

import java.util.Random;

public class Player extends Unit implements Attackable, Recovery {
	
	int heal = 0;
	public Player(String name, int hp, int attack, int defence, int floor) {
		super(name, hp, attack, defence, floor);
	}

	public void attack(Unit target) {
		Random rn = new Random();
		int damage = this.getAttack() - target.getDefence() * (rn.nextInt(150) + 50) / 100;
		if (damage <= 0) {
			damage = 1;
		}
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).getShield() > 0) {
				((ZombieKing) target).setShield(((ZombieKing) target).getShield() - damage);
			} else {
				System.out.println("쉴드를 파괴했습니다");
				target.setHp(target.getHp() - damage);
			}
		}else {			
			target.setHp(target.getHp() - damage);
		}

	}// attack


	@Override
	public void heal(int recovery) {
		if (heal<Recovery.MAX) {
			super.setHp(getHp()+recovery);
			heal++;
			System.out.println("체력을 회복합니다");
		}else {
			System.out.println("회복량 초과");
		}
		
	}
}//player
