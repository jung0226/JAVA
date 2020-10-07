import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SurroundPage{
	Font titleFnt = new Font("����ü", Font.BOLD, 30);	
	Font fnt = new Font("����ü",Font.PLAIN,15);
	
	public SurroundPage() {}
	public JPanel surrond(){
		JPanel pane = new JPanel(new BorderLayout());
			JPanel contentPane = new JPanel(new GridLayout(3,3));
				JLabel camlogoimg = new JLabel(new ImageIcon("img/camlogo.png"));
				JLabel surroundimg = new JLabel(new ImageIcon("img/surround.png"));
				JLabel transportimg = new JLabel(new ImageIcon("img/transport.png"));
				JLabel camlogoTxt = new JLabel("�������б�, �������б�, ȫ�ʹ��б�, ��ȭ���ڴ��б��� �������ϴ�");
				JLabel surroundTxt = new JLabel("��Ȱ ������ ǳ���ϰ� ���߾��� ������ ����, ��ȭ �� ǳ��ο� ��Ȱ�� ���� �� �ֽ��ϴ�.");
				JLabel transportTxt = new JLabel("���̷��͸� �ʿ����ǿ� ��ġ�Ͽ� ������ ���մϴ�.");
				camlogoTxt.setFont(fnt);
				surroundTxt.setFont(fnt);
				transportTxt.setFont(fnt);
				contentPane.add(camlogoimg);
				contentPane.add(camlogoTxt);
				contentPane.add(surroundimg);
				contentPane.add(surroundTxt);
				contentPane.add(transportimg);
				contentPane.add(transportTxt);
			JLabel title = new JLabel("<html><br><hr>�ֺ�ȯ��<hr><br></html>",JLabel.CENTER);
			title.setFont(titleFnt);
			pane.add(title,BorderLayout.NORTH);
			pane.add(contentPane);
			pane.add(new JLabel("<html><br><br><br><br></html>"),BorderLayout.SOUTH);
		return pane;
	}
	
	
	
}