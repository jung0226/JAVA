import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderFileTest {

	public BufferedReaderFileTest() {
		try {
			File f= new File("d://javaDev/javaApi", "CalendarTest.java");
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String txt = br.readLine();// enter∏¶ æ» ¿–¿Ω. ¡Ÿ πŸ≤ﬁ¿Ã æ» µ .
				if(txt==null) {break;}
				System.out.println(txt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("The End....");
	}

	public static void main(String[] args) {
		new BufferedReaderFileTest();

	}

}
