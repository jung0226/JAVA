import java.util.ArrayList;
import java.util.List;

public class QnaDAO extends DBConn {

	public QnaDAO() {
	}
	public static QnaDAO getInstance() {//호출하면 객체가 돌아옴.
		return new QnaDAO();
	}
	//레코드 추가
	public int insertRecord(QnaVO vo) {
		int result = 0;
		try {
			getConn();
			String sql = "insert into qna (qna_num, qna_name, qna_pwd, qna_title, qna_content, qna_write_date)" + 
					" values(QNA_SEQUENCE.nextval, ?,?,?,?,sysdate);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getQna_name());
			pstmt.setString(2, vo.getQna_pwd());
			pstmt.setString(3, vo.getQna_title());
			pstmt.setString(4, vo.getQna_content());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}		
		return result;
	}
	
	
	//레코드 수정
	public int updateRecord(QnaVO vo) {
		int result=0;
		try {
			getConn();
			String sql = "update qna set answer_tilte=?, answer_content=?, answer_write_date=sysdate "
					+ "where qna_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAnswer_title());
			pstmt.setString(2, vo.getAnswer_content());
			pstmt.setInt(3, vo.getQna_num());
			
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
			String sql = "delete from qna where qna_num=?";
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
	public List<QnaVO> getAll() {
		List<QnaVO> list = new ArrayList<QnaVO>();
		try {
			getConn();
			String sql = "select * from qna";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				QnaVO vo = new QnaVO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
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
