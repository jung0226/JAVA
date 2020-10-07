import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroPage {

	Font titleFnt = new Font("굴림체", Font.BOLD, 30);
	Font fnt = new Font("굴림체", Font.PLAIN, 15);
	public IntroPage() {}
	public JPanel introPage() {
		JPanel contentPane = new JPanel(new GridLayout(5, 0));

		// 여백
//		JPanel blank = new JPanel(new GridLayout(0,1));
//			blank.add(new JLabel("  "));
//			blank.add(new JLabel("  "));			
//		contentPane.add(blank);

		JPanel txtPane = new JPanel(new BorderLayout());
		JLabel title = new JLabel("<html><hr>소개 말씀<hr></html>", JLabel.CENTER);
		title.setFont(titleFnt);

		JLabel introTxt = new JLabel("<html>1인 HOUSE는 입주민들의 편안하고 안전한 생활을 위해 항상 노력하며, 합리적인 가격으로 1인 주거 공간을 제공합니다.<br>"
				+ "입주자의 편리함을 위해 각 방 화장실/샤워시설, 인터넷, 책상, 의자, 침대, 옷장, 냉장고를 갖추고 <br>"
				+ "밥, 라면, 기본찬, 조미료 및 소스류 등을 제공하는 주방과 세탁 및 다림실 등 다양한 편의시설을 제공합니다.<br><br>"
				+ "입주 신청은 현재 공실이거나 계약 종료 두 달 전인 방의 신청만 받습니다.<br>" + "보증금 납부 후 입주를 취소하실 경우, 보증금의 50%만 반환됩니다.<br>"
				+ "계약기간 만료 이전에 중도 퇴실할 경우 보증금에서 위약금 30만원이 차감됩니다." + "</html>", JLabel.CENTER);

		introTxt.setFont(fnt);
		txtPane.add(title);
		txtPane.add(introTxt, BorderLayout.SOUTH);
		contentPane.add(txtPane);

		JLabel subTxt = new JLabel("<html><hr>공용시설<hr></html>", JLabel.CENTER);
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
		JLabel cctvTxt = new JLabel("cctv, 비상출동벨 등 다양한 보안 시스템으로 안전한 공간을 조성하고 있습니다.");
		JLabel cleanTxt = new JLabel("주 3회 공용공간 청소로 늘 청결하고 쾌적한 공간을 유지합니다.");
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