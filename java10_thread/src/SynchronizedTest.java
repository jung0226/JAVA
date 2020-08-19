class ATM extends Thread {
	private int deposiMoney = 10000;

	// 1. run()�޼ҵ忡 ����ȭ
	// public synchronized void run() {
	public void run() {
		// 2. �޼ҵ峻�� ����ȭ ����
		synchronized (this) {
			for (int i = 1; i <= 7; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				outputMoney();
			}
		}
	}

	public void outputMoney() {
		if (deposiMoney > 0) {
			deposiMoney -= 1000;
			// ���� �������� ������ �̸� ���ϱ�
			System.out.println(Thread.currentThread().getName() + ", �ܾ�= " + deposiMoney);
		} else {
			System.out.println(Thread.currentThread().getName() + ", �ܾ��� �����մϴ�.");
		}
	}
}

public class SynchronizedTest {

	public SynchronizedTest() {
	}

	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");

		mother.start();
		son.start();
	}

}
