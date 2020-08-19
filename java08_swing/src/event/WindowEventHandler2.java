package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class WindowEventHandler2 extends WindowAdapter{
	WindowEventTest2 w;
	public WindowEventHandler2() {}
	public WindowEventHandler2(WindowEventTest2 w) {//JFrame도 가능 JFrame을 상속받아서. Object도 가능
		this.w=w;
	}
	//재오버라이딩
	public void windowClosing(WindowEvent we) {
		int status = JOptionPane.showConfirmDialog(w,"종료 할까요?");
		if(status == JOptionPane.YES_OPTION) {
			w.dispose();//자원해제
			System.exit(0);
		}
	}

}
