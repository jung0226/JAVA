import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Properties 클래스는 문자열로만 key와 value를 사용하는 컬렉션이다.
		Properties prop = new Properties();
		prop.setProperty("네이트", "nate.com");
		prop.setProperty("다음", "daum.net");
		prop.setProperty("네이버", "naver.com");
		prop.setProperty("서울시청", "seoul.go.kr");
		
		String domain = prop.getProperty("네이버");
		System.out.println("네이버 = "+domain);
		
		Enumeration keyList = prop.propertyNames();
		while(keyList.hasMoreElements()) {
			String str = (String)keyList.nextElement();
			System.out.println(str+"--->"+prop.getProperty(str));
		}
		
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
