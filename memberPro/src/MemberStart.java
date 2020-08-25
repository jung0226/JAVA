

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

public class MemberStart extends JFrame implements ActionListener{
	//폼
	JPanel nPane = new JPanel(new BorderLayout());
		//폼 라벨
		JPanel lblPane = new JPanel(new GridLayout(6,1));
			JLabel numLbl = new JLabel("번호");
			JLabel nameLbl = new JLabel("이름");
			JLabel telLbl = new JLabel("연락처");
			JLabel emailLbl = new JLabel("이메일");
			JLabel addrLbl = new JLabel("주소");
			JLabel writedateLbl = new JLabel("등록일");
		//폼 입력 콤포넌트
		JPanel tfPane = new JPanel(new GridLayout(6,1));
			JTextField numTf = new JTextField(5);			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField nameTf = new JTextField(10);			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField telTf = new JTextField(15);			JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField emailTf = new JTextField(30);		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField addrTf = new JTextField(50);			JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JTextField writedateTf = new JTextField(20);	JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
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
			JButton excelSaveBtn = new JButton("엑셀로 저장하기");
			JButton excelOpenBtn = new JButton("엑셀에서 불러오기");
		//회원목록
		String title[] = {"번호", "이름", "연락처", "이메일", "주소", "등록일"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public MemberStart() {
		super("회원관리 시스템");
		//폼
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
		
		//메뉴, 회원리스트		
		menuPane.add(allListBtn); 
		menuPane.add(addBtn); menuPane.add(editBtn); menuPane.add(delBtn); menuPane.add(clearBtn); menuPane.add(endBtn);
		menuPane.add(excelSaveBtn); menuPane.add(excelOpenBtn);
		cPane.add(menuPane, BorderLayout.NORTH);		
		cPane.add(sp);
		add(cPane);
		
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//전체 레코드 추가
		getAllRecord();
		
		//JTable 이벤트 등록
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if(me.getButton()==1) {//마우스의 왼쪽 버튼 클릭시 동작
					int row = table.getSelectedRow();//현재 선택된 행의 index
					numTf.setText(String.valueOf(model.getValueAt(row, 0)));
					nameTf.setText((String)model.getValueAt(row, 1));
					telTf.setText((String)model.getValueAt(row, 2));
					emailTf.setText((String)model.getValueAt(row, 3));
					addrTf.setText((String)model.getValueAt(row, 4));
					writedateTf.setText((String)model.getValueAt(row, 5));
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
		excelSaveBtn.addActionListener(this);
		excelOpenBtn.addActionListener(this);
	}
	
	//레코드 전체 선택하여 JTable에 추가하기
	public void getAllRecord() {
		//JTable테이블에 있는 레코드 지우기
		model.setRowCount(0);
		
		//DAO 객체 생성
		//MemberDAO dao = new MemberDAO();
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> list= dao.getAllMember();
		
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			Object[] record = {vo.getNum(), vo.getName(), vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWritedate()};
			model.addRow(record);
		}		
	}
	//폼의 문자열 지우기
	public void formClear() {
		numTf.setText("");
		nameTf.setText("");
		telTf.setText("");
		emailTf.setText("");
		addrTf.setText("");
		writedateTf.setText("");		
	}
	
	//품의 레코드를 데이터 베이스에 추가
	public void memberInsert() {
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(numTf.getText()));
		vo.setName(nameTf.getText());
		vo.setTel(telTf.getText());
		vo.setEmail(emailTf.getText());
		vo.setAddr(addrTf.getText());
		
		//데이터 입력유무 확인 후 레코드 추가
		if(vo.getNum()==0) {
			JOptionPane.showMessageDialog(this, "번호를 입력하세요.");
		}else if(vo.getName()==null || vo.getName().equals("")){
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		}else if(vo.getTel()==null || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "연락처를 입력하세요.");
		}else {
			MemberDAO dao = new MemberDAO();
			int result = dao.insertRecord(vo);
			if(result>0) {//추가 되었을 때
				JOptionPane.showMessageDialog(this, "회원이 등록됐습니다.");
				getAllRecord();
				formClear();
			}else {//추가 실패시
				JOptionPane.showMessageDialog(this, "회원 등록을 실패했습니다.");
			}
		}
	}
	
	//회원정보 수정
	public void memberEdit() {
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(numTf.getText()));
		vo.setName(nameTf.getText());
		vo.setTel(telTf.getText());
		vo.setEmail(emailTf.getText());
		vo.setAddr(addrTf.getText());
		
		if(vo.getNum()<=0) {
			JOptionPane.showMessageDialog(this, "번호는 반드시 있어야 합니다.");
		}else if(vo.getName()==null || vo.getName()==""){
			JOptionPane.showMessageDialog(this, "이름은 반드시 있어야 합니다.");
		}else if(vo.getTel()==null || vo.getTel()=="") {
			JOptionPane.showMessageDialog(this, "연락처는 반드시 있어야 합니다.");
		}else {
			MemberDAO dao=MemberDAO.getInstance();
			int result = dao.updateRecord(vo);
			if(result>0) {//수정 되었을 때
				JOptionPane.showMessageDialog(this, "회원정보가 수정되었습니다.");
				getAllRecord();
				formClear();
			}else {//수정 실패시				
				JOptionPane.showMessageDialog(this, "회원정보 수정을 실패했습니다.");
			}
		}
		
	}
	//회원 삭제
	public void memberDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "회원 삭제 하시겠습니까?", "회원 삭제 확인", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 MemberDAO dao = MemberDAO.getInstance();
			 int result = dao.deleteRecord(Integer.parseInt(numTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "회원이 삭제되었습니다.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "회원 삭제 실패하였습니다.");				 
			 }			 
		 }
	}
	
	//엑셀로 JTable 데이터 저장하기
	public void setExcelSave() {
		JFileChooser fc = new JFileChooser();
		int state = fc.showSaveDialog(this);
		if(state==0) {//저장버튼을 선택했을 때
			//워크북
			HSSFWorkbook book = new HSSFWorkbook();
			//시트
			HSSFSheet sheet = book.createSheet("회원목록");
			//제목
			HSSFRow r = sheet.createRow(0);
			r.createCell(0).setCellValue("번호");
			r.createCell(1).setCellValue("이름");
			r.createCell(2).setCellValue("연락처");
			r.createCell(3).setCellValue("이메일");
			r.createCell(4).setCellValue("주소");
			r.createCell(5).setCellValue("등록일");
			
			//행
			int rowCount = table.getRowCount();//JTable에 있는 레코드 수 구하기
			for(int row = 0; row<rowCount; row++) {//0~7
				HSSFRow r1  = sheet.createRow(row+1);
				//열
				int columnCount = table.getColumnCount();
				for(int col=0; col<columnCount; col++) {//0~5
					if(col==0) {// 숫자로 저장
						r1.createCell(col).setCellValue((Integer)model.getValueAt(row, col));
					}else {//문자로 저장
						r1.createCell(col).setCellValue((String)model.getValueAt(row, col));
					}
				}
			}			
			//워크북을 파일에 쓰기
			try {
				File f = fc.getSelectedFile();
				FileOutputStream fos = new FileOutputStream(f);
				
				book.write(fos);
				fos.close();
				book.close();
				JOptionPane.showMessageDialog(this, "엑셀로 쓰기가 완료되었습니다.");
				
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "엑셀로 쓰기가 실패하였습니다.");
			}			
		}
	}
	//엑셀파일을 읽어 JTable에 목록으로 표시하기
	public void getExcelLoad() {
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this);
		if(state==0) {
			try {
				File f = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(f);
				POIFSFileSystem poi = new POIFSFileSystem(fis);
				
				//워크북
				HSSFWorkbook book = new HSSFWorkbook(poi);				
				//시트
				HSSFSheet sheet = book.getSheet("회원목록");
				
				
				//JTable의 원래 정보 없애기
				model.setRowCount(0);
				
				//행
				int rowCount = sheet.getPhysicalNumberOfRows(); //행의 수
				for(int r = 1; r<rowCount;r++) {
					HSSFRow row = sheet.getRow(r);
					//열
					int cellCount = row.getPhysicalNumberOfCells();//셀의 수
					Object data[] = new Object[cellCount];
					for(int c=0; c<cellCount; c++) {
						if(c==0) {//숫자 읽어오기
							data[c]=(int)row.getCell(c).getNumericCellValue();
						}else {//문자 읽어오기
							data[c]=row.getCell(c).getStringCellValue();
						}
					}
					model.addRow(data);
				}
				poi.close();
				fis.close();		
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//버튼 이벤트
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//품의 문자열을 지우기
			formClear();
		}else if(event == addBtn) {//품의 레코드를 데이터 베이스에 추가
			memberInsert();
		}else if(event == editBtn) {
			memberEdit();
		}else if(event == delBtn) {
			memberDelete();
		}else if(event == excelSaveBtn) {
			setExcelSave();
		}else if(event == excelOpenBtn) {
			getExcelLoad();
		}else if(event == allListBtn) {
			getAllRecord();
		}
	}

	public static void main(String[] args) {
		new MemberStart();
	}

}
