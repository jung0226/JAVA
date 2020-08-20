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


public class DigitalClock extends JPanel implements Runnable {
	JLabel lbl = new JLabel("11:50:50");
	Font fnt = new Font("Arial", Font.BOLD, 50);

	public DigitalClock() {
		setLayout(new BorderLayout());
		//setTitle("Clock");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.getImage("img/5.png");
		
		lbl.setHorizontalAlignment(JLabel.CENTER);//JLabel 문자열 가운데 정렬
		lbl.setFont(fnt);
		add(lbl);
		
		
	}
	
	//시간 설정
	public void run() {
		do {
			Calendar now = Calendar.getInstance();//현재시간
			SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");//문자열 11:44:55
			String nowStr = fmt.format(now.getTime());
			//라벨에 셋팅
			lbl.setText(nowStr);
			//일시정지
			try {
				Thread.sleep(500);//0.5초
			}catch(Exception e) {
				
			}
		}while(true);
	}
}
