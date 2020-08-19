
public class EmployeeVO {
	private int num;// 사원번호
	private String name;// 이름
	private String tel;// 전화번호
	private String department;// 부서
	private String position;// 직급

	public EmployeeVO() {
	}

	public EmployeeVO(int num, String name, String tel, String department, String position) {
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.department = department;
		this.position = position;
	}
	public void output() {
		System.out.printf("%6d %6s %15s %6s %6s\n", num, name, tel, department, position);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
