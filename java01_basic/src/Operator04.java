import java.util.Scanner;
class Operator04 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("���� �Է�: ");
		int inData = scan.nextInt();

		String result = (inData>1 && inData<=100)? "�ֽ��ϴ�." : "�����ϴ�." ;

		System.out.println(inData+"�� ���� ���� ���� "+result);

	}
}


/*
����
���� �Է�:59

59�� ���� ���� ���� �ֽ��ϴ�.
-38�� ���� ���� ���� �����ϴ�.
0�� ���� ���� ���� �����ϴ�.


*/
