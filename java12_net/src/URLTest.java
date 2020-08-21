import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class URLTest {

	public URLTest() {
	}
	public void start() {
		try {
			URL url = new URL("https://www.naver.com");
			System.out.println("protocol= "+url.getProtocol());
			System.out.println("host= "+url.getHost());
			System.out.println("path= "+url.getPath());
			System.out.println("port= "+url.getPort());
			System.out.println("filename= "+url.getFile());
			
			// Page Header ��ü ������
			// URL ��ü�� �̿��Ͽ� URLConnection ��ü�� �����Ѵ�.
			URLConnection connection = url.openConnection();
			connection.connect();//��� ä�� Ȯ��
			
			String contentType= connection.getContentType();// ��� ���� ������
			System.out.println("-->"+contentType);
			
			int idx = contentType.indexOf("charset=");
			String code = contentType.substring(idx+8);
		
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, code);//InputStreamReader(InputStream in, String charsetName)
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String inData = br.readLine();
				if(inData==null)break;
				System.out.println(inData);
			}		
			
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public static void main(String[] args) {
		new URLTest().start();
	}

}
