

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
	//폼
	JPanel nPane = new JPanel(new BorderLayout());
		//폼 라벨
		JPanel lblPane = new JPanel(new GridLayout(10,1));
			JLabel resident_numLbl = new JLabel("회원번호");
			JLabel resident_idLbl = new JLabel("아이디");
			JLabel resident_pwdLbl = new JLabel("비밀번호");
			JLabel resident_nameLbl = new JLabel("이름");
			JLabel genderLbl = new JLabel("성별");
			JLabel telLbl = new JLabel("전화번호");
			JLabel room_numLbl = new JLabel("방번호");
			JLabel move_in_dateLbl = new JLabel("입주일");
			JLabel expiration_dateLbl = new JLabel("만기일");
			JLabel monthly_rent_checkLbl = new JLabel("월세납부");
		//폼 입력 콤포넌트
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
			
	//메뉴, 회원리스트
	JPanel cPane = new JPanel(new BorderLayout());
		//메뉴
		JPanel menuPane = new JPanel();
			JButton allListBtn = new JButton("전체 목록");
			JButton addBtn = new JButton("추가");
			JButton	editBtn = new JButton("수정");
			JButton delBtn = new JButton("삭제");
			JButton clearBtn = new JButton("지우기");
			JButton endBtn = new JButton("종료");
		//회원목록
		String title[] = {"회원번호","아이디","비밀번호","이름","성별","전화번호","방번호","입주일","만기일","월세납부"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public ResidentStart() {
		//폼
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
		
		//메뉴, 회원리스트		
		menuPane.add(allListBtn); 
		menuPane.add(addBtn); menuPane.add(editBtn); menuPane.add(delBtn); menuPane.add(clearBtn); menuPane.add(endBtn);
		cPane.add(menuPane, BorderLayout.NORTH);		
		cPane.add(sp);
		add(cPane);
		
		//전체 레코드 추가
		getAllRecord();
		
		//JTable 이벤트 등록
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if(me.getButton()==1) {//마우스의 왼쪽 버튼 클릭시 동작
					int row = table.getSelectedRow();//현재 선택된 행의 index
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
		//메뉴 이벤트 등록
		allListBtn.addActionListener(this);
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		delBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		endBtn.addActionListener(this);
	}
	
	//레코드 전체 선택하여 JTable에 추가하기
	public void getAllRecord() {
		//JTable테이블에 있는 레코드 지우기
		model.setRowCount(0);
		
		//DAO 객체 생성
		ResidentDAO dao = new ResidentDAO();
		List<ResidentVO> list= dao.getAll();
		
		for(int i=0; i<list.size(); i++) {
			ResidentVO vo = list.get(i);
			Object[] record = {vo.getResident_num(), vo.getResident_id(), vo.getResident_pwd(), vo.getResident_name(), vo.getGender(), vo.getTel(),
					vo.getRoom_num(), vo.getMove_in_date(), vo.getExpiration_date(), vo.getMonthly_rent_check()};
			model.addRow(record);
		}		
	}
	//폼의 문자열 지우기
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
	
	//품의 레코드를 데이터 베이스에 추가
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
		
		//데이터 입력유무 확인 후 레코드 추가
		if(vo.getResident_id()==null || vo.getResident_id().equals("")){
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
		}else if(vo.getResident_pwd()==null || vo.getResident_pwd().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
		}else if(vo.getResident_name()==null || vo.getResident_name().equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		}else if(vo.getGender()==null || vo.getGender().equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 입력하세요.");
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 입력하세요.");
		}else if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(this, "방 번호를 입력하세요.");
		}else if(vo.getMove_in_date()==null || vo.getMove_in_date().equals("")) {
			JOptionPane.showMessageDialog(this, "입주일을 입력하세요.");
		}else if(vo.getExpiration_date()==null || vo.getExpiration_date().equals("")) {
			JOptionPane.showMessageDialog(this, "만기일을 입력하세요.");
		}else if(vo.getMonthly_rent_check()==null || vo.getMonthly_rent_check().equals("")) {
			JOptionPane.showMessageDialog(this, "월세완납여부를 입력하세요.");
		}else {
			ResidentDAO dao = new ResidentDAO();
			int result = dao.insertRecord2(vo);
			if(result>0) {//추가 되었을 때
				JOptionPane.showMessageDialog(this, "회원을 등록했습니다.");
				getAllRecord();
				formClear();
			}else {//추가 실패시
				JOptionPane.showMessageDialog(this, "회원등록을 실패했습니다.");
			}
		}
	}
	
	//수정
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
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
		}else if(vo.getResident_pwd()==null || vo.getResident_pwd().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
		}else if(vo.getResident_name()==null || vo.getResident_name().equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		}else if(vo.getGender()==null || vo.getGender().equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 입력하세요.");
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 입력하세요.");
		}else if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(this, "방 번호를 입력하세요.");
		}else if(vo.getMove_in_date()==null || vo.getMove_in_date().equals("")) {
			JOptionPane.showMessageDialog(this, "입주일을 입력하세요.");
		}else if(vo.getExpiration_date()==null || vo.getExpiration_date().equals("")) {
			JOptionPane.showMessageDialog(this, "만기일을 입력하세요.");
		}else if(vo.getMonthly_rent_check()==null || vo.getMonthly_rent_check().equals("")) {
			JOptionPane.showMessageDialog(this, "월세완납여부를 입력하세요.");
		}else {
			ResidentDAO dao= new ResidentDAO();
			int result = dao.updateRecord(vo);
			if(result>0) {//수정 되었을 때
				JOptionPane.showMessageDialog(this, "회원이 수정되었습니다.");
				getAllRecord();
				formClear();
			}else {//수정 실패시				
				JOptionPane.showMessageDialog(this, "회원 수정을 실패했습니다.");
			}
		}
		
	}
	//삭제
	public void residentDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "회원을 삭제 하시겠습니까?", "회원 삭제 확인", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 ResidentDAO dao = new ResidentDAO();
			 int result = dao.deleteRecord(Integer.parseInt(resident_numTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "회원이 삭제되었습니다.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "회원 삭제 실패하였습니다.");				 
			 }			 
		 }
	}
	
	
	//버튼 이벤트
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//품의 문자열을 지우기
			formClear();
		}else if(event == addBtn) {//품의 레코드를 데이터 베이스에 추가
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
