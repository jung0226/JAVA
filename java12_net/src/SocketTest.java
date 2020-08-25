import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class SocketTest {
	Scanner scan = new Scanner(System.in);
	public SocketTest() {
		try {
			InetAddress ia = InetAddress.getByName("192.168.0.225");
			int port = 20000;
			Socket socket = new Socket(ia,port);// 접속이 이뤄짐. 접속한 정보를 socket이 가지고 있음.
			
			//문자 받기
			InputStream is = socket.getInputStream();//byte 단위
			InputStreamReader isr = new InputStreamReader(is);//한 글자씩(문자로) 읽어옴.
			BufferedReader br = new BufferedReader(isr);//한 줄씩 읽어옴.
			
			String msg = br.readLine();//데이터를 읽을 때까지 멈춰있음. 다음 실행문으로 안 넘어감.
			System.out.println("서버로부터 받은 문자-> "+msg);
			
			//클라이언트가 서버로 문자보내기
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("클라이언트 문자를 서버로 보냄...");
			pw.flush();
			
			while(true) {
				System.out.print("보낼 문자 입력= ");
				String data= scan.nextLine();
				socket = new Socket(ia,port);
				
				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os);
				pw = new PrintWriter(osw);
				
				pw.println(data);
				pw.flush();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("클라이언트 프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new SocketTest();
	}

}
