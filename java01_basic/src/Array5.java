class  Array5
{
	public static void main(String[] args) 
	{
		//2���� �迭: ��� ���� �迭�� ������ ��
		int arr[][] = new int [5][3]; //15���� ������ ����. �ʱⰪ 0
		
		int arr2[][];
		arr2 = new int[5][5];

		//2���� �迭�� ������ �����ϱ�
		arr[0][1] =30;
		arr[2][0] =10;
		arr[3][2] =20;

		//arr.length = ���� ��
		//arr[�� �ε���].length = ���� ��

		for(int r=0; r<arr.length ; r++){//�� 0,1,2,3,4
			for(int c=0; c<arr[r].length; c++){//�� 0,1,2,3
				System.out.print(arr[r][c]+"\t");
			}//for
			System.out.println();
		}//for

		//2���� �迭�� �ʱⰪ ����
		//int num[][] = new int[][]{}
		int num[][]={
			{30,40,50},
			{40,60,10},
			{40,50,80}
		};
		System.out.println("----------------");
		for(int i=0; i<num.length ; i++){//�� 0,1,2,3,4
			for(int j=0; j<num[i].length; j++){//�� 0,1,2,3
				System.out.print(num[i][j]+"\t");
			}//for
			System.out.println();
		}//for




	}//end of main
}
