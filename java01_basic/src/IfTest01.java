import java.util.Scanner;

class IfTest01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//� ���� �Է¹޾� 0���� Ŭ ���� ����϶�.
		System.out.print("���� �Է�: ");
		double inData = scan.nextDouble(); //�ܼ��� ���ڸ� �Է¹޾� �Ǽ��� �������ִ� �޼ҵ�

		if(inData>0){ //0���� Ŭ �� ����. ���๮�� �� ���̸� ��ȣ ��������.
			System.out.println("inData = "+inData);
		}
		System.out.println("end");
	}
}
/*
��� : if��
���ǽ� : true, false > ����, ���, ���ͷ�
if(���ǽ�){  --> ���ǽ��� ���� �� ����
	���๮;
	���๮;
}
���๮;

*/