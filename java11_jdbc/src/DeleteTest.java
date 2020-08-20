
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
				System.out.println("�����Ǿ����ϴ�.");
			}else {
				System.out.println("���� �����߽��ϴ�.");
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
