class WhileTest2 
{
	public static void main(String[] args) 
	{
		int row=1;
		while(row<5){//줄

			int col=1;
			while(col<=5){
				System.out.print(col);
				col++;
			}
			System.out.println();
			row++;
		}//row while
	}//end of main
}
/*
while문으로 만들기
12345
12345
12345
12345
12345

*/
