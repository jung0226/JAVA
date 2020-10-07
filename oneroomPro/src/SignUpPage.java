import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpPage implements ActionListener {

	Font titleFnt = new Font("����ü", Font.BOLD, 30);
	Font fnt = new Font("����ü", Font.PLAIN, 15);
	
	JButton signUpBtn;

	JTextField idtf = new JTextField(20);
	JPanel idpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPasswordField pwdtf = new JPasswordField(25);
	JPanel pwdpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPasswordField pwdtf2 = new JPasswordField(25);
	JPanel pwdpan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField nametf = new JTextField(10);
	JPanel namepan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	// radio��ư ����
	JRadioButton wbtn = new JRadioButton("����");
	JRadioButton mbtn = new JRadioButton("����");
	
	JPanel genderpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField roomtf = new JTextField(10);
	JPanel roompan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField teltf = new JTextField(20);
	JPanel telpan = new JPanel(new FlowLayout(FlowLayout.LEFT));

	// BorderLayout
	JPanel contentPane = new JPanel(new BorderLayout());
	
	JButton idCheckBtn;
	public SignUpPage() {}

	public JPanel signUpPage() {
		// lblGridLayout
		JPanel cenGrid = new JPanel(new GridLayout(0, 3));

		JLabel idLbl = new JLabel("���̵�", JLabel.RIGHT);
		JLabel pwdLbl = new JLabel("��й�ȣ", JLabel.RIGHT);
		JLabel pwdLbl2 = new JLabel("��й�ȣ Ȯ��", JLabel.RIGHT);
		JLabel nameLbl = new JLabel("�̸�", JLabel.RIGHT);
		JLabel genderLbl = new JLabel("����", JLabel.RIGHT);
		JLabel roomLbl = new JLabel("�� ��ȣ", JLabel.RIGHT);
		JLabel telLbl = new JLabel("��ȭ��ȣ", JLabel.RIGHT);

		// �ߺ�Ȯ�� btn
		idCheckBtn = new JButton("�ߺ�Ȯ��");
		JPanel idBtnpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idBtnpan.add(idCheckBtn);

		
		ButtonGroup bg = new ButtonGroup();
		bg.add(wbtn);
		bg.add(mbtn);

		idpan.add(idtf);
		pwdpan.add(pwdtf);
		pwdpan2.add(pwdtf2);
		namepan.add(nametf);
		genderpan.add(wbtn);
		genderpan.add(mbtn);
		roompan.add(roomtf);
		telpan.add(teltf);

		// ȸ������ btn
		signUpBtn = new JButton("�����ϱ�");
		JPanel signUpBtnpan = new JPanel(new FlowLayout());
		signUpBtnpan.add(signUpBtn);

		// ȭ�鿡 �߰� (content BorderLayout�� center)
		// ����
		int i = 0;
		while (i < 9) {
			cenGrid.add(new JLabel("  "));
			i++;
		}
		cenGrid.add(idLbl);
		cenGrid.add(idpan);
		cenGrid.add(idBtnpan);
		cenGrid.add(pwdLbl);
		cenGrid.add(pwdpan);
		cenGrid.add(new JLabel(" "));
		cenGrid.add(pwdLbl2);
		cenGrid.add(pwdpan2);
		cenGrid.add(new JLabel(" "));
		cenGrid.add(nameLbl);
		cenGrid.add(namepan);
		cenGrid.add(new JLabel(" "));
		cenGrid.add(genderLbl);
		cenGrid.add(genderpan);
		cenGrid.add(new JLabel(" "));
		cenGrid.add(roomLbl);
		cenGrid.add(roompan);
		cenGrid.add(new JLabel(" "));
		cenGrid.add(telLbl);
		cenGrid.add(telpan);
		cenGrid.add(new JLabel(" "));
		cenGrid.add(new JLabel(" "));
		cenGrid.add(signUpBtnpan);
		cenGrid.add(new JLabel(" "));

		contentPane.add(cenGrid);
		signUpBtn.addActionListener(this);
		return contentPane;
	}
public void actionPerformed(ActionEvent ae) {		
		//�̺�Ʈ�� �߻��� ���۳�Ʈ ������ �˾Ƴ���
		Object event = ae.getSource();
		if(event == signUpBtn) {
			residentInsert();
		}else if(event == idCheckBtn){
			idcheck();
		}
	}

//�ߺ�Ȯ��
public void idcheck() {
	JOptionPane.showMessageDialog(contentPane, "��ưŬ��");
	HashMap<String, String> map = new HashMap<String, String>(); 
	ResidentDAO dao = new ResidentDAO();
	ArrayList<ResidentVO> members = new ArrayList<ResidentVO>(); 
	try { 
		members = (ArrayList<ResidentVO>) dao.getAll(); 
			//map.put(members.get(0).getResident_id(),members.get(0).getPwd());  
		
		String id = idtf.getText(); 
			if(map.containsKey(id)) 
			{
				JOptionPane.showMessageDialog(contentPane, "�Է��Ͻ� id�� �̹� �����ϰ� �ֽ��ϴ�. �ٽ��Է����ּ���.");
				idtf.setText("");
			}else{ 
				JOptionPane.showMessageDialog(contentPane, "��밡���� id�Դϴ�.");
			} 
		} catch(Exception e) {
			e.printStackTrace(); 
		}
}
//ǰ�� ���ڵ带 ������ ���̽��� �߰�
	public void residentInsert() {
		ResidentVO vo = new ResidentVO();
		vo.setResident_id(idtf.getText());
		vo.setResident_pwd(pwdtf.getText());
		vo.setResident_name(nametf.getText());
		if(wbtn.isSelected())
			vo.setGender(wbtn.getText());
		if(mbtn.isSelected())
			vo.setGender(mbtn.getText());
		vo.setRoom_num(Integer.parseInt(roomtf.getText()));
		vo.setTel(teltf.getText());
		
		//������ �Է����� Ȯ�� �� ���ڵ� �߰�
		if(vo.getResident_id()==null || vo.getResident_id().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "���̵� �Է��ϼ���");
			idtf.requestFocus();
		}else if(vo.getResident_pwd()==null || vo.getResident_pwd().equals("")){
			JOptionPane.showMessageDialog(contentPane, "��й�ȣ�� �Է��ϼ���.");
			pwdtf.requestFocus();
		}else if(pwdtf2.getText()==null || pwdtf2.getText().equals("")){
			JOptionPane.showMessageDialog(contentPane, "��й�ȣȮ���� �Է��ϼ���.");
			pwdtf2.requestFocus();
		}else if(!pwdtf.getText().equals(pwdtf2.getText())){
			JOptionPane.showMessageDialog(contentPane, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			pwdtf.requestFocus();
			pwdtf.setText("");
			pwdtf2.setText("");
		}else if(vo.getResident_name()==null || vo.getResident_name().equals("")){
			JOptionPane.showMessageDialog(contentPane, "�̸� �Է��ϼ���.");
			nametf.requestFocus();
		}else if(!wbtn.isSelected() && !mbtn.isSelected()) {
			JOptionPane.showMessageDialog(contentPane, "������ �����ϼ���.");
		}else if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(contentPane, "�� ��ȣ�� �Է��ϼ���.");
			roomtf.requestFocus();
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "����ó�� �Է��ϼ���.");
			teltf.requestFocus();
		}else {
			ResidentDAO dao = new ResidentDAO();
			int result = dao.insertRecord(vo);
			if(result>0) {//�߰� �Ǿ��� ��
				JOptionPane.showMessageDialog(contentPane, "ȸ���� ��ϵƽ��ϴ�.");
				idtf.setText("");
				pwdtf.setText("");
				pwdtf2.setText("");
				nametf.setText("");
				roomtf.setText("");
				teltf.setText("");
				wbtn.setSelected(false);
				mbtn.setSelected(false);
			}else {//�߰� ���н�
				JOptionPane.showMessageDialog(contentPane, "ȸ�� ����� �����߽��ϴ�.");
			}
		}
	}

}
