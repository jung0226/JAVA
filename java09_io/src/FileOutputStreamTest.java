import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStreamTest {

	public FileOutputStreamTest() {
		//������ ������ �о �ٸ� ���Ϸ� �����ϱ�
		File source = new File("D://javaDev/javaApi/CalendarTest.java");//���� ���� ��ü
		File target = new File("D://javaFolder/CalendarTestCopy2.java");//Ÿ�� ���� ��ü
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
			System.out.println(source.getPath()+"������ "+target.getPath()+"�� ����Ǿ����ϴ�.");
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
