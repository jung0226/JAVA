package javaApi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class FormatTest {

	public FormatTest() {
		try {
			// ȭ����� ǥ��
			int money = 523453;// 52,345,153��
			DecimalFormat fmt = new DecimalFormat("000,000,000��");

			String moneyStr = fmt.format(money);
			System.out.println("moneyStr = " + moneyStr);

			// ȭ����� ���ڸ� ���ڷ� ��ȯ
			NumberFormat fmt2 = NumberFormat.getNumberInstance();

			Number num = fmt2.parse(moneyStr);
			int numInt =num.intValue();
			System.out.println("numInt = "+numInt);
		} catch (Exception e) {
		}
		
		//��¥�� �̿��� ����
		Calendar now = Calendar.getInstance();
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
		String dateStr = dateFmt.format(now.getTime());
		System.out.println("dateStr = "+dateStr);
	}

	public static void main(String[] args) {
		new FormatTest();

	}// end of main
}// end of class
