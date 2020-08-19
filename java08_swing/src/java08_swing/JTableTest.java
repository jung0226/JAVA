package java08_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {
	//JTable제목
	String title[] = {"번호", "이름", "연락처", "이메일", "주소"};
	Object data[][] = {
			{1, "홍길동", "010-1111-2222", "abcde@naver.com", "서울시 마포구 백범로"},	
			{2, "세종대왕", "010-2222-3333", "zzzz@nate.com", "서울시 서대문구"},
			{3, "이순신", "010-3333-4444","xzxzxz@hanmail.net","서울시 강남구 논현로"},
			{4, "장영실", "010-4444-5555", "tttt@nate.com", "서울시 영등포구"},
			{5, "유승룡", "010-6666-7777", "zkzkzkzz@naver.com", "서울시 동작구"}			
			
	};
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	JLabel lbl = new JLabel("데이터가 표시되는 곳....");
	
	public JTableTest() {
		lbl.setOpaque(true);
		lbl.setBackground(new Color(200, 230, 200));
		add(BorderLayout.SOUTH, lbl);
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try{Thread.sleep(1000);}catch(Exception e){}
		//레코드 추가
		//추가할 레코드를 Object[] 배열에 담은 다음에 모델에 추가
		Object inData[] = {6, "AAAA", "010-9999-9999", "ffffffff@nate.com", "서울시 서초구"};
		model.addRow(inData);
		
		
		try{Thread.sleep(1000);}catch(Exception e){}
		//레코드 삽입
		Object inData2[] = {7, "BBBB", "010-8888-8888", "djdjdjd@nate.com", "서울시 은평구"};
		model.insertRow(3, inData2);
	
		try{Thread.sleep(1000);}catch(Exception e){}
		//행이동
		model.moveRow(4, 6, 1); //4에서 부터 6까지가 1번 위치로 들어감
		
		//컬럼(열)추가
		Object inData3[] = {"AAAA", "BBBB", "CCCC"};
		//model.addColumn("비고");
		model.addColumn("비고", inData3);
	/*
		try {Thread.sleep(1000);}catch(Exception e) {}
		//행삭제
		model.removeRow(3);
		
		try {Thread.sleep(1000);}catch(Exception e) {}
		//열삭제
		table.removeColumn(table.getColumn("비고"));
		
		
		*/
		
		//MouseEvent처리
		table.addMouseListener(new MouseAdapter() {
			//마우스를 누른 후 손을 놓으면 호출되는 메소드
			public void mouseReleased(MouseEvent me) {
				int btn = me.getButton(); //1.왼쪽버튼, 2:휠, 3:오른쪽버튼
				if(btn ==1) { //마우스 왼쪽 버튼을 누른 경우
					int rowIndex = table.getSelectedRow(); //선택한 행의 index 정보 얻어오기
					//컬럼 수 구하기
					int columnCount = table.getColumnCount();
					String txt = "";
					for(int col=0; col<columnCount; col++) {
						txt += table.getValueAt(rowIndex, col)+ ", ";
						
					}
					lbl.setText(txt);
				}
			}
		});
		
		
	}

	public static void main(String[] args) {
		new JTableTest();

	}

}
