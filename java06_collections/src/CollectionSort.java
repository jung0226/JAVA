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

	// List ����
	public void listSort() {
		List<Integer> lst = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			lst.add(ran.nextInt(100) + 1);
		}
		System.out.println("���� �� = " + lst.toString());
		// ���Ŀ�������
		Collections.sort(lst);
		System.out.println("���� �� = " + lst.toString());
		// ��������
		Collections.reverse(lst);
		System.out.println("���� �� = " + lst.toString());

		//////////
		String names[] = { "�ڽ���", "����", "���", "����ȫ" };
		List<String> lst2 = new ArrayList<String>();
		for (String name : names) {
			lst2.add(name);
		}
		System.out.println("���� �� = " + lst2.toString());
		// ���Ŀ�������
		Collections.sort(lst2);
		System.out.println("���� �� = " + lst2.toString());
	}

	// �÷��ǿ� ��ü�� ���� �� �Ϻ� �����ͷ� ������ ���
	public void objectSort() {
		List<MemberVO> lst = new ArrayList<MemberVO>();
		lst.add(new MemberVO(50, "ȫ�浿", "010-7878-4545", "asdf@nate.com"));
		lst.add(new MemberVO(10, "������", "010-4545-4545", "asd@naver.com"));
		lst.add(new MemberVO(80, "�������", "010-1111-2222", "qw@gamil.com"));
		lst.add(new MemberVO(70, "�̼���", "010-1234-5678", "zx@naver.com"));
		lst.add(new MemberVO(20, "���", "010-2222-33333", "q224@gamil.com"));

		System.out.println("��ȣ�� ������������ ����");
		Collections.sort(lst, new CompareNumAsc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		System.out.println("��ȣ�� ������������ ����");
		Collections.sort(lst, new CompareNumDesc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		System.out.println("�̸��� ������������ ����");
		Collections.sort(lst, new CompareNameAsc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		System.out.println("�̸��� ������������ ����");
		Collections.sort(lst, new CompareNameDesc());
		for (MemberVO vo : lst) {
			vo.print();
		}
		

	}

	// ���� ������ Comparator interface�� ��ӹ��� �� compare() �޼ҵ带 �������̵� �Ͽ� ���ı������� �����Ѵ�.
	// �̸��� ������������ ����
	class CompareNameAsc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v1.getName().compareTo(v2.getName());
		}
	}

	// �̸��� ������������ ����
	class CompareNameDesc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getName().compareTo(v1.getName());
		}
	}

	// ��ȣ�� ������������ ����
	class CompareNumAsc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// v1�� ������ 1�� ����. v2�� ������ -1�� ����, v1�� v2�� ������ 0�� ����
			return (v1.getNum() < v2.getNum() ? -1 : (v1.getNum() == v2.getNum()) ? 0 : 1);
		}
	}

	// ��������
	class CompareNumDesc implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// v1�� ������ 1�� ����. v2�� ������ -1�� ����, v1�� v2�� ������ 0�� ����
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
