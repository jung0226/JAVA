
public class ResidentVO {
	private int resident_num;
	private String resident_id;
	private String resident_pwd;
	private String resident_name;
	private String gender;
	private String tel;	
	private int room_num;
	private String move_in_date; //입주일
	private String expiration_date; //만기일
	private String monthly_rent_check; 
	
	public ResidentVO() {	}
	public ResidentVO(String resident_id, String resident_pwd) {
		this.resident_id=resident_id;
		this.resident_pwd=resident_pwd;
	}
	public ResidentVO(String resident_id, String resident_pwd, String resident_name, String gender, String tel) {
		this(resident_id, resident_pwd);
		this.resident_name=resident_name;
		this.gender=gender;
		this.tel=tel;
	}
	public ResidentVO(int  resident_num, String resident_id, String resident_pwd, String resident_name, String gender, String tel,
					int room_num, String move_in_date, String expiration_date, String monthly_rent_check) {
		this(resident_id, resident_pwd, resident_name, gender, tel);
		this.resident_num= resident_num;		
		this.room_num=room_num;
		this.move_in_date=move_in_date;
		this.expiration_date=expiration_date;
		this.monthly_rent_check=monthly_rent_check;
	}
	
	public int getResident_num() {
		return resident_num;
	}

	public void setResident_num(int resident_num) {
		this.resident_num = resident_num;
	}

	public String getResident_id() {
		return resident_id;
	}

	public void setResident_id(String resident_id) {
		this.resident_id = resident_id;
	}

	public String getResident_pwd() {
		return resident_pwd;
	}

	public void setResident_pwd(String resident_pwd) {
		this.resident_pwd = resident_pwd;
	}

	public String getResident_name() {
		return resident_name;
	}

	public void setResident_name(String resident_name) {
		this.resident_name = resident_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public String getMove_in_date() {
		return move_in_date;
	}

	public void setMove_in_date(String move_in_date) {
		this.move_in_date = move_in_date;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_Date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getMonthly_rent_check() {
		return monthly_rent_check;
	}

	public void setMonthly_rent_check(String monthly_rent_check) {
		this.monthly_rent_check = monthly_rent_check;
	}

	

	
	
}
