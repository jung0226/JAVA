import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroPage {

	Font titleFnt = new Font("����ü", Font.BOLD, 30);
	Font fnt = new Font("����ü", Font.PLAIN, 15);
	public IntroPage() {}
	public JPanel introPage() {
		JPanel contentPane = new JPanel(new GridLayout(5, 0));

		// ����
//		JPanel blank = new JPanel(new GridLayout(0,1));
//			blank.add(new JLabel("  "));
//			blank.add(new JLabel("  "));			
//		contentPane.add(blank);

		JPanel txtPane = new JPanel(new BorderLayout());
		JLabel title = new JLabel("<html><hr>�Ұ� ����<hr></html>", JLabel.CENTER);
		title.setFont(titleFnt);

		JLabel introTxt = new JLabel("<html>1�� HOUSE�� ���ֹε��� ����ϰ� ������ ��Ȱ�� ���� �׻� ����ϸ�, �ո����� �������� 1�� �ְ� ������ �����մϴ�.<br>"
				+ "�������� ������ ���� �� �� ȭ���/�����ü�, ���ͳ�, å��, ����, ħ��, ����, ����� ���߰� <br>"
				+ "��, ���, �⺻��, ���̷� �� �ҽ��� ���� �����ϴ� �ֹ�� ��Ź �� �ٸ��� �� �پ��� ���ǽü��� �����մϴ�.<br><br>"
				+ "���� ��û�� ���� �����̰ų� ��� ���� �� �� ���� ���� ��û�� �޽��ϴ�.<br>" + "������ ���� �� ���ָ� ����Ͻ� ���, �������� 50%�� ��ȯ�˴ϴ�.<br>"
				+ "���Ⱓ ���� ������ �ߵ� ����� ��� �����ݿ��� ����� 30������ �����˴ϴ�." + "</html>", JLabel.CENTER);

		introTxt.setFont(fnt);
		txtPane.add(title);
		txtPane.add(introTxt, BorderLayout.SOUTH);
		contentPane.add(txtPane);

		JLabel subTxt = new JLabel("<html><hr>����ü�<hr></html>", JLabel.CENTER);
		subTxt.setFont(titleFnt);
		contentPane.add(subTxt);

		JPanel imgPane = new JPanel();
		JLabel kitimg = new JLabel(new ImageIcon("img/kitchen.png"));
		JLabel launimg = new JLabel(new ImageIcon("img/laundry.png"));
		JLabel dryimg = new JLabel(new ImageIcon("img/dryer.png"));
		imgPane.add(kitimg);
		imgPane.add(launimg);
		imgPane.add(dryimg);
		contentPane.add(imgPane);

		JLabel subTxt2 = new JLabel("<html><hr>SERVICE<hr></html>", JLabel.CENTER);
		subTxt2.setFont(titleFnt);
		contentPane.add(subTxt2);

		JPanel servicePane = new JPanel(new GridLayout(2, 2));
		JLabel cctvimg = new JLabel(new ImageIcon("img/cctv.png"));
		JLabel cleanimg = new JLabel(new ImageIcon("img/clean.png"));
		JLabel cctvTxt = new JLabel("cctv, ����⵿�� �� �پ��� ���� �ý������� ������ ������ �����ϰ� �ֽ��ϴ�.");
		JLabel cleanTxt = new JLabel("�� 3ȸ ������� û�ҷ� �� û���ϰ� ������ ������ �����մϴ�.");
		cctvTxt.setFont(fnt);
		cleanTxt.setFont(fnt);
		servicePane.add(cctvimg);
		servicePane.add(cleanimg);
		servicePane.add(cctvTxt);
		servicePane.add(cleanTxt);
		contentPane.add(servicePane);

		return contentPane;
	}

}