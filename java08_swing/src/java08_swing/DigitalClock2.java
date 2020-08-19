package java08_swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class DigitalClock2 extends JPanel {
	JLabel lbl = new JLabel("11:50:50");
	Font fnt = new Font("Arial", Font.BOLD, 50);

	public DigitalClock2() {
		setLayout(new BorderLayout());
		//setTitle("Clock");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.getImage("img/5.png");
				
		lbl.setHorizontalAlignment(JLabel.CENTER);//JLabel ���ڿ� ��� ����
		lbl.setFont(fnt);
		add(lbl);
		setTime();
		
	}
	
	//�ð� ����
	public void setTime() {
		do {
			Calendar now = Calendar.getInstance();//����ð�
			SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");//���ڿ� 11:44:55
			String nowStr = fmt.format(now.getTime());
			//�󺧿� ����
			lbl.setText(nowStr);
			//�Ͻ�����
			try {
				Thread.sleep(500);//0.5��
			}catch(Exception e) {
				
			}
		}while(true);
	}


}
