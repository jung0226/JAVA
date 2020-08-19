import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		try {
			// 문자 단위 콘솔에서 데이터 입력받기
			InputStreamReader isr = new InputStreamReader(System.in);

			System.out.print("입력 = ");

//			while (true) {
//				int code = isr.read();
//				if(code==13)break;
//				System.out.println(code + "--->" + (char) code);
//			}
			
			//char배열로 입력
			char data[] = new char[10];
			int cnt = isr.read(data);
			System.out.println(cnt + "--->" + String.valueOf(data));
			
			
		} catch (IOException e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
