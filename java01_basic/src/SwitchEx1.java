import java.util.Scanner;
class  SwitchEx1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�� �Է� : ");
		int month = scan.nextInt();

		if(month>=1 && month<=12){
		String season="";
		switch(month){
				case 11: case 12: case 1: case 2:
					season = "�ܿ�";
					break;
				case 3:	case 4:	case 5:
					season = "��";
					break;
				case 6:	case 7:	case 8:
					season = "����";
					break;
				case 9:	case 10:
					season = "����";
					break;
			}
		System.out.println(month+"���� "+season+"�Դϴ�.");
	}else {
		System.out.println("���� �߸� �Է��߽��ϴ�.");
	}	

/*  
	switch(month){
			case 11:
			case 12:
			case 1:
			case 2:
				System.out.println(month+"���� �ܿ��Դϴ�.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println(month+"���� ���Դϴ�.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(month+"���� �����Դϴ�.");
				break;
			case 9:
			case 10:
				System.out.println(month+"���� �����Դϴ�.");
				break;
		}

*/

	}
}
/*

*/