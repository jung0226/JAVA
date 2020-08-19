import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputInputStream {

	public ObjectOutputInputStream() {
		// ���Ͽ� ��ü�� ����, �б�
		// Ŭ������ ����ȭ�Ǿ���Ѵ�. interface serializeable�� ��ӹ����� �ȴ�
		try {
			File f = new File("D://javaFolder/object.txt");
			// ��ü ����
//			DataVO vo = new DataVO();
//			vo.setNum(9999);
//			vo.setName("�������");
//			
//			FileOutputStream fos = new FileOutputStream(f);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			
//			oos.writeObject(vo);
//			oos.close();
			
			//���Ͽ��� ��ü �о����
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			DataVO vo = (DataVO)obj;
			System.out.println("num="+vo.getNum());
			System.out.println("name="+ vo.getName());
			vo.calendarOutput();
			CalendarSwing cs = new CalendarSwing();
			cs.start();
			
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectOutputInputStream();

	}

}
