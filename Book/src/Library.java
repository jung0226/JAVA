import java.util.HashMap;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Library {
	Scanner scan = new Scanner(System.in);
	HashMap<String, MemberVO> mlist = new HashMap<String, MemberVO>();
	HashMap<String, BookVO> bhm = new HashMap<String, BookVO>();
	HashMap<String, BookRequestVO> bhm2 = new HashMap<String, BookRequestVO>();
	Member m = new Member();
	MemberVO vo = new MemberVO();
	Login login = new Login();
	BookRequestVO rbvo= new BookRequestVO();
	BookVO bvo = new BookVO();
	Book b = new Book();

	// Book bvo�� �Ű�����
	public Library() {
	}

	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.next();
	}

	public void start() {
		int loginCnt = 0;
		// ��� ����
		mlist = m.setEmp();
		bhm = b.setbook();
		bhm2 = b.setbookr();
		a: do {
			
			System.out.println("*****�������� �ý��ۿ� ���� ���� ȯ���մϴ�*****");

			String choice = conInput("�̿��Ͻ� �޴��� �������ּ���. (1.�α���,  2.ȸ������ , 3.�����ϱ�)");
			if (choice.equals("1")) {// �α���
				String id = conInput("���̵�");
				String pwd = conInput("��й�ȣ");
				if (login.memCheck(id, pwd, mlist, bhm, bvo, bhm2, rbvo)) {// �α��� ����
					if (id.equals("admin")) {// ������ ���
						do {
							System.out.println("*******************************************");
							System.out.println(":: \t  ������ ������ �Դϴ�. \t	::");
							System.out.println("*******************************************");
							System.out.println("1. å ��Ϻ���\n2. å ���\n3. å ����\n4. å ���� \n5. å ��û ���\n6. ȸ����Ϻ���\n7. �α׾ƿ�");
							String menu = conInput("�޴��� ������");

							if (menu.equals("1")) {
								b.bookList(bhm, id);
							} else if (menu.equals("2")) {
								b.bookInsert(bhm, bvo);
							} else if (menu.equals("3")) {
								b.bookEdit(bhm);
							} else if (menu.equals("4")) {
								b.bookDelete(bhm);
							} else if (menu.equals("5")) {
								b.bookList2(bhm2);
							} else if (menu.equals("6")) {
								m.memList(mlist);
							} else if (menu.equals("7")) {
								System.out.println("�α׾ƿ� �˴ϴ�.\n");
								
								continue a;
							} else {
								System.out.println("�޴��� �߸� �����Ͽ����ϴ�. �ٽ� �����ϼ���.\n");
							}
						} while (true);
					} else {// �Ϲ�ȸ���� ���
						do {
							String name = mlist.get(id).getName();
							System.out.println("===========================================");
							System.out.println("||" + "\t\t" + name + "�� �ݰ����ϴ�." + "\t\t" + "||");
							System.out.println("===========================================");
							System.out.print("\n�١١١١١١١١ٿ����� ��õ ����: ");
							cal(bhm);
							do {
								System.out.println("\n1. å ��� ����   \n2. å �˻�  \n3. å ��û�ϱ� \n4. ȸ������ �����ϱ� \n5. �α׾ƿ�");
								String menu = conInput("�̿��Ͻ� �޴��� ��ȣ�� �Է����ּ���");
								if (menu.equals("1")) {
									b.bookList(bhm, id);
									break;
								} else if (menu.equals("2")) {
									b.bookSearch(bhm);
								} else if (menu.equals("3")) {
									b.requestedBook(bhm2,rbvo);
								} else if (menu.equals("4")) {
									m.memEdit(mlist, id);
								} else if (menu.equals("5")) {
									System.out.println("�α׾ƿ� �Ͽ����ϴ�. \n");
									
									continue a;
								} else {
									System.out.println("�޴��� �߸� �����Ͽ����ϴ�.\n");
								}
							} while (true);
						} while (true);
					} // else

				} else {// �α��� ����
					loginCnt++;
					if (loginCnt >= 3) {// 3������ �α��νõ�
						System.out.println("���α׷��� ����Ǿ����ϴ�.");
						break a;
					}
				}

			} else if (choice.equals("2")) {// ȸ������
				mlist = m.memAdd(mlist, vo);

			} else if (choice.equals("3")) {// ����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);

			} else {
				System.out.println("��ȣ�� �߸� �������ϴ�. �ٽ� ������ �ּ���.");
			}
		} while (true);

		
	}// end of start

	public static void cal(HashMap<String, BookVO> bhm) {
		Calendar cal = Calendar.getInstance();// ���� ��¥
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		ArrayList list = new ArrayList(); 
		list.addAll(bhm.values());
		BookVO vo = (BookVO)list.get(0);
		
		
		switch(dayOfWeek) {
			case 1:			//�Ͽ���	
				vo = (BookVO)list.get(1);
				System.out.println(vo.getBookName());
			break;
		case 2:
			vo = (BookVO)list.get(2);
			System.out.println(vo.getBookName());
			break;
			case 3:
				vo = (BookVO)list.get(3);
				System.out.println(vo.getBookName());
				break;
			case 4:
				vo = (BookVO)list.get(4);
				System.out.println(vo.getBookName());
				break;
			case 5:
				vo = (BookVO)list.get(5);
				System.out.println(vo.getBookName());
				break;
			case 6:
				vo = (BookVO)list.get(6);
				System.out.println(vo.getBookName());
				break;
			case 7:
				vo = (BookVO)list.get(7);
				System.out.println(vo.getBookName());
				break;
		}//end of switch

	}

}// end of class
