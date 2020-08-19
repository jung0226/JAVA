import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;

public class FrameTest extends Frame{
	Dimension dim = new Dimension(500,600);//폭과 높이를 가지는 객체
	Point p = new Point(300,400);
	Rectangle rect = new Rectangle(p,dim);
	
	Button btn = new Button("확인");
	//메인 창은 Frame클래스로 생성한다.
	public FrameTest() {
		add(btn);
		
		//창의 크기 : setSize(픽셀단위),
		//setSize(300, 400);
//		setSize(dim);
//		setBounds(300,200,500,500);
		setBounds(rect);
		
		
		//창이 보이게 설정한다. : setVisible()
		setVisible(true);
		
	}

	public static void main(String[] args) {
new FrameTest();
	}

}
