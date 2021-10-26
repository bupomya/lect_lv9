package unit;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game implements Recovery {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	private int heal= 3;
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
			System.out.printf("1.공격 2. 물약(%d개 남음)",this.heal);
			int sel = sc.nextInt();
			if (sel == 1) {

			} else if (sel == 2) {

			}
			if (die(enemy) == 1) {
				return false;
			} else {
				System.out.println("player 승리");
				return true;
			}
		} // while
	}// fight

	private void map(int act) {
		System.out.println("1. 올라간다");
		if (act == 1) {
			System.out.println("2. 체력 회복");
			System.out.println("3. 무기 강화");
		}
	}// map

	@Override
	public void heal(int heal) {
		System.out.println("체력을 회복합니다");
		p.setHp(p.getHp() + heal);
		this.heal--;
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getFloor() >= 12) {
				System.out.println("생존 성공");
				break;
			}
			map(act);
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("한층 위로올라감");
				p.setFloor(p.getFloor() + 1);
				int check = checkZombie();
				if (check != -1) {
					boolean fight = fight(enemy.get(check));
					if (!fight) {
						System.out.println("player 사망");
						break;
					}
				} else {
					System.out.println("아무일도 없었다");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				if (this.heal>0) {					
					heal(100);
					act = 2;
					System.out.println("체력이 100 회복되었습니다");
				}else {
					System.out.println("체력회복 횟수 초과");
				}
			} else if (sel == 3 && act == 1) {
				int enforce = rn.nextInt(2);

				if (enforce == 0) {
					enforce = rn.nextInt(3) + 1;
					p.setAttack(p.getAttack() + enforce);
					System.out.printf("공격력 %d만큼 증가\n", enforce);
				} else if (enforce == 1) {
					enforce = rn.nextInt(3) + 1;
					p.setDefence(p.getDefence() + enforce);
					System.out.printf("방어력이 %d만큼 증가\n", enforce);
				}
				act = 2;
			}
		} // while
	}// run

}
