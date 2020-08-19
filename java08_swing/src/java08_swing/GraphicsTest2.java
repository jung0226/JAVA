package java08_swing;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class GraphicsTest2 extends JFrame{
	MyCanvas mc = new MyCanvas();
	Random ran = new Random();
	int x,y,w,h;
	
	public GraphicsTest2() {
		add(mc);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		while(true) {
			x = ran.nextInt(300);
			y = ran.nextInt(300);
			w = ran.nextInt(100)+5;
			h = ran.nextInt(100)+5;
			mc.repaint();
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
		
	}
	
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.fillOval(x, y, w, h);
		}
		public void update(Graphics g) {
			paint(g);
		}
	}

	public static void main(String[] args) {
		new GraphicsTest2();

	}

}
