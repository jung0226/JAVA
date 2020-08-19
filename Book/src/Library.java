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

	// Book bvo를 매개변수
	public Library() {
	}

	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.next();
	}

	public void start() {
		int loginCnt = 0;
		// 멤버 셋팅
		mlist = m.setEmp();
		bhm = b.setbook();
		bhm2 = b.setbookr();
		a: do {
			
			System.out.println("*****도서관리 시스템에 오신 것을 환영합니다*****");

			String choice = conInput("이용하실 메뉴를 선택해주세요. (1.로그인,  2.회원가입 , 3.종료하기)");
			if (choice.equals("1")) {// 로그인
				String id = conInput("아이디");
				String pwd = conInput("비밀번호");
				if (login.memCheck(id, pwd, mlist, bhm, bvo, bhm2, rbvo)) {// 로그인 성공
					if (id.equals("admin")) {// 관리자 모드
						do {
							System.out.println("*******************************************");
							System.out.println(":: \t  관리자 페이지 입니다. \t	::");
							System.out.println("*******************************************");
							System.out.println("1. 책 목록보기\n2. 책 등록\n3. 책 수정\n4. 책 삭제 \n5. 책 요청 목록\n6. 회원목록보기\n7. 로그아웃");
							String menu = conInput("메뉴를 고르세요");

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
								System.out.println("로그아웃 됩니다.\n");
								
								continue a;
							} else {
								System.out.println("메뉴를 잘못 선택하였습니다. 다시 선택하세요.\n");
							}
						} while (true);
					} else {// 일반회원인 경우
						do {
							String name = mlist.get(id).getName();
							System.out.println("===========================================");
							System.out.println("||" + "\t\t" + name + "님 반갑습니다." + "\t\t" + "||");
							System.out.println("===========================================");
							System.out.print("\n☆☆☆☆☆☆☆☆☆오늘의 추천 도서: ");
							cal(bhm);
							do {
								System.out.println("\n1. 책 목록 보기   \n2. 책 검색  \n3. 책 신청하기 \n4. 회원정보 수정하기 \n5. 로그아웃");
								String menu = conInput("이용하실 메뉴의 번호를 입력해주세요");
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
									System.out.println("로그아웃 하였습니다. \n");
									
									continue a;
								} else {
									System.out.println("메뉴를 잘못 선택하였습니다.\n");
								}
							} while (true);
						} while (true);
					} // else

				} else {// 로그인 실패
					loginCnt++;
					if (loginCnt >= 3) {// 3번까지 로그인시도
						System.out.println("프로그램이 종료되었습니다.");
						break a;
					}
				}

			} else if (choice.equals("2")) {// 회원가입
				mlist = m.memAdd(mlist, vo);

			} else if (choice.equals("3")) {// 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			} else {
				System.out.println("번호를 잘못 눌렀습니다. 다시 선택해 주세요.");
			}
		} while (true);

		
	}// end of start

	public static void cal(HashMap<String, BookVO> bhm) {
		Calendar cal = Calendar.getInstance();// 현재 날짜
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		ArrayList list = new ArrayList(); 
		list.addAll(bhm.values());
		BookVO vo = (BookVO)list.get(0);
		
		
		switch(dayOfWeek) {
			case 1:			//일요일	
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
