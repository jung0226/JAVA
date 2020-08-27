import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		
	}
	public void start() {
		try {
			ds = new DatagramSocket(12000);
			
			//받을  Packet
			byte data[] = new byte[512];
			dp = new DatagramPacket(data, data.length);
			
			//받을 준비
			System.out.println("받기 대기 중 ///");
			ds.receive(dp);//받기 전까지 다음 실행문으로 안 넘어감.
			
			//전송받은 데이터 얻어오기
			byte receiveData[] = dp.getData();
			int txtCount = dp.getLength();//받은 문자 수
			String text = new String(receiveData,0,txtCount);
			System.out.println("받은 문자= "+text+"==============");
			System.out.println("받기 완료///");
			
		}catch(Exception e) {}
	}

	public static void main(String[] args) {
		new UnicasteReceive().start();
	}

}
