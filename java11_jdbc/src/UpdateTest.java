
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
			pstmt.setString(3, "��⵵ �Ǳ�");
			pstmt.setInt(4, 1);
			
			//����
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("�����Ǿ����ϴ�.");
			}else {
				System.out.println("���� ����");
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
