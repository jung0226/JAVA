import java.util.Scanner;
class ForEx03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�� �Է�= ");
		int x = scan.nextInt();

		for(int i = 2; i<=9; i++)
		{
			int mul = x*i;
			System.out.println(x+" * "+i+" = "+mul);
			
		}
		
	}
}
/*
�Է� ���� ���� ����ϴ� ���α׷�
����
�� �Է� = 5
5*2=10
:
5*9=45
*/