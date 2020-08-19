import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedInputStreamTest {

	public BufferedInputStreamTest() {
		try {
			// 콘솔에서 문자단위 입력하여 버퍼에 저장 후 줄 단위로 읽어오기
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				System.out.print("입력= ");
				String inData = br.readLine();
				System.out.println(inData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BufferedInputStreamTest();

	}

}
