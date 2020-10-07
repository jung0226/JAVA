import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCTest {
	Scanner scan = new Scanner(System.in);
	public void InsertTest() {
		insertRecord();
	}
	public void insertRecord() {
		try {
			int no = Integer.parseInt(input("��ȣ"));
			String username = input("�̸�");
			String tel = input("����ó");
			String email = input("�̸���");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.225:1521:xe", "scott", "tiger");
			String sql = "insert into jusorok(no, username, email, tel) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, username);
			pstmt.setString(3, email);
			pstmt.setString(4, tel);
 			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("ȸ����ϵǾ����ϴ�..");
			}else {
				System.out.println("ȸ����Ͻ����Ͽ����ϴ�..");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String input(String msg) {
		System.out.print(msg+"=");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		new JDBCTest().InsertTest();
	}
}
