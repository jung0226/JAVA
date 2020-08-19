package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowEventTest2 extends JFrame{
	
	public WindowEventTest2() {
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//addWindowListener(new WindowEventHandler2(this));//���� Ŭ������ �� �ѱ�
		addWindowListener(new WindowEventInner());
	}

	public static void main(String[] args) {
		new WindowEventTest2();

	}
	//����Ŭ������ �̺�Ʈ ó��
	class WindowEventInner extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.out.println("���α׷��� ����Ǿ����ϴ�.");
			dispose();
			System.exit(0);
		}
	}

}
