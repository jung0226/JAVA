import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
public class Login{
	
	public Login() {
	}
	
	public boolean memCheck(String id, String pwd, HashMap<String, MemberVO> mlist, HashMap<String, BookVO> blist, BookVO bvo, HashMap<String, BookRequestVO> blist2,BookRequestVO rbvo) {
			
		if(mlist.containsKey(id)) {
			if((mlist.get(id)).getPwd().equals(pwd)) {
				return true;
			}else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
		}
		else {
			System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
			return false;
		}		
	}

}//end of class
