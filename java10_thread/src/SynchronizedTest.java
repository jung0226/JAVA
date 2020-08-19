class ATM extends Thread {
	private int deposiMoney = 10000;

	// 1. run()메소드에 동기화
	// public synchronized void run() {
	public void run() {
		// 2. 메소드내에 동기화 설정
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
			// 현재 실행중인 스레드 이름 구하기
			System.out.println(Thread.currentThread().getName() + ", 잔액= " + deposiMoney);
		} else {
			System.out.println(Thread.currentThread().getName() + ", 잔액이 부족합니다.");
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
