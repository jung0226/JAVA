import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		try {
			// ���� ���� �ֿܼ��� ������ �Է¹ޱ�
			InputStreamReader isr = new InputStreamReader(System.in);

			System.out.print("�Է� = ");

//			while (true) {
//				int code = isr.read();
//				if(code==13)break;
//				System.out.println(code + "--->" + (char) code);
//			}
			
			//char�迭�� �Է�
			char data[] = new char[10];
			int cnt = isr.read(data);
			System.out.println(cnt + "--->" + String.valueOf(data));
			
			
		} catch (IOException e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
