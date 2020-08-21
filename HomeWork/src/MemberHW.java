import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MemberHW extends JFrame{
	//DB등록
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException c) {
			System.out.println("드라이브 로딩 에러 --->"+c.getMessage());
		}
	}
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url ="jdbc:oracle:thin:@192.168.0.225:1521:xe";
	String userid = "scott";
	String password ="tiger";
	
	//
	Font fnt=new Font("굴림", Font.PLAIN, 50);
	JPanel northPane = new JPanel(new BorderLayout());
		JPanel txtnamePane = new JPanel(new GridLayout(4,1)); //번호, 이름 ...
		String txtname[]= {"번호","이름","주소","전화번호"};
		JPanel txtboxPane = new JPanel(new GridLayout(4,1)); 		
			JTextField numTf = new JTextField(10);
			JTextField nameTf = new JTextField(40);
			JTextField addrTf = new JTextField(70);
			JTextField telTf = new JTextField(25);			
			//int tfNum[]= {1,5,7,8};
			
	JPanel centerPane = new JPanel(new BorderLayout());//버튼, JTable
		JPanel btnPane = new JPanel(new GridLayout(1,5,5,5));
			String btntxt[]= {"추가", "수정", "삭제", "지우기", "종료"};
		JTable table = new JTable();
		// table 제목
		String title[] = {"번호", "이름", "연락처", "이메일", "주소", "등록일"};
		
		JScrollPane sp;
		DefaultTableModel model;
	
		
	public MemberHW() {
		super("회원등록");
		setFont(fnt);
		add(BorderLayout.NORTH,northPane);
			northPane.add(BorderLayout.WEST,txtnamePane);
			northPane.add(txtboxPane);
		//버튼, 테이블 레이아웃
		add(centerPane);
		centerPane.add(BorderLayout.NORTH, btnPane);
			//버튼 등록
			for(int i=0; i<btntxt.length; i++) {
				JButton btn= new JButton(btntxt[i]);
				btnPane.add(btn);				
			}
			centerPane.add(table);
			
		//텍스트 글자	
		for(String j: txtname) {
			txtnamePane.add(new JLabel(j, JLabel.RIGHT));	
		}
		
		txtboxPane.add(numTf);
		txtboxPane.add(nameTf);
		txtboxPane.add(addrTf);
		txtboxPane.add(telTf);
			
//		for(int i=0; i<txtname.length; i++) {
//			txtnamePane.add(new JLabel(txtname[i], JLabel.RIGHT));
//			txtboxPane.add(new JTextField(tfNum[i]));
//			
//		}	
		
		//JTable
		//model = new DefaultTableModel(model, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		centerPane.add(sp);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	}
	
	public void start() {
		try {
			//2.
			con=DriverManager.getConnection(url, userid, password);
			
			//3. 
			String sql = "select num, name, tel, email, addr, to_char(write_date,'MM-DD') write_date "
					+ " from member order by num";
			pstmt = con.prepareStatement(sql);
			
			//4. 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6)});
			}
		}catch(Exception e) {
			System.out.println("DB연결 에러 발생 --> "+e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		MemberHW mhw=new MemberHW();
		mhw.start();
	}

}
