import java.util.Scanner;
class ArrayEx4 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�л� �� = ");
		int stuNum = scan.nextInt();

		String name[] = new String[stuNum];
		double jumsu[][] = new double[stuNum+2][6];		
		
		for(int i=0; i<name.length; i++){
			System.out.print("�̸� = ");
			name[i]= scan.next(); //Line���� �ϸ� "�̸�= "�� 2�� ��µ�.
			int j=0;
			do{
				System.out.print("���� = ");
				jumsu[i][j] = scan.nextDouble(); //jumsu[i][i]
				int kor=(int)jumsu[i][j];

				System.out.print("���� = ");
				jumsu[i][j+1] = scan.nextDouble();
				int eng=(int)jumsu[i][j+1];

				System.out.print("���� = ");
				jumsu[i][j+2] = scan.nextDouble();
				int mat=(int)jumsu[i][j+2];

				//����
				int sum=kor+eng+mat;
				jumsu[i][j+3]=sum;

				//���
				double avg= sum/3.0;
				jumsu[i][j+4]=avg;

				j++;
				if(j==1) break;
			}while(true);

			System.out.println();
		}//for��

		//���� ���ϱ�
		for(int j=0;j<3;j++){
			for(int i=0;i<jumsu.length-2;i++){
				jumsu[jumsu.length-2][j]+=jumsu[i][j];
			}//for
		}//for

		//��� ���ϱ�
		for(int j=0;j<3;j++){			
				jumsu[jumsu.length-1][j]=jumsu[jumsu.length-2][j]/(jumsu.length-2);			
		}//for

		//�������ϱ�
		for(int i=0;i<=jumsu.length-2; i++){
			jumsu[i][jumsu[i].length-1]=stuNum;			
		}
		for(int i=0;i<jumsu.length-2;i++){
			if(jumsu[i][jumsu[i].length-2]>jumsu[i+1][jumsu[i].length-2]) 
				jumsu[i][jumsu[i].length-1]-=1;
		}


		//���
		System.out.println("�̸�\t ����\t ����\t ����\t ����\t ���\t ����\t");
		for(int i=0; i<name.length; i++){
				System.out.print(name[i]+"\t ");
			
			for(int j=0; j<jumsu[i].length; j++){
				System.out.print(jumsu[i][j]+"\t ");
			}			
			System.out.println();
		}//for

		

		//���� ����,��� ���
		for(int i=jumsu.length-2; i<jumsu.length; i++){	
			if(i==jumsu.length-2){
				System.out.print("����\t ");
			}else{
				System.out.print("���\t ");
			}
			for(int j=0; j<jumsu[i].length-2; j++){
				System.out.print(jumsu[i][j]+"\t ");
			}			
			System.out.println();
		}//for

		
		
	}//end of main
}
/*
�л� �� �Է¹ް� �̸�, 3(����, ����, ����)���������� �Է¹��� �� ���κ� ����, ���, ������ ���ϰ�
�� ���� ������ ����� ���϶�.
��, ���������� ����Ѵ�.

����
�л� �� = 3
�̸� = ȫ�浿
���� = 90
���� = 80
���� = 90
�̸� = �ڱ浿
:
�̸�		���� ���� ����  ����  ���  ����
ȫ�浿	90	80	90	260  __  ___
�ڱ浿	__	__	__	__	 __	 ___
:
����		__	__	__
���		__	__	__
*/
