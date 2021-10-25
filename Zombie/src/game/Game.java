package game;

import java.util.ArrayList;
import java.util.Scanner;

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
		enemy.add(new Zombie("힘쌘좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("정예좀비", 25, 5, 1, 3));
		enemy.add(new ZombieKing("좀비왕", 25, 5, 1, 3, 30));// name,hp,attack,defense,floor,shield
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
	private int die(Unit a) {
		if (p.getHp()<=0) {// player사망
			return 1;
		}else if (a.getHp()<=0) {//a층의 좀비 사망
			return 2;
		}else {
			return 0;
		}
	}
	
	private boolean fight(Unit enemy) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			p.print();
			System.out.println("=====VS=====");
			enemy.print();
			System.out.println("--------");
			System.out.println("선택지");
			System.out.println("1. 공격 2. 물약");
			int sel = sc.nextInt();
			if (sel == 1) {
				p.attack(enemy);
			}else if (sel ==2) {
				p.recoveryHp();
			}else {
				System.out.println("잘못된 선택지");
			}
			if (die(enemy)!=0) {
				break;
			}
			enemy.attack(p);
			if (die(enemy)!=0) {
				break;
			}
		}//while
		
		if (die(enemy)==1) {
			System.out.println("player 사망");
			return false;
		}else {
			System.out.println("player 승리");
			return true;
		}
		
	}//fight

	private void map(){}
	public void run() {}
	
}//Game
