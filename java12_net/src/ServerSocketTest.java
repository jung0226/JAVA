import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSocketTest {

	public ServerSocketTest() {
		try {
			//������ ����� �� �����ϸ� Socket��ü�� ���� �� �ִ�.
			ServerSocket ss = new ServerSocket(20000);
			
			//���� ��� : �������� ip�� ��
			System.out.println("Server Start....");
			while(true) {
				System.out.println("���� ��� ��....");
				Socket socket = ss.accept();
				
				//�������� InetAddress ��ü
				InetAddress ia = socket.getInetAddress();
				System.out.println(ia.getHostAddress()+"���� �����߽��ϴ�.");
				
				//�����ڿ��� ���� ������ �غ� ����
				OutputStream os = socket.getOutputStream();			
				OutputStreamWriter osw = new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw);
				
				pw.println("������ ���ӵǾ����ϴ�. ȯ���մϴ�.");//���� ������
				pw.flush();//socket�� �����Ͱ� �Ѿ.
				
				//Ŭ���̾�Ʈ�� ���� ���� �ޱ�
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String msg = br.readLine();
				System.out.println("Ŭ���̾�Ʈ���� ���� ����--> "+msg);
			}
		}catch(Exception e) {e.printStackTrace();}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

	public static void main(String[] args) {
		new ServerSocketTest();

	}

}
