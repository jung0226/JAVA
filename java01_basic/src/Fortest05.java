class  Fortest05
{
	public static void main(String[] args) 
	{		
		//break; �ݺ��� ����.
		//continue; �ݺ��� �� �� �ǳʶ�. continue���� ������� ���� �� ��.
		
		int sum =0;
		for(int i=1;i<=1000;i++){
			sum+=i;
			if(sum>1000)
			{
				System.out.println(i+"-->"+sum);
				//break;
				continue;
			}
			System.out.println("aa");
		}
	}//end of main
}