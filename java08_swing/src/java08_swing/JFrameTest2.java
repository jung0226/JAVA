package java08_swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest2 {
	JFrame frm = new JFrame("창의 제목"); //BoderLayout

	public JFrameTest2() {
		//레이아웃 없이 좌표를 이용해서 컴포넌트 배치하기
		frm.setLayout(null);
		JButton btn = new JButton("좌표로 레이아웃 설정");
		btn.setSize(200, 50);//크기
		btn.setLocation(50, 100);//x, y좌표
		frm.add(btn);
		
		frm.setResizable(false); // 창크기 조절 불가
		frm.setSize(500,500);
		frm.setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameTest2();

	}

}
