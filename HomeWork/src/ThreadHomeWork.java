import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class ThreadHomeWork extends JFrame implements Runnable {
	CalendarSwing2 calendar = new CalendarSwing2();
	DigitalClock clock = new DigitalClock();
	PackMan pack = new PackMan();

	Thread clo = new Thread(clock);
	Thread cal = new Thread(calendar);
	Thread pac = new Thread(pack);


	public ThreadHomeWork() {
		JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, clock, calendar);
		JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, pack);

		add(sp1);

		sp1.setDividerLocation(500);

		sp1.setDividerSize(20); // 경계선의 두께. 단위 px
		sp1.setOneTouchExpandable(true); // 확대 축소
		sp2.setOneTouchExpandable(true);

		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public synchronized void run() {
		
		try {
			Thread.sleep(1000);
			clo.start();
			cal.start();
			pac.start();
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		ThreadHomeWork th=new ThreadHomeWork();
		Thread tth = new Thread(th);
		tth.start();

	}

}
