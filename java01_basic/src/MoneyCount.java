import java.util.Scanner;
class MoneyCount 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하세요= ");
		int money = scan.nextInt();

		int i=50000; int j=2;
		int a= money/i;
		if(a>0){
			System.out.println(i+"원 = "+a+"장");
		}
		while(i!=1)
		{
			if(j%2==0)
			{
				a = (money%i)/(i/5);
				i=i/5;
				if(a>0){
					if(i>=1000)
						System.out.println(i+"원 = "+a+"장");
					else
						System.out.println(i+"원 = "+a+"개");
				}
				
			}else if(i==10){
				a = (money%i)/(i/10);
				i=i/10;
				if(a>0){
					System.out.println(i+"원 = "+a+"개");
				}				
			}
			else {
				a = (money%i)/(i/2);
				i=i/2;
				if(a>0){
					if(i>=1000)
						System.out.println(i+"원 = "+a+"장");
					else
						System.out.println(i+"원 = "+a+"개");
				}				
			}
			j++;

		}
		/*
		
		int m50000 = money/50000;
		int m10000 = (money%50000)/10000;
		int m5000 = (money%10000)/5000;
		int m1000 = (money%5000)/1000;
		int m500 = (money%1000)/500;
		int m100 = (money%500)/100;
		int m50 = (money%100)/50;
		int m10 = (money%50)/10;
		int m1 = (money%10)/1;
		

		if(m50000>0){
			System.out.println("50000원 = "+ m50000+"장");
		}
		if(m10000>0){
			System.out.println("10000원 = "+ m10000+"장");
		}
		if(m5000>0){
			System.out.println("5000원 = "+ m5000+"장");
		}
		if(m1000>0){
			System.out.println("1000원 = "+ m1000+"장");
		}
		if(m500>0){
			System.out.println("500원 = "+ m500+"개");
		}
		if(m100>0){
			System.out.println("100원 = "+ m100+"개");
		}
		if(m50>0){
			System.out.println("50원 = "+ m50+"개");
		}
		if(m10>0){
			System.out.println("10원 = "+ m10+"개");
		}
		if(m1>0){
			System.out.println("1원 = "+ m1+"개");
		}
		*/

		/*강사님 방법
		int cnt=money/50000;
		if(cnt> 0){
			System.out.println("50000원"+cnt+"장");
			money = money -(cnt*50000);
		}
		:        
		if((cnt=money/5000) > 0){
			System.out.println("5000원"+cnt+"장");
			money = money -(cnt*5000);
		}
		if((cnt=money/1000) > 0){
			System.out.println("1000원"+cnt+"장");
			money = money -(cnt*1000);
		}
		:
		if((cnt=money/1) > 0){
			System.out.println("1원"+cnt+"장");
			money = money -(cnt*1);
		}
           

		*/
		

	}//end of main
}
