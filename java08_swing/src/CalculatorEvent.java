import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CalculatorEvent implements ActionListener {
	JTextField tf;
	String oper="";//������ ������ ����
	double result;//ù ��° ���������� ���

	public CalculatorEvent() {
	}

	public CalculatorEvent(JTextField tf) {
		this.tf = tf;// �ּҸ� �Ѱ��� ��.
	}

	public void actionPerformed(ActionEvent ae) {// �̺�Ʈ�� �߻��� ��ư�� ae�� ���.
		String eventTxt = ae.getActionCommand();
		switch (eventTxt) {
		case "End":
			System.exit(0);
			break;
		case "BackSpace":
			setBackSpace();
			break;
		case ".":
			setPoint();
			break;
		case "+":
		case "-":
		case "*":
		case "/":
			setOperator(eventTxt);
			break;
		case "=":
			setCalculator();
			break;
		case "Clear":
			setClear();
			break;
		default:// ���� ��ư�� ���
			setNumber(eventTxt);

		}// switch
	}
	
	public void setClear() {
		result =0.0;
		oper="";
		tf.setText("0.0");
	}
	
	public void setCalculator() {
		double secondNum = Double.parseDouble(tf.getText());
		switch(oper) {
		case "+": result = result +secondNum;break;
		case "-":result = result -secondNum;break;
		case "*":result = result *secondNum;break;
		case "/":
			if(secondNum!=0) {result = result /secondNum;}break;
		}
		//����� tf�� ǥ��
		//tf.setText(String.valueOf(result));
		tf.setText(Double.toString(result));
		
		oper="";//������ �����
	}
	
	public void setOperator(String eventTxt) {
		oper = eventTxt;//������
		result = Double.parseDouble(tf.getText());
		tf.setText("");//tf �ʱ�ȭ
		
	}
	
	public void setPoint() {
		//�Ҽ��� �ִ��� Ȯ��
		String txt = tf.getText();
		if(txt.indexOf(".") == -1) {
			tf.setText(txt+".");
		}
	}// setPoint

	public void setNumber(String eventTxt) {
		String tfTxt = tf.getText();// ���� tf�� �ִ� ��
		if (tfTxt.equals("0.0")) {
			tf.setText(eventTxt);
		} else {
			tf.setText(tfTxt + eventTxt);
		}
	}// setNumber

	public void setBackSpace() {
		try {
		String txt = tf.getText();//""
		String cutTxt= txt.substring(0,txt.length()-1);
		tf.setText(cutTxt);
		}catch(StringIndexOutOfBoundsException sioobe) {}
	}// setBackSpace
	

}
