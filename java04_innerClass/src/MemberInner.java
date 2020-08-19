
public class MemberInner {
	int num = 100;
	String name = "홍길동";
	public MemberInner() {
		
	}

	public void print() {
		System.out.println("번호="+num);
		System.out.println("이름="+name);
		//외부 클래스에서 내부 클래스의 정보를 접근할 수 없다.
		//System.out.println("연락처="+tel);
	}
	
	//내부 클래스
	class Inner{
		int num = 200;
		String tel = "010-1234-5678";
		Inner(){}
		Inner(int num){
			this.num = num;
		}
		public void output() {
			System.out.println("num="+num);
			System.out.println("tel="+tel);
			//내부 클래스에서 외부 클래스의 정보를 접근할 수 있다.
			System.out.println("name="+name);
			print();
		}
	}
	
	
	public static void main(String[] args) {
		MemberInner mi = new MemberInner();
		mi.print();
		
		//내부 클래스 : 객체 생성
		MemberInner.Inner in1 = mi.new Inner();
		MemberInner.Inner in2 = new MemberInner().new Inner(300);
		
		in1.output();
		in2.output();
	}

}
