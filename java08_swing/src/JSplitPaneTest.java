import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java08_swing.RGB2;

public class JSplitPaneTest extends JFrame{
	CalendarSwing2 calendar = new CalendarSwing2();
	RGB2 rgb = new RGB2();
	CalculatorSwing2 calculator = new CalculatorSwing2();	
	
	public JSplitPaneTest() {
		
		JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,calendar, calculator);
		JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,rgb, sp2);
		
		add(sp1);
		
		sp1.setDividerLocation(500);
		sp2.setDividerLocation(600);
		
		sp1.setDividerSize(20); //경계선의 두께. 단위 px
		sp1.setOneTouchExpandable(true); //확대 축소
		sp2.setOneTouchExpandable(true); 
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		new JSplitPaneTest();
	}

}
