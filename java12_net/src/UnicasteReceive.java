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
			
			//����  Packet
			byte data[] = new byte[512];
			dp = new DatagramPacket(data, data.length);
			
			//���� �غ�
			System.out.println("�ޱ� ��� �� ///");
			ds.receive(dp);//�ޱ� ������ ���� ���๮���� �� �Ѿ.
			
			//���۹��� ������ ������
			byte receiveData[] = dp.getData();
			int txtCount = dp.getLength();//���� ���� ��
			String text = new String(receiveData,0,txtCount);
			System.out.println("���� ����= "+text+"==============");
			System.out.println("�ޱ� �Ϸ�///");
			
		}catch(Exception e) {}
	}

	public static void main(String[] args) {
		new UnicasteReceive().start();
	}

}
