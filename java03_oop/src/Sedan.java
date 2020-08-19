
public class Sedan extends Car{
	int speed=150;

	public Sedan() {
		//상위 클래스의 매개변수가 있는 생성자 호출
		//반드시 첫 행에서 호출해야 함.
		super("red");
		System.out.println("Sedan()생성자");
	}
	//오버라이딩 overriding : 상위클래스의 메소드를 하위클래스에서 재정의
	public void speedUp() {
		super.speed+=10;
		if(super.speed>=SPEED_MAX) {
			super.speed = SPEED_MAX;
		}
		System.out.println("speed="+super.speed);
		
		super.speedUp();
		//private 멤버변수는 하위 클래스에서 사용 할 수 없다.
		//= private 멤버변수는 상속되지 않는다.
		//System.out.println("car.color= "+color);
	}

	public static void main(String[] args) {
		Sedan sedan = new Sedan();
		sedan.speedUp();
	}

}
