package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class WindowEventHandler2 extends WindowAdapter{
	WindowEventTest2 w;
	public WindowEventHandler2() {}
	public WindowEventHandler2(WindowEventTest2 w) {//JFrame�� ���� JFrame�� ��ӹ޾Ƽ�. Object�� ����
		this.w=w;
	}
	//��������̵�
	public void windowClosing(WindowEvent we) {
		int status = JOptionPane.showConfirmDialog(w,"���� �ұ��?");
		if(status == JOptionPane.YES_OPTION) {
			w.dispose();//�ڿ�����
			System.exit(0);
		}
	}

}
