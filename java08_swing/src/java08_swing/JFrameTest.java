package java08_swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame {
	JButton btn1 = new JButton("1111");
	JButton btn2 = new JButton("2222");
	JButton btn3 = new JButton("3333");
	JButton btn4 = new JButton("4444");
	JButton btn5 = new JButton("5555");
	
	JPanel pane= new JPanel();
	JButton btn6 = new JButton("66666");
	JButton btn7 = new JButton("77777");
	JButton btn8 = new JButton("88888");

	public JFrameTest() {
		// 각 컨테이너마다 기본 레이아웃이 있다.
		// JFrame, JDailog : BorderLayout
		// JPanel :FlowLayout
		// GridLayout, CardLayout, GridbagLayout
		// BorderLayout: 동, 서, 남, 북, 가운데 5구역으로 나눠짐.
		// FlowLayout : 추가하는 컴퍼넌트 순서대로 배치
		// GridLayout : 바둑판식으로 가로세로 행열의 크기가 같다.
		
		add(btn1);
		add(BorderLayout.NORTH, btn2); //add("North", btn2);
		add("West",btn3);//폭 고정, 높이만 조정
		
		//FlowLayout을 GridLayout으로 변경하기
		pane.setLayout(new GridLayout(2,10, 10,5));
		pane.add(btn6);
		pane.add(btn7);
		pane.add(btn8);
		pane.add(new JButton("A"));
		pane.add(new JButton("B"));
		
		add(BorderLayout.EAST, pane);
		add("South",btn5);
		
		
		setSize(500,500);
		setVisible(true);
		
		//컨테이너가 종료되면 자원해제한다.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameTest();

	}

}
