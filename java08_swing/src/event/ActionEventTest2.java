package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionEventTest2 extends JFrame implements ActionListener {
	JPanel pane = new JPanel();
	JTextField tf = new JTextField(10);
	JButton btn1 = new JButton("������");
	JButton btn2 = new JButton("������(��ü)");

	JTextArea ta = new JTextArea("a\nb\nc");
	JScrollPane sp = new JScrollPane(ta);

	public ActionEventTest2() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		// "North"
		add(BorderLayout.NORTH, pane);
		add(BorderLayout.CENTER, sp);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 1.interface ���
		// 2. �߻�޼ҵ� �������̵�
		// 3. ������Ʈ �̺�Ʈ ���
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		tf.addActionListener(this);
	}

	// �������̵�
	public void actionPerformed(ActionEvent ae) {// JButton, JTextField
		// �̺�Ʈ�� �߻��� ���۳�Ʈ ������ �˾Ƴ���
		Object obj = ae.getSource();//�̺�Ʈ�� �߻��� ��ü�� ���´�.
		// � Ŭ������ ������ ��ü���� Ȯ��
		if(obj instanceof JButton) {// ��ü instanceof Ŭ����
			JButton btn = (JButton) obj;
			if(btn.getText().equals("������")) {
				oneDan();//������(1��)��
				
			}else if(btn.getText().equals("������(��ü)")) {
				allDan();//������ ��ü
				
			}
		}else if(obj instanceof JTextField) {
			oneDan();//������(1��)
		}
	}
	
	public void oneDan() {
		ta.setText("");
		int dan = Integer.parseInt(tf.getText());
		for(int i =2; i<=9; i++)
		{
			ta.append(dan + "*"+i+"= "+dan*i+"\n");
		}
	}
	
	public void allDan() {
		ta.setText("");
		for(int dan =2; dan <=9; dan++) {
			ta.append(dan+"�� \n");
			for(int i =2; i<=9; i++)
			{
				ta.append(dan + "*"+i+"= "+dan*i+"\n");
			}
			ta.append("\n");
		}
	}

	public static void main(String[] args) {
		new ActionEventTest2();

	}

}
