class  Fortest6
{
	public static void main(String[] args) 
	{
		for(int i = 1; i <6;i++){
			for(int j = 1; j<6 ;j++){
				System.out.print("*");
			}
			System.out.println();//줄 변경
		}
		/*
		실행결과
		*
		**
		***
		****
		*****
		
		*/
		
		System.out.println();//줄 변경
		for(int i = 1; i <6;i++){
			for(int j =1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();//줄 변경
		}
		System.out.println();

		/*
		실행결과
		***** 1~5
		****  1~4
		***   1~3
		**    1~2
		*     1~1

		*/

		for(int i=1; i<6 ; i++){
			for(int j = 5; j>=i ; j--){
				System.out.print("*");
			}
			System.out.println();
		}
		/* 같은 결과
		for(int i = 5 ; i>=1 ; i--){//5 4 3 2 1
			for(int j=1 ; j<=i ; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		*/

		/*
		     *  별 1 공백 4, 5-출력변수 = 4
			**  별 2 공백 3, 5-출력변수 = 3
		   ***  별 3 공백 2, 5-출력변수 = 2
		  ****  별 4 공백 1, 5-출력변수 = 1
		 *****  별 5 공백 0  별+공백 = 합5
		
		*/
		
		System.out.println();

		for(int i=1 ; i<=5 ; i++){//별의 수 1,2,3,4,5
			
			//공백
			for(int space=1; space<=5-i; space++){
				System.out.print(" ");
			}
			//별
			for(int j=1;j<=i;j++){		
				System.out.print("@");							
			}			
			System.out.println();//줄바꿈
		}

		/*
		
		*****  별 5 공백 0
		 ****  별 4 공백 1
		  ***  별 3 공백 2
		   **  별 2 공백 3
		    *  별 1 공백 4

			5 - 현재 출력하는 별의 수= 공백
		*/
		System.out.println();

		for(int i=5 ; i>=1 ; i--){//별의 수 1,2,3,4,5

			//공백
			for(int space=1;space<=5-i;space++){		
				System.out.print(" ");							
			}	
			
			//별
			for(int j=1; j<=i; j++){
				System.out.print("@");
			}
					
			System.out.println();//줄바꿈
		}

		/*
				*     별 1 공백 4 4. 9-별 =8. 8/2=4(공백의 수)
			   ***    별 3 공백 3 3
			  *****   별 5 공백 2 2 
			 *******  별 7 공백 1 1
			********* 별 9 공백 0 0
			 별 = 줄+2
		*/

		for(int i=1; i <= 9; i+=2){//별 1 3 5 7 9
			//공백 4 3 2 1
			for(int s=1;s<=(9-i)/2;s++){
				System.out.print(" ");
			}
			//별 출력
			for(int k=1;k<=i;k++){
				System.out.print("$");
			}

			System.out.println();//줄바꿈
		}	


	}//end of main
}
/*
중첩 반복문 : 반복문내의 반복문

실행
1	2	3	4	5
1	2	3	4	5
1	2	3	4	5
1	2	3	4	5
1	2	3	4	5
*/