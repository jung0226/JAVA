package java08_swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DigitalClock extends JFrame {
	JLabel lbl = new JLabel("11:50:50");
	Font fnt = new Font("Arial", Font.BOLD, 50);

	public DigitalClock() {
		super("Clock");
		//setTitle("Clock");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.getImage("img/5.png");
		
		setIconImage(icon);
		
		lbl.setHorizontalAlignment(JLabel.CENTER);//JLabel ���ڿ� ��� ����
		lbl.setFont(fnt);
		add(lbl);
		pack();//������ ���븸ŭ â�� ũ�Ⱑ ������.
		//setSize(400,200);//setBounds(x,y,w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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



	public static void main(String[] args) {
		new DigitalClock();
		

	}

}
