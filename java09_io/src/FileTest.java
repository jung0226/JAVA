import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		// D:\javaDev\javaApi\ArrayTest.java
		File f1 = new File("D:/javaDev/javaApi/ArrayTest.java"); // �����ּ����� ���
		File f2 = new File("D:/javaDev/javaApi", "CalendarTest.java");
		File f3 = new File("D:/javaDev/javaApi"); // ���������ε� ��ü ���� ����
		File f4 = new File(f3, "RandomTest.java");

		File f5 = new File("D:/javaFolder/a/b/c");
		// exits() : ���� Ȥ�� ������ �����ϴ��� Ȯ�����ִ� �޼ҵ� (������ true, ������ false)
		if (!f5.exists()) {
			if (f5.mkdirs()) {// ���� ����
				System.out.println("������ �����Ǿ����ϴ�.");
			} else {
				System.out.println("�������� �����Ͽ����ϴ�.");
			}
		}

		try {
			// ���� �����ϱ�
			File f6 = new File("D:/javaFolder/test.txt");
			if (!f6.exists()) {
				if (f6.createNewFile()) {// IO�� exceptionó�� �ʿ�
					System.out.println("������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���ϻ��� �����Ͽ����ϴ�.");
				}
			}
			
			//������ ������ ���ϱ�
			long lastDate = f2.lastModified(); //�и��ʷ� ������. 1970.01.01���� ���
			System.out.println("lastDate = "+lastDate);
			
			Calendar date= Calendar.getInstance();
			System.out.println("���� �и���= "+date.getTimeInMillis());
			
			date.setTimeInMillis(lastDate);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a hh:mm"); 
			String dateStr = format.format(date.getTime());
			System.out.println("������ ������ = "+dateStr);
			
			System.out.println("exe= "+f2.canExecute());//������ �������� Ȯ��
			System.out.println("read= "+f2.canRead());//�б� �������� Ȯ��
			System.out.println("write= "+f2.canWrite());//���Ⱑ �������� Ȯ��
			
			//Ư�� �������� ��� ���ϰ� ��� ���� ������ ������
			File f7 = new File("D://");
			File f8[] = f7.listFiles();
			for(File f : f8) {
				//getName():���ϸ�, getParent():������, getPath():����+���ϸ�
				if(f.isDirectory()) {//������ ���
					System.out.println(f.getPath()+"[����]");
				}else if(f.isFile()) {
					System.out.println(f.getPath()+"[����]");
				}
			}
			// length() : ������ ����Ʈ ũ�⸦ ���Ѵ�.
			System.out.println("f2.length()="+f2.length()+"byte");
			
			// ���� ��ǻ���� ����̺� ��� ���ϱ�
			File root[] = File.listRoots();
			for(File f:root) {
				System.out.println("����̺�-> "+f.getPath());
			}
			
			// ���� ����
			File f9 = new File("D:/test.class");
			if(f9.delete()) {
				System.out.println("������ �����Ǿ����ϴ�.");
			}else {
				System.out.println("���� ������ �����߽��ϴ�.");
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		new FileTest();
	}

}
