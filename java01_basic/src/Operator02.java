//java.lang ��Ű�� ���� Ŭ������ �����Ϸ��� �˾Ƽ� �߰��� ���ش�.
import java.lang.String;
import java.lang.System;


class Operator02 
{
	public static void main(String[] args) 
	{
		int num = 10;
		int data = 5;
		//��(����) ������ : >, <, >=, <=, ==, !=
		boolean boo = 10> 5;
		System.out.println("boo = "+boo);

		//�켱���� ������ ���ʺ��� ���. 
		/*	�켱���� 
		���� ������>��� ������>�� ������
		*/
		boolean boo2 = 20 <= num*10/2+15- --data; 
		System.out.println("boo2 = "+boo2);

		num = -num;
		System.out.println("num = "+num);

		//���� ������
		//���ǽ��� true or false
		// = (���ǽ�)?���� ��: ������ ��;
		String str = (num>0)? "���":"����";
		System.out.println("str= "+str);
	}
}
