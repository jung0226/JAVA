import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClient extends JFrame implements ActionListener, Runnable{
	//Frame->Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel northPane = new JPanel(new BorderLayout());
			JTextField connTf = new JTextField("192.168.0.225");
			JButton connBtn = new JButton("Connection");
		JTextArea msgView = new JTextArea();
		JScrollPane sp = new JScrollPane(msgView);
		JPanel southPane = new JPanel(new BorderLayout());
			JTextField msgTf = new JTextField();
			JButton sendBtn = new JButton("Send");
	//Frame->East
	JPanel eastPane=new JPanel(new BorderLayout());
		JLabel connListLBl = new JLabel("접속자 리스트");
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> connList = new JList<String>(model);
		JScrollPane sp2 = new JScrollPane(connList);
		JLabel connCount = new JLabel("현재 접속자 : 0명");
	//////////
	Socket socket;
	PrintWriter pw;//메세지 보내기
	BufferedReader br;//메세지 받는 객체
		
	public ChatClient() {
		super("채팅 프로그램");
		connTf.setBackground(new Color(200,200,230));
		msgTf.setBackground(new Color(200,200,230));
		msgView.setBackground(Color.BLUE);
		msgView.setForeground(Color.WHITE);
		
		//Frame->Center
		northPane.add(connTf);
		northPane.add(connBtn, BorderLayout.EAST);
		
		southPane.add(msgTf);
		southPane.add(sendBtn, BorderLayout.EAST);
		
		centerPane.add(northPane, BorderLayout.NORTH);
		centerPane.add(sp);
		centerPane.add(southPane, BorderLayout.SOUTH);
		
		add(centerPane);
		
		//Frame->East
		eastPane.add(connListLBl, BorderLayout.NORTH);
		eastPane.add(sp2);
		eastPane.add(connCount, BorderLayout.SOUTH);
		
		model.addElement("          ");
		add(eastPane, BorderLayout.EAST);
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		connTf.addActionListener(this);
		connBtn.addActionListener(this);
		msgTf.addActionListener(this);
		sendBtn.addActionListener(this);
	}
	
	//접속
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == connTf || event == connBtn) {//서버와 연결
			setServerConnection();			
		}else if(event == msgTf || event == sendBtn) {//서버로 문자 보내기
			msgSend();
		}
	}
	//서버로 문자 보내기
	public void msgSend() {
			pw.println(msgTf.getText());
			pw.flush();
			msgTf.setText("");
	}
	
	//서버와 연결
	public void setServerConnection() {
		try {
			if(!connTf.getText().equals("")) {
				//서버에 접속
				InetAddress ia = InetAddress.getByName(connTf.getText());
				socket = new Socket(ia,9999);
				//inputStream
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//outputStream
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				//연결버튼 비활성화
				//connTf.setEditable(false);
				//connBtn.setEnabled(false);	
				
				//받는 스레드 구현
				Thread t = new Thread(this);
				t.start();
			}
			
		}catch(Exception e) {}
	}
	
	//서버에서 보낸 문자 받을 스레드
	public synchronized void run() {
		while(true) {
			try {
				String receiveMsg = br.readLine();
				if(receiveMsg != null) {
					if(receiveMsg.substring(0,6).equals("CONGU*")) {//접속자 알림
						msgView.append(receiveMsg.substring(6)+"\n");
					}else if(receiveMsg.substring(0,6).equals("CC*$@$")) {//현재 접속자 수
						System.out.println("========="+receiveMsg.substring(6));
						connCount.setText("현재 접속자 : "+receiveMsg.substring(6)+"명");
					}else if(receiveMsg.substring(0,6).equals("[User]")) {
						String username = receiveMsg.substring(6);
						StringTokenizer token = new StringTokenizer(username,"/");
						model.removeAllElements();//이전 리스트제거
						while(token.hasMoreTokens()) {//hasMoreElements()도 가능
							model.addElement(token.nextToken());
						}
					}else if(receiveMsg.substring(0, 6).equals("[CMsg]")) {
						msgView.append(receiveMsg.substring(6)+"\n");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new ChatClient();
	}

}
