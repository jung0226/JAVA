package javaApi;

import java.util.Scanner;

class ScannerTest 
{
	public static void main(String[] args) 
	{
		//Scanner : �ֿܼ��� ����, ���ڸ� �Է¹��� �� �ִ� Ŭ����
		//1. Ŭ�������� ���������� ���(��ü�� ������ �ʰ� ���)
		//2. ��ü�� �����Ͽ� ���
		//new : ��ü�� �����ϴ� Ű����(=�����)
		//�����: Ư���� ����� �������� ��.
		Scanner scan = new Scanner(System.in);
		//nextInt() -> int, nextDouble() --> double
		//next() --> �� �ܾ �о��
		//nextLine() -> 1���� ���ڷ� �о��.
		System.out.print("���� �Է� = ");
		int data = scan.nextInt();
		
		// 1, 2, 3, 4, 5, 6, 7, 8,
		//¦�� Ȧ�� ������
		//String result =(data%2==0)?"¦��":"Ȧ��";
		String result =(data/2==data/2.0)?"¦��":"Ȧ��";
        
		System.out.println(data+"�� " +result+"�Դϴ�.");

	}
}
