import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		try {
		File f = new File("D:/javaDev/javaApi","CalendarTest.java");
		
		//���ڴ��� ������ ���� �о����.
		FileReader fr = new FileReader(f);
		
		while(true) {
			int inData = fr.read();
			if(inData==-1) {break;}
			System.out.print((char)inData);
		}
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileReaderTest();
	}

}
