class SwitchTest 
{
	public static void main(String[] args) 
	{
		//
		int data = 3;
		//data ���� 1: ����, 2: ���, 3:�Ķ�, 4:����, ������ : ���

		String color; //null. "">���鰪
		switch(data){
			case 1:
				color="����";
				break;
			case 2:
				color="���";
				break;
			case 3:
				color="�Ķ�";
				break;
			case 4:
				color="����";
				break;
			case 5:
				color="�ϴû�";
				break;
			default:
				color="�ϴû�";
		}
		System.out.print(color);

	}
}
/*
������ �������� ���� ���ǹ�
�⺻ ������ Ÿ���� int���� ���� Ÿ��(byte, short, int)
			  char, String :���ڿ�
a+b a/3 50 'A' "ȫ�浿"

switch(����, ���){
	case ���: ���๮;
			  ���๮;
			  [break];
	case ���: ���๮;
			  ���๮;
			  [break];
	[default: ���๮;
			 ���๮;]		
}

[] : ���� ����
*/