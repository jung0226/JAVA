import java.util.Scanner;
class MoneyCount 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�ݾ��� �Է��ϼ���= ");
		int money = scan.nextInt();

		int i=50000; int j=2;
		int a= money/i;
		if(a>0){
			System.out.println(i+"�� = "+a+"��");
		}
		while(i!=1)
		{
			if(j%2==0)
			{
				a = (money%i)/(i/5);
				i=i/5;
				if(a>0){
					if(i>=1000)
						System.out.println(i+"�� = "+a+"��");
					else
						System.out.println(i+"�� = "+a+"��");
				}
				
			}else if(i==10){
				a = (money%i)/(i/10);
				i=i/10;
				if(a>0){
					System.out.println(i+"�� = "+a+"��");
				}				
			}
			else {
				a = (money%i)/(i/2);
				i=i/2;
				if(a>0){
					if(i>=1000)
						System.out.println(i+"�� = "+a+"��");
					else
						System.out.println(i+"�� = "+a+"��");
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
			System.out.println("50000�� = "+ m50000+"��");
		}
		if(m10000>0){
			System.out.println("10000�� = "+ m10000+"��");
		}
		if(m5000>0){
			System.out.println("5000�� = "+ m5000+"��");
		}
		if(m1000>0){
			System.out.println("1000�� = "+ m1000+"��");
		}
		if(m500>0){
			System.out.println("500�� = "+ m500+"��");
		}
		if(m100>0){
			System.out.println("100�� = "+ m100+"��");
		}
		if(m50>0){
			System.out.println("50�� = "+ m50+"��");
		}
		if(m10>0){
			System.out.println("10�� = "+ m10+"��");
		}
		if(m1>0){
			System.out.println("1�� = "+ m1+"��");
		}
		*/

		/*����� ���
		int cnt=money/50000;
		if(cnt> 0){
			System.out.println("50000��"+cnt+"��");
			money = money -(cnt*50000);
		}
		:        
		if((cnt=money/5000) > 0){
			System.out.println("5000��"+cnt+"��");
			money = money -(cnt*5000);
		}
		if((cnt=money/1000) > 0){
			System.out.println("1000��"+cnt+"��");
			money = money -(cnt*1000);
		}
		:
		if((cnt=money/1) > 0){
			System.out.println("1��"+cnt+"��");
			money = money -(cnt*1);
		}
           

		*/
		

	}//end of main
}
