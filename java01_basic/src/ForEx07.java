import java.util.Scanner;
class ForEx07 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("홀수 입력 = ");
		int max = scan.nextInt();

		if(max%2==0){//max이 짝수인 경우
			max++;
		}
		
		char txt ='A';		

		for(int i=1; i <= max; i+=2){//문자 1 3 5 7 9 ... max
			//공백 4 3 2 1
			for(int s=1;s<=(max-i)/2;s++){
				System.out.print(" ");
			}
			//문자 출력
			for(int k=1; k<=i; k++){//1
				System.out.print(txt++);
				if(txt>'Z')	txt='A';
			}
			System.out.println();//줄바꿈

		}
		//하단
		for(int i=max-2; i >=1; i-=2){//문자 max ... 7 5 3 1
			//공백 0 1
			for(int s=1;s<=(max-i)/2;s++){
				System.out.print(" ");
			}
			//문자 출력
			for(int k=1; k<=i; k++){
				System.out.print(txt++);
				if(txt>'Z')	txt='A';
			}

			System.out.println();//줄바꿈
		}
		

	}//end of main
}

/*
실행
홀수 입력 = 11
홀수에 따라 삼각형의 크키가 달라짐.
			A
		   BCD
		  EFGHI
		 JKLMNOP
		QRSTUVWXY
	   ZABCDEFGHIJ <--11개
	    KLMNOPQRS
		 TUVWXYZ
		  ABCDE
		   FGH
		    I

*/
