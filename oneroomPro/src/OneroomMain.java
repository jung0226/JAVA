import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class OneroomMain extends JFrame implements ActionListener{
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); //화면 크기
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
			
		//northPane
		JButton homeBtn = new JButton("신촌 원룸");
		JButton introBtn = new JButton("소개");
		JButton roomBtn = new JButton("시설보기");
		JButton surroundingBtn = new JButton("주변 환경");
		JButton mapBtn = new JButton("오시는 길");
		JButton qnaBtn = new JButton("입실 문의");
		
		//img
		JLabel imgLbl;
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//Image homeimg = tk.getImage("img/home1.jpg");
		ImageIcon homeii = new ImageIcon("img/home1.jpg");
		ImageIcon homeii2 = new ImageIcon("img/homeimg1.jpg");
		
	
		JButton loginDbBtn = new JButton("로그인");
		JButton signInBtn2 = new JButton("회원가입");

	public OneroomMain() {
		add(sp);
		bp.add(nnp, BorderLayout.NORTH);
		bp.add(wnp, BorderLayout.WEST);
		bp.add(enp, BorderLayout.EAST);
		bp.add(snp, BorderLayout.SOUTH);
		
		//nnp
		nnp.add(nnp1);
		nnp1.add(nnp2, BorderLayout.EAST);
		nnp2.add(loginBtn);
		nnp2.add(signInBtn);
		
		bp.add(center);
		center.add(northPane, BorderLayout.NORTH);
		center.add(centerPane);
		center.add(southPane, BorderLayout.SOUTH);
		
		
		//northPane
		northPane.add(nnp1, BorderLayout.NORTH);
		northPane.add(menuPane);
			menuPane.add(homeBtn);
			menuPane.add(introBtn);
			menuPane.add(roomBtn);
			menuPane.add(surroundingBtn);
			menuPane.add(mapBtn);
			menuPane.add(qnaBtn);
		
		//centerPane
		imgLbl = new JLabel(homeii);
		centerPane.add(imgLbl);
		
		//southPane
		
		JLabel copyRight = new JLabel("Copyright 2020 Jung All rights reserved");
		JButton adminBtn = new JButton("Admin");
		
		southPane.add(copyRight);
		southPane.add(adminBtn);		
		
		setSize((int)Math.round(res.getWidth()), (int)Math.round(res.getHeight()));
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//버튼 이벤트 등록
		homeBtn.addActionListener(this);
		introBtn.addActionListener(this);
		roomBtn.addActionListener(this);
		surroundingBtn.addActionListener(this);
		mapBtn.addActionListener(this);
		qnaBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		signInBtn.addActionListener(this);
		
		
	}
	//로그인
	public void login() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		//
		JLabel idLbl = new JLabel("아이디 : ", JLabel.LEFT);
		JLabel pwdLbl = new JLabel("비밀번호 : ", JLabel.LEFT);
		
		JPanel loginPane = new JPanel(new GridLayout(2,2));		
		loginPane.add(idLbl);
		loginPane.add(new JTextField(30));
		loginPane.add(pwdLbl);
		loginPane.add(new JTextField(30));
		
		centerPane.add(loginPane);
		centerPane.add(loginDbBtn);
		centerPane.add(signInBtn2);
		
		centerPane.setVisible(true);
		
		//버튼 이벤트
		loginDbBtn.addActionListener(this);
		signInBtn2.addActionListener(this);
	}
	//회원가입
	public void siginIn() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		centerPane.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==homeBtn) {
			
		}else if(obj==introBtn) {
			
		}else if(obj==loginBtn) {
			login();
		}else if(obj==signInBtn || obj==signInBtn2) {
			siginIn();
		}
	}

	public static void main(String[] args) {
		new OneroomMain();

	}

}
