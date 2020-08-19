import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Member {
	Scanner scan = new Scanner(System.in);

	HashMap<String, MemberVO> mlist = new HashMap<String, MemberVO>();

	// ��� ���Խ� - ���� �ּ� 1���̻�, �����ҹ��� �ּ�1�� �̻�, Ư������ ����, �ּ�5~�ִ�15�� ���
	String pwdExp = "^(?=.*[0-9])(?=.*[a-z])(?=.*\\W).{5,15}$";
	// ����ó ���Խ�
	String telExp = "^010(\\d{4})(\\d{4})$";

	public Member() {
	}

	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.next();
	}

	// ȸ�� ����
	public static HashMap<String, MemberVO> setEmp() {
		HashMap<String, MemberVO> mlist = new HashMap<String, MemberVO>();
		// ���̵�, ��й�ȣ, �̸�, �̸���, ����ó, �뿩���� å, ������ å
		mlist.put("admin", new MemberVO("admin", "1234qwer!", "������", "admin@naver.com", "010-1111-1111"));
		mlist.put("aaa", new MemberVO("aaa", "1111!q", "ȫ�浿", "aaaa@naver.com", "010-1234-1263"));
		mlist.put("bbb", new MemberVO("bbb", "2222!q", "������", "bbbb@naver.com", "010-2222-2222"));
		mlist.put("ccc", new MemberVO("ccc", "3333!q", "�̼���", "cccc@naver.com", "010-3333-3333"));
		mlist.put("ddd", new MemberVO("ddd", "4444!q", "�������", "dddd@naver.com", "010-4545-5555"));

		return mlist;

	}

	// ȸ�� ��� ���//
	public void memList(HashMap<String, MemberVO> mlist) {
		Collection<MemberVO> mValueList = mlist.values();
		Iterator<MemberVO> mi = mValueList.iterator();
		System.out.println("���̵�\t��й�ȣ\t�̸�\t�̸���\t����ó");
		System.out.println("-------------------------------------------------------------------");
		while (mi.hasNext()) {
			mi.next().print();
		}
	}

	// ȸ�� ��� ,
	public HashMap<String, MemberVO> memAdd(HashMap<String, MemberVO> mlist, MemberVO mv) {

		// ���̵�, ��й�ȣ, �̸�, �̸���, ����ó

		a: do {

			String id = conInput("���̵� �Է��ϼ���");
			if (mlist.containsKey(id)) {
				System.out.println("�ߺ��� ���̵� �Դϴ�.");
				break a;
			} else {
				mv.setId(id);
			}

			do {
				String pwd = conInput("��й�ȣ��  �Է��ϼ���(����, ������, Ư������ ����. 5~15�ڸ��� �Է�)");
				if (!(pwd.matches(pwdExp))) {
					System.out.println("��й�ȣ ���ǰ� ���� �ʽ��ϴ�. ���ǿ� ���� �Է����ּ���.");
				} else {
					String pwd2 = conInput("��й�ȣ Ȯ���� ���� �ٽ� �Է����ּ���.");
					if (pwd.equals(pwd2)) {
						mv.setPwd(pwd);
						break;
					} else {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");

					}
				}
			} while (true);

			String name = conInput("�̸���  �Է��ϼ���");
			mv.setName(name);

			do {
				String email = conInput("�̸�����  �Է��ϼ���");
				if (emailCheck(email)) {
					mv.setEmail(email);
					break;
				} else {
					System.out.println("�̸��� ������ �ƴմϴ�. �ٽ� �Է����ּ���.");
				}
			} while (true);
			do {
				String tel = conInput("����ó��  �Է��ϼ���(���ڸ� �Է�)\n");
				if (tel.matches(telExp)) {
					mv.setTel(tel);
					break;
				} else {
					System.out.println("����ó ������ �ƴմϴ�. �ٽ� �Է����ּ���.");
				}
			} while (true);

			mlist.put(id, mv);
			memList(mlist);//���
			System.out.println(name + "�� ������ �Ϸ�Ǿ����ϴ�.\n");
			System.out.println();
			
			break;
		} while (true);
		return mlist;
	}

	// �̸��� Ȯ��
	public boolean emailCheck(String email) {
		int atMark = email.indexOf("@");// @��ġ�� index�� ���ϰ� ���� ���� -1�� ������.
		int point = email.indexOf(".");// .��ġ ���ϱ�

		if (atMark < 4 || point < 6 || point < atMark || point - atMark < 2 || atMarkCount(email, '@') != 1
				|| atMarkCount(email, '.') > 2) {
			return false;
		} else {
			return true;
		}
	}

	public int atMarkCount(String email, char str) {
		int cnt = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == str) {
				cnt++;
			}
		}
		return cnt;
	}

	// ȸ�� ����
	public void memEdit(HashMap<String, MemberVO> mlist, String id) {

		MemberVO vo = mlist.get(id);

		vo.print();

		// ���̵�, ��й�ȣ, �̸�, �̸���, ����ó
		String subMenu = conInput("������ �׸��� �����ϼ���.(1: ��й�ȣ, 2: �̸�, 3: �̸���, 4: ����ó)");
		do {
			String data = conInput("������ ������ �Է�");
			if (subMenu.equals("1")) {
				if (!(data.matches(pwdExp))) {
					System.out.println("��й�ȣ ���ǰ� ���� �ʽ��ϴ�. ���ǿ� ���� �Է����ּ���.");
				} else {
					vo.setPwd(data);
					break;
				}
			} else if (subMenu.equals("2")) {
				vo.setName(data);
				break;
			} else if (subMenu.equals("3")) {

				if (emailCheck(data)) {
					vo.setEmail(data);
					break;
				} else {
					System.out.println("�̸��� ������ �ƴմϴ�. �ٽ� �Է����ּ���.");
				}

			} else if (subMenu.equals("4")) {

				if (data.matches(telExp)) {
					vo.setTel(data);
					break;
				} else {
					System.out.println("����ó ������ �ƴմϴ�. �ٽ� �Է����ּ���.");
				}

			} else {
				System.out.println("������ �׸��� �߸� ���� �Ͽ����ϴ�.");
			}
		} while (true);

	}// end of memEdit

	// ȸ�� ����
	public void memDelete(HashMap<String, MemberVO> mlist) {
		String key = new Library().conInput("������ ���̵� �Է�");
		mlist.remove(key);

	}

}
