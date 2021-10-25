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
			System.out.println("체력 100회복");
			this.setHp(this.getHp()+100);
			System.out.printf("%s의 남은체력 : %d",this.getName(),this.getHp());
			recovery--;
		}else {
			System.out.println("회복횟수 초과");
		}
	}//recoveryHp
	
	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			
		}
	}//attack
}//player
