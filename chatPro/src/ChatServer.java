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
	//접속자 목록을 보관할 컬렉션
	List<ChatService> connList = new ArrayList<ChatService>();
	ServerSocket ss;
	public ChatServer() {
		this.start();
	}
	//접속대기 스레드
	public void run() {
		try {
			ss = new ServerSocket(9999);			
			System.out.println("Server Start");
			while(true) {
				System.out.println("접속 대기 중 =======");
				Socket s = ss.accept();
				//접속자 관리할 수 있는 컬력센에 추가
				ChatService cs = new ChatService(s);
				//중복 아이피 검사하기
				setConnectionCheck(cs);
				connList.add(cs);
				//현재 접속자들에게 접속 알림
				cs.setAllMessage("CONGU*"+cs.username+"님이 접속 하였습니다."); //CONGU* -> 접속자 알림
				//인원 수
				cs.setAllMessage("CC*$@$"+connList.size());
				//접속자 목록록
				cs.setAllMessage(getAllUsername());
				//스레드 구현
				cs.start();//개인 접속자
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//모든 접속자 목록 얻어오기
	public String getAllUsername() {
		String usernameList="[User]";
		for(int i=0; i<connList.size(); i++) {
			ChatService cs = connList.get(i);
			usernameList += cs.username+"/";
		}		
		return usernameList;
	} 
	//같은 접속자 제거
	public void setConnectionCheck(ChatService cs) {
		for(int i=0; i<connList.size(); i++) {
			ChatService cs2 = connList.get(i);
			if(cs.username.equals(cs2.username)) {
				connList.remove(i);
				break;
			}
		}
	}
	//접속자 1명 정보를 가진 클래스
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
				username =ia.getHostAddress(); //사용자명
				
			}catch(Exception e) {}
		}
		public void run() {
			try {
				while(true) {
					String ClientMsg = br.readLine();
					if(ClientMsg != null) {
						setAllMessage("[CMsg]["+username+"님 ]"+ClientMsg);
					}
				}
			}catch(Exception e) {
				
			}
		}
		//현재 접속한 모든 접속자에게 정보 보내기
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
