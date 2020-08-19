package java08_swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{

	public GraphicsTest() {
		super("�׸��׸���");
		
		MyCanvas canvas = new MyCanvas();
		add(canvas);//��ġ ���� �� �ϸ� center�� ��
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			//���ڿ� �׸���					x, y
			g.drawString("���ڿ� �׸���", 100,100);
			//���� �׸���
			g.drawLine(50, 50, 300, 300);
			//�簢�� �׸��� - ����
			g.drawRect(100, 50, 300, 100);
			//�簢�� �׸��� - ä���� �簢��			
			g.setColor(Color.yellow);//�׸� ���� ����
			g.fillRect(100, 200, 300, 100);
			
			g.setColor(Color.blue);
			//���׸���
			g.drawOval(50, 50, 300, 200);
			g.fillOval(50, 250, 200, 100);
			//�ձ� �簢��
			g.setColor(Color.red);
			g.fillRoundRect(10, 10, 300, 300, 150, 500);
			//�ٰ���
			g.setColor(Color.green);
			int x[]= {160,340,270,120,85};
			int y[]= {25,150,300,277,155};
			g.drawPolygon(x, y, x.length);
			
			
			
			
		}
	}

	public static void main(String[] args) {
		new GraphicsTest();

	}

}
