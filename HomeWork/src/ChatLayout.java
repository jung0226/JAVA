import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatLayout extends JFrame{
	JPanel pane = new JPanel(new BorderLayout());
	JPanel gridPane= new JPanel(new GridLayout(1,2));
	JPanel westPane = new JPanel(new BorderLayout());
		JPanel ipPane = new JPanel();
			JTextField ipTf = new JTextField(20); // ip�ּ� �Է�
			JButton ipBtn = new JButton("����");
		JTextArea chatTa = new JTextArea(); // ä��ȭ��
		JScrollPane sp1 = new JScrollPane(chatTa);
		JPanel msgPane = new JPanel();
			JTextField msgTf = new JTextField(20); //�޼��� �Է�		
			JButton msgBtn = new JButton("������");
		
	JPanel eastPane = new JPanel(new BorderLayout(20,20));
		JLabel listLbl = new JLabel("������ ����Ʈ", JLabel.CENTER);
		JTextArea accessList = new JTextArea(); // ������ ȭ��
		JScrollPane sp2 = new JScrollPane(accessList);
		int count=0;
		JLabel countLbl = new JLabel("�����: "+count+"��");
	
	public ChatLayout() {		
		super("Chat Client");
		add(pane);		
		pane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		pane.add(gridPane);
		chatTa.setBackground(new Color(0,0,153));
		ipTf.setBackground(new Color(98,209,255));
		msgTf.setBackground(new Color(98,209,255));
		
		//���� 
		gridPane.add(westPane);
		westPane.add(BorderLayout.NORTH,ipPane);
			ipPane.add(ipTf); 
			ipPane.add(ipBtn);
		westPane.add(sp1);
		westPane.add(BorderLayout.SOUTH,msgPane);
			msgPane.add(msgTf);
			msgPane.add(msgBtn);
		
		//������ 
		gridPane.add(eastPane);
		eastPane.add(BorderLayout.NORTH,listLbl);
		eastPane.add(sp2);
		eastPane.add(BorderLayout.SOUTH,countLbl);
		

		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new ChatLayout();
	}

}
