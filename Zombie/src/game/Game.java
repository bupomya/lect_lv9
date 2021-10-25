package game;

import java.util.ArrayList;

public class Game {
	private Game() {
	}

	private static Game instance = new Game();
	private Player p;
	private ArrayList<Unit> enemy = new ArrayList<>();

	public static Game getInstance() {
		return instance;
	}// getInstance

	private void init() {
		p = new Player("player", 100, 5, 1, 1);// name,hp,attack,defense,floor
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3));//name,hp,attack,defense,floor
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3));
		enemy.add(new ZombieKing("그냥좀비", 25, 5, 1, 3, 30));// name,hp,attack,defense,floor,shield
	}// init
	
	private int checkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getFloor() == enemy.get(i).getFloor()) {
				System.out.println("좀비를 만났다");
				return i;
			}
		}
		return -1;
	}//check
	private int Die(Unit a) {
		if (p.getHp()<=0) {// player사망
			return 1;
		}else if (a.getHp()<=0) {//a층의 좀비 사망
			return 2;
		}else {
			return 0;
		}
	}
	

}
