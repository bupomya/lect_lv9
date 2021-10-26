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
		enemy.add(new Zombie("�׳�����", 25, 5, 1, 3));
		enemy.add(new Zombie("��������", 45, 10, 2, 6));
		enemy.add(new Zombie("��������", 65, 15, 2, 9));
		enemy.add(new ZombieKing("�����", 100, 20, 4, 12, 50));
	}// init

	private int checkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getFloor() == enemy.get(i).getFloor()) {
				System.out.println("���� ��Ÿ����");
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
			System.out.printf("1.���� 2. ����(%d�� ����)",this.heal);
			int sel = sc.nextInt();
			if (sel == 1) {

			} else if (sel == 2) {

			}
			if (die(enemy) == 1) {
				return false;
			} else {
				System.out.println("player �¸�");
				return true;
			}
		} // while
	}// fight

	private void map(int act) {
		System.out.println("1. �ö󰣴�");
		if (act == 1) {
			System.out.println("2. ü�� ȸ��");
			System.out.println("3. ���� ��ȭ");
		}
	}// map

	@Override
	public void heal(int heal) {
		System.out.println("ü���� ȸ���մϴ�");
		p.setHp(p.getHp() + heal);
		this.heal--;
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getFloor() >= 12) {
				System.out.println("���� ����");
				break;
			}
			map(act);
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("���� ���οö�");
				p.setFloor(p.getFloor() + 1);
				int check = checkZombie();
				if (check != -1) {
					boolean fight = fight(enemy.get(check));
					if (!fight) {
						System.out.println("player ���");
						break;
					}
				} else {
					System.out.println("�ƹ��ϵ� ������");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				if (this.heal>0) {					
					heal(100);
					act = 2;
					System.out.println("ü���� 100 ȸ���Ǿ����ϴ�");
				}else {
					System.out.println("ü��ȸ�� Ƚ�� �ʰ�");
				}
			} else if (sel == 3 && act == 1) {
				int enforce = rn.nextInt(2);

				if (enforce == 0) {
					enforce = rn.nextInt(3) + 1;
					p.setAttack(p.getAttack() + enforce);
					System.out.printf("���ݷ� %d��ŭ ����\n", enforce);
				} else if (enforce == 1) {
					enforce = rn.nextInt(3) + 1;
					p.setDefence(p.getDefence() + enforce);
					System.out.printf("������ %d��ŭ ����\n", enforce);
				}
				act = 2;
			}
		} // while
	}// run

}
