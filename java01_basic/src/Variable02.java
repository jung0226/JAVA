class  Variable02
{
	public static void main(String[] args) 
	{
		//�Ǽ�: float(4byte), double(8byte, �⺻ Ÿ��)

		float num = (float)10.5;
		//float num = 10.5f;
		double num2 = 25.5;

		System.out.println("num= "+num);
		System.out.println("num2= "+num2);

		//����,���� = ����
		//����,�Ǽ� = �Ǽ�
		double result = num2/5;
		double resultInt = 15/(double)4; //���� ���ϴ� ����

		System.out.println("result= "+result);
		System.out.println("resultInt= "+resultInt);

		//���� ������ ó�� boolean
		boolean boo = true;
		System.out.println("boo= "+boo);
		//������ : 1����
		char c1= 'A';
		char c2= 'B';
		System.out.println(c1+","+c2);

		c1++;
		System.out.println("c1= "+c1);

		c1 =(char)(c1+1);
		System.out.println("c1= "+c1);

		c1 =(char)(120);
		System.out.println("c1= "+c1);

		String userName ="ȫ�浿";
		String addr = "����� ������ �ż���";

		System.out.println(userName);
		System.out.println(addr);

	}
}
