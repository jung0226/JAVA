import java.util.Scanner;
class IfElseEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�޴�(1:�簢���� ����, 2:���� ����): ");
		int menu = scan.nextInt();
		int widht = 0, height =0, radius=0;
		double tot=0;

		if(menu==1){
			System.out.print("�غ�= ");
			widht = scan.nextInt();
			System.out.print("����= ");
			height = scan.nextInt();
			
			tot = widht*height;
			System.out.println("�簢���� ���̴� "+tot+"�Դϴ�.");

		}else{//1���� ��
			if(menu==2){
				System.out.print("������= ");
				radius = scan.nextInt();
			
				tot = radius*radius*Math.PI;
				System.out.println("���� ���̴� "+tot+"�Դϴ�.");
			}else{//1,2�� ������ �޴��� ��
				System.out.println("�޴��� �߸� �����Ͽ����ϴ�.");
			}
		}
	}
}
/*
����
�޴�(1:�簢���� ����, 2:���� ����) ->1
�غ�=
����=
�簢���� ���̴� _�Դϴ�.

�޴�(1:�簢���� ����, 2:���� ����) ->2
������ = 
���� ���̴� _�Դϴ�.


*/
