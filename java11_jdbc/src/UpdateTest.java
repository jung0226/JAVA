
public class UpdateTest extends DBConn{
	SelectTest st = new SelectTest();
	public UpdateTest() {
		start();
	}
	public void start() {
		try {
			getConn();
			String sql = "update member set tel=?, email=?, addr=? where num=?";			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "010-1234-1234");
			pstmt.setString(2, "aaa@naver.com");
			pstmt.setString(3, "경기도 판교");
			pstmt.setInt(4, 1);
			
			//실행
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("수정되었습니다.");
			}else {
				System.out.println("수정 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		st.start();
	}

	public static void main(String[] args) {
		new UpdateTest();
	}

}
