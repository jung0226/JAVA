import java.util.Scanner;
public class MethodTest {
	int dan;//��������� �⺻ �ʱⰪ�� �ִ�. ����=0, �Ǽ�=0.0, ���� = false, char=������ ����
			//						  ��� Ŭ������ü�� �ʱⰪ�� null
	//���۷��� ����= Ŭ������ ����
	Scanner s;
	String name;
	
	//�Ű� ������ ���� �����ڴ� �⺻���� �������ִ� ���� ����.
	public MethodTest() {}

	//�� �Է� �޼ҵ�
	public int getDan(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		dan = scan.nextInt();
		return dan;
	}
	//�Է¹��� ������ ������ ���
	public void danOutput(int dan) {
		for(int i=2;i<=9;i++) {
			calculator(i, dan);//�޼ҵ� ȣ��: ���� Ŭ������ �޼ҵ�� �޼ҵ�� ���ָ� ȣ���.
		}
	}
	//���
	public void calculator(int i, int dan) {
		int result = dan*i;
		System.out.println(dan+"*"+i+"="+result);
	}
	public void startDan() {
		int dan = getDan("�� �Է�");
		danOutput(dan);
	}

	
}//end of class
