class ForTest2 
{
	public static void main(String[] args) 
	{
		//지역변수일때 초기값이 없으면 null
		/*ex 
			int sum;
			sum = sum+1;은 null값이랑 더하는 것이 되어서 문법에러.
		*/
		int sum = 0, i=0;//초기화
		for(i = 1; i<=100;i++)
		{
			sum +=i; //sum=sum+i;
		}
		System.out.println("1~"+(i-1)+"까지의 합은 "+sum);			
	}
}
/*
1 ~ 100 까지 합은 5050

*/
