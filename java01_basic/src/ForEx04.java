import java.util.Scanner;
class ForEx04 
{
	public static void main(String[] args) 
	{
		Scanner src = new Scanner(System.in);
		System.out.print("�� �Է� = ");
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
		System.out.println("1~"+max+"������ ���� "+sum); //sum = oddSum+evenSum
		System.out.println("1~"+max+"������ Ȧ���� ���� "+oddSum);
		System.out.println("1~"+max+"������ ¦���� ���� "+evenSum);

		
	}
}
/*
� �� (����)�� �Է¹޾�
�Է¹��� ������ ¦���� ��, Ȧ���� ��, ��ü ���� ���Ͽ���.

����
�� �Է� = 100
1~100������ ���� 5050
1~100������ Ȧ���� ���� 2500
1~100������ ¦���� ���� 2550
*/

