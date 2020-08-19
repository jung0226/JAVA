import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		try {
			// input, output : byte
			// reader, writer : char

			// byte 단위로 콘솔에서 데이터 입력 받는 클래스

			InputStream in = System.in;
			System.out.print("입력 = ");
//			while (true) {
//				int data = in.read();		
//				if(data==13)break;//enter치면 브레이크
//				System.out.println("data=" + data);
//			}
			// byte 배열을 이용한 데이터 입력
			 byte data[] = new byte[10];
			 int cnt =in.read(data);
			System.out.println(cnt+"--->"+new String(data,0,cnt-2)+"===");// cnt-2 : 데이터 없는 곳을 제외

//			byte data[]=new byte[10];
//			int cnt = in.read(data, 3, 5);
//			System.out.println(cnt + "--->"+new String(data)+"---");
			
		} catch (IOException io) {
			io.printStackTrace();// 에러 메세지 출력
		}
		System.out.println("end");
	}

	public static void main(String[] args) {
		new InputStreamTest();
	}

}
