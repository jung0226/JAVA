import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class OneroomMain extends JFrame implements ActionListener{
	JPanel bp = new JPanel(new BorderLayout());//����
	JScrollPane sp = new JScrollPane(bp);
		JPanel nnp = new JPanel(); //����		
		JPanel wnp = new JPanel(); //����
		JPanel enp = new JPanel(); //����
		JPanel snp = new JPanel(); //����
		JPanel center = new JPanel(new BorderLayout());
			
			JPanel northPane = new JPanel(new BorderLayout()); 
				JPanel nnp1 = new JPanel(new BorderLayout()); //�α��� ȸ������
				JPanel nnp2 = new JPanel();
				JPanel menuPane = new JPanel();//��ư
				
			JPanel centerPane = new JPanel();//����, ��ư Ŭ���� ���Ӱ� �Ǵ� �κ�
			JPanel southPane = new JPanel(); //�ּ� ��ȭ��ȣ Admin
		//nnp
		JButton loginBtn = new JButton("�α���");
		JButton signInBtn = new JButton("ȸ������");
		JButton logoutBtn = new JButton("�α׾ƿ�");
		JButton suggestBtn = new JButton("�����ϱ�");
			
		//northPane
		JButton introBtn = new JButton("�Ұ�");
		JButton roomBtn = new JButton("�ü�����");
		JButton surroundingBtn = new JButton("�ֺ� ȯ��");
		JButton mapBtn = new JButton("���ô� ��");
		JButton qnaBtn = new JButton("�Խ� ����");
		//
		JButton adminBtn = new JButton("Admin");
		
		//img
		JLabel imgLbl;
		ImageIcon homeii2 = new ImageIcon("img/resizemain.gif");
		ImageIcon logo = new ImageIcon("img/logo.png");
		
		//��Ʈ
		Font titleFnt = new Font("����ü", Font.BOLD, 30);	
		Font fnt = new Font("����ü",Font.PLAIN,15);
	
		JButton loginDbBtn = new JButton("�α���");
		JButton signInBtn2 = new JButton("ȸ������");
		
		//DB����
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(Exception e) {
				System.out.println("����̺� �ε�");
			}
		}
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		String url ="jdbc:oracle:thin:@192.168.0.225:1521:xe";
		String userid = "scott";
		String password ="tiger";
		
		//���̺�
		String title[]= {"���ȣ", "����", "���", "â������", "������", "����", "���ְ��ɿ���"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table= new JTable(model);
		JScrollPane spTable = new JScrollPane(table);
		
		//����
		private GoogleAPI googleAPI=new GoogleAPI();
		private String location="37.552629,%20126.937680";
		private JLabel googleMap;
		
		//�ΰ�
		JButton logoimgbtn;
		JButton logobtn;
		
	public OneroomMain() {
		add(sp);		
		bp.add(nnp, BorderLayout.NORTH);
		bp.add(wnp, BorderLayout.WEST);
		bp.add(enp, BorderLayout.EAST);
		bp.add(snp, BorderLayout.SOUTH);
		
		//�ΰ�
		JPanel logoPane = new JPanel();
			ImageIcon logo = new ImageIcon("img/logo.png");
			logoimgbtn = new JButton(logo);
			logobtn = new JButton("1�� HOUSE");
			logobtn.setFont(titleFnt);
			logobtn.setMargin(new Insets(0, 0, 0, 0));
			// ��ư �ܰ��� ���ֱ�
			logoimgbtn.setBorderPainted(false);
			logobtn.setBorderPainted(false);
			// ���뿵�� ä��� ���ֱ�
			logoimgbtn.setContentAreaFilled(false);
			logobtn.setContentAreaFilled(false);
			// ���� �Ǿ����� ����� �׵θ� ���ֱ�
			logoimgbtn.setFocusPainted(false);
			logobtn.setFocusPainted(false);
		logoPane.add(logoimgbtn);
		logoPane.add(logobtn);
		
		//nnp.add(nnp1);
		nnp1.add(nnp2, BorderLayout.EAST);
		nnp2.add(loginBtn);
		nnp2.add(signInBtn);
		nnp1.add(logoPane, BorderLayout.WEST);
		
		bp.add(center);
		center.add(northPane, BorderLayout.NORTH);
		center.add(centerPane);
		center.add(southPane, BorderLayout.SOUTH);
		
		
		//northPane
		northPane.add(nnp1, BorderLayout.NORTH);
		northPane.add(menuPane);
			menuPane.add(introBtn);
			menuPane.add(roomBtn);
			menuPane.add(surroundingBtn);
			menuPane.add(mapBtn);
			menuPane.add(qnaBtn);
		menuPane.setBackground(Color.pink);
		//centerPane
		home();
		
		//southPane
		
		JLabel copyRight = new JLabel("Copyright 2020 Jung All rights reserved");		

		southPane.add(copyRight);
		southPane.add(adminBtn);		
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//��ư �̺�Ʈ ���
		introBtn.addActionListener(this);
		roomBtn.addActionListener(this);
		surroundingBtn.addActionListener(this);
		mapBtn.addActionListener(this);
		qnaBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		signInBtn.addActionListener(this);
		adminBtn.addActionListener(this);
		logoimgbtn.addActionListener(this);
		logobtn.addActionListener(this);

		logoutBtn.addActionListener(this);
		suggestBtn.addActionListener(this);
	}
	
	public void home() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		//centerPane
		
		imgLbl = new JLabel(homeii2);
		centerPane.add(imgLbl);
		
		centerPane.setVisible(true);
	}
	//�α��� ȭ��
	public void login() {//centerPane:flowLayout
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new JPanel(new BorderLayout());
		
		JPanel innergrid = new JPanel(new GridLayout(0,1));
		int i=0;
		while(i<10) {
			innergrid.add(new JLabel("  "));
			i++;
		}
		contentPane.add(innergrid,BorderLayout.NORTH);//����
		//
		JLabel idLbl = new JLabel("���̵�", JLabel.CENTER);
		JLabel pwdLbl = new JLabel("��й�ȣ", JLabel.CENTER);
		
		JTextField idtf = new JTextField(30); //JPanel idpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField pwdtf = new JPasswordField(30); //JPanel pwdpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JPanel all = new JPanel(new GridLayout(2,2));
		all.add(idLbl);
		all.add(idtf);
		all.add(pwdLbl);
		all.add(pwdtf);
		
		contentPane.add(all);		
		
		//��ư
		JPanel btnPane = new JPanel(new BorderLayout());
		JPanel inner2 = new JPanel(new GridLayout(0,1));
		inner2.add(new JLabel("  "));
			
		btnPane.add(inner2, BorderLayout.NORTH);
		JPanel btnPane2 = new JPanel();
		btnPane2.add(loginDbBtn);
		btnPane2.add(signInBtn2);
		btnPane.add(btnPane2);
		contentPane.add(btnPane, BorderLayout.SOUTH);
		centerPane.add(contentPane);
		centerPane.setVisible(true);
		
		//��ư �̺�Ʈ
		loginDbBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {							
				HashMap<String, String> map = new HashMap<String, String>(); 
				ResidentDAO dao = new ResidentDAO();
				ArrayList<ResidentVO> members = new ArrayList<ResidentVO>(); 
				try { 
					members = (ArrayList<ResidentVO>)dao.getLogin();
					for(int i=0; i<members.size();i++) {
						map.put(members.get(i).getResident_id(),members.get(i).getResident_pwd()); 
					}
					
					String id = idtf.getText(); 
					String password = pwdtf.getText();
					if(!map.containsKey(id)){
						JOptionPane.showMessageDialog(sp, "�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ��Է����ּ���.");
						idtf.setText("");
						idtf.requestFocus();
					}else{ 
						if(!(map.get(id)).equals(password)) { 
							JOptionPane.showMessageDialog(sp, "��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ��Է����ּ���.");
							pwdtf.setText("");
							pwdtf.requestFocus();
						} else { 
							loginPost();
						} 
					} 
					} catch(Exception e) {
						e.printStackTrace(); 
					} 
				}
		});		
		signInBtn2.addActionListener(this);
	}
	//�α��� ����
	public void loginPost() {
		nnp1.setVisible(false);
		nnp2.setVisible(false);
		nnp2.removeAll();
		nnp2.add(logoutBtn);
		nnp2.add(suggestBtn);
		nnp1.add(nnp2, BorderLayout.EAST);
		nnp2.setVisible(true);
		nnp1.setVisible(true);
		home();
	}
	//�α׾ƿ�
	public void logout() {
		nnp1.setVisible(false);
		nnp2.setVisible(false);
		nnp2.removeAll();
		nnp2.add(loginBtn);
		nnp2.add(signInBtn);
		nnp1.add(nnp2, BorderLayout.EAST);
		nnp2.setVisible(true);
		nnp1.setVisible(true);
		home();
		
	}
	//ȸ������
	public void siginIn() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new SignUpPage().signUpPage();	
		
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//�Ұ�
	public void introPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new IntroPage().introPage();
		
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//�ü�����
	public void roomPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new JPanel(new BorderLayout());
		//�̹���
		ImageIcon img1 = new ImageIcon("img/room1.jpg");
		ImageIcon img2 = new ImageIcon("img/room2.jpg");
		ImageIcon img3 = new ImageIcon("img/room3.jpg");
		ImageIcon img4 = new ImageIcon("img/room4.jpg");
		img1 = imageSetSize(img1, 100,100);img2 = imageSetSize(img2, 100,100);
		img3 = imageSetSize(img3, 100,100);img4 = imageSetSize(img4, 100,100);
		JPanel imgPane = new JPanel(new BorderLayout());
			JLabel lbl = new JLabel("�� ����");
				JLabel room1 = new JLabel("9�� ��â");
				JLabel room2 = new JLabel("8�� ��â");
				JLabel room3 = new JLabel("7�� ��â");
				JLabel room4 = new JLabel("7�� ��â");
				
				JPanel set1 = new JPanel(new GridLayout(2,1));
				set1.add(room1); set1.add(new JLabel(img1));
				JPanel set2 = new JPanel(new GridLayout(2,1));
				set2.add(room2); set2.add(new JLabel(img2));
				JPanel set3 = new JPanel(new GridLayout(2,1));
				set3.add(room3); set3.add(new JLabel(img3));
				JPanel set4 = new JPanel(new GridLayout(2,1));
				set4.add(room4); set4.add(new JLabel(img4));
				
				JPanel roomIPane = new JPanel();
				roomIPane.add(set1);
				roomIPane.add(set2);
				roomIPane.add(set3);
				roomIPane.add(set4);
		imgPane.add(lbl, BorderLayout.NORTH);
		imgPane.add(roomIPane);
		contentPane.add(imgPane,BorderLayout.WEST);
		contentPane.add(spTable,BorderLayout.EAST);
		setTable();
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//���̺� �߰�
	public void setTable() {
		//JTable�� �ִ� ���ڵ� �����
		model.setRowCount(0);
		//DAO��ü ����
		RoomDAO dao = new RoomDAO();
		List<RoomVO> list = dao.getRoomSelect();
		
		for(int i=0;i<list.size();i++) {
			RoomVO vo = list.get(i);
			Object[] record= {vo.getRoom_num(), vo.getGender(), vo.getArea(), vo.getWindow(), 
					vo.getDeposit(), vo.getMonthly_rent(), vo.getOccupancy_status()	};	
			model.addRow(record);
		}
	}
	//qna ���̺�
	public void setQnaTable() {
		String qnatitle[]= {"�Խù���ȣ","�̸�","��й�ȣ","����","����","�����","�亯����","�亯","�亯�ۼ���","�亯�ۼ���"};
		DefaultTableModel model = new DefaultTableModel(qnatitle,0);
		//JTable�� �ִ� ���ڵ� �����
		model.setRowCount(0);
		//DAO��ü ����
		QnaDAO dao = new QnaDAO();
		List<QnaVO> list = dao.getAll();
		
		for(int i=0;i<list.size();i++) {
			QnaVO vo = list.get(i);
			Object[] record= {vo.getQna_num(), vo.getQna_name(), "****", vo.getQna_title(), vo.getQna_content(), vo.getQna_write_date(),
					vo.getAnswer_title(), vo.getAnswer_content(), vo.getAnswer_writer(), vo.getAnswer_write_date()};	
			model.addRow(record);
		}
	}
	//�̹��� ũ�⺯��
	public ImageIcon imageSetSize(ImageIcon icon, int x, int y) {
		Image ximg = icon.getImage();//ImageIcon�� Image�� ��ȯ
		Image yimg = ximg.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	
	//�ֺ�ȯ��
	public void surroungingPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel pane= new SurroundPage().surrond();

		centerPane.add(pane);
		centerPane.setVisible(true);
	}
	//����
	public void mapPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		JPanel contentPane = new JPanel(new BorderLayout()); //���� -����, �� - �ϴ�
			//����
			googleAPI.downloadMap(location);
			googleMap = new JLabel(googleAPI.getMap(location));
			contentPane.add(googleMap);
			//��
			JLabel title = new JLabel("<html><br><hr>���ô� ��<hr><br></html>",JLabel.CENTER);
			title.setFont(titleFnt);
			
			JLabel maptxt = new JLabel("<html>�ּ� : ���� ������ ����� 23 �������� 3��<br>"
					+ "���̿� ��ġ�� 1�� HOUSE�� ����, �̴�, �����뿡 ������ ������ ���̿� ���� 5�аŸ���  ��ġ���ֽ��ϴ�.</html>");
			maptxt.setFont(fnt);
		contentPane.add(maptxt,BorderLayout.SOUTH);	
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//�Խǹ���
	public void qnaPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		JPanel contentPane = new JPanel(new BorderLayout()); // �۾��� ��ư : ��, ���̺� - ����
			JPanel a = new JPanel();
			JButton writeBtn = new JButton("�۾���");
			a.add(writeBtn);
			
		writeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				qnaWritePage();
			}
		});	
		setQnaTable();
		contentPane.add(writeBtn,BorderLayout.NORTH);
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	
	//�����ϱ� �۾���(�̿ϼ�)
	public void qnaWritePage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		JPanel contentPane = new JPanel(new BorderLayout()); // �۾��� ��ư : ��, ���̺� - ����
				JTextField qna_nameTf = new JTextField(20); JPanel p1 = new JPanel();
				JTextField qna_pwdTf = new JTextField(20); JPanel p2 = new JPanel();
				JTextField titleTf = new JTextField(30); JPanel p3 = new JPanel();
				JTextArea contentTf = new JTextArea(10,20); JPanel p4 = new JPanel();
				//JScrollPane sp = new JScrollPane(contentTf);
					p1.add(new JLabel("�̸�"));p1.add(qna_nameTf);
					p2.add(new JLabel("��й�ȣ"));p2.add(qna_pwdTf);
					p3.add(new JLabel("����"));p3.add(titleTf);
					p4.add(new JLabel("����"));p4.add(contentTf);
				JPanel tp1 = new JPanel(new BorderLayout());
				JPanel tp2 = new JPanel(new BorderLayout());
				JPanel tp3 = new JPanel(new BorderLayout());
				JPanel tp4 = new JPanel(new BorderLayout());
				tp1.add(p1, BorderLayout.NORTH);
				tp1.add(tp2, BorderLayout.CENTER);
				tp2.add(p2, BorderLayout.NORTH);
				tp2.add(tp3, BorderLayout.CENTER);
				tp3.add(p3, BorderLayout.NORTH);
				tp3.add(tp4,BorderLayout.CENTER);
				tp4.add(p4);
				
			JPanel btnPane = new JPanel();
				JButton submitBtn = new JButton("����ϱ�");
				JButton listBtn = new JButton("���");				
			btnPane.add(submitBtn);
			btnPane.add(listBtn);
		contentPane.add(tp1);
		contentPane.add(btnPane,BorderLayout.SOUTH);
		centerPane.add(contentPane);
		centerPane.setVisible(true);
		
		//��ư Ŭ��
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
					//qnaInsert();
					QnaVO vo = new QnaVO();
					vo.setQna_name(qna_nameTf.getText());
					vo.setQna_pwd(qna_pwdTf.getText());
				}
		});	
		
	}
	
	
	
	//������ �۾���
	public void adminPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
			JPanel contentPane = new JPanel(new BorderLayout()); 
				contentPane.add(new JLabel("<html><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></html>"),BorderLayout.NORTH);				
				
				JPanel gridPane = new JPanel(new GridLayout(2,2));
					JLabel idLbl = new JLabel("���̵�", JLabel.CENTER);
					JLabel pwdLbl = new JLabel("��й�ȣ", JLabel.CENTER);
					JTextField idtf = new JTextField(30); 
					JPasswordField pwdtf = new JPasswordField(30);				
				gridPane.add(idLbl);
				gridPane.add(idtf);
				gridPane.add(pwdLbl);
				gridPane.add(pwdtf);
				
				contentPane.add(gridPane);		
				
				//��ư				
				JPanel btnPane = new JPanel();
					btnPane.add(new JLabel("<html><br/><br/><br/><br/></html>"));
					btnPane.add(loginDbBtn);
					
					//��ư �̺�Ʈ
					loginDbBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {							
							HashMap<String, String> map = new HashMap<String, String>(); 
							AdminDAO dao = new AdminDAO();
							ArrayList<AdminVO> members = new ArrayList<AdminVO>(); 
							try { 
								members = (ArrayList<AdminVO>) dao.getAll(); 
									map.put(members.get(0).getId(),members.get(0).getPwd());  
								
								String id = idtf.getText(); 
								String password = pwdtf.getText();
									if(!map.containsKey(id)) 
									{
										JOptionPane.showMessageDialog(sp, "�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ��Է����ּ���.");
										idtf.setText("");
									}else{ 
										if(!(map.get(id)).equals(password)) { 
										JOptionPane.showMessageDialog(sp, "��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ��Է����ּ���.");
										pwdtf.setText("");
										}else{ 
											new Admin();
										} 
									} 
								} catch(Exception e) {
									e.printStackTrace(); 
								}
							}
					});					
					
			contentPane.add(btnPane,BorderLayout.SOUTH);
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==introBtn) {
			introPage();
		}else if(obj==roomBtn) {
			roomPage();
		}else if(obj==surroundingBtn) {
			surroungingPage();
		}else if(obj==mapBtn) {
			mapPage();
		}else if(obj==qnaBtn) {
			qnaPage();
		}else if(obj==loginBtn) {
			login();
		}else if(obj==signInBtn || obj==signInBtn2) {
			siginIn();
		}else if(obj==adminBtn) {
			adminPage();
		}else if(obj==logobtn||obj==logoimgbtn) {
			home();
		}else if(obj==logoutBtn) {
			logout();
		}
	}

	public static void main(String[] args) {
		new OneroomMain();

	}

}
