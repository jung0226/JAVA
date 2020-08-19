import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedInputStreamTest {

	public BufferedInputStreamTest() {
		try {
			// �ֿܼ��� ���ڴ��� �Է��Ͽ� ���ۿ� ���� �� �� ������ �о����
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				System.out.print("�Է�= ");
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
