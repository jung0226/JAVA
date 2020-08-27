import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicasteSend {
	DatagramSocket ds;
	InetAddress ia;
	DatagramPacket dp;

	public UnicasteSend() {
	}
	public void start() {
		//UDP통신 -> Unicaste통신 1:1
		try {
			ia = InetAddress.getByName("192.168.0.225");
			ds = new DatagramSocket();
			
			String data ="Spring FrameWork, 스프링 프레임워크";
			
			//보낼 데이터를 Packet으로 생성한다.
			//						보낼 데이터								받는 쪽 ip,port
			dp = new DatagramPacket(data.getBytes(), data.getBytes().length, ia, 12000);
			
			//데이터 보내기
			ds.send(dp);
			System.out.println("전송 완료///");
			
			
		}catch(Exception e) {}
		
	}
	public static void main(String[] args) {
		new UnicasteSend().start();
	}

}
