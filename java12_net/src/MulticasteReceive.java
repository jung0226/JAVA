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
			ms.joinGroup(ia);//소켓이 ia를 조인한다.
			
			//받기 대기
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("대기 중");
			ms.receive(dp);
			
			//전송 받은 경우
			byte[] rData= dp.getData();
			int len = dp.getLength();
			System.out.println("받은 문자는 "+new String(rData,0,len));
			ms.close();
			
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		new MulticasteReceive().start();
	}
}
