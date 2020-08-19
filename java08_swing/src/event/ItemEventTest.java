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
	JTextArea ta = new JTextArea("��ü�� ���� ��ʸ� ���� ��� ���� �ϻ굿�� '�ݼ���ȸ' ���� Ȯ���ڰ�\n ��� �þ�鼭 ���� �� 12�� �������� ���� 24���� �ƴ�.\n �� ��ȸ ���ܰ����� �̹� '�ø����Ӿ��̾����'�� ����\n ������ȸ�α��� 'n�� ����'�� �̾�����.");
	JScrollPane sp = new JScrollPane(ta);
	
	JToolBar tb = new JToolBar();
		JComboBox<String> fontCombo = new JComboBox<String>();
			DefaultComboBoxModel<String> modelFont = new DefaultComboBoxModel<String>();
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> modelSize = new DefaultComboBoxModel<Integer>();
		JToggleButton plainBtn = new JToggleButton("��");
		JToggleButton boldBtn = new JToggleButton("��");
		JToggleButton italicBtn = new JToggleButton("��");
		
	Font fnt = new Font("����",Font.PLAIN,12);
	String selectFontName="����ü";
	Integer selectFontSize=13;
	int styleBold=0; //0:���� 1:���ϰ� 2:����Ӳ� 3:���ϰ�+����Ӳ�
	int styleItalic=0;
	
	public ItemEventTest() {
		add(sp);		
		
		//�ý����� �۲� ��������
		String fontlist[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String f: fontlist) {
			modelFont.addElement(f);
		}
		fontCombo.setModel(modelFont);
		fontCombo.setSelectedItem("����ü");
	
		//���� ũ��
		for(int i=7;i<=100;i+=3) {
			modelSize.addElement(i);
		}
		fontSize.setModel(modelSize);
		fontSize.setSelectedItem(13);
		//���� ����
		plainBtn.setFont(fnt);
		boldBtn.setFont(new Font("����", Font.BOLD,12));
		italicBtn.setFont(new Font("����",Font.ITALIC,12));
		
		tb.add(fontCombo); tb.add(fontSize); tb.add(plainBtn); tb.add(boldBtn); tb.add(italicBtn);
		add("North",tb);
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ���
		plainBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		
		fontCombo.addItemListener(this);
		fontSize.addItemListener(this);
	}//������
	
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
