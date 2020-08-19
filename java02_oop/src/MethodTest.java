import java.util.Scanner;
public class MethodTest {
	int dan;//멤버변수는 기본 초기값이 있다. 정수=0, 실수=0.0, 논리형 = false, char=데이터 없음
			//						  모든 클래스객체는 초기값이 null
	//레퍼런스 변수= 클래스형 변수
	Scanner s;
	String name;
	
	//매개 변수가 없는 생성자는 기본으로 생성해주는 것이 좋다.
	public MethodTest() {}

	//단 입력 메소드
	public int getDan(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		dan = scan.nextInt();
		return dan;
	}
	//입력받은 단으로 구구단 출력
	public void danOutput(int dan) {
		for(int i=2;i<=9;i++) {
			calculator(i, dan);//메소드 호출: 같은 클래스의 메소드는 메소드명만 써주면 호출됨.
		}
	}
	//계산
	public void calculator(int i, int dan) {
		int result = dan*i;
		System.out.println(dan+"*"+i+"="+result);
	}
	public void startDan() {
		int dan = getDan("단 입력");
		danOutput(dan);
	}

	
}//end of class
