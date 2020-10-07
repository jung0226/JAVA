import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class Admin extends JFrame implements ActionListener{
	JTabbedPane tabPane = new JTabbedPane();
	RoomStart room = new RoomStart();
	ResidentStart resident = new ResidentStart();
	QnaStart qna = new QnaStart();
	JScrollPane sp2 = new JScrollPane(tabPane);
	
	JPanel bp = new JPanel(new BorderLayout());//여백
	JScrollPane sp = new JScrollPane(bp);
		JPanel nnp = new JPanel(); //여백		
		JPanel wnp = new JPanel(); //여백
		JPanel enp = new JPanel(); //여백
		JPanel snp = new JPanel(); //여백
		JPanel center = new JPanel(new BorderLayout());//가운데
			JPanel northPane = new JPanel(new BorderLayout());
			JPanel centerPane = new JPanel();//내용 들어갈 곳
	//버튼
	JButton logoimgbtn;
	JButton logobtn;		
	
	//Font
	Font titleFnt = new Font("굴림체", Font.BOLD, 30);	
	Font fnt = new Font("굴림체",Font.PLAIN,15);
	
	
	public Admin() {
		super("관리자");
		add(sp);
		
		bp.add(nnp, BorderLayout.NORTH);
		bp.add(wnp, BorderLayout.WEST);
		bp.add(enp, BorderLayout.EAST);
		bp.add(snp, BorderLayout.SOUTH);
		
		bp.add(center);
		
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
		
		//		   제목, 내용
		tabPane.add("방 관리", room);
		tabPane.add("입주자 관리", resident);
		tabPane.add("문의하기",qna);
		
		
		northPane.add(logoPane,BorderLayout.WEST);
		centerPane.add(sp2);
		center.add(northPane,BorderLayout.NORTH);
		center.add(centerPane);
		
		setVisible(true);
		setSize(1200,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		//이벤트
		logoimgbtn.addActionListener(this);
		logobtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==logobtn||obj==logoimgbtn) {
			new OneroomMain();
		}
	}
	

}
