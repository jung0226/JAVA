package java08_swing;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDrawTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
		String btnLbl[] = {"원본 그리기", "축소", "확대", "좌우 뒤집기","상하 뒤집기", "일부 그리기"};
	MyCanvas mc = new MyCanvas();	
	Image img;
	String event="";
	
	public ImageDrawTest() {
		super("이미지 그리기");
		for(String lbl:btnLbl) {
			JButton btn = new JButton(lbl);
			pane.add(btn);
			btn.addActionListener(this);//이벤트 등록
		}
		add(BorderLayout.NORTH, pane);
		add(mc);
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}//생성자
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		event = e.getActionCommand();		
		mc.repaint();//paint 메소드를 호출해주는 메소드 //mc.paint();
	}

	class MyCanvas extends Canvas{
		MyCanvas(){
			img = Toolkit.getDefaultToolkit().getImage("img/1.jpg");
		}
		public void paint(Graphics g) {
			//이미지의 폭과 높이를 구한다.(반드시 oaint()메소드에서 구한다.
			int w= img.getWidth(this);
			int h= img.getHeight(this);
			if(event.equals("원본 그리기")) {
				//이미지 그리기
				g.drawImage(img, 1,1,this);
			}else if(event.equals("축소")) {
				g.drawImage(img,1,1,w/2,h/2,this);
			}else if(event.equals("확대")) {
				g.drawImage(img, 1, 1, w*2, h*2, this);
			}else if(event.equals("좌우 뒤집기")) {
				g.drawImage(img, 0, 0, w, h,
								w, 0, 0, h, this);
			}else if(event.equals("상하 뒤집기")) {
				g.drawImage(img, 0, 0, w, h, 
								0, h, w, 0, this);
			}else if(event.equals("일부 그리기")) {
				int imgw = w/10;
				int imgh = h/10;
				g.drawImage(img, 0, 0, w, h, imgw, imgh, imgw*8, imgh*8, this);
			}
		}
	}//end of MyCanvas

	public static void main(String[] args) {
		new ImageDrawTest();
	}

}
