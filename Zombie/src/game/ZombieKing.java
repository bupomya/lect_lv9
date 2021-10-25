package game;

public class ZombieKing extends Unit{
	private int shield;
	public ZombieKing(String name,int hp,int attack,int defense,int floor,int shield) {
		super(name, hp, attack, defense, floor);
		this.shield = shield;
	}
}
