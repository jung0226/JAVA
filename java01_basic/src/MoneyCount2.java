import java.util.Scanner;
class MoneyCount2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�ݾ��� �Է��ϼ��� = ");
		int money = scan.nextInt();
		
		int won = 50000;
		int danwi = 5;

		while(won>=10){
			int cnt=money/won;
			if(cnt>0){
				System.out.print(won+"��="+cnt);
				if(won>=1000){
					System.out.println("��");
				}else{
					System.out.println("��");
				}
			}
			//���� ȭ�� ����
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
