import java.util.Scanner;
class OperatorEx2 
{
	public static void main(String[] args) 
	{
		//1. �Է�
		Scanner scan = new Scanner(System.in);
		System.out.print("�޴�(1:�簢�� ����, 2: �簢�� �ѷ�): ");
		int menu= scan.nextInt();

		System.out.print("�غ� = ");
		int width= scan.nextInt();
		System.out.print("���� = ");
		int height= scan.nextInt();

		//2. ���		
		String result = (menu==1)?"�簢���� ���̴� "+ width*height:"�簢���� �ѷ��� "+ (width+height)*2;
		System.out.println(result);

		/*���� ��µ���
		int result = (menu==1)?width*height:(width+height)*2;
		String msg = (menu==1)?"����":"�ѷ�";
		
		System.out.printf("�簢���� %s�� %d\n",msg, result);

		*/

		/*
		if(menu==1)
			System.out.println("���� = "+ width*height);
		else 
			System.out.println("�ѷ� = "+ (width+height)*2);
		*/


	}
}
/*

�� ���� �Է¹޾� �簢���� ���� �Ǵ� �簢���� �ѷ��� ���϶�.
�簢���� ���� = �غ�(����)*����(����)
�簢���� �ѷ� = (�غ�+����)*2

����
�޴�(1:�簢�� ����, 2: �簢�� �ѷ�) ->
�غ� ->
���� ->

*/
