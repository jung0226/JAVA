import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {

	public ArrayListTest() {
	}
	public void start() {
		//������ �����ϰ�, index�� ������ �ִ�.
		//ArrayList al = new ArrayList();
		List al = new ArrayList();
		al.add(100);
		al.add(10.6);
		al.add(new VectorTest());
		al.add("����� ������ �����");
		
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
		
		//���ʸ��� �÷��ǿ� �߰��ϴ� ��ü���� ���ϴ� ���̴�.
		//E: element		K: key			V:value
		List<String> data = new ArrayList<String>();
		List<MemberVO> data2 = new ArrayList<MemberVO>();
		
		data.add("12345");
		data.add("�ڹ��÷���");
		
		String str = data.get(1);//Generic�� �ִ� �÷��� get()ȣ��� ����ȯ�� ���� �ʾƵ� �ȴ�.
		System.out.println(str);
		
		data2.add(new MemberVO(111,"hong","010-4545-7878","a@naver.com"));
		//data2.add(Calendar.getInstance());// -->MemberVO��ü�� �ƴ�.
		
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
