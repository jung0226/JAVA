class Array1 
{
	public static void main(String[] args) 
	{
		//�迭 : ���� ������ ���� ������ ������ �ʿ��� �� ����.
		//�迭�� ���� ���� ������ index�� �̿��Ͽ� ������ �� �ִ�.

		//�迭 ���� ��� - ������ 10���� ������ ����
		int[] num = new int[11];//int num[]�� ����. 0���� �ʱⰪ
		double num2[] = new double[5];//0.0���� �ʱⰪ
		String name[] = new String[10];//null���� �ʱ� ����

		num[1]=90;
		num[3]=100;
		num[7]=80;
		//				�迭�� ���� = ������ ����
		//				idx<num.length-1, idx<=num.length-2
		for(int idx=0; idx<num.length;idx++){
			num[10]+=num[idx];
			System.out.println("num["+idx+"]=" +num[idx]);
		}
		System.out.println("sum="+num[10]);

	}//end of main
}
