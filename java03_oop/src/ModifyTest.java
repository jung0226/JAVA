import test.CCC;

public class ModifyTest {

	public ModifyTest() {
		//public : � Ŭ���������� ������ ����Ѵ�.(Ŭ����, �������, ������ �޼ҽ�, �޼ҵ�)
		//default : ���������� ������ ���� ���Ѵ�. ���� ��Ű�� �������� ������ ����.
		//private : �ٸ� Ŭ�������� ������ �� ����. ���� Ŭ���� �������� ������ ����.
		//			���������  private�� ��� ��ü�� ���������� �Ұ�
		AAA a = new AAA();
		System.out.println("a.name= "+a.name);
		a.print();
		
		//CCC c=new CCC();
		CCC c= CCC.getInstance();
		//System.out.println("c.tel="+c.tel);
		//c.sum();
		
		//������ �޼ҵ� private �̸� ��ü�� ������ �� ����.
		BBB b= new BBB();
		//private ������� �����ϱ�: �Ұ���
		//System.out.println("addr= "+b.addr);
		b.output();
	}

	public static void main(String[] args) {
		new ModifyTest();
	}

}
