
public class DeleteTest extends DBConn {

	public DeleteTest() {
	}
	public void deleteStart() {
		try {
			getConn();
			
			String sql = "delete from member where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("삭제 실패했습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();			
		}finally {
			getClose();
		}
	}

	public static void main(String[] args) {
		new DeleteTest().deleteStart();
	}

}
