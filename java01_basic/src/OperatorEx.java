import java.util.Scanner;
class OperatorEx 
{
	public static void main(String[] args) 
	{

		Scanner x = new Scanner(System.in);
		
		//1. �޿��Է�
		System.out.print("�޿��Է� = ");
		int salary = x.nextInt();
		//2. ���
		double bonus=(salary>=2000000)?salary*0.05:salary*0.1;
		double tot = salary+bonus;
		//3.���
		System.out.printf("�޿� = %d\n���ʽ� = %.2f\n���޾� = %.2f\n",salary,bonus,tot);	

	}
}
/*
�޿��� �Է¹޾� �޿��� 200���� �̸��̸� ���ʽ��� ��10%�����ϰ�,
�޿��� 200�����̻��̸� ���ʽ��� 5% �����ϴ� ���α׷��� �ۼ�.

����
�޿��Է�=
�޿�=
���ʽ�=
���޾�


*/
