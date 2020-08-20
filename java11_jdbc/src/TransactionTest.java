import java.sql.SQLException;

public class TransactionTest extends DBConn {

	public TransactionTest() {
	}

	// 자바에서 데이터베이스 레코드 추가, 수정, 삭제는 자동 Commit이 실행된다.
	// 자동 commit을 해제하고 작업이 완료되면 commit을 실행하고
	// 에러 발생시 rollback 실행.
	
	public void start() {
		try {
			getConn();
			conn.setAutoCommit(false);//자동 커밋 해제
			//1. 
			String sql ="insert into member(num, name, tel, email, addr)"
					+ " values(15,'QQQ','010-1111-1111','adsfasfd@naver.com', '서울시 송파구')";
			pstmt = conn.prepareStatement(sql);
			int cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("첫 번째 레코드 추가 성공");
			}else {
				System.out.println("첫 번째 수정 실패");
			}
			
			//2. 
			sql ="insert into member(num, name, tel, email, addr)"
					+ " values(16,'ZZZ','010-2222-224444444444444444421','adsfasfd@naver.com', '서울시 성동구')";
			pstmt = conn.prepareStatement(sql);
			cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("두 번째 레코드 추가 성공");
			}else {
				System.out.println("두 번째 수정 실패");
			}
			//커밋설정
			conn.commit();
		}catch(Exception e) {
			try {
			conn.rollback();
			}catch(SQLException se) {}
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public static void main(String[] args) {
		new TransactionTest().start();;

	}

}
