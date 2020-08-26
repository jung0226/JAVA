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
		JLabel connListLBl = new JLabel("������ ����Ʈ");
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> connList = new JList<String>(model);
		JScrollPane sp2 = new JScrollPane(connList);
		JLabel connCount = new JLabel("���� ������ : 0��");
	//////////
	Socket socket;
	PrintWriter pw;//�޼��� ������
	BufferedReader br;//�޼��� �޴� ��ü
		
	public ChatClient() {
		super("ä�� ���α׷�");
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
	
	//����
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == connTf || event == connBtn) {//������ ����
			setServerConnection();			
		}else if(event == msgTf || event == sendBtn) {//������ ���� ������
			msgSend();
		}
	}
	//������ ���� ������
	public void msgSend() {
			pw.println(msgTf.getText());
			pw.flush();
			msgTf.setText("");
	}
	
	//������ ����
	public void setServerConnection() {
		try {
			if(!connTf.getText().equals("")) {
				//������ ����
				InetAddress ia = InetAddress.getByName(connTf.getText());
				socket = new Socket(ia,9999);
				//inputStream
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//outputStream
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				//�����ư ��Ȱ��ȭ
				//connTf.setEditable(false);
				//connBtn.setEnabled(false);	
				
				//�޴� ������ ����
				Thread t = new Thread(this);
				t.start();
			}
			
		}catch(Exception e) {}
	}
	
	//�������� ���� ���� ���� ������
	public synchronized void run() {
		while(true) {
			try {
				String receiveMsg = br.readLine();
				if(receiveMsg != null) {
					if(receiveMsg.substring(0,6).equals("CONGU*")) {//������ �˸�
						msgView.append(receiveMsg.substring(6)+"\n");
					}else if(receiveMsg.substring(0,6).equals("CC*$@$")) {//���� ������ ��
						System.out.println("========="+receiveMsg.substring(6));
						connCount.setText("���� ������ : "+receiveMsg.substring(6)+"��");
					}else if(receiveMsg.substring(0,6).equals("[User]")) {
						String username = receiveMsg.substring(6);
						StringTokenizer token = new StringTokenizer(username,"/");
						model.removeAllElements();//���� ����Ʈ����
						while(token.hasMoreTokens()) {//hasMoreElements()�� ����
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
