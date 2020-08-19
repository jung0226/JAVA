import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTestMain {

	public VectorTestMain() {
	}
	public void start() {
		VectorTest vt = new VectorTest();
		Vector v = vt.getData();
		int num = (Integer)v.get(0);//500
		double ave = (double)v.get(1);//80.5
		System.out.println("num= "+num);
		System.out.println("ave= "+ave);
		
		String name= (String)v.get(2);
		System.out.println("name= "+name);//홍길동
		
		Calendar date = (Calendar)v.get(3);
		System.out.println("date= "+date);//2022,10,10
		
		Random ran = (Random)v.get(4);
		System.out.println("ran= "+ran.nextInt());
		
		//학생정보
		Vector member= vt.getMember();
		member.remove(3);
		// size():벡터의 객체 수를 구한다.
		for(int i=0;i<member.size();i++) {
			MemberVO vo = (MemberVO)member.elementAt(i);
			vo.print();
		}
	}

	public static void main(String[] args) {
		new VectorTestMain().start();

	}

}
