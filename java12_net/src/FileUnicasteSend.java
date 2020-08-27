import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileUnicasteSend extends JFrame implements ActionListener{
	JButton btn = new JButton("파일 전송하기");
	public FileUnicasteSend() {
		add(btn);
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btn.addActionListener(this);
	}
	public void start() {
		try {
			JFileChooser fc = new JFileChooser();
			int state = fc.showOpenDialog(this);
			if(state == 0) {
				//열기 선택시 파일전송하기
				File file = fc.getSelectedFile();
				//파일명
				String fileName = file.getName();
				
				InetAddress ia = InetAddress.getByName("192.168.0.225");
				DatagramSocket ds = new DatagramSocket();
				
				//1. 파일명 보내기
				String sendFilename = "[*filename*]"+fileName;
				DatagramPacket dp = new DatagramPacket(sendFilename.getBytes(), sendFilename.getBytes().length, ia, 15000);
				ds.send(dp);		
				
				//2. 파일 전송
				FileInputStream fis = new FileInputStream(file);
				while(true) {
					byte data[] = new byte[512];
					int cnt= fis.read(data, 0, data.length);
					if(cnt>0) {
						dp = new DatagramPacket(data, cnt, ia, 15000);
						ds.send(dp);
					}else {
						fis.close();
						break;
					}
					Thread.sleep(100);
				}
				
				//3. 마지막
				String lastMsg = "[*lastdata*]end";
				dp = new DatagramPacket(lastMsg.getBytes(), lastMsg.getBytes().length, ia, 15000);
				ds.send(dp);
				System.out.println("보내기완료");
				
			}
			
			}catch(Exception e) {}
	}
	public void actionPerformed(ActionEvent ae) {
		
	}

	public static void main(String[] args) {
		new FileUnicasteSend().start();

	}

}
