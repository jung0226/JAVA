import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//Set interface : �Է¼����� �������� �ʴ´�.
		//				   �ߺ���ü�� ������� �ʴ´�
	}
	public void start() {
		//							  -		-	  -			  -
		Double[]data = {23.6, 52.4, 45.4, 45.4, 54.4, 58.5, 54.4, 45.7,};
		
		HashSet<Double> hs= new HashSet<Double>();
		for(Double d: data) {
			hs.add(d);
		}
		
		System.out.println(hs.size());
		
		//HashSet�� get()�޼ҵ尡 ����.
		//Iterator�������̽��� �̿��Ͽ� �����͸� ����� �� �ִ�.
		
		Iterator<Double> iter = hs.iterator();
		while(iter.hasNext()) {//��ü�� �ִ��� Ȯ��
			double d = iter.next();
			System.out.println(d);
			
		}
	}

	public static void main(String[] args) {
		new HashSetTest().start();

	}

}
