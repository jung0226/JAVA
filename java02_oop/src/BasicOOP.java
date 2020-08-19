//package p1.p2.p3;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
public class BasicOOP {
	//전역변수(=멤버변수), 클래스 안에서 정의.
	int a=1234;//0
	String name;//null
	//전역변수는 초기값 안 줘도 기본으로 들어감.
	
	//생성자 메소드: 객체를 생성할 때 한 번 실행한다.
	//			  메소드명이 반드시 클래스명과 같아야 한다.
	//			 생성자 메소드는 변환형이 없다.
	//생성자 메소드를 만들면 new BasicOOP()를 쓸 수 있게 됨. 
	//여러개 존재 가능. but ()안이 달라야 함.객체를 만드는 방법이 다양 해짐.
	public BasicOOP() {
		System.out.println("생성자= "+a);
	}
	public BasicOOP(int a) {
		
	}
	//메소드 단위로 기능이 구현 됨.
	//메소드 반환형
	//메소드 명은 소문자로 시작. 합성어일 경우 두번째 단어의 첫번째 문자를 대문자. 숫자, _, $사용가능.
	//첫 번째 문자는 영어 소문자만 가능.
	public void sum() {//void = 반환값 없음. return하면 오류.
		//기능 구현
		int s=0;
		for(int i=1; i<=10; i++) {
			s+=i;
		}
		System.out.println("s= "+s);
		System.out.println("sum->a "+a);
	}
	public void add(int a, int b) {
		int c=a+b;
		System.out.println("c= "+c);		
		//내부 클래스 - 메소드 내의 내부 클래스
		class BBB{
			
		}//class
	}//add()
	public String getName() {//문자열을 돌려줌.
		return "홍길동";
	}
	//내부 클래스
	class AAA{}
	

	

}//end of class
