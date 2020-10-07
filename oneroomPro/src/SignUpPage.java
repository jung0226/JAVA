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

	Font titleFnt = new Font("굴림체", Font.BOLD, 30);
	Font fnt = new Font("굴림체", Font.PLAIN, 15);
	
	JButton signUpBtn;

	JTextField idtf = new JTextField(20);
	JPanel idpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPasswordField pwdtf = new JPasswordField(25);
	JPanel pwdpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPasswordField pwdtf2 = new JPasswordField(25);
	JPanel pwdpan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField nametf = new JTextField(10);
	JPanel namepan = new JPanel(new FlowLayout(FlowLayout.LEFT));
	// radio버튼 성별
	JRadioButton wbtn = new JRadioButton("여자");
	JRadioButton mbtn = new JRadioButton("남자");
	
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

		JLabel idLbl = new JLabel("아이디", JLabel.RIGHT);
		JLabel pwdLbl = new JLabel("비밀번호", JLabel.RIGHT);
		JLabel pwdLbl2 = new JLabel("비밀번호 확인", JLabel.RIGHT);
		JLabel nameLbl = new JLabel("이름", JLabel.RIGHT);
		JLabel genderLbl = new JLabel("성별", JLabel.RIGHT);
		JLabel roomLbl = new JLabel("방 번호", JLabel.RIGHT);
		JLabel telLbl = new JLabel("전화번호", JLabel.RIGHT);

		// 중복확인 btn
		idCheckBtn = new JButton("중복확인");
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

		// 회원가입 btn
		signUpBtn = new JButton("가입하기");
		JPanel signUpBtnpan = new JPanel(new FlowLayout());
		signUpBtnpan.add(signUpBtn);

		// 화면에 추가 (content BorderLayout의 center)
		// 여백
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
		//이벤트가 발생한 컴퍼넌트 정보를 알아내기
		Object event = ae.getSource();
		if(event == signUpBtn) {
			residentInsert();
		}else if(event == idCheckBtn){
			idcheck();
		}
	}

//중복확인
public void idcheck() {
	JOptionPane.showMessageDialog(contentPane, "버튼클릭");
	HashMap<String, String> map = new HashMap<String, String>(); 
	ResidentDAO dao = new ResidentDAO();
	ArrayList<ResidentVO> members = new ArrayList<ResidentVO>(); 
	try { 
		members = (ArrayList<ResidentVO>) dao.getAll(); 
			//map.put(members.get(0).getResident_id(),members.get(0).getPwd());  
		
		String id = idtf.getText(); 
			if(map.containsKey(id)) 
			{
				JOptionPane.showMessageDialog(contentPane, "입력하신 id는 이미 존재하고 있습니다. 다시입력해주세요.");
				idtf.setText("");
			}else{ 
				JOptionPane.showMessageDialog(contentPane, "사용가능한 id입니다.");
			} 
		} catch(Exception e) {
			e.printStackTrace(); 
		}
}
//품의 레코드를 데이터 베이스에 추가
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
		
		//데이터 입력유무 확인 후 레코드 추가
		if(vo.getResident_id()==null || vo.getResident_id().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "아이디를 입력하세요");
			idtf.requestFocus();
		}else if(vo.getResident_pwd()==null || vo.getResident_pwd().equals("")){
			JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력하세요.");
			pwdtf.requestFocus();
		}else if(pwdtf2.getText()==null || pwdtf2.getText().equals("")){
			JOptionPane.showMessageDialog(contentPane, "비밀번호확인을 입력하세요.");
			pwdtf2.requestFocus();
		}else if(!pwdtf.getText().equals(pwdtf2.getText())){
			JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.");
			pwdtf.requestFocus();
			pwdtf.setText("");
			pwdtf2.setText("");
		}else if(vo.getResident_name()==null || vo.getResident_name().equals("")){
			JOptionPane.showMessageDialog(contentPane, "이름 입력하세요.");
			nametf.requestFocus();
		}else if(!wbtn.isSelected() && !mbtn.isSelected()) {
			JOptionPane.showMessageDialog(contentPane, "성별을 선택하세요.");
		}else if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(contentPane, "방 번호를 입력하세요.");
			roomtf.requestFocus();
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "연락처를 입력하세요.");
			teltf.requestFocus();
		}else {
			ResidentDAO dao = new ResidentDAO();
			int result = dao.insertRecord(vo);
			if(result>0) {//추가 되었을 때
				JOptionPane.showMessageDialog(contentPane, "회원이 등록됐습니다.");
				idtf.setText("");
				pwdtf.setText("");
				pwdtf2.setText("");
				nametf.setText("");
				roomtf.setText("");
				teltf.setText("");
				wbtn.setSelected(false);
				mbtn.setSelected(false);
			}else {//추가 실패시
				JOptionPane.showMessageDialog(contentPane, "회원 등록을 실패했습니다.");
			}
		}
	}

}
