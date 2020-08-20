import java.sql.SQLException;

public class TransactionTest extends DBConn {

	public TransactionTest() {
	}

	// �ڹٿ��� �����ͺ��̽� ���ڵ� �߰�, ����, ������ �ڵ� Commit�� ����ȴ�.
	// �ڵ� commit�� �����ϰ� �۾��� �Ϸ�Ǹ� commit�� �����ϰ�
	// ���� �߻��� rollback ����.
	
	public void start() {
		try {
			getConn();
			conn.setAutoCommit(false);//�ڵ� Ŀ�� ����
			//1. 
			String sql ="insert into member(num, name, tel, email, addr)"
					+ " values(15,'QQQ','010-1111-1111','adsfasfd@naver.com', '����� ���ı�')";
			pstmt = conn.prepareStatement(sql);
			int cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("ù ��° ���ڵ� �߰� ����");
			}else {
				System.out.println("ù ��° ���� ����");
			}
			
			//2. 
			sql ="insert into member(num, name, tel, email, addr)"
					+ " values(16,'ZZZ','010-2222-224444444444444444421','adsfasfd@naver.com', '����� ������')";
			pstmt = conn.prepareStatement(sql);
			cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("�� ��° ���ڵ� �߰� ����");
			}else {
				System.out.println("�� ��° ���� ����");
			}
			//Ŀ�Լ���
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
