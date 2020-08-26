import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread{
	//������ ����� ������ �÷���
	List<ChatService> connList = new ArrayList<ChatService>();
	ServerSocket ss;
	public ChatServer() {
		this.start();
	}
	//���Ӵ�� ������
	public void run() {
		try {
			ss = new ServerSocket(9999);			
			System.out.println("Server Start");
			while(true) {
				System.out.println("���� ��� �� =======");
				Socket s = ss.accept();
				//������ ������ �� �ִ� �÷¼��� �߰�
				ChatService cs = new ChatService(s);
				//�ߺ� ������ �˻��ϱ�
				setConnectionCheck(cs);
				connList.add(cs);
				//���� �����ڵ鿡�� ���� �˸�
				cs.setAllMessage("CONGU*"+cs.username+"���� ���� �Ͽ����ϴ�."); //CONGU* -> ������ �˸�
				//�ο� ��
				cs.setAllMessage("CC*$@$"+connList.size());
				//������ ��Ϸ�
				cs.setAllMessage(getAllUsername());
				//������ ����
				cs.start();//���� ������
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//��� ������ ��� ������
	public String getAllUsername() {
		String usernameList="[User]";
		for(int i=0; i<connList.size(); i++) {
			ChatService cs = connList.get(i);
			usernameList += cs.username+"/";
		}		
		return usernameList;
	} 
	//���� ������ ����
	public void setConnectionCheck(ChatService cs) {
		for(int i=0; i<connList.size(); i++) {
			ChatService cs2 = connList.get(i);
			if(cs.username.equals(cs2.username)) {
				connList.remove(i);
				break;
			}
		}
	}
	//������ 1�� ������ ���� Ŭ����
	class ChatService extends Thread{
		Socket s;
		BufferedReader br;
		PrintWriter pw;
		String username;
		InetAddress ia;
		
		ChatService(){}
		ChatService(Socket s){
			this.s=s;
			try {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
				ia = s.getInetAddress();
				username =ia.getHostAddress(); //����ڸ�
				
			}catch(Exception e) {}
		}
		public void run() {
			try {
				while(true) {
					String ClientMsg = br.readLine();
					if(ClientMsg != null) {
						setAllMessage("[CMsg]["+username+"�� ]"+ClientMsg);
					}
				}
			}catch(Exception e) {
				
			}
		}
		//���� ������ ��� �����ڿ��� ���� ������
		public void setAllMessage(String msg) {			
			for(int i=0; i<connList.size(); i++) {
				ChatService cs = connList.get(i);
				try {
					cs.pw.println(msg);
					cs.pw.flush();
				}catch(Exception e) {
					connList.remove(i);
					i--;
				}
			}//end of for
		}
	}//end of class
	public static void main(String[] args) {
		new ChatServer();
	}

}
