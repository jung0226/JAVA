import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class PacMan extends JFrame implements Runnable {
	MyCanvas mc = new MyCanvas();
	int sel = 2;// 이미지 sel
	Image img;
	int x = 225, y = 225;// 좌표
	int mx, my;// 이동

	public PacMan() {
		super("팩맨");
		add(mc);
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Thread t = new Thread(this);
		t.start();
		
		// 키보드 이벤트
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					sel = 4;
					mx = 0;
					my -= 10;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					sel = 6;
					mx = 0;
					my += 10;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					sel = 2;
					mx = 10;
					my = 0;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					sel = 0;
					mx -= 10;
					my = 0;
				}
				repaint();
			}
		});

	}


	class MyCanvas extends Canvas {
		public MyCanvas() {
		}

		public void paint(Graphics g) {
			// 출력화면 시작, 마지막점(화면위치) 원본파일의 시작점 원본파일의 마지막 점
			g.drawImage(img, x, y, x + 50, y + 50, sel * 50, 0, sel * 50 + 50, 50, this);

		}
	}// end of MyCanvas
		
	
	@Override
	public void run() {
		while (true) {
			if (sel % 2 == 0) {
				sel++;
			} else {
				sel--;
			}

			x += mx;
			y += my;

			if (x > 500) { // 오른쪽 끝
				mx = 10;
				my = 0;
				x=10;
			} else if (x < 10) { // 왼쪽 끝
				mx -= 10;
				my = 0;
				x= 500;
			} else if (y > 500) {//아래
				mx = 0;
				my = 10;
				y=10;

			} else if (y < 10) {//위
				mx = 0;
				my -= 10;
				y=500;
			}

			mc.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} // while

	}

	public static void main(String[] args) {
		new PacMan();

	}

}