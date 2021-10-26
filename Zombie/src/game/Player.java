package game;

import java.util.Random;

public class Player extends Unit{
	private int recovery = 3;
	
	
	public Player(String name, int hp, int attack,int defense,int floor) {
		super(name,hp,attack,defense,floor);
	}//player
	
	public int getRecovery() {
		return this.recovery;
	}
	
	public void recoveryHp() {
		if (recovery>0) {
			System.out.println("체력 100회복");
			this.setHp(this.getHp()+100);
			System.out.printf("%s의 남은체력 : %d",getName(),getHp());
			recovery--;
		}else {
			System.out.println("회복횟수 초과");
		}
	}//recoveryHp
	
	public void attack(Unit target) {
		Random rn = new Random();
		
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).getShield()>0) {
				int damage = (this.getAttack() - target.getDefense())*(rn.nextInt(150)+50)/100;
				if (damage<=0) {
					damage = 1;
				}
				System.out.printf("%s의 공격 -> %d데미지\n",getName(),damage);
				((ZombieKing) target).setShield(((ZombieKing) target).getShield()-damage);
				if (((ZombieKing) target).getShield()<=0) {
					System.out.printf("%s 의 쉴드 파괴",target.getName());
					((ZombieKing) target).setShield(0);
				}
				System.out.printf("%s의 남은 체력 : %d / 쉴드 : %d\n",target.getName(),target.getHp(),((ZombieKing) target).getShield());
			}else {
				super.attack(target);
			}
		}else {
			super.attack(target);
		}
	}//attack
}//player
