import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorSwing2 extends JPanel{
	Font fnt = new Font("Arial",Font.PLAIN,30);
	JTextField tf = new JTextField("0.0");
	
	//Button 라벨
	String btnLbl [] = {"BackSpace", "Clear", "End",
						"7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", ".", "=", "/"};
	
	JPanel frmCenter = new JPanel(new BorderLayout());
		JPanel centerNorth = new JPanel(new GridLayout(1,3));
		JPanel centerBtn = new JPanel(new GridLayout(4,4,5,5));
		
	CalculatorEvent event = new CalculatorEvent(tf);

	public CalculatorSwing2() {
		setLayout(new BorderLayout());
		tf.setFont(fnt);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		add("North",tf);
		
		//버튼들
		add("Center", frmCenter);
			frmCenter.add("North",centerNorth);
			frmCenter.add("Center",centerBtn);
			
		for(int i =0; i<btnLbl.length;i++) {
			JButton btn = new JButton(btnLbl[i]);//버튼 생성
			btn.setFont(fnt);//글자크기 설정
			btn.setBackground(Color.LIGHT_GRAY);//배경색칠하기
			btn.addActionListener(event);//이벤트 등록, 실행가능 위치를 괄호 안에 지정
			//버튼을 JPanel에 추가
			if(i<=2) {
				centerNorth.add(btn);
			}else {
				centerBtn.add(btn);
			}
		}		
		
		
	}
	
}
