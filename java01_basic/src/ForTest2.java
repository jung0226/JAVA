class ForTest2 
{
	public static void main(String[] args) 
	{
		//���������϶� �ʱⰪ�� ������ null
		/*ex 
			int sum;
			sum = sum+1;�� null���̶� ���ϴ� ���� �Ǿ ��������.
		*/
		int sum = 0, i=0;//�ʱ�ȭ
		for(i = 1; i<=100;i++)
		{
			sum +=i; //sum=sum+i;
		}
		System.out.println("1~"+(i-1)+"������ ���� "+sum);			
	}
}
/*
1 ~ 100 ���� ���� 5050

*/
