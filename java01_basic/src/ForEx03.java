import java.util.Scanner;
class ForEx03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력= ");
		int x = scan.nextInt();

		for(int i = 2; i<=9; i++)
		{
			int mul = x*i;
			System.out.println(x+" * "+i+" = "+mul);
			
		}
		
	}
}
/*
입력 받은 단을 출력하는 프로그램
실행
단 입력 = 5
5*2=10
:
5*9=45
*/