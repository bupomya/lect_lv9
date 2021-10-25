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
			System.out.println("ü�� 100ȸ��");
			this.setHp(this.getHp()+100);
			System.out.printf("%s�� ����ü�� : %d",getName(),getHp());
			recovery--;
		}else {
			System.out.println("ȸ��Ƚ�� �ʰ�");
		}
	}//recoveryHp
	
	public void attack(Unit target) {
		Random rn = new Random();
		ZombieKing zombieKing = (ZombieKing) target;
		if (target instanceof ZombieKing) {
			if (zombieKing.getShield()>0) {
				int damage = (this.getAttack() - target.getDefense())*(rn.nextInt(150)+50)/100;
				if (damage<=0) {
					damage = 1;
				}
				System.out.printf("%s�� ���� -> %d������\n",getName(),damage);
				((ZombieKing) target).setShield(zombieKing.getShield()-damage);
				if (zombieKing.getShield()<=0) {
					System.out.printf("%s �� ���� �ı�",target.getName());
					zombieKing.setShield(0);
				}
				System.out.printf("%s�� ���� ü�� : %d / ���� : %d",target.getName(),target.getHp(),zombieKing.getShield());
			}else {
				super.attack(target);
			}
		}else {
			super.attack(target);
		}
	}//attack
}//player
