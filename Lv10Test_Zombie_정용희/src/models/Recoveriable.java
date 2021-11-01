package models;

public interface Recoveriable {
	public static final int MAX_RECOVERY = 3;
	public void heal(int recovery);
}
