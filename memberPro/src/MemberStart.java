

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberStart extends JFrame implements ActionListener{
	//��
	JPanel nPane = new JPanel(new BorderLayout());
		//�� ��
		JPanel lblPane = new JPanel(new GridLayout(6,1));
			JLabel numLbl = new JLabel("��ȣ");
			JLabel nameLbl = new JLabel("�̸�");
			JLabel telLbl = new JLabel("����ó");
			JLabel emailLbl = new JLabel("�̸���");
			JLabel addrLbl = new JLabel("�ּ�");
			JLabel writedateLbl = new JLabel("�����");
		//�� �Է� ������Ʈ
		JPanel tfPane = new JPanel(new GridLayout(6,1));
			JTextField numTf = new JTextField(5);			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField nameTf = new JTextField(10);			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField telTf = new JTextField(15);			JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField emailTf = new JTextField(30);		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField addrTf = new JTextField(50);			JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField writedateTf = new JTextField(20);	JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
	//�޴�, ȸ������Ʈ
	JPanel cPane = new JPanel(new BorderLayout());
		//�޴�
		JPanel menuPane = new JPanel();
			JButton addBtn = new JButton("�߰�");
			JButton	editBtn = new JButton("����");
			JButton delBtn = new JButton("����");
			JButton clearBtn = new JButton("�����");
			JButton endBtn = new JButton("����");
		//ȸ�����
		String title[] = {"��ȣ", "�̸�", "����ó", "�̸���", "�ּ�", "�����"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public MemberStart() {
		super("ȸ������ �ý���");
		//��
		nPane.add(BorderLayout.WEST, lblPane);
			lblPane.add(numLbl); lblPane.add(nameLbl); lblPane.add(telLbl);
			lblPane.add(emailLbl); lblPane.add(addrLbl); lblPane.add(writedateLbl);
		nPane.add(BorderLayout.EAST, tfPane);
			p1.add(numTf);   tfPane.add(p1); 
			p2.add(nameTf);  tfPane.add(p2); 
			p3.add(telTf);   tfPane.add(p3);
			p4.add(emailTf); tfPane.add(p4); 
			p5.add(addrTf);  tfPane.add(p5); 
			p6.add(writedateTf); tfPane.add(p6);
		
		add(BorderLayout.NORTH, nPane);
		
		//�޴�, ȸ������Ʈ
		menuPane.add(addBtn); menuPane.add(editBtn); menuPane.add(delBtn); menuPane.add(clearBtn); menuPane.add(endBtn);
		cPane.add(menuPane, BorderLayout.NORTH);		
		cPane.add(sp);
		add(cPane);
		
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//��ü ���ڵ� �߰�
		getAllRecord();
		
		//JTable �̺�Ʈ ���
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if(me.getButton()==1) {//���콺�� ���� ��ư Ŭ���� ����
					int row = table.getSelectedRow();//���� ���õ� ���� index
					numTf.setText(String.valueOf(model.getValueAt(row, 0)));
					nameTf.setText((String)model.getValueAt(row, 1));
					telTf.setText((String)model.getValueAt(row, 2));
					emailTf.setText((String)model.getValueAt(row, 3));
					addrTf.setText((String)model.getValueAt(row, 4));
					writedateTf.setText((String)model.getValueAt(row, 5));
				}
			}			
		});
		//�޴� �̺�Ʈ ���
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		delBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		endBtn.addActionListener(this);
	}
	
	//���ڵ� ��ü �����Ͽ� JTable�� �߰��ϱ�
	public void getAllRecord() {
		//JTable���̺� �ִ� ���ڵ� �����
		model.setRowCount(0);
		
		//DAO ��ü ����
		//MemberDAO dao = new MemberDAO();
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> list= dao.getAllMember();
		
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			Object[] record = {vo.getNum(), vo.getName(), vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWritedate()};
			model.addRow(record);
		}		
	}
	//���� ���ڿ� �����
	public void formClear() {
		numTf.setText("");
		nameTf.setText("");
		telTf.setText("");
		emailTf.setText("");
		addrTf.setText("");
		writedateTf.setText("");		
	}
	
	//ǰ�� ���ڵ带 ������ ���̽��� �߰�
	public void memberInsert() {
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(numTf.getText()));
		vo.setName(nameTf.getText());
		vo.setTel(telTf.getText());
		vo.setEmail(emailTf.getText());
		vo.setAddr(addrTf.getText());
		
		//������ �Է����� Ȯ�� �� ���ڵ� �߰�
		if(vo.getNum()==0) {
			JOptionPane.showMessageDialog(this, "��ȣ�� �Է��ϼ���.");
		}else if(vo.getName()==null || vo.getName().equals("")){
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "����ó�� �Է��ϼ���.");
		}else {
			MemberDAO dao = new MemberDAO();
			int result = dao.insertRecord(vo);
			if(result>0) {//�߰� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "ȸ���� ��ϵƽ��ϴ�.");
				getAllRecord();
				formClear();
			}else {//�߰� ���н�
				JOptionPane.showMessageDialog(this, "ȸ�� ����� �����߽��ϴ�.");
			}
		}
	}
	
	//ȸ������ ����
	public void memberEdit() {
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(numTf.getText()));
		vo.setName(nameTf.getText());
		vo.setTel(telTf.getText());
		vo.setEmail(emailTf.getText());
		vo.setAddr(addrTf.getText());
		
		if(vo.getNum()<=0) {
			JOptionPane.showMessageDialog(this, "��ȣ�� �ݵ�� �־�� �մϴ�.");
		}else if(vo.getName()==null || vo.getName()==""){
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �־�� �մϴ�.");
		}else if(vo.getTel()==null || vo.getTel()=="") {
			JOptionPane.showMessageDialog(this, "����ó�� �ݵ�� �־�� �մϴ�.");
		}else {
			MemberDAO dao=MemberDAO.getInstance();
			int result = dao.updateRecord(vo);
			if(result>0) {//���� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "ȸ�������� �����Ǿ����ϴ�.");
				getAllRecord();
				formClear();
			}else {//���� ���н�				
				JOptionPane.showMessageDialog(this, "ȸ������ ������ �����߽��ϴ�.");
			}
		}
		
	}
	//ȸ�� ����
	public void memberDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "ȸ�� ���� �Ͻðڽ��ϱ�?", "ȸ�� ���� Ȯ��", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 MemberDAO dao = MemberDAO.getInstance();
			 int result = dao.deleteRecord(Integer.parseInt(numTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "ȸ���� �����Ǿ����ϴ�.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "ȸ�� ���� �����Ͽ����ϴ�.");				 
			 }
			 
		 }
	}
	//��ư �̺�Ʈ
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//ǰ�� ���ڿ��� �����
			formClear();
		}else if(event == addBtn) {//ǰ�� ���ڵ带 ������ ���̽��� �߰�
			memberInsert();
		}else if(event == editBtn) {
			memberEdit();
		}else if(event == delBtn) {
			memberDelete();
		}
	}

	public static void main(String[] args) {
		new MemberStart();
	}

}
