package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
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
		enemy.add(new Zombie("힘쌘좀비", 45, 10, 2, 6));
		enemy.add(new Zombie("정예좀비", 65, 15, 3, 9));
		enemy.add(new ZombieKing("좀비왕", 100, 20, 4, 12, 30));// name,hp,attack,defense,floor,shield
	}// init
	
	private int checkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getFloor() == enemy.get(i).getFloor()) {
				System.out.println("좀비를 만났다");
				return i;
			}
		}
		return -1;
	}//checkZombie
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

	private void map(int a){
		System.out.println("1.올라간다");
		if (a == 1) {
			System.out.println("2. 체력회복");
			System.out.println("3. 무기강화");
		}
	}//map
	
	public void run() {
		init();
		int act = 1;
		while(true) {
			if (p.getFloor()>=12) {
				System.out.println("생존성공");
				break;
			}
			map(act);
			int sel = sc.nextInt();
			if (sel == 1) {
				p.setFloor(p.getFloor()+1);
				int check = checkZombie();
				if (check != -1) {
					boolean fight = fight(enemy.get(check));
					if (!fight) {
						break;
					}
				}else {
					System.out.println("아무일도 일어나지 않았다");
				}
				act = 1;
			}else if (sel == 2 && act == 1) {
				int recoveryHp = rn.nextInt(40)+20;
				p.setHp(p.getHp()+recoveryHp);
				act = 2;
				System.out.printf("체력을 %d 만큼 회복\n",recoveryHp);
			}else if (sel == 3 && act ==1) {
				int enforce = rn.nextInt(2);
				if (enforce == 0) {
					enforce = rn.nextInt(3)+1;
					p.setAttack(p.getAttack()+enforce);
					System.out.printf("공격력 %d 만큼 증가\n",enforce);
				}else if (enforce == 1) {
					enforce = rn.nextInt(3)+1;
					p.setDefense(p.getDefense()+enforce);
					System.out.printf("방어력이 %d 만큼 중가\n",enforce);
				}
				act = 2;
			}
		}//while
	}//run
	
}//Game
