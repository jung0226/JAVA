
public class ExceptionTest3 {

	public ExceptionTest3() {
		sum();
		try {// ����ó�� ���� �ʿ�
			Thread.sleep(2000);// 1000=1s
		} catch (InterruptedException ie) {
			System.out.println("���ܹ߻���");
		}
		oddSum();
	}

	public void sum() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("sum= " + sum);
	}

	public void oddSum() {
		int oddSum = 0;
		for (int i = 1; i <= 100; i += 2) {
			oddSum += i;
		}
		System.out.println("oddsum= " + oddSum);
	}

	public static void main(String[] args) {
		new ExceptionTest3();

	}

}
