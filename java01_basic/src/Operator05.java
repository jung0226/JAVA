class Operator05 
{
	public static void main(String[] args) 
	{
		//��Ʈ ������ : 2���� ����� �ϴ� ������
		//			$, |, ~(����), ^(EOR:�� ���� �ٸ� �� ��)


		int a = 10;
		int b = 3;
		int c = a & b;

		System.out.println("c= "+c);

		int d = a | b;

		System.out.println("d= "+d);

		//������ ��� 2�� ������ �����.
		//2�� ������ 1�� ���� + 1�� �ϸ� �ȴ�.
		//1�� ������ 0->1, 1->0���� �ٲٴ� ��.
		int e= ~a;
		System.out.println("e= "+e);

		int f= a^b;
		System.out.println("f= "+f);

		//����Ʈ������
		// <<:�������� �̵�(0���� ä����, ��ġ�� ����), >>:���������� �̵�(��ȣ�� ä����)
		// >>>:���������� �̵�(0���� ä����)

		int g = a<<2; //40 -->��
		System.out.println("g= "+g);

		a=-10;

		int h = a>>2; //2 -->
		System.out.println("h= "+h);//3

		int i = a>>>2;
		System.out.println("i= "+i);//62

		

	}
}
