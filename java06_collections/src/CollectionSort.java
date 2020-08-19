import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CollectionSort {
	Random ran = new Random();

	public CollectionSort() {
	}

	// List 정렬
	public void listSort() {
		List<Integer> lst = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			lst.add(ran.nextInt(100) + 1);
		}
		System.out.println("정렬 전 = " + lst.toString());
		// 정렬오름차순
		Collections.sort(lst);
		System.out.println("정렬 후 = " + lst.toString());
		// 내림차순
		Collections.reverse(lst);
		System.out.println("정렬 후 = " + lst.toString());

		//////////
		String names[] = { "코스모스", "백합", "장미", "연산홍" };
		List<String> lst2 = new ArrayList<String>();
		for (String name : names) {
			lst2.add(name);
		}
		System.out.println("정렬 전 = " + lst2.toString());
		// 정렬오름차순
		Collections.sort(lst2);
		System.out.println("정렬 후 = " + lst2.toString());
	}

	// 컬렉션에 객체의 내용 중 일부 데이터로 정렬할 경우
	public void objectSort() {
		List<MemberVO> lst = new ArrayList<MemberVO>();
		lst.add(new MemberVO(50, "홍길동", "010-7878-4545", "asdf@nate.com"));
		lst.add(new MemberVO(10, "강감찬", "010-4545-4545", "asd@naver.com"));
		lst.add(new MemberVO(80, "세종대왕", "010-1111-2222", "qw@gamil.com"));
		lst.add(new MemberVO(70, "이순신", "010-1234-5678", "zx@naver.com"));
		lst.add(new MemberVO(20, "김삿갓", "010-2222-33333", "q224@gamil.com"));

		System.out.println("번호를 오름차순으로 정렬");
		Collections.sort(lst, new CompareNumAsc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		System.out.println("번호를 내름차순으로 정렬");
		Collections.sort(lst, new CompareNumDesc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		System.out.println("이름을 오름차순으로 정렬");
		Collections.sort(lst, new CompareNameAsc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		System.out.println("이름을 내름차순으로 정렬");
		Collections.sort(lst, new CompareNameDesc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		

	}

	// 정렬 기준을 Comparator interface를 상속받은 후 compare() 메소드를 오버라이딩 하여 정렬기준으로 적용한다.
	// 이름을 오름차순으로 정렬
	class CompareNameAsc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v1.getName().compareTo(v2.getName());
		}
	}

	// 이름을 내림차순으로 정렬
	class CompareNameDesc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getName().compareTo(v1.getName());
		}
	}

	// 번호를 오름차순으로 정렬
	class CompareNumAsc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// v1이 작으면 1을 리턴. v2가 작으면 -1을 리턴, v1과 v2가 같으면 0을 리턴
			return (v1.getNum() < v2.getNum() ? -1 : (v1.getNum() == v2.getNum()) ? 0 : 1);
		}
	}

	// 내림차순
	class CompareNumDesc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// v1이 작으면 1을 리턴. v2가 작으면 -1을 리턴, v1과 v2가 같으면 0을 리턴
			return (v1.getNum() < v2.getNum() ? 1 : (v1.getNum() == v2.getNum()) ? 0 : -1);

		}
	}

	public void start() {
		listSort();
		System.out.println("************************");
		objectSort();
	}

	public static void main(String[] args) {
		CollectionSort cs = new CollectionSort();
		cs.start();

	}

}
