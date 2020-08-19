
public class MemberVO {
	//번호, 이름, 연락처, 이메일
	private int num;
	private String name;
	private String tel;
	private String email;
	public MemberVO() {
	}
	public MemberVO(int num, String name) {
		this.num=num;
		this.name=name;
	}
	public MemberVO(int num, String name, String tel, String email) {
		//this.num=num;
		//this.name=name;
		this(num,name);
		this.tel=tel;
		this.email=email;
	}
	public void print() {
		System.out.println(num+", "+name+", "+tel+", "+email);
	}
	//getter, setter
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
		this.email=email;
	}

}
