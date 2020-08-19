import java.util.Calendar;

public class GenericMain {

	public GenericMain() {
	}
	public void start() {
		String str = "홍길동";
		GenericTest gt = new GenericTest();
		gt.setName(str);
		System.out.println(gt.getName());
		
		gt.setName(String.valueOf(1234));
		
		//제너릭
		GenericTest<Calendar> gt2 = new GenericTest<Calendar>();
		gt2.setName(Calendar.getInstance());
		
		Calendar date = gt2.getName();
		System.out.println(date);
		
	}

	public static void main(String[] args) {
		new GenericMain().start();

	}

}
