public class AbstractMain extends AbstractTest {
	public AbstractMain() {	
	}
	@Override
	public void print(int a) {
		System.out.println("a= "+a+", max= "+max);		
	}
	@Override
	public int sum() {
		int total=0;
		for(int i=1; i<=max; i++) {
			total+=i;
		}
		return total;
	}
	public static void main(String[] args) {
		//�߻�Ŭ������ ��ü�� ������ �� ����.
		//new AbstractTest();
		//�߻� Ŭ������ ����� �޾� ��� �߻�޼ҵ带 �������̵��� �Ͽ��� �Ѵ�.
		AbstractMain main = new AbstractMain();
		main.print(200);
		System.out.println("sum= "+main.sum());
		
	
	}
}