package java08_swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest2 {
	JFrame frm = new JFrame("â�� ����"); //BoderLayout

	public JFrameTest2() {
		//���̾ƿ� ���� ��ǥ�� �̿��ؼ� ������Ʈ ��ġ�ϱ�
		frm.setLayout(null);
		JButton btn = new JButton("��ǥ�� ���̾ƿ� ����");
		btn.setSize(200, 50);//ũ��
		btn.setLocation(50, 100);//x, y��ǥ
		frm.add(btn);
		
		frm.setResizable(false); // âũ�� ���� �Ұ�
		frm.setSize(500,500);
		frm.setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameTest2();

	}

}
