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
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); //ȭ�� ũ��
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
			
		//northPane
		JButton homeBtn = new JButton("���� ����");
		JButton introBtn = new JButton("�Ұ�");
		JButton roomBtn = new JButton("�ü�����");
		JButton surroundingBtn = new JButton("�ֺ� ȯ��");
		JButton mapBtn = new JButton("���ô� ��");
		JButton qnaBtn = new JButton("�Խ� ����");
		
		//img
		JLabel imgLbl;
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//Image homeimg = tk.getImage("img/home1.jpg");
		ImageIcon homeii = new ImageIcon("img/home1.jpg");
		ImageIcon homeii2 = new ImageIcon("img/homeimg1.jpg");
		
	
		JButton loginDbBtn = new JButton("�α���");
		JButton signInBtn2 = new JButton("ȸ������");

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
		
		//��ư �̺�Ʈ ���
		homeBtn.addActionListener(this);
		introBtn.addActionListener(this);
		roomBtn.addActionListener(this);
		surroundingBtn.addActionListener(this);
		mapBtn.addActionListener(this);
		qnaBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		signInBtn.addActionListener(this);
		
		
	}
	//�α���
	public void login() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		
		//
		JLabel idLbl = new JLabel("���̵� : ", JLabel.LEFT);
		JLabel pwdLbl = new JLabel("��й�ȣ : ", JLabel.LEFT);
		
		JPanel loginPane = new JPanel(new GridLayout(2,2));		
		loginPane.add(idLbl);
		loginPane.add(new JTextField(30));
		loginPane.add(pwdLbl);
		loginPane.add(new JTextField(30));
		
		centerPane.add(loginPane);
		centerPane.add(loginDbBtn);
		centerPane.add(signInBtn2);
		
		centerPane.setVisible(true);
		
		//��ư �̺�Ʈ
		loginDbBtn.addActionListener(this);
		signInBtn2.addActionListener(this);
	}
	//ȸ������
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
