import java.util.Scanner;
class ForEx04 
{
	public static void main(String[] args) 
	{
		Scanner src = new Scanner(System.in);
		System.out.print("수 입력 = ");
		int max = src.nextInt();
		int i=0, sum=0, evenSum=0, oddSum=0;

		for(i=1;i<=max;i++)
		{
			sum +=i;

			if(i%2==0)
			{
				evenSum +=i;
			}else
			{
				oddSum +=i;
			}
		}
		System.out.println("1~"+max+"까지의 합은 "+sum); //sum = oddSum+evenSum
		System.out.println("1~"+max+"까지의 홀수의 합은 "+oddSum);
		System.out.println("1~"+max+"까지의 짝수의 합은 "+evenSum);

		
	}
}
/*
어떤 수 (정수)를 입력받아
입력받은 수까지 짝수의 합, 홀수의 합, 전체 합을 구하여라.

실행
수 입력 = 100
1~100까지의 합은 5050
1~100까지의 홀수의 합은 2500
1~100까지의 짝수의 합은 2550
*/

