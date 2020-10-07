import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends DBConn {

	public AdminDAO() {
	}
	public static AdminDAO getInstance() {//ȣ���ϸ� ��ü�� ���ƿ�.
		return new AdminDAO();
	}
	
	
	//���ڵ� ����
	public int updateRecord(AdminVO vo) {
		int result=0;
		try {
			getConn();
			String sql = "update admin set pwd=? where id='admin'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return result;
	}
	
	
	//���ڵ� ��ü ����
	public List<AdminVO> getAll() {
		List<AdminVO> list = new ArrayList<AdminVO>();
		try {
			getConn();
			String sql = "select * from admin";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				MemberVO vo = new MemberVO();
//				vo.setNum(rs.getInt(1));
//				vo.setName(rs.getString(2));
//				vo.setTel(rs.getString(3));
//				vo.setEmail(rs.getString(4));
//				vo.setAddr(rs.getString(5));
//				vo.setWritedate(rs.getString(6));
				
				AdminVO vo = new AdminVO(rs.getString(1), rs.getString(2));
				list.add(vo);	 // �Ѹ��� ���� -> ��ü �ο� ��Ȳ ��ü
			}//end of while
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	
	

}
