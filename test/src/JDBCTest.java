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
			int no = Integer.parseInt(input("번호"));
			String username = input("이름");
			String tel = input("연락처");
			String email = input("이메일");
			
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
				System.out.println("회원등록되었습니다..");
			}else {
				System.out.println("회원등록실패하였습니다..");
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
