import java.util.Scanner;
class IfEx02
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//1. 입력
		System.out.print("첫 번째 수 = ");
		int x = scan.nextInt();
		System.out.print("두 번째 수 = ");
		int y = scan.nextInt();

		int sum=0, sub=0, mul=0, div=0;

		//2. 계산
		if(x>0&&y>0)
		{
			sum = x+y;
			sub = x-y;
			mul = x*y;
			div = x/y;

			//3. 출력
			System.out.println(x+ " + "+ y + " = "+sum);
			System.out.println(x+ " - "+ y + " = "+sub);
			System.out.println(x+ " * "+ y + " = "+mul);
			System.out.println(x+ " / "+ y + " = "+div);        
		}

		
	}
}
/*
반드시 if문 사용
두 수를 입력받아 두 수가 양수일 때만 사칙연산을 하여 출력.

실행
첫 번째 수 = 6
두 번째 수 = 6
6 + 4 = 10
6 - 4 = 2
6 * 4 = 24
6 / 4 = 1
*/
