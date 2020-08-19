
public class ThreadTest1 extends Thread{
	int i = 1;
	String title;
	public ThreadTest1() {
	}
	public ThreadTest1(String title) {
		this.title=title;
	}

//	public void numOutput() {
//		while (true) {
//			System.out.println(title+"--> " + i++);
//		}
//	}
	
	public void run() {
		while(true) {
			System.out.println(title+"--> "+ i++);
		}
	}

}
// Thread클래스를 이용한 스레드 구현
// Thread클래스를 상속 받아 스레드가 구현되어야 하는 기능을 
// run()메소드에 오버라이딩 한다.
// start()메소드로 스레드 스케줄러에 스레드 구현 등록한다.
// start에서 run메소드가 호출됨