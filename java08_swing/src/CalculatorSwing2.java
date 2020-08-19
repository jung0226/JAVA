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
	
	//Button ��
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
		
		//��ư��
		add("Center", frmCenter);
			frmCenter.add("North",centerNorth);
			frmCenter.add("Center",centerBtn);
			
		for(int i =0; i<btnLbl.length;i++) {
			JButton btn = new JButton(btnLbl[i]);//��ư ����
			btn.setFont(fnt);//����ũ�� ����
			btn.setBackground(Color.LIGHT_GRAY);//����ĥ�ϱ�
			btn.addActionListener(event);//�̺�Ʈ ���, ���డ�� ��ġ�� ��ȣ �ȿ� ����
			//��ư�� JPanel�� �߰�
			if(i<=2) {
				centerNorth.add(btn);
			}else {
				centerBtn.add(btn);
			}
		}		
		
		
	}
	
}
