package javaApi;

public class StringTest {
	public StringTest() {
		start();
	}

	public void start() {
		//String�� ���ڿ��� ���õ� ���.
		String name;
		String name2 = new String();		
		String name3 = new String("ȫ�浿");
		String name4 = new String("ȫ�浿");
		
		if(name3==name4) {
			System.out.println("name3�� name4�� ����.");
		}else {
			System.out.println("name3�� name4�� �ٸ���.");
		}
		//��ü�� ������ Ȯ���ϱ� ���ؼ��� equals()�޼ҵ� ����Ѵ�.
		if(name3.equals(name4)) {//name4.equals(name3)
			System.out.println("����.");
		}else {
			System.out.println("�ٸ���.");
		}
		char c[]= {'J', 'A', 'V', 'A'};
		String cStr = new String(c);
		System.out.println("cStr= "+cStr);
		
		String valueStr = String.copyValueOf(c);
		System.out.println("valueStr= "+valueStr);
		
		int num=1234;
		String numStr = String.valueOf(num);
		System.out.println("numStr= "+(numStr+100));
		
		String numStr2 = num+"";
		System.out.println("numStr2= "+(numStr2+100));
		//			 0123456789012345678901234
		String data="Java Programing Test.....";
		char at= data.charAt(5);
		System.out.println("charAt= "+at);
		
		//���ڿ��� ����Ʈ �迭�� �����Ͽ� �������ش�.
		byte dataArr[]=data.getBytes();
		for(int i=0; i<dataArr.length; i++) {
			System.out.println("dataArr["+i+"]="+dataArr[i]);
		}
		//Ư�� ������ index��ġ�� ���Ѵ�.
		int idx= data.indexOf("g");
		System.out.println("indexOf= "+idx);
		
		int idxLast = data.lastIndexOf("g");
		System.out.println("lastIndexOf= "+idxLast);
		
		//���� ��
		int size = data.length();
		System.out.println("length= "+size);
		
		//		 0123456789012345678901234
		//	String data="Java Programing Test.....";
		
		data=data.replaceAll("Java", "�ڹ�");
		System.out.println(data);
		
		String tel="010-1234--5678";
		String telSplit[]= tel.split("-");
		for(int i=0;i<telSplit.length;i++) {
			System.out.println("telSplit["+i+"]="+telSplit[i]);
		}
		//				01234567890123
		String email = "abcde@nate.com";
		int atMark = email.indexOf("@");//6
		//								6���ڸ����� ������.
		String id = email.substring(0,atMark);
		System.out.println("id= "+id);
		String domain = email.substring(atMark+1);
		System.out.println("domain= "+domain);
		
		//toLowerCase() : �ҹ��ڷ� ����
		//toUpperCase() : �빮�ڷ� ����
		String lower = data.toLowerCase();
		String upper = data.toUpperCase();
		System.out.println("toLowerCase= "+lower);
		System.out.println("toUpperCase= "+upper);
		
		//�յ� ������ ����
		String data2 = "	Java Spring Mybatis		";
		String trim = data2.trim();
		System.out.println("trim="+trim+"-----");
		
		//equals(): ��ҹ��� �����Ͽ� ������ ���true, false
		//equalsIngnoreCase(): ��ҹ��ڸ� �������� �ʰ� ������ ����� ���Ѵ�.
		
		String d1="Test Program";
		String d2="test program";
		
		if(d1.equals(d2)) {
			System.out.println("equals()=>d1�� d2�� ���� ���ڿ��Դϴ�.");
		}else {
			System.out.println("equals()=>d1�� d2�� �ٸ� ���ڿ��Դϴ�.");	
		}
		if(d1.equalsIgnoreCase(d2)) {
			System.out.println("equalsIgnoreCase()=>d1�� d2�� ���� ���ڿ��Դϴ�.");
		}else {
			System.out.println("equalsIgnoreCase()=>d1�� d2�� �ٸ� ���ڿ��Դϴ�.");	
		}
		
	}
	public static void main(String[] args) {
		new StringTest();

	}

}
