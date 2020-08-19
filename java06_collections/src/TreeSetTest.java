import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		// TreeSet : 중복 허용하지 않는다.
		// 입력 순서 유지하지 않는다.
		// 크기 순서대로 정렬된다.
	}

	public void start() {
		TreeSet<String> ts = new TreeSet<String>();

		String txt[] = { "JAVA", "자바", "스프링", "SPRING", "JAVA", "자바스크립트", "HTML", "css", "jquery", "스프링", "자바스크립트", "HTML" };
		for(String t: txt) {
			ts.add(t);
		}
		//오름차순으로 정렬된 데이터를 구한다.
		Iterator<String> result= ts.iterator();
		while(result.hasNext()) {
			System.out.println(result.next());
		}
		System.out.println("-----");
		//내림차순으로 정렬된 데이터를 구한다.
		Iterator<String> descSort = ts.descendingIterator();
		while (descSort.hasNext()) {
			System.out.println(descSort.next());
		}
	}

	public static void main(String[] args) {
		new TreeSetTest().start();

	}

}
