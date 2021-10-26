package unit;

public class Player extends Unit {
	private int heal = 3;
	public Player(String name, int hp, int attack, int defence, int floor) {
		super(name,hp,attack,defence,floor);
	}
	
	public int getHeal() {
		return this.heal;
	}
	
	public void heal() {
		if (heal>0) {
			System.out.println("회복합니다\n체력이 100만큼 회복됨");
			this.setHp(this.getHp()+100);
			System.out.printf("남음 체력 : %d\n",this.getHp());
		}else {
			System.out.println("회복횟수 초과");
		}
	}
}
