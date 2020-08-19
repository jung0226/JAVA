import java.util.Calendar;

public class StaticTest {

	public static void main(String[] args) {
		BBB b=new BBB();
		System.out.println("b.num = "+b.num);
		//static  키워드가 멤버변수 표기될 경우 객체를 생성하지 않고 접근 할 수 있다.
		System.out.println("AAA.nu = "+AAA.num);
		
		CCC c1 = new CCC();
		CCC c2 = new CCC();
		CCC c3 = new CCC();
		
		//static 변수를 객체로 생성시 각 객체의 공통변수로 사용한다.
		c2.name="세종대왕";
		c3.print();
		
		//static 메소드에 표기하는 경우 객체 생성하지 않고 메소드를 호출할 수 있다.
		CCC.print();
		
		Math.random();//static method
		Calendar.getInstance();//static method
		
		BBB b2=BBB.getInstance();
		System.out.println("b2.num= "+b2.num);
	}

}
