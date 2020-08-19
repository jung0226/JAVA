import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//Set interface : 입력순서를 유지하지 않는다.
		//				   중복객체를 허용하지 않는다
	}
	public void start() {
		//							  -		-	  -			  -
		Double[]data = {23.6, 52.4, 45.4, 45.4, 54.4, 58.5, 54.4, 45.7,};
		
		HashSet<Double> hs= new HashSet<Double>();
		for(Double d: data) {
			hs.add(d);
		}
		
		System.out.println(hs.size());
		
		//HashSet은 get()메소드가 없다.
		//Iterator인터페이스를 이용하여 데이터를 출력할 수 있다.
		
		Iterator<Double> iter = hs.iterator();
		while(iter.hasNext()) {//객체가 있는지 확인
			double d = iter.next();
			System.out.println(d);
			
		}
	}

	public static void main(String[] args) {
		new HashSetTest().start();

	}

}
