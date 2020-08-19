import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeStart {
	Scanner scan = new Scanner(System.in);
	HashMap<String, EmployeeVO> list = new HashMap<String, EmployeeVO>();

	public EmployeeStart() {
		// �α���
		int loginCnt = 0;
		do {
			String userid = conInput("���̵�");
			String userpwd = conInput("��й�ȣ");
			Login login = new Login();
			if (login.empCheck(userid, userpwd)) {// �α��� ����
				// ��� ����
				list = Login.setEmp();

				do {
					
					String menu = conInput("�޴�(1:��� ���, 2:��� ���, 3:��� ����, 4:��� ����, 5: ����)");// �޴�ǥ��
					if (menu.equals("1")) {
						employeeList();
					} else if (menu.equals("2")) {
						employeeInsert();
					} else if (menu.equals("3")) {
						employeeEdit();
					} else if (menu.equals("4")) {
						employeeDelete();
					} else if (menu.equals("5")) {
						System.out.println("���α׷��� ����Ǿ����ϴ�.");
						System.exit(0);
					} else {
						System.out.println("�޴��� �߸� �����Ͽ����ϴ�. �ٽ� �����ϼ���.");
					}
				} while (true);

			} else {// �α��� ����
				loginCnt++;
				if (loginCnt >= 3) {// 3������ �α��� ����
					break;
				}
			}
		} while (true);
	}

	// �ֿܼ��� ���� �Է�
	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.nextLine();
	}

	// ��� ���
	public void employeeList() {
		Collection<EmployeeVO> valueList = list.values();
		Iterator<EmployeeVO> ii = valueList.iterator();
		while (ii.hasNext()) {
			ii.next().output();
		}
	}

	// ������
	public void employeeInsert() {
		int num = Integer.parseInt(conInput("��ȣ"));
		String name = conInput("�̸�");
		String tel = conInput("����ó");
		String department = conInput("�μ���");
		String position = conInput("����");

		EmployeeVO vo = new EmployeeVO(num, name, tel, department, position);
		list.put(name, vo);
		employeeList();
	}
	
	// ��� ����
	public void employeeEdit() {
		String name = conInput("������ �����");
		EmployeeVO vo= list.get(name);
		if(vo!=null) {
			vo.output();
			String subMenu=conInput("������ �׸��� �����ϼ���.(1: ����ó, 2: �μ���, 3: ����)");
			String data = conInput("������ ������ �Է�");
			if(subMenu.equals("1")) {
				vo.setTel(data);
			}else if(subMenu.equals("2")) {
				vo.setDepartment(data);
			}else if(subMenu.equals("3")) {
				vo.setPosition(data);
			}else {
				System.out.println("������ �׸��� �߸� ���� �Ͽ����ϴ�.");
			}
		}else {
			System.out.println(name+"���� ������Դϴ�.");
		}
	}
	
	// ��� ����
	public void employeeDelete() {
		String key = conInput("������ ��� �Է�");
		list.remove(key);
	}

	public static void main(String[] args) {
		new EmployeeStart();
	}

}
