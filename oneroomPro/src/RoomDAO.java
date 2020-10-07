import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends DBConn {

	public RoomDAO() {
	}
	public static RoomDAO getInstance() {//호출하면 객체가 돌아옴.
		return new RoomDAO();
	}
	//레코드 추가
	public int insertRecord(RoomVO vo) {
		int result = 0;
		try {
			getConn();
			String sql = "insert into room(room_num, gender, area, window, deposit, monthly_rent, occpancy_status) "
					+ "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRoom_num());
			pstmt.setString(2, vo.getGender());
			pstmt.setInt(3, vo.getArea());
			pstmt.setString(4, vo.getWindow());
			pstmt.setInt(5, vo.getDeposit());
			pstmt.setInt(6, vo.getMonthly_rent());
			pstmt.setString(7, vo.getOccupancy_status());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}		
		return result;
	}
	
	//레코드 수정
	public int updateRecord(RoomVO vo) {
		int result=0;
		try {
			getConn();
			String sql = "update room set room_num=?, gender=?, area=?, window=?, deposit=?, monthly_rent=?, occpancy_status=?, reservation=?, resident_num=?"
					+ "where room_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRoom_num());
			pstmt.setString(2, vo.getGender());
			pstmt.setInt(3, vo.getArea());
			pstmt.setString(4, vo.getWindow());
			pstmt.setInt(5, vo.getDeposit());
			pstmt.setInt(6, vo.getMonthly_rent());
			pstmt.setString(7, vo.getOccupancy_status());
			pstmt.setString(8, vo.getReservation());
			pstmt.setInt(9, vo.getResident_num());
			pstmt.setInt(10, vo.getRoom_num());
			
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
			String sql = "delete from room where room_num=?";
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
	//레코드 소개페이지 선택
	public List<RoomVO> getRoomSelect() {
		List<RoomVO> list = new ArrayList<RoomVO>();
		try {
			getConn();
			String sql = "select room_num, gender, area, window, deposit, monthly_rent, occpancy_status, reservation from room order by room_num";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				RoomVO vo = new RoomVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				list.add(vo);				
			}//end of while
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	
	//레코드 전체 선택
	public List<RoomVO> getRoomAll() {
		List<RoomVO> list = new ArrayList<RoomVO>();
		try {
			getConn();
			String sql = "select * from room order by room_num";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				RoomVO vo = new RoomVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
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
