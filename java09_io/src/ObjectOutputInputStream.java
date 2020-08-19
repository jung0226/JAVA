import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputInputStream {

	public ObjectOutputInputStream() {
		// 파일에 객체를 쓰기, 읽기
		// 클래스가 직렬화되어야한다. interface serializeable를 상속받으면 된다
		try {
			File f = new File("D://javaFolder/object.txt");
			// 객체 쓰기
//			DataVO vo = new DataVO();
//			vo.setNum(9999);
//			vo.setName("세종대왕");
//			
//			FileOutputStream fos = new FileOutputStream(f);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			
//			oos.writeObject(vo);
//			oos.close();
			
			//파일에서 객체 읽어오기
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
