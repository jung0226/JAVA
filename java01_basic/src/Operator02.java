//java.lang 패키지 내의 클래스는 컴파일러가 알아서 추가를 해준다.
import java.lang.String;
import java.lang.System;


class Operator02 
{
	public static void main(String[] args) 
	{
		int num = 10;
		int data = 5;
		//비교(관계) 연산자 : >, <, >=, <=, ==, !=
		boolean boo = 10> 5;
		System.out.println("boo = "+boo);

		//우선순위 같을시 왼쪽부터 계산. 
		/*	우선순위 
		증감 연산자>산술 연산자>비교 연산자
		*/
		boolean boo2 = 20 <= num*10/2+15- --data; 
		System.out.println("boo2 = "+boo2);

		num = -num;
		System.out.println("num = "+num);

		//삼항 연산자
		//조건식은 true or false
		// = (조건식)?참일 때: 거짓일 때;
		String str = (num>0)? "양수":"음수";
		System.out.println("str= "+str);
	}
}
