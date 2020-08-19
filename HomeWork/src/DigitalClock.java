
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JFrame implements Runnable {
	JLabel lbl = new JLabel("11:50:50");
	Font fnt = new Font("Arial", Font.BOLD, 70);
	int x = 1;

	public DigitalClock() {
		super("Clock");
		// setTitle("Clock");

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.getImage("img/5.png");

		setIconImage(icon);

		lbl.setHorizontalAlignment(JLabel.CENTER);// JLabel ���ڿ� ��� ����
		lbl.setFont(fnt);
		add(lbl);

	}

	public DigitalClock(int x) {
		this();
		this.x = x;
		// pack();//������ ���븸ŭ â�� ũ�Ⱑ ������.
		// setSize(400,200);//setBounds(x,y,w,h);
		setBounds(x, 1, 400, 150);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	// �ð� ����
	public void run() {
		do {
			Calendar now = Calendar.getInstance();// ����ð�
			SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");// ���ڿ� 11:44:55
			String nowStr = fmt.format(now.getTime());
			// �󺧿� ����
			lbl.setText(nowStr);
			// �Ͻ�����
			try {
				Thread.sleep(500);// 0.5��
			} catch (Exception e) {

			}
		} while (true);
	}
	public static void main(String[] args) {
		DigitalClock dc1 = new DigitalClock(1);
		DigitalClock dc2 = new DigitalClock(401);
		DigitalClock dc3 = new DigitalClock(801);
		
		Thread t1 = new Thread(dc1);
		Thread t2 = new Thread(dc2);
		Thread t3 = new Thread(dc3);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
