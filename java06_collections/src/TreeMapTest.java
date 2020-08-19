import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
	}
	public void start() {
		//TreeMap: key, value�� ������.
		//		   key�� �������� ���� �Ǿ��ִ�.
		
		TreeMap<String, MemberVO> tm = new TreeMap<String ,MemberVO>(); 
		MemberVO vo = new MemberVO(50, "ȫ�浿", "010-7878-4545", "asdf@nate.com");
		tm.put("ȫ�浿", vo);
		tm.put("������", new MemberVO(10,"������","010-4545-4545","asd@naver.com"));
		tm.put("�������", new MemberVO(80,"�������","010-1111-2222","qw@gamil.com"));
		tm.put("�̼���", new MemberVO(70,"�̼���","010-1234-5678","zx@naver.com"));
		tm.put("���", new MemberVO(20,"���","010-2222-33333","q224@gamil.com"));
		
		MemberVO vo2= tm.get("�̼���");
		vo2.print();
		System.out.println("++++++++key++++++++");
		Set<String> keyList =tm.keySet();
		Iterator<String> i = keyList.iterator();
		while(i.hasNext()) {
			MemberVO vo3 = tm.get(i.next());
			vo3.print();
		}
		System.out.println("+++++++value+++++++");
		Collection<MemberVO> value = tm.values();
		Iterator<MemberVO> v = value.iterator();
		while(v.hasNext()) {
			MemberVO vo4 = v.next();
			vo4.print();
		}
	
	
	
	}

	public static void main(String[] args) {
		TreeMapTest tmt = new TreeMapTest();
		tmt.start();

	}

}
