package javaApi;

import java.util.Scanner;

class ScannerTest 
{
	public static void main(String[] args) 
	{
		//Scanner : 콘솔에서 숫자, 문자를 입력받을 수 있는 클래스
		//1. 클래스명을 직접적으로 사용(객체를 만들지 않고 사용)
		//2. 객체를 생성하여 사용
		//new : 객체를 생성하는 키워드(=예약어)
		//예약어: 특정한 기능을 만들어놓은 것.
		Scanner scan = new Scanner(System.in);
		//nextInt() -> int, nextDouble() --> double
		//next() --> 한 단어를 읽어옴
		//nextLine() -> 1줄을 문자로 읽어옴.
		System.out.print("정수 입력 = ");
		int data = scan.nextInt();
		
		// 1, 2, 3, 4, 5, 6, 7, 8,
		//짝수 홀수 구별식
		//String result =(data%2==0)?"짝수":"홀수";
		String result =(data/2==data/2.0)?"짝수":"홀수";
        
		System.out.println(data+"는 " +result+"입니다.");

	}
}
