//파일이름과 같은 클래스에만 public 쓰기.
public class AAA {
	static int num =100;
}// class

class BBB{
	int num=200;
	BBB(){}
	static BBB getInstance() {
		return new BBB();
	}//자신을 객체로 만들어서 리턴.
	
}// class 

 class CCC{
	 static int num=300;
	 static String name="홍길동";
	 static String addr="서울시 마포구";
	 
	 //상수 만들기
	 //final 변수의 값은 수정불가
	 static final int MAX = 100;
	 static final int MIN = 1;
	 
	 static void print() {
		 System.out.println("번호 = "+num);
		 System.out.println("이름 = "+name);
		 System.out.println("주소 = "+addr);
		 System.out.println("MIN= "+MIN);
		 System.out.println("MAX= "+MAX);
	 }
 }


 