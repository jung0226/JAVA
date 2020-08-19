class  Fortest05
{
	public static void main(String[] args) 
	{		
		//break; 반복문 종료.
		//continue; 반복문 한 번 건너뜀. continue다음 문장들이 실행 안 됨.
		
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