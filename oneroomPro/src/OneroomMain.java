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
	JPanel bp = new JPanel(new BorderLayout());//여백
	JScrollPane sp = new JScrollPane(bp);
		JPanel nnp = new JPanel(); //여백		
		JPanel wnp = new JPanel(); //여백
		JPanel enp = new JPanel(); //여백
		JPanel snp = new JPanel(); //여백
		JPanel center = new JPanel(new BorderLayout());
			
			JPanel northPane = new JPanel(new BorderLayout()); 
				JPanel nnp1 = new JPanel(new BorderLayout()); //로그인 회원가입
				JPanel nnp2 = new JPanel();
				JPanel menuPane = new JPanel();//버튼
				
			JPanel centerPane = new JPanel();//사진, 버튼 클릭시 새롭게 되는 부분
			JPanel southPane = new JPanel(); //주소 전화번호 Admin
		//nnp
		JButton loginBtn = new JButton("로그인");
		JButton signInBtn = new JButton("회원가입");
		JButton logoutBtn = new JButton("로그아웃");
		JButton suggestBtn = new JButton("건의하기");
			
		//northPane
		JButton introBtn = new JButton("소개");
		JButton roomBtn = new JButton("시설보기");
		JButton surroundingBtn = new JButton("주변 환경");
		JButton mapBtn = new JButton("오시는 길");
		JButton qnaBtn = new JButton("입실 문의");
		//
		JButton adminBtn = new JButton("Admin");
		
		//img
		JLabel imgLbl;
		ImageIcon homeii2 = new ImageIcon("img/resizemain.gif");
		ImageIcon logo = new ImageIcon("img/logo.png");
		
		//폰트
		Font titleFnt = new Font("굴림체", Font.BOLD, 30);	
		Font fnt = new Font("굴림체",Font.PLAIN,15);
	
		JButton loginDbBtn = new JButton("로그인");
		JButton signInBtn2 = new JButton("회원가입");
		
		//DB연결
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(Exception e) {
				System.out.println("드라이브 로딩");
			}
		}
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		String url ="jdbc:oracle:thin:@192.168.0.225:1521:xe";
		String userid = "scott";
		String password ="tiger";
		
		//테이블
		String title[]= {"방번호", "성별", "평수", "창문유무", "보증금", "월세", "입주가능여부"};
		DefaultTableModel model = new DefaultTableModel(title,0);
		JTable table= new JTable(model);
		JScrollPane spTable = new JScrollPane(table);
		
		//지도
		private GoogleAPI googleAPI=new GoogleAPI();
		private String location="37.552629,%20126.937680";
		private JLabel googleMap;
		
		//로고
		JButton logoimgbtn;
		JButton logobtn;
		
	public OneroomMain() {
		add(sp);		
		bp.add(nnp, BorderLayout.NORTH);
		bp.add(wnp, BorderLayout.WEST);
		bp.add(enp, BorderLayout.EAST);
		bp.add(snp, BorderLayout.SOUTH);
		
		//로고
		JPanel logoPane = new JPanel();
			ImageIcon logo = new ImageIcon("img/logo.png");
			logoimgbtn = new JButton(logo);
			logobtn = new JButton("1인 HOUSE");
			logobtn.setFont(titleFnt);
			logobtn.setMargin(new Insets(0, 0, 0, 0));
			// 버튼 외곽선 없애기
			logoimgbtn.setBorderPainted(false);
			logobtn.setBorderPainted(false);
			// 내용영역 채우기 없애기
			logoimgbtn.setContentAreaFilled(false);
			logobtn.setContentAreaFilled(false);
			// 선택 되었을때 생기는 테두리 없애기
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
		
		//버튼 이벤트 등록
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
	//로그인 화면
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
		contentPane.add(innergrid,BorderLayout.NORTH);//여백
		//
		JLabel idLbl = new JLabel("아이디", JLabel.CENTER);
		JLabel pwdLbl = new JLabel("비밀번호", JLabel.CENTER);
		
		JTextField idtf = new JTextField(30); //JPanel idpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField pwdtf = new JPasswordField(30); //JPanel pwdpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JPanel all = new JPanel(new GridLayout(2,2));
		all.add(idLbl);
		all.add(idtf);
		all.add(pwdLbl);
		all.add(pwdtf);
		
		contentPane.add(all);		
		
		//버튼
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
		
		//버튼 이벤트
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
						JOptionPane.showMessageDialog(sp, "입력하신 id는 존재하지 않습니다. 다시입력해주세요.");
						idtf.setText("");
						idtf.requestFocus();
					}else{ 
						if(!(map.get(id)).equals(password)) { 
							JOptionPane.showMessageDialog(sp, "비밀번호가 일치하지 않습니다. 다시입력해주세요.");
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
	//로그인 성공
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
	//로그아웃
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
	//회원가입
	public void siginIn() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new SignUpPage().signUpPage();	
		
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//소개
	public void introPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new IntroPage().introPage();
		
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//시설보기
	public void roomPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel contentPane = new JPanel(new BorderLayout());
		//이미지
		ImageIcon img1 = new ImageIcon("img/room1.jpg");
		ImageIcon img2 = new ImageIcon("img/room2.jpg");
		ImageIcon img3 = new ImageIcon("img/room3.jpg");
		ImageIcon img4 = new ImageIcon("img/room4.jpg");
		img1 = imageSetSize(img1, 100,100);img2 = imageSetSize(img2, 100,100);
		img3 = imageSetSize(img3, 100,100);img4 = imageSetSize(img4, 100,100);
		JPanel imgPane = new JPanel(new BorderLayout());
			JLabel lbl = new JLabel("방 유형");
				JLabel room1 = new JLabel("9평 외창");
				JLabel room2 = new JLabel("8평 외창");
				JLabel room3 = new JLabel("7평 외창");
				JLabel room4 = new JLabel("7평 내창");
				
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
	//테이블에 추가
	public void setTable() {
		//JTable에 있는 레코드 지우기
		model.setRowCount(0);
		//DAO객체 생성
		RoomDAO dao = new RoomDAO();
		List<RoomVO> list = dao.getRoomSelect();
		
		for(int i=0;i<list.size();i++) {
			RoomVO vo = list.get(i);
			Object[] record= {vo.getRoom_num(), vo.getGender(), vo.getArea(), vo.getWindow(), 
					vo.getDeposit(), vo.getMonthly_rent(), vo.getOccupancy_status()	};	
			model.addRow(record);
		}
	}
	//qna 테이블
	public void setQnaTable() {
		String qnatitle[]= {"게시물번호","이름","비밀번호","제목","내용","등록일","답변제목","답변","답변작성인","답변작성일"};
		DefaultTableModel model = new DefaultTableModel(qnatitle,0);
		//JTable에 있는 레코드 지우기
		model.setRowCount(0);
		//DAO객체 생성
		QnaDAO dao = new QnaDAO();
		List<QnaVO> list = dao.getAll();
		
		for(int i=0;i<list.size();i++) {
			QnaVO vo = list.get(i);
			Object[] record= {vo.getQna_num(), vo.getQna_name(), "****", vo.getQna_title(), vo.getQna_content(), vo.getQna_write_date(),
					vo.getAnswer_title(), vo.getAnswer_content(), vo.getAnswer_writer(), vo.getAnswer_write_date()};	
			model.addRow(record);
		}
	}
	//이미지 크기변경
	public ImageIcon imageSetSize(ImageIcon icon, int x, int y) {
		Image ximg = icon.getImage();//ImageIcon을 Image로 전환
		Image yimg = ximg.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	
	//주변환경
	public void surroungingPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		JPanel pane= new SurroundPage().surrond();

		centerPane.add(pane);
		centerPane.setVisible(true);
	}
	//지도
	public void mapPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		JPanel contentPane = new JPanel(new BorderLayout()); //지도 -센터, 글 - 하단
			//지도
			googleAPI.downloadMap(location);
			googleMap = new JLabel(googleAPI.getMap(location));
			contentPane.add(googleMap);
			//글
			JLabel title = new JLabel("<html><br><hr>오시는 길<hr><br></html>",JLabel.CENTER);
			title.setFont(titleFnt);
			
			JLabel maptxt = new JLabel("<html>주소 : 서울 마포구 백범로 23 구프라자 3층<br>"
					+ "신촌에 위치한 1인 HOUSE는 연대, 이대, 서강대에 인접해 있으며 신촌역 도보 5분거리에  위치해있습니다.</html>");
			maptxt.setFont(fnt);
		contentPane.add(maptxt,BorderLayout.SOUTH);	
		centerPane.add(contentPane);
		centerPane.setVisible(true);
	}
	//입실문의
	public void qnaPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		JPanel contentPane = new JPanel(new BorderLayout()); // 글쓰기 버튼 : 위, 테이블 - 센터
			JPanel a = new JPanel();
			JButton writeBtn = new JButton("글쓰기");
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
	
	//문의하기 글쓰기(미완성)
	public void qnaWritePage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		JPanel contentPane = new JPanel(new BorderLayout()); // 글쓰기 버튼 : 위, 테이블 - 센터
				JTextField qna_nameTf = new JTextField(20); JPanel p1 = new JPanel();
				JTextField qna_pwdTf = new JTextField(20); JPanel p2 = new JPanel();
				JTextField titleTf = new JTextField(30); JPanel p3 = new JPanel();
				JTextArea contentTf = new JTextArea(10,20); JPanel p4 = new JPanel();
				//JScrollPane sp = new JScrollPane(contentTf);
					p1.add(new JLabel("이름"));p1.add(qna_nameTf);
					p2.add(new JLabel("비밀번호"));p2.add(qna_pwdTf);
					p3.add(new JLabel("제목"));p3.add(titleTf);
					p4.add(new JLabel("내용"));p4.add(contentTf);
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
				JButton submitBtn = new JButton("등록하기");
				JButton listBtn = new JButton("목록");				
			btnPane.add(submitBtn);
			btnPane.add(listBtn);
		contentPane.add(tp1);
		contentPane.add(btnPane,BorderLayout.SOUTH);
		centerPane.add(contentPane);
		centerPane.setVisible(true);
		
		//버튼 클릭
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
					//qnaInsert();
					QnaVO vo = new QnaVO();
					vo.setQna_name(qna_nameTf.getText());
					vo.setQna_pwd(qna_pwdTf.getText());
				}
		});	
		
	}
	
	
	
	//관리자 글쓰기
	public void adminPage() {
		centerPane.setVisible(false);
		centerPane.removeAll();
			JPanel contentPane = new JPanel(new BorderLayout()); 
				contentPane.add(new JLabel("<html><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></html>"),BorderLayout.NORTH);				
				
				JPanel gridPane = new JPanel(new GridLayout(2,2));
					JLabel idLbl = new JLabel("아이디", JLabel.CENTER);
					JLabel pwdLbl = new JLabel("비밀번호", JLabel.CENTER);
					JTextField idtf = new JTextField(30); 
					JPasswordField pwdtf = new JPasswordField(30);				
				gridPane.add(idLbl);
				gridPane.add(idtf);
				gridPane.add(pwdLbl);
				gridPane.add(pwdtf);
				
				contentPane.add(gridPane);		
				
				//버튼				
				JPanel btnPane = new JPanel();
					btnPane.add(new JLabel("<html><br/><br/><br/><br/></html>"));
					btnPane.add(loginDbBtn);
					
					//버튼 이벤트
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
										JOptionPane.showMessageDialog(sp, "입력하신 id는 존재하지 않습니다. 다시입력해주세요.");
										idtf.setText("");
									}else{ 
										if(!(map.get(id)).equals(password)) { 
										JOptionPane.showMessageDialog(sp, "비밀번호가 일치하지 않습니다. 다시입력해주세요.");
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
