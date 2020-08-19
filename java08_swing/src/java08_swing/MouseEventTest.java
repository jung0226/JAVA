package java08_swing;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


public class MouseEventTest extends JFrame {
	MyCanvas mc = new MyCanvas();
	MyAdapter ma = new MyAdapter();
	int startX, startY;
	int lastX, lastY;
	int btn;
	
	public MouseEventTest() {
		add(mc);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mc.addMouseListener(ma);
		mc.addMouseMotionListener(ma);
	}
	class MyAdapter extends MouseAdapter{
		//마우스를 누른 상태일 때
		public void mousePressed(MouseEvent me) {
			//me에는 x, y좌표, 마우스 버튼 종류(왼쪽, 오른쪽 버튼, 휠)를 가지고 있음.
			btn =me.getButton(); //버튼 종류 왼쪽:1 , 휠 :2, 오른쪽:3
			if(btn==MouseEvent.BUTTON1) {
				startX = me.getX();//마우스가 클릭된 곳의 x좌표
				startY = me.getY();
			}
		}
		
		//마우스에서 손을 놓았을 때
		public void mouseReleased(MouseEvent me) {
//			if(me.getButton()==MouseEvent.BUTTON1) {
//				lastX = me.getX();
//				lastY = me.getY();
//				mc.repaint(); //그림이 그려져야 한다.
//			}
			btn=0;
		}
		public void mouseDragged(MouseEvent me) {
			lastX=me.getX();
			lastY=me.getY();
			
			if(btn==MouseEvent.BUTTON1) {
				mc.repaint();
			}
			startX=me.getX();
			startY=me.getY();
			
		}
		
	}//end of MyAdapter
	
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawLine(startX, startY, lastX, lastY);
		}
		public void update(Graphics g) {
			paint(g);
		}
	}
	public static void main(String[] args) {
		new MouseEventTest();
	}

}
