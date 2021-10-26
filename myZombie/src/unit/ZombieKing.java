package unit;

public class ZombieKing extends Unit {
	private int shield;
	public ZombieKing(String name, int hp, int attack, int defence, int floor,int shield) {
		super(name,hp,attack,defence,floor);
		this.shield = shield;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	
}//ZombieKing
