import java.util.ArrayList;
import java.util.List;

public class ResidentDAO extends DBConn {

	public ResidentDAO() {
	}
	public static ResidentDAO getInstance() {//호출하면 객체가 돌아옴.
		return new ResidentDAO();
	}
	//레코드 추가
	public int insertRecord(ResidentVO vo) {
		int result = 0;
		try {
			getConn();
			String sql = "insert into resident(resident_num, resident_id, resident_pwd, resident_name, gender, room_num, tel) "
					+ "values(resident_sequence.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getResident_id());
			pstmt.setString(2, vo.getResident_pwd());
			pstmt.setString(3, vo.getResident_name());
			pstmt.setString(4, vo.getGender());
			pstmt.setInt(5, vo.getRoom_num());
			pstmt.setString(6, vo.getTel());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}		
		return result;
	}
	//레코드 추가 관리자모드
	public int insertRecord2(ResidentVO vo) {
		int result = 0;
		try {
			getConn();
			String sql = "insert into resident "
					+ "values(resident_sequence.nextval,?,?,?,?,?,?,TO_DATE(?, 'yyyy-MM-dd'),TO_DATE(?, 'yyyy-MM-dd'),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getResident_id());
			pstmt.setString(2, vo.getResident_pwd());
			pstmt.setString(3, vo.getResident_name());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getTel());
			pstmt.setInt(6, vo.getRoom_num());
			pstmt.setString(7, vo.getMove_in_date());
			pstmt.setString(8, vo.getExpiration_date());
			pstmt.setString(9, vo.getMonthly_rent_check());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}		
		return result;
	}
	
	//레코드 수정
	public int updateRecord(ResidentVO vo) {
		int result=0;
		try {
			getConn();
			String sql = "update resident set resident_name=?, resident_pwd=?, room_num=?, tel=?, expiration_date=TO_DATE(?, 'yyyy-MM-dd') "
					+ "where resident_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getResident_name());
			pstmt.setString(2, vo.getResident_pwd());
			pstmt.setInt(3, vo.getRoom_num());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getExpiration_date());
			pstmt.setInt(6, vo.getResident_num());

			
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
			String sql = "delete from resident where resident_num=?";
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
	//로그인
		public List<ResidentVO> getLogin() {
			List<ResidentVO> list = new ArrayList<ResidentVO>();
			try {
				getConn();
				String sql = "select resident_id, resident_pwd from resident";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {					
					ResidentVO vo = new ResidentVO(rs.getString(1), rs.getString(2));
					list.add(vo);	 // 한명의 정보 -> 전체 인원 현황 객체
				}//end of while
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
			return list;
		}
	//레코드 전체 선택
	public List<ResidentVO> getAll() {
		List<ResidentVO> list = new ArrayList<ResidentVO>();
		try {
			getConn();
			String sql = "select * from resident order by resident_num";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				ResidentVO vo = new ResidentVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
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
