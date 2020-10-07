

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

public class RoomStart extends JPanel implements ActionListener{
	//��
	JPanel nPane = new JPanel(new BorderLayout());
		//�� ��
		JPanel lblPane = new JPanel(new GridLayout(9,1));
			JLabel roomNumLbl = new JLabel("�� ��ȣ");
			JLabel genderLbl = new JLabel("����");
			JLabel areaLbl = new JLabel("���");
			JLabel windowLbl = new JLabel("â������");
			JLabel depositLbl = new JLabel("������");
			JLabel monthlyRentLbl = new JLabel("����");
			JLabel occupancyStatusLbl = new JLabel("���ְ��ɿ���");
			JLabel reservationLbl = new JLabel("���࿩��");
			JLabel residentNumLbl = new JLabel("�����ڹ�ȣ");
		//�� �Է� ������Ʈ
		JPanel tfPane = new JPanel(new GridLayout(9,1));
			JTextField roomNumTf = new JTextField(5);			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField genderTf = new JTextField(10);			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField areaTf = new JTextField(15);				JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField windowTf = new JTextField(30);			JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField depositTf = new JTextField(50);			JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField monthlyTf = new JTextField(20);				JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField occupancyStatusTf = new JTextField(30);		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField reservationTf = new JTextField(50);			JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			//JTextField residentNumTf = new JTextField(20);			JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
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
		String title[] = {"�� ��ȣ", "����", "���", "â������", "������", "����", "���ְ��ɿ���", "���࿩��"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public RoomStart() {
		//��
		nPane.add(BorderLayout.WEST, lblPane);
			lblPane.add(roomNumLbl); lblPane.add(genderLbl); lblPane.add(areaLbl);
			lblPane.add(windowLbl); lblPane.add(depositLbl); lblPane.add(monthlyRentLbl);
			lblPane.add(occupancyStatusLbl); lblPane.add(reservationLbl); lblPane.add(residentNumLbl);
		nPane.add(BorderLayout.EAST, tfPane);
			p1.add(roomNumTf);   tfPane.add(p1); 
			p2.add(genderTf);  tfPane.add(p2); 
			p3.add(areaTf);   tfPane.add(p3);
			p4.add(windowTf); tfPane.add(p4); 
			p5.add(depositTf);  tfPane.add(p5); 
			p6.add(monthlyTf); tfPane.add(p6);
			p7.add(occupancyStatusTf); tfPane.add(p7); 
			p8.add(reservationTf);  tfPane.add(p8); 
			//p6.add(residentNumTf); tfPane.add(p6);
		
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
					roomNumTf.setText(String.valueOf(model.getValueAt(row, 0)));
					genderTf.setText((String)model.getValueAt(row, 1));
					areaTf.setText(String.valueOf(model.getValueAt(row, 2)));
					windowTf.setText((String)model.getValueAt(row, 3));
					depositTf.setText(String.valueOf(model.getValueAt(row, 4)));
					monthlyTf.setText(String.valueOf(model.getValueAt(row, 5)));
					occupancyStatusTf.setText((String)model.getValueAt(row, 6));
					reservationTf.setText((String)model.getValueAt(row, 7));
					//residentNumTf.setText((String)model.getValueAt(row, 8));
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
		RoomDAO dao = new RoomDAO();
		List<RoomVO> list= dao.getRoomAll();
		
		for(int i=0; i<list.size(); i++) {
			RoomVO vo = list.get(i);
			Object[] record = {vo.getRoom_num(), vo.getGender(), vo.getArea(), vo.getWindow(), vo.getDeposit(), vo.getMonthly_rent(),
					vo.getOccupancy_status()};
			model.addRow(record);
		}		
	}
	//���� ���ڿ� �����
	public void formClear() {
		roomNumTf.setText("");
		genderTf.setText("");
		areaTf.setText("");
		windowTf.setText("");
		depositTf.setText("");
		monthlyTf.setText("");
		occupancyStatusTf.setText("");
		reservationTf.setText("");
		//residentNumTf.setText("");
	}
	
	//ǰ�� ���ڵ带 ������ ���̽��� �߰�
	public void roomInsert() {
		RoomVO vo = new RoomVO();
		vo.setRoom_num(Integer.parseInt(roomNumTf.getText()));
		vo.setGender(genderTf.getText());
		vo.setArea(Integer.parseInt(areaTf.getText()));
		vo.setWindow(windowTf.getText());
		vo.setDeposit(Integer.parseInt(depositTf.getText()));
		vo.setMonthly_rent(Integer.parseInt(monthlyTf.getText()));
		vo.setOccupancy_status(occupancyStatusTf.getText());

		
		//������ �Է����� Ȯ�� �� ���ڵ� �߰�
		if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(this, "�� ��ȣ�� �Է��ϼ���.");
		}else if(vo.getGender()==null || vo.getGender().equals("")){
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���.");
		}else if(vo.getArea()==0) {
			JOptionPane.showMessageDialog(this, "����� �Է��ϼ���.");
		}else {
			RoomDAO dao = new RoomDAO();
			int result = dao.insertRecord(vo);
			if(result>0) {//�߰� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "���� ����߽��ϴ�.");
				getAllRecord();
				formClear();
			}else {//�߰� ���н�
				JOptionPane.showMessageDialog(this, "�� ����� �����߽��ϴ�.");
			}
		}
	}
	
	//����
	public void roomEdit() {
		RoomVO vo = new RoomVO();
		vo.setRoom_num(Integer.parseInt(roomNumTf.getText()));
		vo.setGender(genderTf.getText());
		vo.setArea(Integer.parseInt(areaTf.getText()));
		vo.setWindow(windowTf.getText());
		vo.setDeposit(Integer.parseInt(depositTf.getText()));
		vo.setMonthly_rent(Integer.parseInt(monthlyTf.getText()));
		vo.setOccupancy_status(occupancyStatusTf.getText());
		
		if(vo.getRoom_num()<=0) {
			JOptionPane.showMessageDialog(this, "��ȣ�� �ݵ�� �־�� �մϴ�.");
		}else if(vo.getGender()==null || vo.getGender()==""){
			JOptionPane.showMessageDialog(this, "������ �ݵ�� �־�� �մϴ�.");
		}else if(vo.getArea()==0) {
			JOptionPane.showMessageDialog(this, "����� �ݵ�� �־�� �մϴ�.");
		}else {
			RoomDAO dao= new RoomDAO();
			int result = dao.updateRecord(vo);
			if(result>0) {//���� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "���� �����Ǿ����ϴ�.");
				getAllRecord();
				formClear();
			}else {//���� ���н�				
				JOptionPane.showMessageDialog(this, "�� ������ �����߽��ϴ�.");
			}
		}
		
	}
	//����
	public void roomDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "���� ���� �Ͻðڽ��ϱ�?", "�� ���� Ȯ��", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 RoomDAO dao = RoomDAO.getInstance();
			 int result = dao.deleteRecord(Integer.parseInt(roomNumTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "���� �����Ǿ����ϴ�.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "�� ���� �����Ͽ����ϴ�.");				 
			 }			 
		 }
	}
	
	
	//��ư �̺�Ʈ
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//ǰ�� ���ڿ��� �����
			formClear();
		}else if(event == addBtn) {//ǰ�� ���ڵ带 ������ ���̽��� �߰�
			roomInsert();
		}else if(event == editBtn) {
			roomEdit();
		}else if(event == delBtn) {
			roomDelete();
		}else if(event == allListBtn) {
			getAllRecord();
		}
	}

	

}
