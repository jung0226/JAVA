import java.util.HashMap;

public class Login {
	private String userid="admin";
	private String userpwd="1234";

	public Login() {
	}
	public boolean empCheck(String userid, String userpwd) {
		if(this.userid.equals(userid) && this.userpwd.equals(userpwd)) {
			return true;//�α��� ����
		}else {
			return false;
		}			
	}
	public static HashMap<String, EmployeeVO> setEmp() {
		HashMap<String, EmployeeVO> hm = new HashMap<String, EmployeeVO> ();
		hm.put("ȫ�浿", new EmployeeVO(1,"ȫ�浿","010-1111-2222","��ȹ��","����"));
		hm.put("�̼���", new EmployeeVO(2,"�̼���","010-2522-3333","�λ��","���"));
		hm.put("������", new EmployeeVO(3,"������","010-1212-4545","�ѹ���","����"));
		hm.put("�念��", new EmployeeVO(4,"�念��","010-7878-1111","������","�븮"));
		hm.put("���·�", new EmployeeVO(5,"���·�","010-1414-5252","�ѹ���","���"));
		
		return hm;
	}
}
