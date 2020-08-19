package event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WindowEventTest extends JFrame implements WindowListener{

	JTextArea ta = new JTextArea();
	
	public WindowEventTest() {
		add(ta);
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//â�� ���� ����.
		
		//�̺�Ʈ ���
		addWindowListener(this);
		
	}
	
	@Override
	public void windowActivated(WindowEvent we) {
		System.out.println("Activated");
	}

	@Override
	public void windowClosed(WindowEvent we) {
		System.out.println("Closed");
	}
	@Override
	public void windowClosing(WindowEvent we) {
		//����
		int status= JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?");
		if(status == JOptionPane.OK_OPTION) {
			dispose();//�ڿ�����
			System.exit(0);
		}
	}
	@Override
	public void windowDeactivated(WindowEvent we) {
		System.out.println("Deactivated");
	}
	@Override
	public void windowDeiconified(WindowEvent we) {
		System.out.println("Deiconified");
	}
	@Override
	public void windowIconified(WindowEvent we) {
		System.out.println("Iconified");
	}

	@Override
	public void windowOpened(WindowEvent we) {
		System.out.println("Opened");
	}
	


	
	public static void main(String[] args) {
		new WindowEventTest();
	}

}
