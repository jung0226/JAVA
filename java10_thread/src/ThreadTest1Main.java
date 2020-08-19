import javax.swing.JFrame;

public class ThreadTest1Main extends JFrame{

	public ThreadTest1Main() {
	}

	public static void main(String[] args) {
//		ThreadTest1 t1 = new ThreadTest1("첫번째");
//		//t1.numOutput();
//		t1.start();//먼저 등록했다고 먼저 구현되지 않음. JVM이 알아서 함.
//		ThreadTest1 t2 = new ThreadTest1("두번째");
//		//t2.numOutput();
//		t2.start();
		
		ThreadTest2 t3 = new ThreadTest2("first");
		ThreadTest2 t4 = new ThreadTest2("second");
		
		//Thread 객체 
		Thread tt3= new Thread(t3);
		Thread tt4 = new Thread(t4);
		
		tt4.setPriority(Thread.MAX_PRIORITY); //우선 순위
		
		tt3.start();
		tt4.start();
		

	}
}
