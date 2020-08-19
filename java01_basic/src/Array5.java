class  Array5
{
	public static void main(String[] args) 
	{
		//2차원 배열: 행과 열이 배열을 선언할 때
		int arr[][] = new int [5][3]; //15개의 공간이 생김. 초기값 0
		
		int arr2[][];
		arr2 = new int[5][5];

		//2차원 배열에 데이터 저장하기
		arr[0][1] =30;
		arr[2][0] =10;
		arr[3][2] =20;

		//arr.length = 행의 수
		//arr[행 인덱스].length = 열의 수

		for(int r=0; r<arr.length ; r++){//행 0,1,2,3,4
			for(int c=0; c<arr[r].length; c++){//열 0,1,2,3
				System.out.print(arr[r][c]+"\t");
			}//for
			System.out.println();
		}//for

		//2차원 배열의 초기값 설정
		//int num[][] = new int[][]{}
		int num[][]={
			{30,40,50},
			{40,60,10},
			{40,50,80}
		};
		System.out.println("----------------");
		for(int i=0; i<num.length ; i++){//행 0,1,2,3,4
			for(int j=0; j<num[i].length; j++){//열 0,1,2,3
				System.out.print(num[i][j]+"\t");
			}//for
			System.out.println();
		}//for




	}//end of main
}
