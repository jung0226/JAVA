import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {

	public ArrayListTest() {
	}
	public void start() {
		//순서를 유지하고, index를 가지고 있다.
		//ArrayList al = new ArrayList();
		List al = new ArrayList();
		al.add(100);
		al.add(10.6);
		al.add(new VectorTest());
		al.add("서울시 마포구 백범로");
		
		double data1 = (double)al.get(1);
		System.out.println("data1= "+data1);
		
		VectorTest vt = (VectorTest)al.get(2);
		Vector v = vt.getData();
		String name = (String)v.get(2);
		System.out.println("name = "+name);
		
		Vector v2 =vt.getMember();
		for(int i=0; i<v2.size(); i++) {
			MemberVO vo = (MemberVO)v2.get(i);
			vo.print();
		}
		
		//제너릭은 컬렉션에 추가하는 객체형을 정하는 것이다.
		//E: element		K: key			V:value
		List<String> data = new ArrayList<String>();
		List<MemberVO> data2 = new ArrayList<MemberVO>();
		
		data.add("12345");
		data.add("자바컬렉션");
		
		String str = data.get(1);//Generic이 있는 컬렉션 get()호출시 형변환을 하지 않아도 된다.
		System.out.println(str);
		
		data2.add(new MemberVO(111,"hong","010-4545-7878","a@naver.com"));
		//data2.add(Calendar.getInstance());// -->MemberVO객체가 아님.
		
		MemberVO vo3 = data2.get(0);
		vo3.print();
		
		//
		List<Integer> data3 = new ArrayList<Integer>();
		for(int i=1; i<100; i+=8) {
			data3.add(i);
		}
		System.out.println(data3.size());
		
		Object arr[] = data3.toArray();
		for(Object obj:arr) {
			System.out.println(obj);
		}
	
	}

	public static void main(String[] args) {
		new ArrayListTest().start();

	}

}
