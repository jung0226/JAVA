import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBConn {

	public MemberDAO() {
	}
	public static MemberDAO getInstance() {//호출하면 객체가 돌아옴.
		return new MemberDAO();
	}
	//레코드 추가
	public int insertRecord(MemberVO vo) {
		int result = 0;
		try {
			getConn();
			String sql = "insert into member(num, name, tel, email, addr, write_date) "
					+ "values(?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddr());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}		
		return result;
	}
	
	//레코드 수정
	public int updateRecord(MemberVO vo) {
		int result=0;
		try {
			getConn();
			String sql = "update member set name=?, tel=?, email=?, addr=? "
					+ "where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddr());
			pstmt.setInt(5, vo.getNum());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return result;
	}
	
	//레코드 삭제
	public int deleteRecord(int num) {
		int result=0;
		try {
			getConn();
			String sql = "delete from member where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}
	//레코드 전체 선택
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getConn();
			String sql = "select num, name, tel, email, addr, write_date from member order by num";
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
				
				MemberVO vo = new MemberVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(vo);				
			}//end of while
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	
	

}
