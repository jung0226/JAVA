import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		// TreeSet : �ߺ� ������� �ʴ´�.
		// �Է� ���� �������� �ʴ´�.
		// ũ�� ������� ���ĵȴ�.
	}

	public void start() {
		TreeSet<String> ts = new TreeSet<String>();

		String txt[] = { "JAVA", "�ڹ�", "������", "SPRING", "JAVA", "�ڹٽ�ũ��Ʈ", "HTML", "css", "jquery", "������", "�ڹٽ�ũ��Ʈ", "HTML" };
		for(String t: txt) {
			ts.add(t);
		}
		//������������ ���ĵ� �����͸� ���Ѵ�.
		Iterator<String> result= ts.iterator();
		while(result.hasNext()) {
			System.out.println(result.next());
		}
		System.out.println("-----");
		//������������ ���ĵ� �����͸� ���Ѵ�.
		Iterator<String> descSort = ts.descendingIterator();
		while (descSort.hasNext()) {
			System.out.println(descSort.next());
		}
	}

	public static void main(String[] args) {
		new TreeSetTest().start();

	}

}
