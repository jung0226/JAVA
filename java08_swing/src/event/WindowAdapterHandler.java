package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowAdapterHandler extends JFrame{
	JFrame frm;
	public WindowAdapterHandler() {
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//â �� ����.
		
		// �߻� �޼ҵ尡 �������̵� �Ǿ��ִ� AdapterŬ������ �� �������̵� �Ѵ�.
		// �͸��� ���� Ŭ����
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int status = JOptionPane.showConfirmDialog(frm, "���� ���� �Ͻðڽ��ϱ�?");
				if(status == JOptionPane.YES_OPTION) {
					dispose();//�ڿ�����
					System.exit(0);
				}
			}
		}//Ŭ�����ε� �̸��� ����.
		);
		
	}

	public static void main(String[] args) {
		new WindowAdapterHandler();
	}

}
