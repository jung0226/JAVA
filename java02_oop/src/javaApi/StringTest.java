package javaApi;

public class StringTest {
	public StringTest() {
		start();
	}

	public void start() {
		//String은 문자열과 관련된 기능.
		String name;
		String name2 = new String();		
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		if(name3==name4) {
			System.out.println("name3과 name4는 같다.");
		}else {
			System.out.println("name3과 name4는 다르다.");
		}
		//객체가 같은지 확인하기 위해서는 equals()메소드 사용한다.
		if(name3.equals(name4)) {//name4.equals(name3)
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
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
		
		//문자열을 바이트 배열로 생성하여 리턴해준다.
		byte dataArr[]=data.getBytes();
		for(int i=0; i<dataArr.length; i++) {
			System.out.println("dataArr["+i+"]="+dataArr[i]);
		}
		//특정 문자의 index위치를 구한다.
		int idx= data.indexOf("g");
		System.out.println("indexOf= "+idx);
		
		int idxLast = data.lastIndexOf("g");
		System.out.println("lastIndexOf= "+idxLast);
		
		//글자 수
		int size = data.length();
		System.out.println("length= "+size);
		
		//		 0123456789012345678901234
		//	String data="Java Programing Test.....";
		
		data=data.replaceAll("Java", "자바");
		System.out.println(data);
		
		String tel="010-1234--5678";
		String telSplit[]= tel.split("-");
		for(int i=0;i<telSplit.length;i++) {
			System.out.println("telSplit["+i+"]="+telSplit[i]);
		}
		//				01234567890123
		String email = "abcde@nate.com";
		int atMark = email.indexOf("@");//6
		//								6앞자리까지 구해짐.
		String id = email.substring(0,atMark);
		System.out.println("id= "+id);
		String domain = email.substring(atMark+1);
		System.out.println("domain= "+domain);
		
		//toLowerCase() : 소문자로 변경
		//toUpperCase() : 대문자로 변경
		String lower = data.toLowerCase();
		String upper = data.toUpperCase();
		System.out.println("toLowerCase= "+lower);
		System.out.println("toUpperCase= "+upper);
		
		//앞뒤 공백을 없앰
		String data2 = "	Java Spring Mybatis		";
		String trim = data2.trim();
		System.out.println("trim="+trim+"-----");
		
		//equals(): 대소문자 구별하여 같은지 결과true, false
		//equalsIngnoreCase(): 대소문자를 구별하지 않고 같은지 결과를 구한다.
		
		String d1="Test Program";
		String d2="test program";
		
		if(d1.equals(d2)) {
			System.out.println("equals()=>d1과 d2는 같은 문자열입니다.");
		}else {
			System.out.println("equals()=>d1과 d2는 다른 문자열입니다.");	
		}
		if(d1.equalsIgnoreCase(d2)) {
			System.out.println("equalsIgnoreCase()=>d1과 d2는 같은 문자열입니다.");
		}else {
			System.out.println("equalsIgnoreCase()=>d1과 d2는 다른 문자열입니다.");	
		}
		
	}
	public static void main(String[] args) {
		new StringTest();

	}

}
