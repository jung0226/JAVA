import java.util.Scanner;
class IfEx02
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//1. �Է�
		System.out.print("ù ��° �� = ");
		int x = scan.nextInt();
		System.out.print("�� ��° �� = ");
		int y = scan.nextInt();

		int sum=0, sub=0, mul=0, div=0;

		//2. ���
		if(x>0&&y>0)
		{
			sum = x+y;
			sub = x-y;
			mul = x*y;
			div = x/y;

			//3. ���
			System.out.println(x+ " + "+ y + " = "+sum);
			System.out.println(x+ " - "+ y + " = "+sub);
			System.out.println(x+ " * "+ y + " = "+mul);
			System.out.println(x+ " / "+ y + " = "+div);        
		}

		
	}
}
/*
�ݵ�� if�� ���
�� ���� �Է¹޾� �� ���� ����� ���� ��Ģ������ �Ͽ� ���.

����
ù ��° �� = 6
�� ��° �� = 6
6 + 4 = 10
6 - 4 = 2
6 * 4 = 24
6 / 4 = 1
*/
