import java.util.Scanner;
import java.util.Calendar;
class ForEx06 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ = ");
		int year = scan.nextInt();
		System.out.print("�� = ");
		int month = scan.nextInt();

		Calendar cal = Calendar.getInstance(); //���� ��¥, �ð��� ���õ� ����
		//��¥ ����
		cal.set(year, month-1, 1);
		//����
		int week = cal.get(Calendar.DAY_OF_WEEK);//���� - 1=�����
		//������
		int lastDay=31;
		switch(month){
			case 4: case 6: case 9: case 11:
				lastDay=30;
				break;
			case 2:
				if(year%4==0&&year%100!=0||year%400==0){
					lastDay=29;
				}else{
					lastDay=28;
				}

		}//end of switch
		//int lastDay = cal.getActualMaximum(Calendar.DATE);

		//���� ���
		System.out.println("��	��	ȭ	��	��	��	��");//�Ͽ��� 1 ~ ����� 7
		//1�� ��� �� ���� ���
		for(int s=1;s<week;s++){
			System.out.print("\t");
		}
		//��¥ ���
		for(int i=1;i<=lastDay;i++){
			System.out.print(i+"\t");
			if( (i+(week-1))%7==0 ){//�� �ٿ� ���� ���� 7���� ����ϸ� ���� �ٲ۴�.
				System.out.println();			
			}
		}
		System.out.println();



	}//end of main
}

/*
����
�⵵ = 2020
�� = 7
��	��	ȭ	��	��	��	��
			1	2	3	4
5	6	7	8	9	10	11
12	13	14	15	16	17	18
19	20	21	22	23	24	25
26	27	28	29	30	31
*/