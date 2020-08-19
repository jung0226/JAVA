class  Fortest1
{
	public static void main(String[] args) 
	{
		// 반복문
		// 1~10까지 출력하는 프로그램 만들기
		for(int i =1;i<=10;i++){
			System.out.println('A');
		}
		/*  무한루프
		for(int j=1;;j=j+10)
			System.out.println("Test->"+j);
		*/

		for(int i=1;i<=100;i++){//짝수 구하기
			if(i%2==0){
				System.out.println(i);
			}
		}

		for(int i=2;i<=100;i+=2){//짝수 구하기
			System.out.println(i);
		}

		for(int i=10;i>=1;i--){//i--, --i, i=i-1, i-=1
			System.out.println("i = "+i);
			
		}



	}//end of main
}

/*
		초기값 최종값(조건식) 증가값
	for(int i=1; i<=10 ; i++){

	}

실행
1
2
3
4
5
:
10


*/
