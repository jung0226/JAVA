

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ResidentStart extends JPanel implements ActionListener{
	//��
	JPanel nPane = new JPanel(new BorderLayout());
		//�� ��
		JPanel lblPane = new JPanel(new GridLayout(10,1));
			JLabel resident_numLbl = new JLabel("ȸ����ȣ");
			JLabel resident_idLbl = new JLabel("���̵�");
			JLabel resident_pwdLbl = new JLabel("��й�ȣ");
			JLabel resident_nameLbl = new JLabel("�̸�");
			JLabel genderLbl = new JLabel("����");
			JLabel telLbl = new JLabel("��ȭ��ȣ");
			JLabel room_numLbl = new JLabel("���ȣ");
			JLabel move_in_dateLbl = new JLabel("������");
			JLabel expiration_dateLbl = new JLabel("������");
			JLabel monthly_rent_checkLbl = new JLabel("��������");
		//�� �Է� ������Ʈ
		JPanel tfPane = new JPanel(new GridLayout(10,1));
			JTextField resident_numTf = new JTextField(5);			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField resident_idTf = new JTextField(10);			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField resident_pwdTf = new JTextField(15);				JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField resident_nameTf = new JTextField(30);			JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField genderTf = new JTextField(50);			JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField telTf = new JTextField(20);				JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField room_numTf = new JTextField(30);		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField move_in_dateTf = new JTextField(20);			JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField expiration_dateTf = new JTextField(20);			JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField monthly_rent_checkTf = new JTextField(20);			JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
	//�޴�, ȸ������Ʈ
	JPanel cPane = new JPanel(new BorderLayout());
		//�޴�
		JPanel menuPane = new JPanel();
			JButton allListBtn = new JButton("��ü ���");
			JButton addBtn = new JButton("�߰�");
			JButton	editBtn = new JButton("����");
			JButton delBtn = new JButton("����");
			JButton clearBtn = new JButton("�����");
			JButton endBtn = new JButton("����");
		//ȸ�����
		String title[] = {"ȸ����ȣ","���̵�","��й�ȣ","�̸�","����","��ȭ��ȣ","���ȣ","������","������","��������"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public ResidentStart() {
		//��
		nPane.add(BorderLayout.WEST, lblPane);
			lblPane.add(resident_numLbl); lblPane.add(resident_idLbl); lblPane.add(resident_pwdLbl);
			lblPane.add(resident_nameLbl); lblPane.add(genderLbl); lblPane.add(telLbl);
			lblPane.add(room_numLbl); lblPane.add(move_in_dateLbl); lblPane.add(expiration_dateLbl); lblPane.add(monthly_rent_checkLbl);
		nPane.add(BorderLayout.EAST, tfPane);
			p1.add(resident_numTf);   tfPane.add(p1); 
			p2.add(resident_idTf);  tfPane.add(p2); 
			p3.add(resident_pwdTf);   tfPane.add(p3);
			p4.add(resident_nameTf); tfPane.add(p4); 
			p5.add(genderTf);  tfPane.add(p5); 
			p6.add(telTf); tfPane.add(p6);
			p7.add(room_numTf); tfPane.add(p7); 
			p8.add(move_in_dateTf);  tfPane.add(p8); 
			p9.add(expiration_dateTf);  tfPane.add(p9); 
			p10.add(monthly_rent_checkTf);  tfPane.add(p10); 
		
		add(BorderLayout.NORTH, nPane);
		
		//�޴�, ȸ������Ʈ		
		menuPane.add(allListBtn); 
		menuPane.add(addBtn); menuPane.add(editBtn); menuPane.add(delBtn); menuPane.add(clearBtn); menuPane.add(endBtn);
		cPane.add(menuPane, BorderLayout.NORTH);		
		cPane.add(sp);
		add(cPane);
		
		//��ü ���ڵ� �߰�
		getAllRecord();
		
		//JTable �̺�Ʈ ���
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if(me.getButton()==1) {//���콺�� ���� ��ư Ŭ���� ����
					int row = table.getSelectedRow();//���� ���õ� ���� index
					resident_numTf.setText(String.valueOf(model.getValueAt(row, 0)));
					resident_idTf.setText((String)model.getValueAt(row, 1));
					resident_pwdTf.setText((String)model.getValueAt(row, 2));
					resident_nameTf.setText((String)model.getValueAt(row, 3));
					genderTf.setText((String)model.getValueAt(row, 4));
					telTf.setText((String)model.getValueAt(row, 5));
					room_numTf.setText(String.valueOf(model.getValueAt(row, 6)));
					move_in_dateTf.setText((String)model.getValueAt(row, 7));
					expiration_dateTf.setText((String)model.getValueAt(row, 8));
					monthly_rent_checkTf.setText((String)model.getValueAt(row, 9));
				}
			}			
		});
		//�޴� �̺�Ʈ ���
		allListBtn.addActionListener(this);
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
		ResidentDAO dao = new ResidentDAO();
		List<ResidentVO> list= dao.getAll();
		
		for(int i=0; i<list.size(); i++) {
			ResidentVO vo = list.get(i);
			Object[] record = {vo.getResident_num(), vo.getResident_id(), vo.getResident_pwd(), vo.getResident_name(), vo.getGender(), vo.getTel(),
					vo.getRoom_num(), vo.getMove_in_date(), vo.getExpiration_date(), vo.getMonthly_rent_check()};
			model.addRow(record);
		}		
	}
	//���� ���ڿ� �����
	public void formClear() {
		resident_numTf.setText("");
		resident_idTf.setText("");
		resident_pwdTf.setText("");
		resident_nameTf.setText("");
		genderTf.setText("");
		telTf.setText("");
		room_numTf.setText("");
		move_in_dateTf.setText("");
		expiration_dateTf.setText("");
		monthly_rent_checkTf.setText("");
	}
	
	//ǰ�� ���ڵ带 ������ ���̽��� �߰�
	public void residentInsert() {
		ResidentVO vo = new ResidentVO();
		//vo.setResident_num(Integer.parseInt(resident_numTf.getText()));
		vo.setResident_id(resident_idTf.getText());
		vo.setResident_pwd(resident_pwdTf.getText());
		vo.setResident_name(resident_nameTf.getText());
		vo.setGender(genderTf.getText());
		vo.setTel(telTf.getText());
		vo.setRoom_num(Integer.parseInt(room_numTf.getText()));
		vo.setMove_in_date(move_in_dateTf.getText());
		vo.setExpiration_Date(expiration_dateTf.getText());
		vo.setMonthly_rent_check(monthly_rent_checkTf.getText());
		
		//������ �Է����� Ȯ�� �� ���ڵ� �߰�
		if(vo.getResident_id()==null || vo.getResident_id().equals("")){
			JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���.");
		}else if(vo.getResident_pwd()==null || vo.getResident_pwd().equals("")) {
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���.");
		}else if(vo.getResident_name()==null || vo.getResident_name().equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		}else if(vo.getGender()==null || vo.getGender().equals("")) {
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���.");
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �Է��ϼ���.");
		}else if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(this, "�� ��ȣ�� �Է��ϼ���.");
		}else if(vo.getMove_in_date()==null || vo.getMove_in_date().equals("")) {
			JOptionPane.showMessageDialog(this, "�������� �Է��ϼ���.");
		}else if(vo.getExpiration_date()==null || vo.getExpiration_date().equals("")) {
			JOptionPane.showMessageDialog(this, "�������� �Է��ϼ���.");
		}else if(vo.getMonthly_rent_check()==null || vo.getMonthly_rent_check().equals("")) {
			JOptionPane.showMessageDialog(this, "�����ϳ����θ� �Է��ϼ���.");
		}else {
			ResidentDAO dao = new ResidentDAO();
			int result = dao.insertRecord2(vo);
			if(result>0) {//�߰� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "ȸ���� ����߽��ϴ�.");
				getAllRecord();
				formClear();
			}else {//�߰� ���н�
				JOptionPane.showMessageDialog(this, "ȸ������� �����߽��ϴ�.");
			}
		}
	}
	
	//����
	public void residentEdit() {
		ResidentVO vo = new ResidentVO();
		vo.setResident_num(Integer.parseInt(resident_numTf.getText()));
		vo.setResident_id(resident_idTf.getText());
		vo.setResident_pwd(resident_pwdTf.getText());
		vo.setResident_name(resident_nameTf.getText());
		vo.setGender(genderTf.getText());
		vo.setTel(telTf.getText());
		vo.setRoom_num(Integer.parseInt(room_numTf.getText()));
		vo.setMove_in_date(move_in_dateTf.getText());
		vo.setExpiration_Date(expiration_dateTf.getText());
		vo.setMonthly_rent_check(monthly_rent_checkTf.getText());
		
		if(vo.getResident_id()==null || vo.getResident_id().equals("")){
			JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���.");
		}else if(vo.getResident_pwd()==null || vo.getResident_pwd().equals("")) {
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���.");
		}else if(vo.getResident_name()==null || vo.getResident_name().equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		}else if(vo.getGender()==null || vo.getGender().equals("")) {
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���.");
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �Է��ϼ���.");
		}else if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(this, "�� ��ȣ�� �Է��ϼ���.");
		}else if(vo.getMove_in_date()==null || vo.getMove_in_date().equals("")) {
			JOptionPane.showMessageDialog(this, "�������� �Է��ϼ���.");
		}else if(vo.getExpiration_date()==null || vo.getExpiration_date().equals("")) {
			JOptionPane.showMessageDialog(this, "�������� �Է��ϼ���.");
		}else if(vo.getMonthly_rent_check()==null || vo.getMonthly_rent_check().equals("")) {
			JOptionPane.showMessageDialog(this, "�����ϳ����θ� �Է��ϼ���.");
		}else {
			ResidentDAO dao= new ResidentDAO();
			int result = dao.updateRecord(vo);
			if(result>0) {//���� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "ȸ���� �����Ǿ����ϴ�.");
				getAllRecord();
				formClear();
			}else {//���� ���н�				
				JOptionPane.showMessageDialog(this, "ȸ�� ������ �����߽��ϴ�.");
			}
		}
		
	}
	//����
	public void residentDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "ȸ���� ���� �Ͻðڽ��ϱ�?", "ȸ�� ���� Ȯ��", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 ResidentDAO dao = new ResidentDAO();
			 int result = dao.deleteRecord(Integer.parseInt(resident_numTf.getText()));
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
			residentInsert();
		}else if(event == editBtn) {
			residentEdit();
		}else if(event == delBtn) {
			residentDelete();
		}else if(event == allListBtn) {
			getAllRecord();
		}
	}


}
