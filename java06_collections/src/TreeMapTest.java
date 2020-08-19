import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
	}
	public void start() {
		//TreeMap: key, value를 가진다.
		//		   key를 기준으로 정렬 되어있다.
		
		TreeMap<String, MemberVO> tm = new TreeMap<String ,MemberVO>(); 
		MemberVO vo = new MemberVO(50, "홍길동", "010-7878-4545", "asdf@nate.com");
		tm.put("홍길동", vo);
		tm.put("강감찬", new MemberVO(10,"강감찬","010-4545-4545","asd@naver.com"));
		tm.put("세종대왕", new MemberVO(80,"세종대왕","010-1111-2222","qw@gamil.com"));
		tm.put("이순신", new MemberVO(70,"이순신","010-1234-5678","zx@naver.com"));
		tm.put("김삿갓", new MemberVO(20,"김삿갓","010-2222-33333","q224@gamil.com"));
		
		MemberVO vo2= tm.get("이순신");
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
