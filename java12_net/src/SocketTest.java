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
			Socket socket = new Socket(ia,port);// ������ �̷���. ������ ������ socket�� ������ ����.
			
			//���� �ޱ�
			InputStream is = socket.getInputStream();//byte ����
			InputStreamReader isr = new InputStreamReader(is);//�� ���ھ�(���ڷ�) �о��.
			BufferedReader br = new BufferedReader(isr);//�� �پ� �о��.
			
			String msg = br.readLine();//�����͸� ���� ������ ��������. ���� ���๮���� �� �Ѿ.
			System.out.println("�����κ��� ���� ����-> "+msg);
			
			//Ŭ���̾�Ʈ�� ������ ���ں�����
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("Ŭ���̾�Ʈ ���ڸ� ������ ����...");
			pw.flush();
			
			while(true) {
				System.out.print("���� ���� �Է�= ");
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
		System.out.println("Ŭ���̾�Ʈ ���α׷��� ����Ǿ����ϴ�.");
	}

	public static void main(String[] args) {
		new SocketTest();
	}

}
