package unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	private Game() {
	}

	private static Game instance = new Game();

	public static Game getInsetance() {
		return instance;
	}

	private Player p;
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void init() {
		p = new Player("player", 100, 5, 1, 1);
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("힘쎈좀비", 45, 10, 2, 6));
		enemy.add(new Zombie("정예좀비", 65, 15, 2, 9));
		enemy.add(new ZombieKing("좀비왕", 100, 20, 4, 12, 50));
	}// init

	private int checkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getFloor() == enemy.get(i).getFloor()) {
				System.out.println("좀비가 나타났다");
				return i;
			}
		}
		return -1;
	}// checkZombie

	private int die(Unit unit) {
		if (p.getHp() <= 0) {
			return 1;
		} else if (unit.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}// die

	private boolean fight(Unit enemy) {

		while (true) {
			p.print();
			System.out.println("=====VS======");
			enemy.print();
			System.out.printf("1.공격 2. 물약(%d개 남음)");
			
			if (die(enemy) == 1) {
				System.out.println("player 사망");
				return false;
			} else {
				System.out.println("player 승리");
				return true;
			}
		} // while

	}// fight
}
