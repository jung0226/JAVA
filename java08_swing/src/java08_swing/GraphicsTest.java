package java08_swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{

	public GraphicsTest() {
		super("그림그리기");
		
		MyCanvas canvas = new MyCanvas();
		add(canvas);//위치 지정 안 하면 center에 들어감
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			//문자열 그리기					x, y
			g.drawString("문자열 그리기", 100,100);
			//직선 그리기
			g.drawLine(50, 50, 300, 300);
			//사각형 그리기 - 선만
			g.drawRect(100, 50, 300, 100);
			//사각형 그리기 - 채워진 사각형			
			g.setColor(Color.yellow);//그림 색상 설정
			g.fillRect(100, 200, 300, 100);
			
			g.setColor(Color.blue);
			//원그리기
			g.drawOval(50, 50, 300, 200);
			g.fillOval(50, 250, 200, 100);
			//둥근 사각형
			g.setColor(Color.red);
			g.fillRoundRect(10, 10, 300, 300, 150, 500);
			//다각형
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
