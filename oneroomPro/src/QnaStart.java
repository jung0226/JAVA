

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
	//폼
	JPanel nPane = new JPanel(new BorderLayout());
		//폼 라벨
		JPanel lblPane = new JPanel(new GridLayout(10,1));
			JLabel qna_numLbl = new JLabel("qna번호");
			JLabel qna_nameLbl = new JLabel("이름");
			JLabel qna_pwdLbl = new JLabel("비밀번호");
			JLabel qna_titleLbl = new JLabel("제목");
			JLabel qna_contentLbl = new JLabel("내용");
			JLabel qna_write_dateLbl = new JLabel("등록일");
			JLabel answer_tilteLbl = new JLabel("답변제목");
			JLabel answer_contentLbl = new JLabel("답변");
			JLabel answer_writerLbl = new JLabel("답변작성인");
			JLabel answer_write_dateLbl = new JLabel("답변작성일");
		//폼 입력 콤포넌트
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
			
	//메뉴, qna리스트
	JPanel cPane = new JPanel(new BorderLayout());
		//메뉴
		JPanel menuPane = new JPanel();
			JButton allListBtn = new JButton("전체 목록");
			JButton	editBtn = new JButton("수정");
			JButton delBtn = new JButton("삭제");
			JButton clearBtn = new JButton("지우기");
			JButton endBtn = new JButton("종료");
		//목록
		String title[] = {"게시물번호","이름","비밀번호","제목","내용","등록일","답변제목","답변","답변작성인","답변작성일"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
	public QnaStart() {
		//폼
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
		
		//메뉴, 회원리스트		
		menuPane.add(allListBtn); 
		menuPane.add(editBtn); menuPane.add(delBtn); menuPane.add(clearBtn); menuPane.add(endBtn);
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
		
		//비활성화
		qna_numTf.setEnabled(false);
		qna_nameTf.setEnabled(false);
		qna_pwdTf.setEnabled(false);
		qna_titleTf.setEnabled(false);
		qna_contentTf.setEnabled(false);
		qna_write_dateTf.setEnabled(false);
		
		//메뉴 이벤트 등록
		allListBtn.addActionListener(this);
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
		QnaDAO dao = new QnaDAO();
		List<QnaVO> list= dao.getAll();
		
		for(int i=0; i<list.size(); i++) {
			QnaVO vo = list.get(i);
			Object[] record = {vo.getQna_num(), vo.getQna_name(), vo.getQna_pwd(), vo.getQna_title(), vo.getQna_content(),
							vo.getQna_write_date(), vo.getAnswer_title(), vo.getAnswer_content(), vo.getAnswer_writer(), vo.getAnswer_write_date()};
			model.addRow(record);
		}		
	}
	//폼의 문자열 지우기
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
	
	//수정
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
			JOptionPane.showMessageDialog(this, "제목를 입력하세요.");
		}else if(vo.getAnswer_content()==null || vo.getAnswer_content().equals("")) {
			JOptionPane.showMessageDialog(this, "내용을 입력하세요.");
		}else {
			QnaDAO dao= new QnaDAO();
			int result = dao.updateRecord(vo);
			if(result>0) {//수정 되었을 때
				JOptionPane.showMessageDialog(this, "qna가 수정되었습니다.");
				getAllRecord();
				formClear();
			}else {//수정 실패시				
				JOptionPane.showMessageDialog(this, "qna 수정을 실패했습니다.");
			}
		}
		
	}
	//삭제
	public void qnaDelete() {
		 int okNo= JOptionPane.showConfirmDialog(this, "qna를 삭제 하시겠습니까?", "회원 삭제 확인", JOptionPane.YES_NO_OPTION);
		 if(okNo==JOptionPane.OK_OPTION) {
			 QnaDAO dao = new QnaDAO();
			 int result = dao.deleteRecord(Integer.parseInt(qna_numTf.getText()));
			 if(result>0) {
				 JOptionPane.showMessageDialog(this, "qna가 삭제되었습니다.");
				 getAllRecord();
				 formClear();
			 }else {
				 JOptionPane.showMessageDialog(this, "qna 삭제 실패하였습니다.");				 
			 }			 
		 }
	}
	
	
	//버튼 이벤트
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == clearBtn) {//품의 문자열을 지우기
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
