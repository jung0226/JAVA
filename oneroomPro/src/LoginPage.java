import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage {

	Font titleFnt = new Font("굴림체", Font.BOLD, 30);
	Font fnt = new Font("굴림체", Font.PLAIN, 15);
	public LoginPage() {}
	public JPanel introPage() {
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
		JTextField pwdtf = new JTextField(30); //JPanel pwdpan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
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
		//btnPane2.add(loginDbBtn);
	//	btnPane2.add(signInBtn2);
		btnPane.add(btnPane2);
		contentPane.add(btnPane, BorderLayout.SOUTH);
		
		return contentPane;
	}

}