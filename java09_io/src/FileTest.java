import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		// D:\javaDev\javaApi\ArrayTest.java
		File f1 = new File("D:/javaDev/javaApi/ArrayTest.java"); // 절대주소지정 방식
		File f2 = new File("D:/javaDev/javaApi", "CalendarTest.java");
		File f3 = new File("D:/javaDev/javaApi"); // 폴더만으로도 객체 생성 가능
		File f4 = new File(f3, "RandomTest.java");

		File f5 = new File("D:/javaFolder/a/b/c");
		// exits() : 폴더 혹은 파일이 존재하는지 확인해주는 메소드 (있으면 true, 없으면 false)
		if (!f5.exists()) {
			if (f5.mkdirs()) {// 폴더 생성
				System.out.println("폴더가 생성되었습니다.");
			} else {
				System.out.println("폴더생성 실패하였습니다.");
			}
		}

		try {
			// 파일 생성하기
			File f6 = new File("D:/javaFolder/test.txt");
			if (!f6.exists()) {
				if (f6.createNewFile()) {// IO라 exception처리 필요
					System.out.println("파일이 생성되었습니다.");
				} else {
					System.out.println("파일생성 실패하였습니다.");
				}
			}
			
			//마지막 수정일 구하기
			long lastDate = f2.lastModified(); //밀리초로 구해짐. 1970.01.01부터 계산
			System.out.println("lastDate = "+lastDate);
			
			Calendar date= Calendar.getInstance();
			System.out.println("오늘 밀리초= "+date.getTimeInMillis());
			
			date.setTimeInMillis(lastDate);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a hh:mm"); 
			String dateStr = format.format(date.getTime());
			System.out.println("마지막 수정일 = "+dateStr);
			
			System.out.println("exe= "+f2.canExecute());//실행형 파일인지 확인
			System.out.println("read= "+f2.canRead());//읽기 전용인지 확인
			System.out.println("write= "+f2.canWrite());//쓰기가 가능한지 확인
			
			//특정 폴더내의 모든 파일과 모든 폴더 정보를 얻어오기
			File f7 = new File("D://");
			File f8[] = f7.listFiles();
			for(File f : f8) {
				//getName():파일명, getParent():폴더명, getPath():폴더+파일명
				if(f.isDirectory()) {//폴더인 경우
					System.out.println(f.getPath()+"[폴더]");
				}else if(f.isFile()) {
					System.out.println(f.getPath()+"[파일]");
				}
			}
			// length() : 파일의 바이트 크기를 구한다.
			System.out.println("f2.length()="+f2.length()+"byte");
			
			// 현재 컴퓨터의 드라이브 목록 구하기
			File root[] = File.listRoots();
			for(File f:root) {
				System.out.println("드라이브-> "+f.getPath());
			}
			
			// 파일 삭제
			File f9 = new File("D:/test.class");
			if(f9.delete()) {
				System.out.println("파일이 삭제되었습니다.");
			}else {
				System.out.println("파일 삭제를 실패했습니다.");
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		new FileTest();
	}

}
