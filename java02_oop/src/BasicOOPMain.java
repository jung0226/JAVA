
public class BasicOOPMain {

	public static void main(String[] args) {
		String name= new String();
		
		//��ü ����
		BasicOOP oop1 = new BasicOOP();
		BasicOOP oop2 = new BasicOOP();
		//��ü ���� �޼ҵ� ȣ�� -> ��ü��, �޼ҵ� ��
		oop1.sum();
		
		name = oop1.getName();
		System.out.println("name= "+name);
		
		oop1.sum();
		oop1.sum();
		
		//��ü���� ��������� �����͸� �����ų� �����Ϥ�
		//��ü��. ������
		oop1.a=2500;
		
		System.out.println("oop1.a= "+oop1.a);
		System.out.println("oop2.a= "+oop2.a);	

	}

}
