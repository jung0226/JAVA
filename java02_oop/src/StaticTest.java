import java.util.Calendar;

public class StaticTest {

	public static void main(String[] args) {
		BBB b=new BBB();
		System.out.println("b.num = "+b.num);
		//static  Ű���尡 ������� ǥ��� ��� ��ü�� �������� �ʰ� ���� �� �� �ִ�.
		System.out.println("AAA.nu = "+AAA.num);
		
		CCC c1 = new CCC();
		CCC c2 = new CCC();
		CCC c3 = new CCC();
		
		//static ������ ��ü�� ������ �� ��ü�� ���뺯���� ����Ѵ�.
		c2.name="�������";
		c3.print();
		
		//static �޼ҵ忡 ǥ���ϴ� ��� ��ü �������� �ʰ� �޼ҵ带 ȣ���� �� �ִ�.
		CCC.print();
		
		Math.random();//static method
		Calendar.getInstance();//static method
		
		BBB b2=BBB.getInstance();
		System.out.println("b2.num= "+b2.num);
	}

}
