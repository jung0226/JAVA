import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	//jdbc����̺� �ε�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		}catch(ClassNotFoundException e) {
			System.out.println("����̺� �ε� ���� --->"+e.getMessage());
		}
	}
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "scott";
	String password = "tiger";

	public DBConn() {	}
	//DB ����
	public void getConn() {		
		try {
			conn = DriverManager.getConnection(url, userid, password);
		}catch(SQLException se) {
			System.out.println("DB���� ���� �߻� --> "+se.getMessage());
		}
	}
	//DB ����
	public void getClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException se) {
			System.out.println("���� �߻� --> "+se.getMessage());
		}
	}

}
