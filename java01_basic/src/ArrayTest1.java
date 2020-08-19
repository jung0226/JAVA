import java.util.Scanner;
class  ArrayTest1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("임의의 수 = "); 
		int max=scan.nextInt();

		//각 숫자를 카운트할 배열
		int cnt[]= new int[10];

		for(int i=1;i<=max;i++){
				cnt[i%10]++;//단 자리			
				if(i>=10) cnt[i/10%10]++;//십자리
				if(i>=100) cnt[i/100%10]++;//백자리
				if(i>=1000) cnt[i/1000%10]++;//천자리                
		}//for

		//출력
		for(int idx=0; idx<cnt.length; idx++){
			System.out.println(idx+"-->"+cnt[idx]);
		}
		
		
	}//end of main
}
