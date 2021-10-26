package unit;

public class Player extends Unit {
	private int heal = 3;
	public Player(String name, int hp, int attack, int defence, int floor) {
		super(name,hp,attack,defence,floor);
	}
	
	public int getHeal() {
		return this.heal;
	}
	
	public void heal() {
		if (heal>0) {
			System.out.println("ȸ���մϴ�\nü���� 100��ŭ ȸ����");
			this.setHp(this.getHp()+100);
			System.out.printf("���� ü�� : %d\n",this.getHp());
		}else {
			System.out.println("ȸ��Ƚ�� �ʰ�");
		}
	}
}
