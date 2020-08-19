import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public FileInputStreamTest() {
		//파일의 내용을  byte단위로 읽기
		try {
			File file = new File("D:/javaDev/javaApi/CalendarTest.java");
			FileInputStream fis = new FileInputStream(file);
			while(true) {
				int inData = fis.read();
				if(inData==-1) {break;}// End of File : EOF
				System.out.print((char)inData);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileInputStreamTest();
	}

}
