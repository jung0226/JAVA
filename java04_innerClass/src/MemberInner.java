
public class MemberInner {
	int num = 100;
	String name = "ȫ�浿";
	public MemberInner() {
		
	}

	public void print() {
		System.out.println("��ȣ="+num);
		System.out.println("�̸�="+name);
		//�ܺ� Ŭ�������� ���� Ŭ������ ������ ������ �� ����.
		//System.out.println("����ó="+tel);
	}
	
	//���� Ŭ����
	class Inner{
		int num = 200;
		String tel = "010-1234-5678";
		Inner(){}
		Inner(int num){
			this.num = num;
		}
		public void output() {
			System.out.println("num="+num);
			System.out.println("tel="+tel);
			//���� Ŭ�������� �ܺ� Ŭ������ ������ ������ �� �ִ�.
			System.out.println("name="+name);
			print();
		}
	}
	
	
	public static void main(String[] args) {
		MemberInner mi = new MemberInner();
		mi.print();
		
		//���� Ŭ���� : ��ü ����
		MemberInner.Inner in1 = mi.new Inner();
		MemberInner.Inner in2 = new MemberInner().new Inner(300);
		
		in1.output();
		in2.output();
	}

}
