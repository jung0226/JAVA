package event;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class ItemEventTest extends JFrame implements ActionListener, ItemListener{
	JTextArea ta = new JTextArea("구체적 감염 사례를 보면 경기 고양시 일산동구 '반석교회' 관련 확진자가\n 계속 늘어나면서 전날 낮 12시 기준으로 누적 24명이 됐다.\n 이 교회 집단감염은 이미 '시립숲속아이어린이집'을 거쳐\n 지역사회로까지 'n차 전파'가 이어졌다.");
	JScrollPane sp = new JScrollPane(ta);
	
	JToolBar tb = new JToolBar();
		JComboBox<String> fontCombo = new JComboBox<String>();
			DefaultComboBoxModel<String> modelFont = new DefaultComboBoxModel<String>();
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> modelSize = new DefaultComboBoxModel<Integer>();
		JToggleButton plainBtn = new JToggleButton("가");
		JToggleButton boldBtn = new JToggleButton("가");
		JToggleButton italicBtn = new JToggleButton("가");
		
	Font fnt = new Font("돋움",Font.PLAIN,12);
	String selectFontName="바탕체";
	Integer selectFontSize=13;
	int styleBold=0; //0:보통 1:진하게 2:기울임꼴 3:진하게+기울임꼴
	int styleItalic=0;
	
	public ItemEventTest() {
		add(sp);		
		
		//시스템의 글꼴 가져오기
		String fontlist[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String f: fontlist) {
			modelFont.addElement(f);
		}
		fontCombo.setModel(modelFont);
		fontCombo.setSelectedItem("바탕체");
	
		//글자 크기
		for(int i=7;i<=100;i+=3) {
			modelSize.addElement(i);
		}
		fontSize.setModel(modelSize);
		fontSize.setSelectedItem(13);
		//글자 유형
		plainBtn.setFont(fnt);
		boldBtn.setFont(new Font("돋움", Font.BOLD,12));
		italicBtn.setFont(new Font("돋움",Font.ITALIC,12));
		
		tb.add(fontCombo); tb.add(fontSize); tb.add(plainBtn); tb.add(boldBtn); tb.add(italicBtn);
		add("North",tb);
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		plainBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		
		fontCombo.addItemListener(this);
		fontSize.addItemListener(this);
	}//생성자
	
	public void actionPerformed(ActionEvent ae) {
		JToggleButton event =(JToggleButton)ae.getSource();
		if(event.equals(plainBtn)) {
			styleBold=0;
			styleItalic=0;
		}else if(event.equals(boldBtn)) {
			if(boldBtn.isSelected()) {
				styleBold=Font.BOLD;
			}else {
				styleBold=0;
			}
		}else if(event.equals(italicBtn)) {
			if(italicBtn.isSelected()) {
				styleItalic =Font.ITALIC;
			}else {
				styleItalic=0;
			}
		}
		fnt = new Font(selectFontName, styleBold+styleItalic, selectFontSize);
		ta.setFont(fnt);
	
	}
	
	public void	itemStateChanged(ItemEvent e) {
		JComboBox event = (JComboBox)e.getSource();
		if(event==fontCombo) {
			selectFontName = (String)fontCombo.getSelectedItem();
		}else if(event == fontSize) {
			selectFontSize = (Integer)fontSize.getSelectedItem();
		}
		fnt = new Font(selectFontName, styleBold+styleItalic, selectFontSize);
		ta.setFont(fnt);
	}

	public static void main(String[] args) {
		new ItemEventTest();
	}

}
