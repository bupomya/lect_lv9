package game;

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
			System.out.printf("%s�� ����ü�� : %d",this.getName(),this.getHp());
			recovery--;
		}else {
			System.out.println("ȸ��Ƚ�� �ʰ�");
		}
	}//recoveryHp
	
	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			
		}
	}//attack
}//player
