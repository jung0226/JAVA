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
	
	JPanel bp = new JPanel(new BorderLayout());//����
	JScrollPane sp = new JScrollPane(bp);
		JPanel nnp = new JPanel(); //����		
		JPanel wnp = new JPanel(); //����
		JPanel enp = new JPanel(); //����
		JPanel snp = new JPanel(); //����
		JPanel center = new JPanel(new BorderLayout());//���
			JPanel northPane = new JPanel(new BorderLayout());
			JPanel centerPane = new JPanel();//���� �� ��
	//��ư
	JButton logoimgbtn;
	JButton logobtn;		
	
	//Font
	Font titleFnt = new Font("����ü", Font.BOLD, 30);	
	Font fnt = new Font("����ü",Font.PLAIN,15);
	
	
	public Admin() {
		super("������");
		add(sp);
		
		bp.add(nnp, BorderLayout.NORTH);
		bp.add(wnp, BorderLayout.WEST);
		bp.add(enp, BorderLayout.EAST);
		bp.add(snp, BorderLayout.SOUTH);
		
		bp.add(center);
		
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
		
		//		   ����, ����
		tabPane.add("�� ����", room);
		tabPane.add("������ ����", resident);
		tabPane.add("�����ϱ�",qna);
		
		
		northPane.add(logoPane,BorderLayout.WEST);
		centerPane.add(sp2);
		center.add(northPane,BorderLayout.NORTH);
		center.add(centerPane);
		
		setVisible(true);
		setSize(1200,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		//�̺�Ʈ
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
