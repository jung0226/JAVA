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
	//DB���
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException c) {
			System.out.println("����̺� �ε� ���� --->"+c.getMessage());
		}
	}
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url ="jdbc:oracle:thin:@192.168.0.225:1521:xe";
	String userid = "scott";
	String password ="tiger";
	
	//
	Font fnt=new Font("����", Font.PLAIN, 50);
	JPanel northPane = new JPanel(new BorderLayout());
		JPanel txtnamePane = new JPanel(new GridLayout(4,1)); //��ȣ, �̸� ...
		String txtname[]= {"��ȣ","�̸�","�ּ�","��ȭ��ȣ"};
		JPanel txtboxPane = new JPanel(new GridLayout(4,1)); 		
			JTextField numTf = new JTextField(10);
			JTextField nameTf = new JTextField(40);
			JTextField addrTf = new JTextField(70);
			JTextField telTf = new JTextField(25);			
			//int tfNum[]= {1,5,7,8};
			
	JPanel centerPane = new JPanel(new BorderLayout());//��ư, JTable
		JPanel btnPane = new JPanel(new GridLayout(1,5,5,5));
			String btntxt[]= {"�߰�", "����", "����", "�����", "����"};
		JTable table = new JTable();
		// table ����
		String title[] = {"��ȣ", "�̸�", "����ó", "�̸���", "�ּ�", "�����"};
		
		JScrollPane sp;
		DefaultTableModel model;
	
		
	public MemberHW() {
		super("ȸ�����");
		setFont(fnt);
		add(BorderLayout.NORTH,northPane);
			northPane.add(BorderLayout.WEST,txtnamePane);
			northPane.add(txtboxPane);
		//��ư, ���̺� ���̾ƿ�
		add(centerPane);
		centerPane.add(BorderLayout.NORTH, btnPane);
			//��ư ���
			for(int i=0; i<btntxt.length; i++) {
				JButton btn= new JButton(btntxt[i]);
				btnPane.add(btn);				
			}
			centerPane.add(table);
			
		//�ؽ�Ʈ ����	
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
			
			//4. ����
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6)});
			}
		}catch(Exception e) {
			System.out.println("DB���� ���� �߻� --> "+e.getMessage());
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
