import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
		//List �������̽��� ��ӹ��� �÷����� �Է¼����� �����ϰ� index�� ������ �ִ�.		
	}
	public Vector getData() {
		int num=500;
		String name = "ȫ�浿";
		Calendar now  = Calendar.getInstance();
		now.set(2022,10,10);
		Random ran = new Random();
		double ave = 80.5;
		
		Vector vector = new Vector();
		vector.add(num);// Integer	0
		vector.addElement(name);//	2
		vector.add(now);//			3
		vector.add(ran);//			4
		vector.add(1, ave);//		1
		
		return vector;
	}
	//�л�����
	public Vector getMember() {
		Vector v= new Vector();
		MemberVO vo = new MemberVO();
		vo.setNum(100);
		vo.setName("ȫ�浿");
		vo.setTel("010-1234-5678");
		vo.setEmail("aaa@nate.com");
		v.add(vo);
		
		MemberVO vo2 = new MemberVO(200, "�̼���", "010-1251-1356", "b@nate.com");
		v.add(vo2);
		
		v.add(new MemberVO(300,"�������", "010-1245-7845","cc@nate.com"));
		v.add(new MemberVO(400,"��","010-4512-7854","dd@naver.com"));
		v.add(new MemberVO(500,"��", "010-1325-0264","ff@gmail.com"));
		
		return v;
	}

}
