import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileUnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	FileOutputStream os = null;

	public FileUnicasteReceive() {

	}

	public void start() {
		try {
			ds = new DatagramSocket(15000);

			byte data[] = new byte[512];
			dp = new DatagramPacket(data, 0, data.length);

			while (true) {
				System.out.println("���۹ޱ� �����//");
				ds.receive(dp);
				
				byte receiveData[] = dp.getData();
				int length = dp.getLength();//���۹��� ���� ��
				
				String dataStr = new String(receiveData, 0, length);
				if(length>12) {
					//���ϸ� [*filename*]aaa.png
					if(dataStr.substring(0,12).equals("[*filename*]")) {
						//outStream
						os = new FileOutputStream(new File("D://javaFolder",dataStr.substring(12)));
					}else if(dataStr.substring(0,12).equals("[*lastdata*]")) {
						//������
						os.close();
						System.out.println("���� �Ϸ�/////");
					}else {//���ϳ���
						fileWrite(receiveData, length);
						
					}
				}else {
					//���ϳ���
					fileWrite(receiveData, length);
				}
			}

		} catch (Exception e) {}
	}

	public void fileWrite(byte data[], int len) {
		try {
			os.write(data, 0, len);
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		new FileUnicasteReceive().start();
	}

}
