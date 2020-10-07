

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class QnaStart extends JPanel implements ActionListener{
	//��
	JPanel nPane = new JPanel(new BorderLayout());
		//�� ��
		JPanel lblPane = new JPanel(new GridLayout(10,1));
			JLabel qna_numLbl = new JLabel("qna��ȣ");
			JLabel qna_nameLbl = new JLabel("�̸�");
			JLabel qna_pwdLbl = new JLabel("��й�ȣ");
			JLabel qna_titleLbl = new JLabel("����");
			JLabel qna_contentLbl = new JLabel("����");
			JLabel qna_write_dateLbl = new JLabel("�����");
			JLabel answer_tilteLbl = new JLabel("�亯����");
			JLabel answer_contentLbl = new JLabel("�亯");
			JLabel answer_writerLbl = new JLabel("�亯�ۼ���");
			JLabel answer_write_dateLbl = new JLabel("�亯�ۼ���");
		//�� �Է� ������Ʈ
		JPanel tfPane = new JPanel(new GridLayout(10,1));
			JTextField qna_numTf = new JTextField(5);			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField qna_nameTf = new JTextField(10);			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField qna_pwdTf = new JTextField(15);				JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField qna_titleTf = new JTextField(30);			JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextArea qna_contentTf = new JTextArea(5,20);			JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField qna_write_dateTf = new JTextField(20);				JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField answer_tilteTf = new JTextField(30);		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextArea answer_contentTf = new JTextArea(5,20);			JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField answer_writerTf = new JTextField(20);			JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField answer_write_dateTf = new JTextField(20);			JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
	//�޴�, qna����Ʈ
	JPanel cPane = new JPanel(new BorderLayout());
		//�޴�
		JPanel menuPane = new JPanel();
			JButton allListBtn = new JButton("��ü ���");
			JButton	editBtn = new JButton("����");
			JButton delBtn = new JButton("����");
			JButton clearBtn = new JButton("�����");
			JButton endBtn = new JButton("����");
		//���
		String title[] = {"�Խù���ȣ","�̸�","��й�ȣ","����","����","�����","�亯����","�亯","�亯�ۼ���","�亯�ۼ���"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public QnaStart() {
		//��
		nPane.add(BorderLayout.WEST, lblPane);
			lblPane.add(qna_numLbl); lblPane.add(qna_nameLbl); lblPane.add(qna_pwdLbl);
			lblPane.add(qna_titleLbl); lblPane.add(qna_contentLbl); lblPane.add(qna_write_dateLbl);
			lblPane.add(answer_tilteLbl); lblPane.add(answer_contentLbl); lblPane.add(answer_writerLbl); lblPane.add(answer_write_dateLbl);
		nPane.add(BorderLayout.EAST, tfPane);
			p1.add(qna_numTf);   tfPane.add(p1); 
			p2.add(qna_nameTf);  tfPane.add(p2); 
			p3.add(qna_pwdTf);   tfPane.add(p3);
			p4.add(qna_titleTf); tfPane.add(p4); 
			p5.add(qna_contentTf);  tfPane.add(p5); 
			p6.add(qna_write_dateTf); tfPane.add(p6);
			p7.add(answer_tilteTf); tfPane.add(p7); 
			p8.add(answer_contentTf);  tfPane.add(p8); 
			p9.add(answer_writerTf);  tfPane.add(p9); 
			p10.add(answer_write_dateTf);  tfPane.add(p10); 
		
		add(BorderLayout.NORTH, nPane);
		
		//�޴�, ȸ������Ʈ		
		menuPane.add(allListBtn); 
		menuPane.add(editBtn); menuPane.add(delBtn); menuPane.add(clearBtn); menuPane.add(endBtn);
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
					qna_numTf.setText(String.valueOf(model.getValueAt(row, 0)));
					qna_nameTf.setText((String)model.getValueAt(row, 1));
					qna_pwdTf.setText((String)model.getValueAt(row, 2));
					qna_titleTf.setText((String)model.getValueAt(row, 3));
					qna_contentTf.setText((String)model.getValueAt(row, 4));
					qna_write_dateTf.setText((String)model.getValueAt(row, 5));
					answer_tilteTf.setText(String.valueOf(model.getValueAt(row, 6)));
					answer_contentTf.setText((String)model.getValueAt(row, 7));
					answer_writerTf.setText((String)model.getValueAt(row, 8));
					answer_write_dateTf.setText((String)model.getValueAt(row, 9));
				}
			}			
		});
		
		//��Ȱ��ȭ
		qna_numTf.setEnabled(false);
		qna_nameTf.setEnabled(false);
		qna_pwdTf.setEnabled(false);
		qna_titleTf.setEnabled(false);
		qna_contentTf.setEnabled(false);
		qna_write_dateTf.setEnabled(false);
		
		//�޴� �̺�Ʈ ���
		allListBtn.addActionListener(this);
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
		QnaDAO dao = new QnaDAO();
		List<QnaVO> list= dao.getAll();
		
		for(int i=0; i<list.size(); i++) {
			QnaVO vo = list.get(i);
			Object[] record = {vo.getQna_num(), vo.getQna_name(), vo.getQna_pwd(), vo.getQna_title(), vo.getQna_content(),
							vo.getQna_write_date(), vo.getAnswer_title(), vo.getAnswer_content(), vo.getAnswer_writer(), vo.getAnswer_write_date()};
			model.addRow(record);
		}		
	}
	//���� ���ڿ� �����
	public void formClear() {
		qna_numTf.setText("");
		qna_nameTf.setText("");
		qna_pwdTf.setText("");
		qna_titleTf.setText("");
		qna_contentTf.setText("");
		qna_write_dateTf.setText("");
		answer_tilteTf.setText("");
		answer_contentTf.setText("");
		answer_writerTf.setText("");
		answer_write_dateTf.setText("");
	}	
	
	//����
	public void qnaEdit() {
		QnaVO vo = new QnaVO();
		vo.setQna_num(Integer.parseInt(qna_numTf.getText()));
		vo.setQna_name(qna_nameTf.getText());
		vo.setQna_pwd(qna_pwdTf.getText());
		vo.setQna_title(qna_titleTf.getText());
		vo.setQna_content(qna_contentTf.getText());
		vo.setQna_write_date(qna_write_dateTf.getText());
		vo.setAnswer_title(answer_tilteTf.getText());
		vo.setAnswer_content(answer_contentTf.getText());
		vo.setAnswer_writer(answer_writerTf.getText());
		vo.setAnswer_write_date(answer_write_dateTf.getText());
		
		if(vo.getAnswer_title()==null || vo.getAnswer_title().equals("")){
			JOptionPane.showMessageDialog(this, "���� �Է��ϼ���.");
		}else if(vo.getAnswer_content()==null || vo.getAnswer_content().equals("")) {
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���.");
		}else {
			QnaDAO dao= new QnaDAO();
			int result = dao.updateRecord(vo);
			if(result>0) {//���� �Ǿ��� ��
				JOptionPane.showMessageDialog(this, "qna�� �����Ǿ����ϴ�.");
				getAllRecord();
				formClear();
			}else {//���� ���н�				
				JOptionPane.showMessageDialog(this, "qna ������ �����߽��ϴ�.");
			}
		}
		
	}
	//����
	public void qnaDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "qna�� ���� �Ͻðڽ��ϱ�?", "ȸ�� ���� Ȯ��", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 QnaDAO dao = new QnaDAO();
			 int result = dao.deleteRecord(Integer.parseInt(qna_numTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "qna�� �����Ǿ����ϴ�.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "qna ���� �����Ͽ����ϴ�.");				 
			 }			 
		 }
	}
	
	
	//��ư �̺�Ʈ
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//ǰ�� ���ڿ��� �����
			formClear();
		}else if(event == editBtn) {
			qnaEdit();
		}else if(event == delBtn) {
			qnaDelete();
		}else if(event == allListBtn) {
			getAllRecord();
		}
	}


}
