import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Hashtable;

public class Book {
	Scanner scan = new Scanner(System.in);

	// ���ǳ⵵ ���Խ� - 1900��� 2000���
	String pyExp = "^([1|2]\\d{3})$";
	// �з���ȣ ���Խ�
	String bnExp = "^(\\d{3})$";

	public Book() {

	}

	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.nextLine();
	}

	// å ����
	public HashMap<String, BookVO> setbook() {

		HashMap<String, BookVO> bhm = new HashMap<String, BookVO>();
		// å�̸�, ����, ���ǻ�, ���ǿ���, å�з���ȣ
		bhm.put("�ȳ��� �ϱ�", new BookVO("�ȳ��� �ϱ�", "�ȳ�����ũ", "��������", 2011, 800));
		bhm.put("ö�� ���̶ٱ�", new BookVO("ö�� ���̶ٱ�", "�ܸ�ũ ����������", "�ñ�ġ", 2019, 100));
		bhm.put("� ���ϴ�", new BookVO("� ���ϴ�", "����� ", "�ؼ���", 2020, 200));
		bhm.put("�̰��� �ڹٴ�", new BookVO("�̰��� �ڹٴ�", "�ſ��", "�Ѻ��̵��", 2015, 500));
		bhm.put("��ȸ����", new BookVO("��ȸ����", "�� �庸��", "���", 2017, 300));
		bhm.put("����", new BookVO("����", "������", "21����Ͻ�", 2020, 900));
		bhm.put("�������", new BookVO("�������", "�罺 �ظ���", "���̵���", 2020, 500));
		bhm.put("��ų�ڻ�� ���̵�", new BookVO("��ų�ڻ�� ���̵�","�ι�Ʈ","�Ʒ���",2018,800));
		return bhm;
	}
	
	// å ����
		public HashMap<String, BookRequestVO> setbookr() {

			HashMap<String, BookRequestVO> bhm2 = new HashMap<String, BookRequestVO>();
			// å�̸�, ����, ���ǻ�, ���ǿ���, å�з���ȣ
			bhm2.put("�����ý�����1", new BookRequestVO("�����ý�����1", "�ǿ������޴��� ��Į�󸮿�", "����", 2006, 800));
			bhm2.put("�����ý�����2", new BookRequestVO("�����ý�����2", "�ǿ������޴��� ��Į�󸮿�", "����", 2006, 800));
			bhm2.put("�����ý�����3", new BookRequestVO("�����ý�����3", "�ǿ������޴��� ��Į�󸮿�", "����", 2006, 800));
			
			return bhm2;
		}

	// å �˻�
	public void bookSearch(HashMap<String, BookVO> bhm) {

//			Set set = bth.keySet();
//			Iterator iterator = set.iterator();
//			while (iterator.hasNext()) {
//				String key = (String) iterator.next();
//				System.out.println("bth Key : " + key);
//			}

		String bname = conInput("�������� �Է��ϼ���");
		BookVO bvo = bhm.get(bname);
		if (bvo != null) {
			System.out.println("��� ���� : å����, ����, ���ǻ�,  ���ǳ⵵,  �з���ȣ");
			System.out.println("-------------------------------------------------------");
			bvo.output();

		} else {
			System.out.println("å�� �������� �ʽ��ϴ�.");

		}
	}

	

	// å ���
	public void bookList(HashMap<String, BookVO> bhm, String id) {
		Collection<BookVO> valueList = bhm.values();
		Iterator<BookVO> ii = valueList.iterator();
		
		System.out.println("��� ���� : å����, ����, ���ǻ�,  ���ǳ⵵,  �з���ȣ");
		System.out.println("-------------------------------------------------------");
		while (ii.hasNext()) {
				ii.next().output();
			
		}
	}

	// ��û�� å ���
	public void bookList2(HashMap<String, BookRequestVO> bhm2) {
		Collection<BookRequestVO> valueList = bhm2.values();
		Iterator<BookRequestVO> ii = valueList.iterator();
		while (ii.hasNext()) {
			ii.next().output();
		}
	}

	// å ���
	public void bookInsert(HashMap<String, BookVO> bhm, BookVO bvo) {
		// å ����, ����, ���ǻ�, ���ǳ⵵, �з���ȣ
		do {
			String bookName = conInput("å ������ �Է��ϼ���");
			bvo.setBookName(bookName);
			String writer = conInput("���ڸ� �Է��ϼ���");
			bvo.setWriter(writer);
			String publisher = conInput("���ǻ縦 �Է��ϼ���");
			bvo.setPublisher(publisher);

			do {
				String publishYear = conInput("���ǳ⵵�� �Է��ϼ���");
				if (publishYear.matches(pyExp)) {
					bvo.setPublishYear(Integer.parseInt(publishYear));
					break;
				} else {
					System.out.println("���ǳ⵵�� �ùٸ��� �Է��ϼ���.");
				}
			} while (true);

			do {
				String bookNum = conInput("�з���ȣ�� �Է��ϼ���.");
				if (bookNum.matches(bnExp)) {
					bvo.setBookNum(Integer.parseInt(bookNum));
					break;
				}

				else {
					System.out.println("�з���ȣ�� �ùٸ��� �Է����ּ���.");
				}
			} while (true);

			bhm.put(bookName, bvo);
			System.out.println(bookName + "å�� ��ϵǾ����ϴ�.\n");

			break;
		} while (true);

	}

	// å ����
	public void bookEdit(HashMap<String, BookVO> bhm) {

		String bname = conInput("������ å����");
		BookVO vo = bhm.get(bname);
		if (vo != null) {
			vo.output();
			String subMenu = conInput("������ �׸��� �����ϼ���.(1: å ����, 2: ����, 3: ���ǻ�, 4: ���ǳ⵵, 5: �з���ȣ )");
			do {
				String data = conInput("������ ������ �Է�");
				if (subMenu.equals("1")) {
					vo.setBookName(data);
				} else if (subMenu.equals("2")) {
					vo.setWriter(data);
				} else if (subMenu.equals("3")) {
					vo.setPublisher(data);
				} else if (subMenu.equals("4")) {
					if (data.matches(pyExp)) {
						vo.setPublishYear(Integer.parseInt(data));
					} else {
						System.out.println("���ǳ⵵�� �ùٸ��� �Է����ּ���");
					}
				} else if (subMenu.equals("5")) {
					if (data.matches(bnExp)) {
						vo.setBookNum(Integer.parseInt(data));
					} else {
						System.out.println("�з���ȣ�� �ùٸ��� �Է����ּ���");
					}
				} else {
					System.out.println("������ �׸��� �߸� ���� �Ͽ����ϴ�");
				}
			} while (true);
		} else {
			System.out.println(bname + "���� å�Դϴ�.");
		}

	}

	// å ����
	public void bookDelete(HashMap<String, BookVO> bhm) {
		String key = conInput("������ å�� �Է��ϼ���");
		bhm.remove(key);

	}
	

	// å ��û���
	public void requestedBook(HashMap<String, BookRequestVO> bhm2, BookRequestVO bvo) {
		// å ����, ����, ���ǻ�, ���ǳ⵵, �з���ȣ
		do {
			String bookName = conInput("å ������ �Է��ϼ���");
			bvo.setRbookName(bookName);
			String writer = conInput("���ڸ� �Է��ϼ���");
			bvo.setRwriter(writer);
			String publisher = conInput("���ǻ縦 �Է��ϼ���");
			bvo.setRpublisher(publisher);

			do {
				String publishYear = conInput("���ǳ⵵�� �Է��ϼ���");
				if (publishYear.matches(pyExp)) {
					bvo.setRpublishYear(Integer.parseInt(publishYear));
					break;
				} else {
					System.out.println("���ǳ⵵�� �ùٸ��� �Է��ϼ���.");
				}
			} while (true);

			do {
				String bookNum = conInput("�з���ȣ�� �Է��ϼ���.");
				bvo.setRbookNum(Integer.parseInt(bookNum));
				if (bookNum.matches(bnExp)) {

					bvo.setRbookNum(Integer.parseInt(bookNum));
					break;
				}

				else {
					System.out.println("�з���ȣ�� �ùٸ��� �Է����ּ���.");
				}
			} while (true);

			bhm2.put(bookName, bvo);
			System.out.println(bookName + "å�� ��û�Ǿ����ϴ�.\n");
			System.out.println("��� ���� : å����, ����, ���ǻ�,  ���ǳ⵵,  �з���ȣ");
			bookList2(bhm2);

			break;
		} while (true);

	}

	public static void main(String[] args) {
		new Book();
	}

}
