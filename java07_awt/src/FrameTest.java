import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;

public class FrameTest extends Frame{
	Dimension dim = new Dimension(500,600);//���� ���̸� ������ ��ü
	Point p = new Point(300,400);
	Rectangle rect = new Rectangle(p,dim);
	
	Button btn = new Button("Ȯ��");
	//���� â�� FrameŬ������ �����Ѵ�.
	public FrameTest() {
		add(btn);
		
		//â�� ũ�� : setSize(�ȼ�����),
		//setSize(300, 400);
//		setSize(dim);
//		setBounds(300,200,500,500);
		setBounds(rect);
		
		
		//â�� ���̰� �����Ѵ�. : setVisible()
		setVisible(true);
		
	}

	public static void main(String[] args) {
new FrameTest();
	}

}
