

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
	//폼
	JPanel nPane = new JPanel(new BorderLayout());
		//폼 라벨
		JPanel lblPane = new JPanel(new GridLayout(9,1));
			JLabel roomNumLbl = new JLabel("방 번호");
			JLabel genderLbl = new JLabel("성별");
			JLabel areaLbl = new JLabel("평수");
			JLabel windowLbl = new JLabel("창문유무");
			JLabel depositLbl = new JLabel("보증금");
			JLabel monthlyRentLbl = new JLabel("월세");
			JLabel occupancyStatusLbl = new JLabel("입주가능여부");
			JLabel reservationLbl = new JLabel("예약여부");
			JLabel residentNumLbl = new JLabel("입주자번호");
		//폼 입력 콤포넌트
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
		String title[] = {"방 번호", "성별", "평수", "창문유무", "보증금", "월세", "입주가능여부", "예약여부"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public RoomStart() {
		//폼
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
		RoomDAO dao = new RoomDAO();
		List<RoomVO> list= dao.getRoomAll();
		
		for(int i=0; i<list.size(); i++) {
			RoomVO vo = list.get(i);
			Object[] record = {vo.getRoom_num(), vo.getGender(), vo.getArea(), vo.getWindow(), vo.getDeposit(), vo.getMonthly_rent(),
					vo.getOccupancy_status()};
			model.addRow(record);
		}		
	}
	//폼의 문자열 지우기
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
	
	//품의 레코드를 데이터 베이스에 추가
	public void roomInsert() {
		RoomVO vo = new RoomVO();
		vo.setRoom_num(Integer.parseInt(roomNumTf.getText()));
		vo.setGender(genderTf.getText());
		vo.setArea(Integer.parseInt(areaTf.getText()));
		vo.setWindow(windowTf.getText());
		vo.setDeposit(Integer.parseInt(depositTf.getText()));
		vo.setMonthly_rent(Integer.parseInt(monthlyTf.getText()));
		vo.setOccupancy_status(occupancyStatusTf.getText());

		
		//데이터 입력유무 확인 후 레코드 추가
		if(vo.getRoom_num()==0) {
			JOptionPane.showMessageDialog(this, "방 번호를 입력하세요.");
		}else if(vo.getGender()==null || vo.getGender().equals("")){
			JOptionPane.showMessageDialog(this, "성별을 입력하세요.");
		}else if(vo.getArea()==0) {
			JOptionPane.showMessageDialog(this, "평수를 입력하세요.");
		}else {
			RoomDAO dao = new RoomDAO();
			int result = dao.insertRecord(vo);
			if(result>0) {//추가 되었을 때
				JOptionPane.showMessageDialog(this, "방을 등록했습니다.");
				getAllRecord();
				formClear();
			}else {//추가 실패시
				JOptionPane.showMessageDialog(this, "방 등록을 실패했습니다.");
			}
		}
	}
	
	//수정
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
			JOptionPane.showMessageDialog(this, "번호는 반드시 있어야 합니다.");
		}else if(vo.getGender()==null || vo.getGender()==""){
			JOptionPane.showMessageDialog(this, "성별은 반드시 있어야 합니다.");
		}else if(vo.getArea()==0) {
			JOptionPane.showMessageDialog(this, "평수는 반드시 있어야 합니다.");
		}else {
			RoomDAO dao= new RoomDAO();
			int result = dao.updateRecord(vo);
			if(result>0) {//수정 되었을 때
				JOptionPane.showMessageDialog(this, "방이 수정되었습니다.");
				getAllRecord();
				formClear();
			}else {//수정 실패시				
				JOptionPane.showMessageDialog(this, "방 수정을 실패했습니다.");
			}
		}
		
	}
	//삭제
	public void roomDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "방을 삭제 하시겠습니까?", "방 삭제 확인", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 RoomDAO dao = RoomDAO.getInstance();
			 int result = dao.deleteRecord(Integer.parseInt(roomNumTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "방이 삭제되었습니다.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "방 삭제 실패하였습니다.");				 
			 }			 
		 }
	}
	
	
	//버튼 이벤트
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//품의 문자열을 지우기
			formClear();
		}else if(event == addBtn) {//품의 레코드를 데이터 베이스에 추가
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
