import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
	}
	public void start() {
		// HashMap: 동기화하지 않는다. HashTable: 동기화한다.
		//HashMap<String, MemberVO> map= new HashMap<String, MemberVO>();
		
		Hashtable<String, MemberVO> map = new Hashtable<String, MemberVO>();
		MemberVO vo = new MemberVO(50, "홍길동", "010-7878-4545", "asdf@nate.com");
		map.put("홍길동", vo);
		map.put("강감찬", new MemberVO(10,"강감찬","010-4545-4545","asd@naver.com"));
		map.put("세종대왕", new MemberVO(80,"세종대왕","010-1111-2222","qw@gamil.com"));
		map.put("이순신", new MemberVO(70,"이순신","010-1234-5678","zx@naver.com"));
		map.put("김삿갓", new MemberVO(20,"김삿갓","010-2222-33333","q224@gamil.com"));
		//key를 이용한 정보 얻어오기
		MemberVO vo2= map.get("세종대왕");
		vo2.print();
		System.out.println("==================");
		//key의 목록 구하기
		Set<String> keyList = map.keySet();
		Iterator<String> key = keyList.iterator();
		
		while(key.hasNext()) {
			MemberVO vo3 = map.get(key.next());
			vo3.print();
		}
		System.out.println("==================");
		//value목록 구하기
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
