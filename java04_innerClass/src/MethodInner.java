
public class MethodInner {
	String username = "이순신";
	int age = 30;

	public MethodInner() {
		
	}

	public void getInfo() {
		String addr = "서울시 마포구 백범로";
	
		//메소드 내부 클래스
		//메소드가 호출이 되어야 내부클래스 사용 가능
		class Inner{
			String tel = "010-1234-5678";
			String username = "세종대왕";
			
			Inner(){}
			
			void print() {
				System.out.println("이름="+username);
				System.out.println("연락처="+tel);
				//메소드 내의 내부 클래스에서는 외부 클래스의 멤버변수를 사용할 수 있다.
				System.out.println("나이="+ age);
				//메소드의 지역 변수  클래스 정의 이전에 생성된 변수만 접근이 가능하다.
				System.out.println("주소="+ addr);
				//System.out.println("이메일="+email);
			}	
		}
		String email = "abcdef@nate.com";
		//메소드 내의 내부 클래스 객체는 class 정의 후 객체를 생성한다.
		Inner i = new Inner();
		i.print();
		
	}
	public static void main(String[] args) {
		MethodInner mi = new MethodInner();
		mi.getInfo();
		
	}
}
