package diff;

import level10.Robo;

//부모클래스가 다른 패키지 안에 있고,
//private 과 default는 접근X
public class Computer extends Robo{
	public Computer() {
		super.brand = "";
		super.name = "";
//		super.code = 0;
//		super.power = 0;
	}
}
