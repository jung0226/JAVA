//�����̸��� ���� Ŭ�������� public ����.
public class AAA {
	static int num =100;
}// class

class BBB{
	int num=200;
	BBB(){}
	static BBB getInstance() {
		return new BBB();
	}//�ڽ��� ��ü�� ���� ����.
	
}// class 

 class CCC{
	 static int num=300;
	 static String name="ȫ�浿";
	 static String addr="����� ������";
	 
	 //��� �����
	 //final ������ ���� �����Ұ�
	 static final int MAX = 100;
	 static final int MIN = 1;
	 
	 static void print() {
		 System.out.println("��ȣ = "+num);
		 System.out.println("�̸� = "+name);
		 System.out.println("�ּ� = "+addr);
		 System.out.println("MIN= "+MIN);
		 System.out.println("MAX= "+MAX);
	 }
 }


 