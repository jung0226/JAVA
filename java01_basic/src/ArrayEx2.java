import java.util.Scanner;
class ArrayEx2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String title[]={"����", "����", "����", "��ȸ" ,"����", "����", "����", "ȭ��", "����"};
		int jumsu[]= new int[9];

		for(int idx=0; idx<title.length; idx++){//0, 1, 2, 3, .....8
			System.out.print(title[idx]+"= ");			
			jumsu[idx] = scan.nextInt();
		}

		//����
		int tot=0;
		for(int j:jumsu){
			tot+=j;
		}
		//���
		double ave=tot/9.0;
		//����
		String grade="";
		switch((int)(ave/10)){// 0,1,2,3,...10
			case 10: case 9: grade="A";break; 
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D";break;
			default: grade="F";
			
		}
		System.out.println("���� = "+tot);
		System.out.println("��� = "+ave);
		System.out.println("���� = "+grade);
	}//end of main
}
/*
����
����= 
����= 
����= 
:
:
:
����= _____
���= _____
����= _____
*/
