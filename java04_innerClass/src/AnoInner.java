
public class AnoInner {
	int num = 2222;
	String addr = "����� ���빮��";
	public AnoInner() {
		
	}
	
	public void start() {
		//�͸��� ���� Ŭ���� ���� ������ ���Խ�Ű�� ����
		new Information() {
			public void print() {
				System.out.println("��ȣ="+ num);
				System.out.println("�̸�="+ name);
				System.out.println("����ó="+tel);
			}
			public void output() {
				System.out.println("num="+ num);
				System.out.println("addr="+ addr);
			}
		}.output();
	}

	public static void main(String[] args) {
		AnoInner ai = new AnoInner();
		ai.start();

	}
}
