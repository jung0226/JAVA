class  Fortest1
{
	public static void main(String[] args) 
	{
		// �ݺ���
		// 1~10���� ����ϴ� ���α׷� �����
		for(int i =1;i<=10;i++){
			System.out.println('A');
		}
		/*  ���ѷ���
		for(int j=1;;j=j+10)
			System.out.println("Test->"+j);
		*/

		for(int i=1;i<=100;i++){//¦�� ���ϱ�
			if(i%2==0){
				System.out.println(i);
			}
		}

		for(int i=2;i<=100;i+=2){//¦�� ���ϱ�
			System.out.println(i);
		}

		for(int i=10;i>=1;i--){//i--, --i, i=i-1, i-=1
			System.out.println("i = "+i);
			
		}



	}//end of main
}

/*
		�ʱⰪ ������(���ǽ�) ������
	for(int i=1; i<=10 ; i++){

	}

����
1
2
3
4
5
:
10


*/
