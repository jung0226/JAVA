package test;
//클래스에서 클래스를 상속받는 경우 1개의 클래스만 상속가능.
public class Car2 extends Object{
	private String color="white";
	protected int wheel = 4;
	final int SPEED_MAX=200;
	int speed=0;//현재속도

	protected Car2() {
		System.out.println("Car2()생성자");
	}
	public Car2(String color) {
		this.color= color;//this: 현재 클래스명
		System.out.println("color= "+color);
	}
	public void speedUp() {
		speed++;
		if(speed>=SPEED_MAX) {
			speed = SPEED_MAX;
		}
		System.out.println("speed="+speed);
	}
	public void speedDown() {
		speed--;
		if(speed<=0) {
			speed=0;
		}
		System.out.println("speed="+speed);
	}
	public static Car2 getInstance() {
		return new Car2();
	}

}//end of class
