import java.awt.Button;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
public class FrameTest2 {//Frame�� ��� ���� �� �ϴ� ���
	Frame frm = new Frame("â ����");
	Button btn = new Button("OK");
	public FrameTest2() {
		frm.setTitle("������ â ����");
		
		frm.add(btn);
		//�����̳� ������ ����
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("img/a.jpg");
		frm.setIconImage(icon);
		
		frm.setSize(500, 500);
		frm.setVisible(true);
	}

	public static void main(String[] args) {
		new FrameTest2();
	}

}
