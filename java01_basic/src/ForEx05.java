import java.util.Scanner;
class ForEx05 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �� = ");
		int num = scan.nextInt();
		int sum = 0;

		for(int i=1;;i++){
			sum+=i;
			if(sum>num){
				System.out.println("1���� "+i+"������ ���� "+sum+"�̴�.");
				break;
			}
		}
	}
}
/*
������ ���� �Է¹޾� 
1���� ���� ���ϴµ� ���� �Է¹��� ���� ���ʷ� �ʰ��ϴ� ������ ���� ���� ���϶�.
for��

����
������ �� = 253254
1���� __������ ����  __�̴�.
*/
