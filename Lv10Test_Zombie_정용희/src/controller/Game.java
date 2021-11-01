package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Player;
import models.Unit;
import models.Zombie;
import models.ZombieKing;

public class Game {
	Scanner sc = new Scanner(System.in);
	private Game() {}
	
	private static Game instance = new Game();
	
	public static Game getInstance() {
		return instance;
	}//getInstance
	
	private Player p;
	private ArrayList<Unit> zombie = new ArrayList<>();
	
	
	private void init() {
		p = new Player("player", 100, 1, 5, 1);
		zombie.add(new Zombie("그냥 좀비", 10, 1, 1, 3));
		zombie.add(new Zombie("힘쌘 좀비", 20, 2, 2, 6));
		zombie.add(new Zombie("정예 좀비", 30, 2, 3, 9));
		zombie.add(new ZombieKing("좀비 왕", 40, 4, 4, 12,40));
	}//init
	
	private void map() {
		System.out.printf("현재 층 : %d층\n",p.getFloor());
		System.out.println("1. 올라간다");
		System.out.println("2. 체력회복");
		System.out.println("3. 무기 강화");
	}//map
	
	
	private void enforce() {
		Random rn = new Random();
		int ranSelEnforce = rn.nextInt(2);
		int ranEnforce = rn.nextInt(3)+1;
		if (ranSelEnforce == 1) {
			p.setAttack(p.getAttack()+ranEnforce);
			System.out.printf("공격력 %d 강화\n",p.getAttack());
		}else if (ranSelEnforce == 2) {
			p.setDefence(p.getDefence()+ranEnforce);
			System.out.printf("방어력 %d 강화\n",p.getDefence());
		}
	}//enforce
	
	
	private int die(Unit unit) {
		if (p.getHp() <=0) {
			return 0;
		}else if (unit.getHp()<=0) {
			return 1;
		}else {
			return -1;
		}
	}//die
	
	private boolean fight(Unit zombie) {
		while(true) {
			p.printUnit();
			System.out.println("VS");
			zombie.printUnit();
			System.out.println("1.공격\n2.물약");
			String sel = sc.next();
			if (sel.equals("1")) {
				p.attack(zombie);
			}else if (sel.equals("2")) {
				p.heal(100);
				System.out.println("체력 100 회복");
			}else {
				System.out.println("잘못된 선택지");
			}
			
			if (die(zombie) != -1) {
				break;
			}
			zombie.attack(p);
			if (die(zombie) != -1) {
				break;
			}

		}//while
			if (die(zombie) == 0) {
				System.out.println("승리");
				return true;
			}else {
				System.out.println("패배");
				return false;
			}
	}//fight

	private int checkZombie() {
		for (int i = 0; i < zombie.size(); i++) {
			if (p.getFloor() == zombie.get(i).getFloor()) {
				System.out.println("좀비를 만났다");
				return i;
			}
		}
		return -1;
	}//checkZombie

	public void run() {
		init();
		while(true) {
			if (p.getFloor() >=12) {
				System.out.println("생존 성공");
				break;
			}
			map();
			String sel = sc.next();
			if (sel.equals("1")) {
				p.setFloor(p.getFloor()+1);
				int check = checkZombie();
				if (check!=-1) {
					boolean fight = fight(zombie.get(check));
					if (fight = false) {
						break;
					}

				}else {
					System.out.println("좀비 없음");
				}
			}else if (sel.equals("2")) {
				p.heal(100);
			}else if (sel.equals("3")) {
				enforce();
			}else {
				System.out.println("잘못된 선택지");
			}
		}//while
	}//run
}//Game
