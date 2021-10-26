package unit;

public class Unit {
	private String name;
	private int hp;
	private int attack;
	private int defence;
	private int floor;
	public Unit(String name, int hp, int attack, int defence, int floor) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defence = defence;
		this.floor = floor;
	}//Unit
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public void print() {
		System.out.printf("�̸� : %s\tü�� : %d\n",name,hp);
		System.out.printf("���ݷ� : %d\t���� : %d\t%d��\n",attack,defence,floor);
	}//print

}//Unit
