
public class ConstractorTest {
	int num=10;
	String name;
	String tel="010-1111-2222";
	
	public ConstractorTest() {//컴파일러가 생성해준다.
		
	}
	public ConstractorTest(int num) {
		System.out.println("ConstractorTest(int num) 생성자");
		this.num = num; //this: 실행되는 클래스. 멤버변수 num을 가리킴.
	}
	public ConstractorTest(String name) {
		
	}
	public ConstractorTest(int num, String name, String tel) {
		//생성자에서 다른 생성자를 호출하기 위해서는 반드시 첫번째 실행문으로 처리해야 한다.
		this(num);
		System.out.println("ConstractorTest(int num, String name, String tel) 생성자");
		//this.num = num; 
		this.name=name;
		this.tel =tel;
		
	}
	public ConstractorTest(String name, String tel, int num) {
		this(num, name, tel);//다른 생성자 호출
	}
	public void prn() {
		System.out.println("번호 = "+num);
		System.out.println("이름 = "+name);
		System.out.println("연락처 = "+tel);
	}

}//end of class
