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
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//창 안 닫힘.
		
		// 추상 메소드가 오버라이딩 되어있는 Adapter클래스를 재 오버라이딩 한다.
		// 익명의 내부 클래스
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int status = JOptionPane.showConfirmDialog(frm, "정말 종료 하시겠습니까?");
				if(status == JOptionPane.YES_OPTION) {
					dispose();//자원해제
					System.exit(0);
				}
			}
		}//클래스인데 이름이 없음.
		);
		
	}

	public static void main(String[] args) {
		new WindowAdapterHandler();
	}

}
