import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticasteReceive {
	InetAddress ia;
	MulticastSocket ms;
	DatagramPacket dp;
	public MulticasteReceive() {
	}
	
	public void start() {
		try {
			ia = InetAddress.getByName("230.1.1.14");
			ms = new MulticastSocket(20000);
			
			/////
			ms.joinGroup(ia);//������ ia�� �����Ѵ�.
			
			//�ޱ� ���
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("��� ��");
			ms.receive(dp);
			
			//���� ���� ���
			byte[] rData= dp.getData();
			int len = dp.getLength();
			System.out.println("���� ���ڴ� "+new String(rData,0,len));
			ms.close();
			
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		new MulticasteReceive().start();
	}
}
