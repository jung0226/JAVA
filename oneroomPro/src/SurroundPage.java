import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SurroundPage{
	Font titleFnt = new Font("굴림체", Font.BOLD, 30);	
	Font fnt = new Font("굴림체",Font.PLAIN,15);
	
	public SurroundPage() {}
	public JPanel surrond(){
		JPanel pane = new JPanel(new BorderLayout());
			JPanel contentPane = new JPanel(new GridLayout(3,3));
				JLabel camlogoimg = new JLabel(new ImageIcon("img/camlogo.png"));
				JLabel surroundimg = new JLabel(new ImageIcon("img/surround.png"));
				JLabel transportimg = new JLabel(new ImageIcon("img/transport.png"));
				JLabel camlogoTxt = new JLabel("연세대학교, 서강대학교, 홍익대학교, 이화여자대학교와 가깝습니다");
				JLabel surroundTxt = new JLabel("생활 인프라가 풍부하게 갖추어져 있으며 쇼핑, 문화 등 풍요로운 생활을 즐기실 수 있습니다.");
				JLabel transportTxt = new JLabel("신촌로터리 초역세권에 위치하여 교통이 편리합니다.");
				camlogoTxt.setFont(fnt);
				surroundTxt.setFont(fnt);
				transportTxt.setFont(fnt);
				contentPane.add(camlogoimg);
				contentPane.add(camlogoTxt);
				contentPane.add(surroundimg);
				contentPane.add(surroundTxt);
				contentPane.add(transportimg);
				contentPane.add(transportTxt);
			JLabel title = new JLabel("<html><br><hr>주변환경<hr><br></html>",JLabel.CENTER);
			title.setFont(titleFnt);
			pane.add(title,BorderLayout.NORTH);
			pane.add(contentPane);
			pane.add(new JLabel("<html><br><br><br><br></html>"),BorderLayout.SOUTH);
		return pane;
	}
	
	
	
}