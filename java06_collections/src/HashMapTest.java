import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
	}
	public void start() {
		// HashMap: ����ȭ���� �ʴ´�. HashTable: ����ȭ�Ѵ�.
		//HashMap<String, MemberVO> map= new HashMap<String, MemberVO>();
		
		Hashtable<String, MemberVO> map = new Hashtable<String, MemberVO>();
		MemberVO vo = new MemberVO(50, "ȫ�浿", "010-7878-4545", "asdf@nate.com");
		map.put("ȫ�浿", vo);
		map.put("������", new MemberVO(10,"������","010-4545-4545","asd@naver.com"));
		map.put("�������", new MemberVO(80,"�������","010-1111-2222","qw@gamil.com"));
		map.put("�̼���", new MemberVO(70,"�̼���","010-1234-5678","zx@naver.com"));
		map.put("���", new MemberVO(20,"���","010-2222-33333","q224@gamil.com"));
		//key�� �̿��� ���� ������
		MemberVO vo2= map.get("�������");
		vo2.print();
		System.out.println("==================");
		//key�� ��� ���ϱ�
		Set<String> keyList = map.keySet();
		Iterator<String> key = keyList.iterator();
		
		while(key.hasNext()) {
			MemberVO vo3 = map.get(key.next());
			vo3.print();
		}
		System.out.println("==================");
		//value��� ���ϱ�
		Collection<MemberVO> value = map.values();
		
		Iterator<MemberVO> v= value.iterator();
		while(v.hasNext()) {
			MemberVO vo4 = v.next();
			vo4.print();
			
		}
		
		
		
		
	}

	public static void main(String[] args) {
		new HashMapTest().start();

	}

}
