
public class MonthlyVO {
	private int resident_num;
	private String pay_date;//납부일
	private String actual_pay_date;//실납부일
	private String check_date;//확인날짜	

	public MonthlyVO() {  }

	public int getResident_num() {
		return resident_num;
	}

	public void setResident_num(int resident_num) {
		this.resident_num = resident_num;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getActual_pay_date() {
		return actual_pay_date;
	}

	public void setActual_pay_date(String actual_pay_date) {
		this.actual_pay_date = actual_pay_date;
	}

	public String getCheck_date() {
		return check_date;
	}

	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}
	
	

}
