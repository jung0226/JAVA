
public class Sedan extends Car{
	int speed=150;

	public Sedan() {
		//���� Ŭ������ �Ű������� �ִ� ������ ȣ��
		//�ݵ�� ù �࿡�� ȣ���ؾ� ��.
		super("red");
		System.out.println("Sedan()������");
	}
	//�������̵� overriding : ����Ŭ������ �޼ҵ带 ����Ŭ�������� ������
	public void speedUp() {
		super.speed+=10;
		if(super.speed>=SPEED_MAX) {
			super.speed = SPEED_MAX;
		}
		System.out.println("speed="+super.speed);
		
		super.speedUp();
		//private ��������� ���� Ŭ�������� ��� �� �� ����.
		//= private ��������� ��ӵ��� �ʴ´�.
		//System.out.println("car.color= "+color);
	}

	public static void main(String[] args) {
		Sedan sedan = new Sedan();
		sedan.speedUp();
	}

}
