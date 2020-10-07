
public class RoomVO {
	private int room_num;
	private String gender;
	private int area;
	private String window;
	private int deposit; //∫∏¡ı±›
	private int monthly_rent;
	private String occupancy_status;
	private String reservation;
	private int resident_num;

	public RoomVO() {  }
	public RoomVO(int room_num, String gender, int area, String window, int deposit, int monthly_rent, String occupancy_status) {
		this.room_num=room_num;
		this.gender=gender;
		this.area=area;
		this.window=window;
		this.deposit=deposit;
		this.monthly_rent=monthly_rent;		
		this.occupancy_status=occupancy_status;
	}
	public RoomVO(int room_num, String gender, int area, String window, int deposit, int monthly_rent, String occupancy_status, String reservation, int resident_num ) {
		this(room_num, gender, area, window, deposit, monthly_rent, occupancy_status);
		this.reservation = reservation;
		this.resident_num=resident_num;
	}
	public RoomVO(int room_num, String gender, int area, String window, int deposit, int monthly_rent, String occupancy_status, String reservation ) {
		this(room_num, gender, area, window, deposit, monthly_rent, occupancy_status);
		this.reservation = reservation;
	}
	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getMonthly_rent() {
		return monthly_rent;
	}

	public void setMonthly_rent(int monthly_rent) {
		this.monthly_rent = monthly_rent;
	}

	public String getOccupancy_status() {
		return occupancy_status;
	}

	public void setOccupancy_status(String occupancy_status) {
		this.occupancy_status = occupancy_status;
	}

	public int getResident_num() {
		return resident_num;
	}

	public void setResident_num(int resident_num) {
		this.resident_num = resident_num;
	}

	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	

}
