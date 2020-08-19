import java.util.Scanner;
class MoneyCount2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하세요 = ");
		int money = scan.nextInt();
		
		int won = 50000;
		int danwi = 5;

		while(won>=10){
			int cnt=money/won;
			if(cnt>0){
				System.out.print(won+"원="+cnt);
				if(won>=1000){
					System.out.println("장");
				}else{
					System.out.println("개");
				}
			}
			//다음 화폐 단위
			money -=cnt*won;
			won = won/danwi;//10000
			if(danwi==5){
				danwi=2;
			}else{
				danwi=5;
			}

		}//while

	}
}
