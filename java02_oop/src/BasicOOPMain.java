
public class BasicOOPMain {

	public static void main(String[] args) {
		String name= new String();
		
		//객체 생성
		BasicOOP oop1 = new BasicOOP();
		BasicOOP oop2 = new BasicOOP();
		//객체 내의 메소드 호출 -> 객체형, 메소드 명
		oop1.sum();
		
		name = oop1.getName();
		System.out.println("name= "+name);
		
		oop1.sum();
		oop1.sum();
		
		//객체내의 멤버변수의 데이터를 얻어오거나 변경하ㅣ
		//객체명. 변수명
		oop1.a=2500;
		
		System.out.println("oop1.a= "+oop1.a);
		System.out.println("oop2.a= "+oop2.a);	

	}

}
