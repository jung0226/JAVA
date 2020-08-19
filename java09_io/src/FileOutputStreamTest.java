import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStreamTest {

	public FileOutputStreamTest() {
		//파일의 내용을 읽어서 다른 파일로 저장하기
		File source = new File("D://javaDev/javaApi/CalendarTest.java");//원본 파일 객체
		File target = new File("D://javaFolder/CalendarTestCopy2.java");//타켓 파일 객체
		try {
//			FileInputStream fis = new FileInputStream(source);
//			FileOutputStream fos = new FileOutputStream(target);
			
			FileReader fis = new FileReader(source);
			FileWriter fos = new FileWriter(target);
			
			while(true) {
				int inData=fis.read();
				if(inData==-1) {break;}
				fos.write(inData);
			}
			System.out.println(source.getPath()+"파일이 "+target.getPath()+"로 복사되었습니다.");
			fis.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileOutputStreamTest();
	}

}
