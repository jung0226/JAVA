import java.util.Scanner;
class  ArrayTest1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �� = "); 
		int max=scan.nextInt();

		//�� ���ڸ� ī��Ʈ�� �迭
		int cnt[]= new int[10];

		for(int i=1;i<=max;i++){
				cnt[i%10]++;//�� �ڸ�			
				if(i>=10) cnt[i/10%10]++;//���ڸ�
				if(i>=100) cnt[i/100%10]++;//���ڸ�
				if(i>=1000) cnt[i/1000%10]++;//õ�ڸ�                
		}//for

		//���
		for(int idx=0; idx<cnt.length; idx++){
			System.out.println(idx+"-->"+cnt[idx]);
		}
		
		
	}//end of main
}
