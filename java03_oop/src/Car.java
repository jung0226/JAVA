//클래스에서 클래스를 상속받는 경우 1개의 클래스만 상속가능.
public class Car extends Object{
	private String color="white";
	protected int wheel = 4;
	final int SPEED_MAX=200;
	int speed=0;//현재속도

	public Car() {
		System.out.println("Car()생성자");
	}
	public Car(String color) {
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

}//end of class
