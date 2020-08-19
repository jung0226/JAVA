import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CalculatorEvent implements ActionListener {
	JTextField tf;
	String oper="";//연산자 저장할 변수
	double result;//첫 번째 연산자이자 결과

	public CalculatorEvent() {
	}

	public CalculatorEvent(JTextField tf) {
		this.tf = tf;// 주소를 넘겨준 것.
	}

	public void actionPerformed(ActionEvent ae) {// 이벤트가 발생한 버튼은 ae에 담김.
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
		default:// 숫자 버튼일 경우
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
		//계산결과 tf에 표시
		//tf.setText(String.valueOf(result));
		tf.setText(Double.toString(result));
		
		oper="";//연산자 지우기
	}
	
	public void setOperator(String eventTxt) {
		oper = eventTxt;//연산자
		result = Double.parseDouble(tf.getText());
		tf.setText("");//tf 초기화
		
	}
	
	public void setPoint() {
		//소수점 있는지 확인
		String txt = tf.getText();
		if(txt.indexOf(".") == -1) {
			tf.setText(txt+".");
		}
	}// setPoint

	public void setNumber(String eventTxt) {
		String tfTxt = tf.getText();// 지금 tf에 있는 값
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
