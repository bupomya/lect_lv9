package level10;

//부모 클래스가 같은 패키지 안에 있고, 
//private 멤버를 제외한 모든 멤버에 접근가능


public class Radio extends Robo{
	public Radio() {
		super.brand = "";
		super.name = "";
		super.code = 0;
//		super.power = 0;
		
	}
}
