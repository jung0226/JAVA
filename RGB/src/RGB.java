import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RGB extends JFrame implements ChangeListener{
	JPanel rgb = new JPanel();
		int r,g,b;
		
	
	JPanel sliderPane = new JPanel(new BorderLayout());
		JPanel colorPane = new JPanel();		
		JPanel sliderNamePane = new JPanel(new GridLayout(3,1));
		JPanel sliderColorPane = new JPanel(new GridLayout(3,1));
			JSlider colorSlider[] = new JSlider[3];		
		JPanel colorThumnailPane = new JPanel(new GridLayout(3,1));
			JPanel redThumnail = new JPanel();
			JPanel greenThumnail = new JPanel();
			JPanel blueThumnail = new JPanel();

	public RGB() {
		super("RGB");
		add(BorderLayout.NORTH,rgb);
		
		add(sliderPane);		
		for(int i=0;i<colorSlider.length; i++) {
			colorSlider[i]=new JSlider(0,255,125);
			colorSlider[i].setPaintLabels(true); //레이블 여부
			colorSlider[i].setPaintTicks(true);//눈금 표시
			colorSlider[i].setPaintTrack(true);
			colorSlider[i].setMajorTickSpacing(50); //간격
			colorSlider[i].setMinorTickSpacing(10); //간격
			//이벤트
			colorSlider[i].addChangeListener(this);			
		}
		
		//값 설정
		r=colorSlider[0].getValue();
		g=colorSlider[1].getValue();
		b=colorSlider[2].getValue();
		rgb.add(new JLabel("RGB("+String.valueOf(r)+","+String.valueOf(g)+","+String.valueOf(b)+")"));
		
		colorPane.setBackground(new Color(r,g,b));
		redThumnail.setBackground(new Color(r,0,0));
		greenThumnail.setBackground(new Color(0,g,0));
		blueThumnail.setBackground(new Color(0,0,b));
		
		//화면 레이아웃
		sliderPane.add(BorderLayout.NORTH,colorPane);
		sliderPane.add(BorderLayout.WEST, sliderNamePane);
		sliderPane.add(sliderColorPane);
		sliderPane.add(BorderLayout.EAST, colorThumnailPane);
		
		sliderNamePane.add(new JLabel("RED"));
		sliderNamePane.add(new JLabel("GREEN"));
		sliderNamePane.add(new JLabel("BLUE"));
		
		colorThumnailPane.add(redThumnail);
		colorThumnailPane.add(greenThumnail);
		colorThumnailPane.add(blueThumnail);
		
		//화면에 출력
		for(int i=0; i<colorSlider.length;i++) {
			JSlider prn = colorSlider[i];
			sliderColorPane.add(prn);
		}
		
		redThumnail.setPreferredSize(new Dimension(50,50));
		colorPane.setPreferredSize(new Dimension(700,300));
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		r=colorSlider[0].getValue();
		g=colorSlider[1].getValue();
		b=colorSlider[2].getValue();
		
		colorPane.setBackground(new Color(r,g,b));
		redThumnail.setBackground(new Color(r,0,0));
		greenThumnail.setBackground(new Color(0,g,0));
		blueThumnail.setBackground(new Color(0,0,b));
		rgb.setVisible(false);
		rgb.removeAll();
		rgb.add(new JLabel("RGB("+String.valueOf(r)+","+String.valueOf(g)+","+String.valueOf(b)+")"));
		rgb.setVisible(true);
	}



	public static void main(String[] args) {
		new RGB();

	}

}
