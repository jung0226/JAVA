import javax.swing.JFrame;

public class ThreadTest1Main extends JFrame{

	public ThreadTest1Main() {
	}

	public static void main(String[] args) {
//		ThreadTest1 t1 = new ThreadTest1("ù��°");
//		//t1.numOutput();
//		t1.start();//���� ����ߴٰ� ���� �������� ����. JVM�� �˾Ƽ� ��.
//		ThreadTest1 t2 = new ThreadTest1("�ι�°");
//		//t2.numOutput();
//		t2.start();
		
		ThreadTest2 t3 = new ThreadTest2("first");
		ThreadTest2 t4 = new ThreadTest2("second");
		
		//Thread ��ü 
		Thread tt3= new Thread(t3);
		Thread tt4 = new Thread(t4);
		
		tt4.setPriority(Thread.MAX_PRIORITY); //�켱 ����
		
		tt3.start();
		tt4.start();
		

	}
}
