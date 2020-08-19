import java.util.Scanner;

class IfTest01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//어떤 수를 입력받아 0보다 클 때만 출력하라.
		System.out.print("숫자 입력: ");
		double inData = scan.nextDouble(); //콘솔의 문자를 입력받아 실수로 변경해주는 메소드

		if(inData>0){ //0보다 클 때 실행. 실행문이 한 줄이면 괄호 생략가능.
			System.out.println("inData = "+inData);
		}
		System.out.println("end");
	}
}
/*
제어문 : if문
조건식 : true, false > 수식, 상수, 리터럴
if(조건식){  --> 조건식이 참일 때 실행
	실행문;
	실행문;
}
실행문;

*/