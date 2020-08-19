package java08_swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame {
	JButton btn1 = new JButton("1111");
	JButton btn2 = new JButton("2222");
	JButton btn3 = new JButton("3333");
	JButton btn4 = new JButton("4444");
	JButton btn5 = new JButton("5555");
	
	JPanel pane= new JPanel();
	JButton btn6 = new JButton("66666");
	JButton btn7 = new JButton("77777");
	JButton btn8 = new JButton("88888");

	public JFrameTest() {
		// �� �����̳ʸ��� �⺻ ���̾ƿ��� �ִ�.
		// JFrame, JDailog : BorderLayout
		// JPanel :FlowLayout
		// GridLayout, CardLayout, GridbagLayout
		// BorderLayout: ��, ��, ��, ��, ��� 5�������� ������.
		// FlowLayout : �߰��ϴ� ���۳�Ʈ ������� ��ġ
		// GridLayout : �ٵ��ǽ����� ���μ��� �࿭�� ũ�Ⱑ ����.
		
		add(btn1);
		add(BorderLayout.NORTH, btn2); //add("North", btn2);
		add("West",btn3);//�� ����, ���̸� ����
		
		//FlowLayout�� GridLayout���� �����ϱ�
		pane.setLayout(new GridLayout(2,10, 10,5));
		pane.add(btn6);
		pane.add(btn7);
		pane.add(btn8);
		pane.add(new JButton("A"));
		pane.add(new JButton("B"));
		
		add(BorderLayout.EAST, pane);
		add("South",btn5);
		
		
		setSize(500,500);
		setVisible(true);
		
		//�����̳ʰ� ����Ǹ� �ڿ������Ѵ�.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameTest();

	}

}
