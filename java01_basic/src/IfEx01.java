import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{

		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ = ");
		int year = scan.nextInt();
		
		//4�� ����� �⵵ 100���� �������� �ʾƾ� �Ѵ�.
		//400���� �� ������ ������ ����.
		boolean result = year%4==0 && year%100!=0 || year%400==0;
		if(result)
			System.out.println(year+"���� �����Դϴ�.");
		if(!result)
			System.out.println(year+"���� ������ �ƴմϴ�.");
	}
}


/*
�ֿܼ��� �⵵�� �Է¹޾� �������� �ƴ��� �����Ͽ� ����϶�.
����
�⵵ = 2020
2020���� �����Դϴ�.

�⵵ = 2022
2022���� ������ �ƴմϴ�.


*/
