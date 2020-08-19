package java08_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {
	//JTable����
	String title[] = {"��ȣ", "�̸�", "����ó", "�̸���", "�ּ�"};
	Object data[][] = {
			{1, "ȫ�浿", "010-1111-2222", "abcde@naver.com", "����� ������ �����"},	
			{2, "�������", "010-2222-3333", "zzzz@nate.com", "����� ���빮��"},
			{3, "�̼���", "010-3333-4444","xzxzxz@hanmail.net","����� ������ ������"},
			{4, "�念��", "010-4444-5555", "tttt@nate.com", "����� ��������"},
			{5, "���·�", "010-6666-7777", "zkzkzkzz@naver.com", "����� ���۱�"}			
			
	};
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	JLabel lbl = new JLabel("�����Ͱ� ǥ�õǴ� ��....");
	
	public JTableTest() {
		lbl.setOpaque(true);
		lbl.setBackground(new Color(200, 230, 200));
		add(BorderLayout.SOUTH, lbl);
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try{Thread.sleep(1000);}catch(Exception e){}
		//���ڵ� �߰�
		//�߰��� ���ڵ带 Object[] �迭�� ���� ������ �𵨿� �߰�
		Object inData[] = {6, "AAAA", "010-9999-9999", "ffffffff@nate.com", "����� ���ʱ�"};
		model.addRow(inData);
		
		
		try{Thread.sleep(1000);}catch(Exception e){}
		//���ڵ� ����
		Object inData2[] = {7, "BBBB", "010-8888-8888", "djdjdjd@nate.com", "����� ����"};
		model.insertRow(3, inData2);
	
		try{Thread.sleep(1000);}catch(Exception e){}
		//���̵�
		model.moveRow(4, 6, 1); //4���� ���� 6������ 1�� ��ġ�� ��
		
		//�÷�(��)�߰�
		Object inData3[] = {"AAAA", "BBBB", "CCCC"};
		//model.addColumn("���");
		model.addColumn("���", inData3);
	/*
		try {Thread.sleep(1000);}catch(Exception e) {}
		//�����
		model.removeRow(3);
		
		try {Thread.sleep(1000);}catch(Exception e) {}
		//������
		table.removeColumn(table.getColumn("���"));
		
		
		*/
		
		//MouseEventó��
		table.addMouseListener(new MouseAdapter() {
			//���콺�� ���� �� ���� ������ ȣ��Ǵ� �޼ҵ�
			public void mouseReleased(MouseEvent me) {
				int btn = me.getButton(); //1.���ʹ�ư, 2:��, 3:�����ʹ�ư
				if(btn ==1) { //���콺 ���� ��ư�� ���� ���
					int rowIndex = table.getSelectedRow(); //������ ���� index ���� ������
					//�÷� �� ���ϱ�
					int columnCount = table.getColumnCount();
					String txt = "";
					for(int col=0; col<columnCount; col++) {
						txt += table.getValueAt(rowIndex, col)+ ", ";
						
					}
					lbl.setText(txt);
				}
			}
		});
		
		
	}

	public static void main(String[] args) {
		new JTableTest();

	}

}
