import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		//file�� ������ ������� �� ������, index�� �̿��� �̵��� �� �ִ�.
		try {
			String txt = "java input output stream test...";
			File f = new File("D://javaFolder/access.txt");
			
			//w: ���� ����, rw: ���� �б� ����, r: �б� ����
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			raf.writeBytes(txt);
			
			//��ġ�̵�
			raf.seek(5);
			raf.writeBytes("ABCD");
			raf.seek(10);
			raf.writeInt(1234);
			
			
			//�б�
			raf.seek(10);
			int intData = raf.readInt();
			System.out.println("int=" + intData);
			raf.close();
			
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new RandomAccessFileTest();

	}

}
