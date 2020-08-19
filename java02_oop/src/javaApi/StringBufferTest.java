package javaApi;

public class StringBufferTest {
	public StringBufferTest() {
		//���ڿ��� ó��, ������ �����Ǿ �ּҸ� �ű��� ����.
		//StringBufferŬ����
		//StringBuilderŬ����
		
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(50);
		StringBuffer sb3 = new StringBuffer("�ڹ�");
		
		sb.append("StringBuffer");//���ڿ� �߰�
		sb.append("��ü �׽�Ʈ ���Դϴ�.");
		//���ڿ� ���̱��ϱ�
		System.out.println("length= "+sb.length());
		
		//���ڿ� ����
		sb.insert(8, "�������̽�");
		System.out.println("sb= "+sb);
		//012345678 90
		//StringBu�������̽�ffer��ü �׽�Ʈ ���Դϴ�.
		sb.delete(3, 7);
		System.out.println("sb= "+sb);
		
		sb.reverse();//���ڿ� �յڹٲٱ�
		System.out.println("sb.reverse()-> "+sb);
		
		//�޸� ũ�⸦ ���ϴ� �޼ҵ�
		System.out.println("capacity= "+sb.capacity()+", "+sb2.capacity()+", "+sb3.capacity());
		
		//StringŬ������ �����Ͱ� ����Ǹ� �ٽ� �������־�� �Ѵ�.
		String str= "test replace";
		StringBuffer str4 = new StringBuffer("test replace");
		
		str= str.replaceAll("test", "�׽�Ʈ");
		str4.replace(0, 4, "�׽�Ʈ");
		System.out.println("str= "+str);
		System.out.println("str4="+str4);
		
	}//������

	public static void main(String[] args) {
		new StringBufferTest();
		
	}//end of main
}
