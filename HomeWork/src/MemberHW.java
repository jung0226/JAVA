import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class MemberHW extends JFrame implements ActionListener, MouseListener{
	//DB���
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException c) {
			c.getMessage();
		}
	}
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "scott";
	String password ="tiger";
	
	//member ����
	int num;
	String name, tel, email, addr;
	
	//������ ��
	int row;
	
	Font fnt=new Font("����", Font.PLAIN, 50);
	JPanel northPane = new JPanel(new BorderLayout());
		JPanel txtnamePane = new JPanel(new GridLayout(5,1)); //��ȣ, �̸� ...
		String txtname[]= {"��ȣ","�̸�","�ּ�","��ȭ��ȣ","�̸���"};
		JPanel txtboxPane = new JPanel(new GridLayout(5,1)); 				 	
			JTextField numTf = new JTextField(10);
			JTextField nameTf = new JTextField(40);
			JTextField addrTf = new JTextField(70);
			JTextField telTf = new JTextField(25);
			JTextField emailTf = new JTextField(30);
			
	JPanel centerPane = new JPanel(new BorderLayout());//��ư, JTable
		JPanel btnPane = new JPanel(new GridLayout(1,5,5,5));
			String btntxt[]= {"�߰�", "����", "����", "�����", "����"};
		JTable table = new JTable();
		// table ����
		String title[] = {"��ȣ", "�̸�", "�ּ�", "��ȭ��ȣ", "�̸���", "�����"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		
		JScrollPane sp;
	
		
	public MemberHW() {
		super("ȸ�����");
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
				btn.addActionListener(this);
			}
			
		//�ؽ�Ʈ ����	
		for(String j: txtname) {
			txtnamePane.add(new JLabel(j, JLabel.RIGHT));	
		}
		txtboxPane.setLayout(null);
		int x=15;
		numTf.setBounds(15, 3, 100, x);
		nameTf.setBounds(15, x+6, 150, x);
		addrTf.setBounds(15, x+24, 400, x);
		telTf.setBounds(15, x+41, 200, x);
		emailTf.setBounds(15, x+60, 300, x);
		
		txtboxPane.add(numTf);
		txtboxPane.add(nameTf);
		txtboxPane.add(addrTf);
		txtboxPane.add(telTf);
		txtboxPane.add(emailTf);

		
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		centerPane.add(sp);
		

		select();
		
		//���콺 �̺�Ʈ
		table.addMouseListener(this);
//		addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent me) {
//				
//			}
//		});
		
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		
	}
	
	public void select() {
		try {
			con=DriverManager.getConnection(url, userid, password);
			
			String sql = "select num, name, addr, tel, email, to_char(write_date,'MM-DD') write_date "
					+ " from member order by num";
			pstmt = con.prepareStatement(sql);
			
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
	
	//�߰�
	public void insert() {
		try {
			
			
			con=DriverManager.getConnection(url, userid, password);
									
			String sql = "insert into member(num, name, addr, tel, email, write_date)"
					+"values(?,?,?,?,?,sysdate)"; 
			num = Integer.parseInt(numTf.getText());
			name = nameTf.getText();
			addr = addrTf.getText();
			tel = telTf.getText();
			email = emailTf.getText();
			pstmt = con.prepareStatement(sql);
			
			//����
			pstmt.setInt(1, num);
			pstmt.setString(2, name);			
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);	
			
			//����
			pstmt.executeUpdate();			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			select();
		}		
	}
	
	//����
	public void update() {
		try {
			con=DriverManager.getConnection(url, userid, password);
			
			String sql = "update member set name=?, addr=?, tel=?, email=? where num=?";			
			pstmt = con.prepareStatement(sql);
			
			//int row = table.getSelectedRow();
			pstmt.setInt(5,(int) table.getValueAt(row, 0));
			
			pstmt.setString(1, nameTf.getText());
			pstmt.setString(2, addrTf.getText());
			pstmt.setString(3, telTf.getText());
			pstmt.setString(4, emailTf.getText());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			select();
		}
		
	}
	//����
	public void delete() {
		try {
			con=DriverManager.getConnection(url, userid, password);
			
			String sql = "delete from member where num=?";
			pstmt = con.prepareStatement(sql);
			
			int row = table.getSelectedRow();
			pstmt.setInt(1,(int) table.getValueAt(row, 0));
			
			pstmt.executeUpdate();			
			
		}catch(Exception e) {
			e.printStackTrace();			
		}finally {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			select();
		}
	}
	
	//��ư �̺�Ʈ
	public void actionPerformed(ActionEvent ae) {
		String event= ae.getActionCommand();
		if(event.equals("�߰�")) {
			insert();
		}else if(event.equals("����")){
			update();
		}else if(event.equals("����")){
			delete();
		}else if(event.equals("�����")){
			numTf.setText("");
			nameTf.setText("");
			addrTf.setText("");
			telTf.setText("");
			emailTf.setText("");
		}else if(event.equals("����")) {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {}
			
			dispose();
			System.exit(0);
		}
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		//�� Ŭ����
		row = table.getSelectedRow();
		numTf.setText(String.valueOf(table.getValueAt(row, 0)) );
		nameTf.setText(String.valueOf(table.getValueAt(row, 1)));	
		addrTf.setText(String.valueOf(table.getValueAt(row, 2)));
		telTf.setText(String.valueOf(table.getValueAt(row, 3)));
		emailTf.setText(String.valueOf( table.getValueAt(row, 4)));	
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	public static void main(String[] args) {
		new MemberHW();
	}

}