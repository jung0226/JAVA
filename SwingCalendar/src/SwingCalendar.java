import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SwingCalendar extends JFrame implements ActionListener, ItemListener {
	
	Font fnt1 = new Font("굴림체", Font.BOLD, 12);
	Font fnt2 = new Font("궁서체", Font.BOLD, 12);	

	// 달력
	Calendar cal = Calendar.getInstance();

	ImageIcon lastBtn1 = new ImageIcon("img/last1.png"); // 기본
	ImageIcon lastBtn2 = new ImageIcon("img/last2.png"); // 버튼을 누른 상태일 때
	ImageIcon lastBtn3 = new ImageIcon("img/last3.png"); // 마우스 오버시
	ImageIcon nextBtn1 = new ImageIcon("img/next1.png");
	ImageIcon nextBtn2 = new ImageIcon("img/next2.png");
	ImageIcon nextBtn3 = new ImageIcon("img/next3.png");

	// 년도
	DefaultComboBoxModel year = new DefaultComboBoxModel();
	JComboBox yearbox = new JComboBox(year);
	// 월
	DefaultComboBoxModel month = new DefaultComboBoxModel();
	JComboBox monthbox = new JComboBox(month);

	JPanel northFrm = new JPanel();
	JButton lastMonth = new JButton(lastBtn1);
	JButton nextMonth = new JButton(nextBtn1);

	// GirdLayout: 입력하는 순서대로 우로, 위에서 배치
	// grd.setVgap(5); grid사이를 수직 간격으로 5픽셀로 설정
	JPanel calFrm = new JPanel(new BorderLayout());
	JPanel calWeek = new JPanel(new GridLayout(1, 7)); // 요일
	JPanel calDay = new JPanel(new GridLayout(0, 7)); // 1, 2, 3,...,31

	String day[] = { "일", "월", "화", "수", "목", "금", "토" };
	JLabel dayLbl;

	public SwingCalendar() {
		super("달력");
		add("North", northFrm);
		// 버튼 외곽선 없애기
		lastMonth.setBorderPainted(false);
		nextMonth.setBorderPainted(false);
		// 내용영역 채우기 없애기
		lastMonth.setContentAreaFilled(false);
		nextMonth.setContentAreaFilled(false);
		// 선택 되었을때 생기는 테두리 없애기
		lastMonth.setFocusPainted(false);
		nextMonth.setFocusPainted(false);

		// 버튼 눌렀을 때
		lastMonth.setPressedIcon(lastBtn2);
		nextMonth.setPressedIcon(nextBtn2);
		// 마우스 오버시
		lastMonth.setRolloverIcon(lastBtn3);
		nextMonth.setRolloverIcon(nextBtn3);

		// 년도
		for (int i = 1940; i <= 3000; i++) {
			year.addElement(i);
		}
		// 월
		for (int i = 1; i <= 12; i++) {
			month.addElement(i);
		}
		year.setSelectedItem("2020");
		month.setSelectedItem("8");

		// 버튼, 콤보박스를 패널에 추가
		northFrm.add(lastMonth);
		northFrm.add(yearbox);
		northFrm.add(monthbox);
		northFrm.add(nextMonth);


		add("Center", calFrm);
		calFrm.add("North", calWeek);
		calFrm.add("Center", calDay);

		calWeek.setBackground(Color.LIGHT_GRAY);
		calDay.setBackground(Color.pink);

		// 요일 출력
		weekPrn(calWeek);

		// 첫 화면
		// cal.set(Calendar.YEAR, Calendar.MONTH, 1);// 년, 월, 1
		cal.set(2020, 7, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);// 요일 1->월, 요일 - 1=공백수
		// 마지막 날 구하기
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 공백
		for (int i = 1; i < week; i++) {
			calDay.add(new JLabel(""));
		}
		// 날짜
		dayPrn(calDay, lastDay, week);

		// 이벤트
		// lastMonth.addActionListener(this);
		// nextMonth.addActionListener(this);
		yearbox.addItemListener(this);
		monthbox.addItemListener(this);

		lastMonth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton event = (JButton) e.getSource();
				if (event.equals(lastMonth)) {
					int l = Integer.parseInt(month.getSelectedItem().toString());
					if (l == 1) {
						year.setSelectedItem(Integer.parseInt(year.getSelectedItem().toString()) - 1);
						monthbox.setSelectedItem(12);
					} else {
						for (int i = l - 1; i > l - 2; i--) {
							monthbox.setSelectedItem(i);
						}
					}
				} // if
			}
		});

		nextMonth.addActionListener(new ActionListener() {
			int selectYear = 2020;
			int selectMonth = 7;// 0->1월;

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton event = (JButton) e.getSource();
				if (event.equals(nextMonth)) {
					int m = Integer.parseInt(monthbox.getSelectedItem().toString());
					if (m == 12) {
						year.setSelectedItem(Integer.parseInt(year.getSelectedItem().toString()) + 1);
						monthbox.setSelectedItem(1);
					} else {
						for (int i = m + 1; i < m + 2; i++) {
							monthbox.setSelectedItem(i);

						}
					}
				}

			}

		});

		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	// 오버라이딩
	public void actionPerformed(ActionEvent e) {
	}

	// 오버라이딩
	public void itemStateChanged(ItemEvent e) {
		int selectYear = 2020;
		int selectMonth = 7;// 0->1월;
		// 콤보박스
		JComboBox event = (JComboBox) e.getSource();
		if (event == yearbox) {
			selectYear = Integer.parseInt(yearbox.getSelectedItem().toString());
			calendar(selectYear, Integer.parseInt(monthbox.getSelectedItem().toString()));

		} else if (event == monthbox) {
			selectMonth = Integer.parseInt(monthbox.getSelectedItem().toString());
			calendar(Integer.parseInt(yearbox.getSelectedItem().toString()), selectMonth);
		}

	}

	// 요일 출력
	public void weekPrn(JPanel calWeek) {

		for (int i = 0; i < day.length; i++) {
			JLabel label = new JLabel(day[i], SwingConstants.CENTER);
			label.setFont(fnt1);
			if (i == 0) {
				label.setForeground(Color.red);
				calWeek.add(label);
			} else if (i == 6) {
				label.setForeground(Color.blue);
				calWeek.add(label);
			} else {
				calWeek.add(label);
			}
		}
	}
	
	// 날짜 출력
	 public void dayPrn(JPanel newCalDay, int lastDay, int week) {
		 for (int d = 1; d <= lastDay; d++) {
				JLabel jDay = new JLabel(String.valueOf(d));
				jDay.setFont(fnt2);
				switch(week) {
				case 1:
					if(d==1 || d%7==1) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==7 || d%7==0){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 2:
					if(d==7 || d%7==0) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==6 || d%7==6){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 3:
					if(d==6 || d%7==6) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==5 || d%7==5){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 4:
					if(d==5 || d%7==5) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==4 || d%7==4){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 5:
					if(d==4 || d%7==4) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==3 || d%7==3){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 6:
					if(d==3 || d%7==3) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==2 || d%7==2){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 7:
					if(d==2 || d%7==2) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==1 || d%7==1){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				default:
					newCalDay.add(jDay);
				}//end of switch
				
			}
	 }
	
	

	// 달력
	public void calendar(int year, int month) {// 년도, 월

		calFrm.removeAll();
		JPanel newCalWeek = new JPanel(new GridLayout(1, 7));
		//요일 출력
		weekPrn(newCalWeek);
		JPanel newCalDay = new JPanel(new GridLayout(0, 7));
		newCalWeek.setBackground(Color.LIGHT_GRAY);
		newCalDay.setBackground(Color.pink);
		calFrm.add("North", newCalWeek);
		calFrm.add("Center", newCalDay);

		// 요일 - 입력받은 년, 월, 1일이 무슨 요일인지 구한다.
		cal.set(year, month - 1, 1);// 년, 월, 1
		int week = cal.get(Calendar.DAY_OF_WEEK);// 요일 1->월, 요일 - 1=공백수

		// 마지막 날 구하기
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 공백
		for (int i = 1; i < week; i++) {
			newCalDay.add(new JLabel(""));
		}
		// 날짜 출력
		dayPrn(newCalDay, lastDay, week);

		validate();
		newCalDay.setVisible(true);

	}// end of calendar

	public static void main(String[] args) {
		new SwingCalendar();

	}

}
