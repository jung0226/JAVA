import java.util.Scanner;
class  DoWhileEx
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);		

		while(true){
		System.out.print("정수 입력 = ");
		int num=scan.nextInt();
		int tot=0, evensum=0, oddsum=0, i=1;
		if(num<0) {
			System.out.println("프로그램이 종료되었습니다."); 
			break;
			}

			while(i<=num){
				
				if(i%2==0){
					evensum+=i;
				}else {
					oddsum+=i;
				}
			i++;
			tot=evensum+oddsum;
			}//while
			System.out.println("1~"+num+"까지의 합은 "+tot);
			System.out.println("1~"+num+"까지의 홀수의 합은 "+oddsum);
			System.out.println("1~"+num+"까지의 짝수의 합은 "+evensum);
			System.out.println();
		}//whlie

		/*
		do{
			System.out.print("정수입력= ");
			int max=scan.nextInt();
			if(max<0){
				System.out.print("프로그램이 종료되었습니다.");
				break;
			}
			//0보다 크거나 같을 때
			int tot=0, evensum=0, oddsum=0, i=0;
			while(i<max){	
				i++;
				if(i%2==0){
					evensum+=i;
				}else {
					oddsum+=i;
				}
			
			tot=evensum+oddsum;
			}//while
			System.out.println("1~"+max+"까지의 합은 "+tot);
			System.out.println("1~"+max+"까지의 홀수의 합은 "+oddsum);
			System.out.println("1~"+max+"까지의 짝수의 합은 "+evensum);
			System.out.println();
		}while(true);
		*/

	}//end of main
}
/*
==반드시 while 또는 do~while
== 0보다 작은 수가 입력되면 프로그램이 종료됨.
실행
정수입력 = 100
1~100까지의 합은 5050
1~100까지의 홀수의 합은 2500
1~100까지의 짝수의 합은 2550

정수입력 = 150
1~150까지의 합은 ____
1~150까지의 홀수의 합은 ____
1~150까지의 짝수의 합은 ____

정수입력 = -1
프로그램이 종료되었습니다.

*/
