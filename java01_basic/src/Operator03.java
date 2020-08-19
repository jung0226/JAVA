import java.util.Scanner;
class Operator03 
{
	public static void main(String[] args) 
	{
		//객체 생성
		Scanner s = new Scanner(System.in);

		System.out.print("정수 입력: ");
		int data = s.nextInt();
		
		String result = (data>0)? "양수" : (data<0)? "음수":"0" ;

		System.out.printf("%d는 %s입니다.\n", data, result);

		
	}
}

/*
실행
정수입력 =85

85은 양수 입니다.
-85는 음수 입니다.
0은 0입니다.

*/