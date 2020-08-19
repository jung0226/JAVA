package java08_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RGB2 extends JPanel implements ChangeListener, ActionListener{ //�����ð�
	JTextArea ta; 
	JDialog dialog;
	JButton setBtn = new JButton("����");
	
	Font fnt = new Font("����ü", Font.BOLD, 30);
	JLabel rgbLbl = new JLabel("RGB(150,150,150)", JLabel.CENTER);
	int red=150, green=150, blue=150;
	
	//Frame --> Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel rgbColor = new JPanel();
		JPanel rgbSlider = new JPanel(new BorderLayout()); //red, green, blue
	
	// JSlider
	JPanel colorNamePane = new JPanel(new GridLayout(3,1));
		JLabel[] colorName = {new JLabel("RED"), new JLabel("GREEN"), new JLabel("BLUE")};
	JPanel colorSliderPane = new JPanel(new GridLayout(3,1));
		JSlider[] colorSlider = {new JSlider(0,255), new JSlider(0,255), new JSlider(0,255)};
	JPanel colorPane = new JPanel(new GridLayout(3,1));
		Color[] color= {new Color(150,0,0), new Color(0,150,0), new Color(0,0,150)};
		JLabel[] colorLbl = new JLabel[3];
	
	public RGB2() {
		//super("RGB����ǥ");
		setLayout(new BorderLayout());
		
		rgbLbl.setFont(fnt);
		add("North",rgbLbl);
		
		add(centerPane);
		centerPane.add(rgbColor);
			rgbColor.setBackground(new Color(red,green,blue));
		centerPane.add("South",rgbSlider);
			rgbSlider.add(BorderLayout.WEST, colorNamePane);
			rgbSlider.add("Center", colorSliderPane);
			rgbSlider.add("East",colorPane);
		for(int i=0; i<colorName.length; i++) {
			colorNamePane.add(colorName[i]);
			colorSliderPane.add(colorSlider[i]);
			//����
			colorSlider[i].setMajorTickSpacing(50); //�� ����
			colorSlider[i].setMinorTickSpacing(10);//���� ����
			colorSlider[i].setPaintTicks(true);//���� ���̱�
			colorSlider[i].setPaintLabels(true);//�� ���̱�
			
			//�̺�Ʈ
			colorSlider[i].addChangeListener(this);
			
			colorLbl[i] = new JLabel("             ");
			colorLbl[i].setOpaque(true);
			colorLbl[i].setBackground(color[i]);
			colorPane.add(colorLbl[i]);
		}
		
		
		
		// rgbSlider --> Border ����
		LineBorder lb = new LineBorder(Color.cyan, 5, true);
		TitledBorder tb=new TitledBorder(lb, "Color Slider", TitledBorder.CENTER, TitledBorder.CENTER); //���Ʒ�, �¿�
		rgbSlider.setBorder(tb);
		
		add("South",setBtn);
		setBtn.addActionListener(this);
		
	}
	
	public RGB2(JTextArea ta, JDialog dialog) {
		this();// �Ű������� ���� ������. �ݵ�� ù ��° �ٿ� �;� ��.
		this.ta=ta;		
		this.dialog = dialog;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Object obj = e.getSource();
		if(obj ==colorSlider[0]) {
			red=colorSlider[0].getValue();
			colorLbl[0].setBackground(new Color(red,0,0));
		}else if(obj ==colorSlider[1]) {
			green=colorSlider[1].getValue();
			colorLbl[1].setBackground(new Color(0,green,0));
		}else if(obj ==colorSlider[2]) {
			blue=colorSlider[2].getValue();
			colorLbl[2].setBackground(new Color(0,0,blue));
		}
		
		rgbColor.setBackground(new Color(red, green, blue));
		rgbLbl.setText("RGB("+red+","+green+","+blue+")");
	}
	
	//�׼� �̺�Ʈ�� ���� �������̵�
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == setBtn) {
			ta.setForeground(new Color(red, green, blue));
			dialog.setVisible(false); //dispose�ϸ� setVisible �� �ᵵ ����.
			dialog.dispose();
		}
	}
	
}
