import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	//jdbc드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이브 로딩 에러 --->"+e.getMessage());
		}
	}
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "scott";
	String password = "tiger";

	public DBConn() {	}
	//DB 연결
	public void getConn() {		
		try {
			conn = DriverManager.getConnection(url, userid, password);
		}catch(SQLException se) {
			System.out.println("DB연결 에러 발생 --> "+se.getMessage());
		}
	}
	//DB 끊기
	public void getClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException se) {
			System.out.println("에러 발생 --> "+se.getMessage());
		}
	}

}
