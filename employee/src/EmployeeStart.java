import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeStart {
	Scanner scan = new Scanner(System.in);
	HashMap<String, EmployeeVO> list = new HashMap<String, EmployeeVO>();

	public EmployeeStart() {
		// 로그인
		int loginCnt = 0;
		do {
			String userid = conInput("아이디");
			String userpwd = conInput("비밀번호");
			Login login = new Login();
			if (login.empCheck(userid, userpwd)) {// 로그인 성공
				// 사원 셋팅
				list = Login.setEmp();

				do {
					
					String menu = conInput("메뉴(1:사원 목록, 2:사원 등록, 3:사원 수정, 4:사원 삭제, 5: 종료)");// 메뉴표시
					if (menu.equals("1")) {
						employeeList();
					} else if (menu.equals("2")) {
						employeeInsert();
					} else if (menu.equals("3")) {
						employeeEdit();
					} else if (menu.equals("4")) {
						employeeDelete();
					} else if (menu.equals("5")) {
						System.out.println("프로그램이 종료되었습니다.");
						System.exit(0);
					} else {
						System.out.println("메뉴를 잘못 선택하였습니다. 다시 선택하세요.");
					}
				} while (true);

			} else {// 로그인 실패
				loginCnt++;
				if (loginCnt >= 3) {// 3번까지 로그인 가능
					break;
				}
			}
		} while (true);
	}

	// 콘솔에서 문자 입력
	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.nextLine();
	}

	// 사원 목록
	public void employeeList() {
		Collection<EmployeeVO> valueList = list.values();
		Iterator<EmployeeVO> ii = valueList.iterator();
		while (ii.hasNext()) {
			ii.next().output();
		}
	}

	// 사원등록
	public void employeeInsert() {
		int num = Integer.parseInt(conInput("번호"));
		String name = conInput("이름");
		String tel = conInput("연락처");
		String department = conInput("부서명");
		String position = conInput("직급");

		EmployeeVO vo = new EmployeeVO(num, name, tel, department, position);
		list.put(name, vo);
		employeeList();
	}
	
	// 사원 수정
	public void employeeEdit() {
		String name = conInput("수정할 사원명");
		EmployeeVO vo= list.get(name);
		if(vo!=null) {
			vo.output();
			String subMenu=conInput("수정할 항목을 선택하세요.(1: 연락처, 2: 부서명, 3: 직급)");
			String data = conInput("수정할 데이터 입력");
			if(subMenu.equals("1")) {
				vo.setTel(data);
			}else if(subMenu.equals("2")) {
				vo.setDepartment(data);
			}else if(subMenu.equals("3")) {
				vo.setPosition(data);
			}else {
				System.out.println("수정할 항목을 잘못 선택 하였습니다.");
			}
		}else {
			System.out.println(name+"없는 사원명입니다.");
		}
	}
	
	// 사원 삭제
	public void employeeDelete() {
		String key = conInput("삭제할 사원 입력");
		list.remove(key);
	}

	public static void main(String[] args) {
		new EmployeeStart();
	}

}
