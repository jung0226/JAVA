import java.util.Scanner;
class  DoWhileEx
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);		

		while(true){
		System.out.print("���� �Է� = ");
		int num=scan.nextInt();
		int tot=0, evensum=0, oddsum=0, i=1;
		if(num<0) {
			System.out.println("���α׷��� ����Ǿ����ϴ�."); 
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
			System.out.println("1~"+num+"������ ���� "+tot);
			System.out.println("1~"+num+"������ Ȧ���� ���� "+oddsum);
			System.out.println("1~"+num+"������ ¦���� ���� "+evensum);
			System.out.println();
		}//whlie

		/*
		do{
			System.out.print("�����Է�= ");
			int max=scan.nextInt();
			if(max<0){
				System.out.print("���α׷��� ����Ǿ����ϴ�.");
				break;
			}
			//0���� ũ�ų� ���� ��
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
			System.out.println("1~"+max+"������ ���� "+tot);
			System.out.println("1~"+max+"������ Ȧ���� ���� "+oddsum);
			System.out.println("1~"+max+"������ ¦���� ���� "+evensum);
			System.out.println();
		}while(true);
		*/

	}//end of main
}
/*
==�ݵ�� while �Ǵ� do~while
== 0���� ���� ���� �ԷµǸ� ���α׷��� �����.
����
�����Է� = 100
1~100������ ���� 5050
1~100������ Ȧ���� ���� 2500
1~100������ ¦���� ���� 2550

�����Է� = 150
1~150������ ���� ____
1~150������ Ȧ���� ���� ____
1~150������ ¦���� ���� ____

�����Է� = -1
���α׷��� ����Ǿ����ϴ�.

*/
