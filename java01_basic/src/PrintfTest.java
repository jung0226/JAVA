public class PrintfTest 
{
	// final ���: �빮�ڷ� ����
	//static public void main(String[] args)
	//public static void main(String args[])
	//public static void main(String data[]) args�� ���� ���ϴ� ������ �ٲ� �� ����.
	public static void main(String[] args) 
	{
		//
		String msg = "�� ��° �ڹ� ������...";
		System.out.println(msg);

		//printf(): ��� ������ �������� �����Ѵ�.
		double result = 10/3.; //�Ǽ��� ��ȯ>> 3. = 3.0
		System.out.println("result= "+result); //��� 3.333333333333335

		//����, �Ǽ�, ���ڿ�
		int numInt =1234;
		String username="ȫ�浿";
		//���� format : %10d
		System.out.printf("numInt(����)=%10d\n",numInt);

		//�Ǽ� format : %10.2f
		System.out.printf("result=%10.2f\n",result);

		//���� format : %10s
		System.out.printf("�̸�=%10s",username);

		System.out.println();

		//�� ���� ���� ������ ���
        System.out.printf("%6.1f, %7d, %5s\n",result, numInt, username);//numInt ��� ���� ���� �־ ����

		//����� : \", \', \n(newline), \t (tab, 8ĭ �鿩���� ���.)
		//�̸� ���: �� �̸��� "ȫ�浿"�Դϴ�.
		System.out.printf("\t�� �̸��� \"%s\"�Դϴ�.\n",username); // "�� ������ ������ �� ����. "ǥ���ϰ� ���� ���� ���� ���� �̿�.

		//�̸� ���: �� �̸��� \ȫ�浿\�Դϴ�.
		// \�� �ڿ��� ����ڰ� �Ǵ� ���. \�� �� �� ����ϸ� \ǥ�� ��.
		System.out.printf("\t�� �̸��� \\%s\\�Դϴ�.",username);


	}
}
