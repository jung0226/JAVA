import java.util.Scanner;
class IfElse01 
{
	public static void main(String[] args) 
	{
		//������ �Է¹޾� ����� ���� ����� 100�� ���Ͽ� ����ϰ�
		//			 �����϶��� �Է¹��� ���� ����� ������ ���� 200�� ���Ͽ� ���.
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� = ");
		int inData = scan.nextInt(); //int ���� ����
		int result = 0;

		if(inData<0){// -
			result = -inData*200;
			//int result = -inData*200; result if���� ���� ���� ����
			System.out.println("result= "+result);
		}else{// 0,+
			result = inData*100;
			System.out.println("result= "+result);
		}
	}
}
/*
if(���ǽ�){//���� ��
	���๮;
}else{//������ ��
	���๮;
}

*/