
public class MethodInner {
	String username = "�̼���";
	int age = 30;

	public MethodInner() {
		
	}

	public void getInfo() {
		String addr = "����� ������ �����";
	
		//�޼ҵ� ���� Ŭ����
		//�޼ҵ尡 ȣ���� �Ǿ�� ����Ŭ���� ��� ����
		class Inner{
			String tel = "010-1234-5678";
			String username = "�������";
			
			Inner(){}
			
			void print() {
				System.out.println("�̸�="+username);
				System.out.println("����ó="+tel);
				//�޼ҵ� ���� ���� Ŭ���������� �ܺ� Ŭ������ ��������� ����� �� �ִ�.
				System.out.println("����="+ age);
				//�޼ҵ��� ���� ����  Ŭ���� ���� ������ ������ ������ ������ �����ϴ�.
				System.out.println("�ּ�="+ addr);
				//System.out.println("�̸���="+email);
			}	
		}
		String email = "abcdef@nate.com";
		//�޼ҵ� ���� ���� Ŭ���� ��ü�� class ���� �� ��ü�� �����Ѵ�.
		Inner i = new Inner();
		i.print();
		
	}
	public static void main(String[] args) {
		MethodInner mi = new MethodInner();
		mi.getInfo();
		
	}
}
