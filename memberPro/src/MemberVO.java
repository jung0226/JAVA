
public class MemberVO {
	private int num;//��ȣ
	private String name;//�̸�
	private String tel;//��ȭ��ȣ
	private String email;//�̸���
	private String addr;//�ּ�
	private String writedate;//�����

	public MemberVO() {}
	//�ؿ� 3�� �޼ҵ�� �ʼ� �ƴ�. ������ ���� ��.
	public MemberVO(int num, String name, String tel, String email, String addr) {
		this.num=num;
		this.name=name;
		this.tel=tel;
		this.email=email;
		this.addr=addr;
	}
	
	public MemberVO(int num, String name, String tel, String email, String addr, String writedate) {
		this(num, name, tel, email, addr);
		this.writedate=writedate;
	}
	
	public void print() {
		System.out.printf("%d %s %s %s %s %s",num, name, tel, email, addr, writedate);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
}
