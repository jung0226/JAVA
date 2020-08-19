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

public class ActionEventTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
	JTextField tf = new JTextField(10);
	JButton btn1= new JButton("������");
	JButton btn2 = new JButton("������(��ü)");
	
	JTextArea ta = new JTextArea("a\nb\nc");
	JScrollPane sp = new JScrollPane(ta);
	public ActionEventTest() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		//		"North"
		add(BorderLayout.NORTH,pane);
		add(BorderLayout.CENTER,sp);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//1.interface ��� 
		//2. �߻�޼ҵ� �������̵� 
		//3. ������Ʈ �̺�Ʈ ���
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		tf.addActionListener(this);
	}
	//�������̵�
	public void actionPerformed(ActionEvent ae) {//JButton, JTextField
		
		
		//�̺�Ʈ�� �߻��� ���۳�Ʈ ������ �˾Ƴ���
		String event = ae.getActionCommand();//��ư�� �� ��� ��.
		//System.out.println(event);
		if(event.equals("������")) {
			String gugudan ="";
			int dan = Integer.parseInt(tf.getText());
			for(int i=2;i<=9;i++) {
				gugudan+= dan+" * "+i+"= "+ dan*i+"\n" ;
			}
			//append() : �߰�
			//setText() : ���� ���� ����� �߰�
			//insert() : �߰��� �߰�
			ta.setText(gugudan);			
		}else if(event.equals("������(��ü)")) {
			String gugudan ="";
			for(int dan=2;dan<=9;dan++) {
				for(int i=2;i<=9;i++) {
					gugudan += dan+" * "+i+"= "+ dan*i+"\n" ;
				}
				
			}//for
			ta.setText(gugudan);
		}
	}

	public static void main(String[] args) {
		new ActionEventTest();

	}

}
