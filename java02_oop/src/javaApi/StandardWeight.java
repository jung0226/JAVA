package javaApi;

//�ؼ� ����.
import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("���� = ");
		int age = scan.nextInt();

		System.out.print("����(1:����, 2:����) = ");
		int menu = scan.nextInt();

		//��������
		
		int height=0, weight=0;
		double stWeight=0; //ǥ�� ü��
		double bodyCondition=0;//ǥ�� ü�� ����
		String result="";//ǥ��ü������ �� ����
		/* ����� ���
			1. �Է� ��(����, ����, Ű, ���� ü��)�� �� ���� ����
			2. ǥ��ü���� 3�� ���
			//ǥ��ü��
			double standard = 0.90;
			if(age<=35 && gender==2){
				standard = 0.85;
			}else if(age>=36 && gender==1){
				standard = 0.95;
			}
			double standrdWeight = (height-100)*standard;

			3.ǥ��ü������
			double standardIndex=(weight/standrdWeight)*100;
			
			4.ü��
			String standardName="";
			if(standardIndex<=85) //85���� ������ �ؿ� �� ����X. else if ��������.
				standardName = "������"; //85 ���� ū ��� �ٷ� �ؿ� ���� �����ؼ� && �Ƚᵵ ��.
			else if(standardIndex<=95)
				standardName = "���ݸ�����";
			else if(standardIndex<=115)
				standardName = "ǥ����";
			else if(standardIndex<=125)
				standardName = "���ݺ���";
			else if(standardIndex>=126)
				standardName = "����";

			5.���

		
		*/



		switch(menu){
			case 1: //����			
			System.out.print("Ű = ");
			height = scan.nextInt();

			System.out.print("���� ü�� = ");
			weight = scan.nextInt();
			if(age>=0 && age<=35){
				stWeight = (height-100)*0.90;
			}else if(age>=36){
				stWeight = (height-100)*0.95;}
			
			//�ߺ��Ǵ� �ڵ�

			bodyCondition = (weight/stWeight)*100;	

			if(bodyCondition<=85)
				result = "������";
			else if(bodyCondition>85 && bodyCondition<=95)
				result = "���ݸ�����";
			else if(bodyCondition>95 && bodyCondition<=115)
				result = "ǥ����";
			else if(bodyCondition>115 && bodyCondition<=125)
				result = "���ݺ���";
			else if(bodyCondition>=126)
				result = "����";
			
			System.out.println("ǥ�� ü�� = "+stWeight);
			System.out.println("����� ǥ��ü��������"+bodyCondition+ "���� "+result+ "�Դϴ�.");


			break;


			case 2: //����
				System.out.print("Ű = ");
				height = scan.nextInt();

				System.out.print("���� ü�� = ");
				weight = scan.nextInt();

				if(age>=0 && age<=35){
					stWeight = (height-100)*0.85;
				}else if(age>=36){
					stWeight = (height-100)*0.90;
				}

				//�ߺ��Ǵ� �ڵ�

				bodyCondition = (weight/stWeight)*100;	

				if(bodyCondition<=85)
					result = "������";
				else if(bodyCondition>85 && bodyCondition<=95)
					result = "���ݸ�����";
				else if(bodyCondition>95 && bodyCondition<=115)
					result = "ǥ����";
				else if(bodyCondition>115 && bodyCondition<=125)
					result = "���ݺ���";
				else if(bodyCondition>=126)
					result = "����";
				
				System.out.println("ǥ�� ü�� = "+stWeight);
				System.out.println("����� ǥ��ü��������"+bodyCondition+ "���� "+result+ "�Դϴ�.");

			
			
			break;
						
			default:
				System.out.println("������ �߸� �Է��Ͽ����ϴ�.");			
			}
		
	}//end of main
}//end of class
