import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import java08_swing.RGB2;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane pane = new JTabbedPane();
	JButton btn = new JButton("�� �г� �׽�Ʈ ��");
	ImageIcon ii = new ImageIcon("img/2.jpg");
	ImageIcon ii2 = new ImageIcon("img/icon.png");
	JLabel lbl = new JLabel(ii);
	RGB2 rgb = new RGB2();
	CalculatorSwing2 cs2 = new CalculatorSwing2();
	CalendarSwing2 cal = new CalendarSwing2();
	
	public JTabbedPaneTest() {
		super("�Ǹ޴�");
		add(pane);
		//		   ����, ����
		pane.add("��ư", btn);
		pane.add("�̹���", lbl);
		pane.add("����ǥ", rgb);
		//pane.insertTab("", ii2, cs2, "����", 1);
		pane.insertTab("����", ii2, cs2, "����", 1); //�Ǹ޴� ����
		pane.insertTab("�޷�", null, cal, "�޷�", 3);
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			Thread.sleep(3000);
		}catch(Exception e){}
		//�� �޴��� Ȱ��ȭ : true(�ʱⰪ), ��Ȱ��ȭ : false
		//setEnabled() : ù��° �Ǹ� Ȱ��ȭ ������ ���� ��Ȱ������ �ȴ�.
		//pane.setEnabled(false);
		pane.setEnabledAt(3, false);
		
		try {
			Thread.sleep(3000);
		}catch(Exception e){}
		//���ϴ� �Ǹ� Ȱ��ȭ, ��Ȱ��ȭ
		pane.setEnabledAt(3, true);
		
		//�Ǹ޴� ��ġ �̵�
		pane.setTabPlacement(JTabbedPane.LEFT);
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
