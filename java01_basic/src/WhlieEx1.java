import java.util.Scanner;
class  WhlieEx1
{
	public static void main(String[] args) 
	{
		//�ݺ����� while�� �̿�.
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �� = ");
		int num = scan.nextInt();
		int sum=0;
		int i=1;

		while(sum<=num){			
			sum +=i;
			i++;
		}
		System.out.println("1���� "+i+"������ ���� " +sum+"�̴�.");
	}//end of main
}
/*
������ ���� �Է¹޾� 
1���� ���� ���ϴµ� ���� �Է¹��� ���� ���ʷ� �ʰ��ϴ� ������ ���� ���� ���϶�.
while��

����
������ �� = 253254
1���� __������ ����  __�̴�.
*/