package java08_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame{
	ImageIcon ii1 = new ImageIcon("img/1.jpg");
	ImageIcon ii2 = new ImageIcon("img/2.jpg");
	ImageIcon ii3 = new ImageIcon("img/3.jpeg");
	ImageIcon ii4 = new ImageIcon("img/4.png");
	ImageIcon ii5 = new ImageIcon("img/5.png");
	public JButtonTest() {
		super("JButton");
		setLayout(new GridLayout(0,3,10,10));
		JButton btn1 = new JButton("첫번째");
		add(btn1);
		
		//btn1.setEnabled(false);//버튼 비활성화(true:활성화, false:비활성화)
		
		JButton btn2 = new JButton(ii1);
		add(btn2);
		
		JButton btn3 = new JButton("세번째",ii2);
		add(btn3);
		
		btn3.setRolloverIcon(ii3);//마우스 오버시 icon 변경
		btn3.setPressedIcon(ii4);//버튼을 누른 상태일 때 icon변경
		
		//RadioButton
		JPanel pane = new JPanel(new GridLayout(3,1));
		JRadioButton rb1= new JRadioButton("ONE");
		JRadioButton rb2= new JRadioButton("TWO");
		JRadioButton rb3= new JRadioButton("THREE");
		
		ButtonGroup bg = new ButtonGroup();//라디오버튼 동작하기 위해서는 그룹을 생성해주어야 한다.
		bg.add(rb1);bg.add(rb2);bg.add(rb3);
		pane.add(rb1);pane.add(rb2);pane.add(rb3);
		
		add(pane);
		
		//ToggleButton
		JToggleButton tBtn=new JToggleButton(ii5);
		add(tBtn);
		tBtn.setSelectedIcon(ii1);//버튼이 선택상태일 때 아이콘
		
		//JLabel
		JLabel lbl1 = new JLabel("라벨", JLabel.RIGHT);//LEFT, RIGHT, CENTER
		JLabel lbl2 = new JLabel("라벨", ii2, JLabel.RIGHT);
		add(lbl1);
		add(lbl2);
		
		//투명처리 해제
		lbl1.setOpaque(true);//true: 투명해제, false: 투명
		pane.setOpaque(true);
		
		
		//배경색
		lbl1.setBackground(Color.YELLOW);
		pane.setBackground(Color.green);
		btn1.setBackground(Color.orange);
		
		JPanel pane2 = new JPanel();
		add(pane2);
		pane2.setOpaque(true);
		pane2.setBackground(Color.cyan);
		
		
		rb1.setBackground(Color.red);
		
		//글자색					r  g   b  ->0~255
		Color clr = new Color(100,100,200);
		lbl1.setForeground(clr);
		
		//글꼴 ->글꼴(돋움체, 굴림, arial..), 글자유형(진하게, 기울임꼴, 보통),  글자크기(정수:pixel)
		//Font 클래스						1		2
		Font fnt = new Font("궁서체", Font.BOLD+Font.ITALIC, 40);
		lbl1.setFont(fnt);
		
		//JComboBox
		Vector<String> vec = new Vector<String>();
		vec.add("JAVA");
		vec.add("스트링");
		vec.add("HTML");
		vec.add("CSS");
		
		
		JComboBox box1= new JComboBox(vec);
		add(box1);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Red");
		model.addElement("Green");
		model.addElement("Blue");
		model.addElement("White");
		
		JComboBox box2 = new JComboBox(model);
		add(box2);
		
		//JList
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		for(int i=100; i<=1000; i+=100) {
			model2.addElement(String.valueOf(i));
		}
		JList<String> list = new JList<String>(model2);
		JScrollPane sp = new JScrollPane(list);
		add(sp);
		
		//TextField: 1줄 문자열을 입력
		JTextField tf = new JTextField();
		add(tf);
		
		//JTextArea: 여러 줄의 문자열을 입력
		JTextArea ta = new JTextArea();
		JScrollPane sp2 = new JScrollPane(ta);
		add(sp2);
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		new JButtonTest();

	}

}
