
public class ConstractorTest {
	int num=10;
	String name;
	String tel="010-1111-2222";
	
	public ConstractorTest() {//�����Ϸ��� �������ش�.
		
	}
	public ConstractorTest(int num) {
		System.out.println("ConstractorTest(int num) ������");
		this.num = num; //this: ����Ǵ� Ŭ����. ������� num�� ����Ŵ.
	}
	public ConstractorTest(String name) {
		
	}
	public ConstractorTest(int num, String name, String tel) {
		//�����ڿ��� �ٸ� �����ڸ� ȣ���ϱ� ���ؼ��� �ݵ�� ù��° ���๮���� ó���ؾ� �Ѵ�.
		this(num);
		System.out.println("ConstractorTest(int num, String name, String tel) ������");
		//this.num = num; 
		this.name=name;
		this.tel =tel;
		
	}
	public ConstractorTest(String name, String tel, int num) {
		this(num, name, tel);//�ٸ� ������ ȣ��
	}
	public void prn() {
		System.out.println("��ȣ = "+num);
		System.out.println("�̸� = "+name);
		System.out.println("����ó = "+tel);
	}

}//end of class
